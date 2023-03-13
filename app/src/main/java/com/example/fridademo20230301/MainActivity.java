package com.example.fridademo20230301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.next_check);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, FridaActivity.class));
    }
}