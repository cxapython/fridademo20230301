package com.example.fridademo20230301;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import dalvik.system.DexClassLoader;

public class FridaActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Object DynamicDexCheck = null;
    private static final String TAG = "FridaActivity2";
    private static Class<?> clazz = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Button button = (Button) findViewById(R.id.next_check2);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (getDynamicDexCheck() != null) {
            Method method = null;
            try {
                method = this.clazz.getDeclaredMethod("check", byte[].class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            method.setAccessible(true);
            boolean result = false;
            try {
                result = (boolean) method.invoke(this.DynamicDexCheck, "233".getBytes());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            Log.i(TAG, "result = " + result);
            if (result) {
                Toast.makeText(this, "恭喜破解，进入下一关", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, FridaActivity3.class));
                finishActivity(0);
                return;
            } else {
                Toast.makeText(this, "没破解进不了下一关哦,继续加油", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        Toast.makeText(this, "onClick loaddex Failed!", Toast.LENGTH_SHORT).show();

    }

    private Object loaddex() {
        File dexFile = new File(getFilesDir(), "DynamicPlugin.dex");
        if(dexFile.exists()){
            return this.DynamicDexCheck;
        }

        try (InputStream is = getAssets().open("DynamicPlugin.dex")) {
            byte[] jpgBytes = new byte[is.available()];
            is.read(jpgBytes);
            try (OutputStream os2 = new FileOutputStream(dexFile)) {
                os2.write(jpgBytes);
            }
            String dexPath = dexFile.getAbsolutePath();
            String dexOutputDir = getFilesDir().getAbsolutePath();
            ClassLoader classLoader = new DexClassLoader(dexPath, dexOutputDir, null, getClassLoader());
            this.clazz = classLoader.loadClass("com.example.fridademo20230301.Dynamic.DynamicCheck");
            this.DynamicDexCheck = this.clazz.newInstance();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object getDynamicDexCheck() {
        if (this.DynamicDexCheck == null) {
            loaddex();
        }
        return this.DynamicDexCheck;
    }

}
