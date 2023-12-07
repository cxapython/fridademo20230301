package com.example.fridademo20230301;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FridaActivity4 extends AppCompatActivity implements View.OnClickListener {
    static {
        System.loadLibrary("native-lib");
    }

    public int aaa;
    public EditText inputText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frida_activity4);
        Button button = (Button) findViewById(R.id.next_check4);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


    }

}
