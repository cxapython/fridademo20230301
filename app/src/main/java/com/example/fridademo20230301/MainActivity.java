package com.example.fridademo20230301;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.fridademo20230301.a.a;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.next_check);
        button.setOnClickListener(this);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                if(new a().a(27042)){
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, "检测到frida!", Toast.LENGTH_LONG).show();
//                            finish();
//                        }
//                    });
//
//                }
//            }
//        }).start();

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, FridaActivity.class));
    }
}