package com.example.fridademo20230301;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FridaActivity3 extends AppCompatActivity implements View.OnClickListener {
    static {
        System.loadLibrary("native-lib");
    }

    public int aaa;
    public EditText inputText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frida_activity3);
        Button button = (Button) findViewById(R.id.next_check4);
        button.setOnClickListener(this);
        inputText = (EditText) findViewById(R.id.input_str);


    }

    public String getNewStr(String oldStr) {
        String newString = oldStr;
        if (oldStr.length() >= 6) {
            String front = oldStr.substring(0, 3);
            String back = oldStr.substring(oldStr.length() - 3);
            newString = front + back;
        }
        return newString;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_check4:
                String pwd = inputText.getText().toString();
                if (pwd.equals(getNewStr(Signature(this, aaa, pwd)))) {
                    Toast.makeText(this, R.string.step4, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, FridaActivity4.class));
                    finishActivity(0);
                    return;
                }
                break;
            default:
                break;
        }


    }

    public native String Signature(Context context, int num, String pwd);

}
