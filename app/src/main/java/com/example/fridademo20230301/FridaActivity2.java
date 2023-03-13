package com.example.fridademo20230301;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridademo20230301.Dynamic.CheckInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import dalvik.system.DexClassLoader;

public class FridaActivity2 extends AppCompatActivity implements View.OnClickListener {
    private CheckInterface DynamicDexCheck = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Button button = (Button) findViewById(R.id.next_check2);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (getDynamicDexCheck() != null) {
            if (getDynamicDexCheck().check("233".getBytes())) {
                Toast.makeText(this, "恭喜破解，进入下一关", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, FridaActivity3.class));
                finishActivity(0);
                return;
            }else{
                Toast.makeText(this,"没破解进不了下一关哦,继续加油", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        Toast.makeText(this, "onClick loaddex Failed!", Toast.LENGTH_SHORT).show();

    }

    public static void copyFiles(Context context, String str, File file) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getApplicationContext().getAssets().open(str);
        } catch (IOException e) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream.close();
            } catch (IOException e2) {
                inputStream2 = inputStream;
                try {
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    inputStream = inputStream2;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th2;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                fileOutputStream2 = fileOutputStream;
                if (inputStream != null) {
                }
                if (fileOutputStream2 != null) {
                }
                throw th3;
            }
        } catch (IOException e4) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            if (inputStream != null) {
            }
            if (fileOutputStream2 != null) {
            }
            throw th4;
        }
    }

    private void loaddex() {
        File cacheDir = getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }
        String str = cacheDir.getAbsolutePath() + File.separator + "DynamicPlugin.dex";
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
                copyFiles(this, "DynamicPlugin.dex", file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.DynamicDexCheck = (CheckInterface) new DexClassLoader(str, cacheDir.getAbsolutePath(), null, getClassLoader()).loadClass("com.example.fridademo20230301.Dynamic.DynamicCheck").newInstance();
            if (this.DynamicDexCheck != null) {
                return;
            }
            Toast.makeText(this, "loaddex Failed!", Toast.LENGTH_SHORT).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public CheckInterface getDynamicDexCheck() {
        if (this.DynamicDexCheck == null) {
            loaddex();
        }
        return this.DynamicDexCheck;
    }

}
