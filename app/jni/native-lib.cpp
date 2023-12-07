#include <jni.h>
#include "openssl/md5.h"
#include <android/log.h>

#define APPNAME "fridademo20230301"

#define TAG "CXAFridaDemo"

// 定义info信息

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)

void show(JNIEnv *env, jobject context, const char *msg) {
    jclass toastClass = env->FindClass("android/widget/Toast");
    jmethodID makeTextMethodID = env->GetStaticMethodID(toastClass, "makeText",
                                                        "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;");
    jobject contextObj = context;  // 获取到合适的 Context 对象
    jstring text = env->NewStringUTF(msg);  // 要显示的文本
    jint duration = 1;  // Toast.LENGTH_SHORT
    jobject toastObj = env->CallStaticObjectMethod(toastClass, makeTextMethodID, contextObj, text,
                                                   duration);
// 调用 Toast 对象的 show 方法来显示 Toast 消息
    jmethodID showMethodID = env->GetMethodID(toastClass, "show", "()V");
    env->CallVoidMethod(toastObj, showMethodID);
}

void calculateMD5(JNIEnv *env, jobject thiz, jstring inputString, char *hashStr) {
// 将Java字符串转换为C字符串
    const char *input = env->GetStringUTFChars(inputString, nullptr);
    size_t inputLength = strlen(input);

// 创建MD5上下文
    MD5_CTX md5Context;
    MD5_Init(&md5Context);

// 更新MD5上下文，提供要计算哈希的数据
    MD5_Update(&md5Context, (const unsigned char *) input, inputLength);

// 完成MD5计算并获取哈希值
    unsigned char hash[MD5_DIGEST_LENGTH];
    MD5_Final(hash, &md5Context);

// 将哈希值转换为十六进制字符串
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        sprintf(hashStr + (i * 2), "%02x", hash[i]);
    }
// 释放输入字符串的内存
    env->ReleaseStringUTFChars(inputString, input);
}

extern "C"
JNIEXPORT jstring
Java_com_example_fridademo20230301_FridaActivity3_Signature(JNIEnv
                                                            *env, jobject thiz, jobject context,
                                                            jint num, jstring inputStr) {
    if (num == 0 || env->GetStringUTFLength(inputStr) == 0) {
        show(env, context,
             "破解才能进入下一关");
        return env->NewStringUTF("error");
    }

    jclass jclass1 = env->GetObjectClass(thiz);
    jfieldID jid = env->GetFieldID(jclass1, "aaa", "I");
    jint aaa = env->GetIntField(thiz, jid);

    if (aaa == MD5_DIGEST_LENGTH) {
        char outStr[MD5_DIGEST_LENGTH * 2 + 1];
        calculateMD5(env, context, env
                ->NewStringUTF("F0r14a"), outStr);

        return env->
                NewStringUTF(outStr);
    }

}