package com.example.fridademo20230301;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FridaActivity3 extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frida_activity3);
        Button button = (Button) findViewById(R.id.next_check3);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
