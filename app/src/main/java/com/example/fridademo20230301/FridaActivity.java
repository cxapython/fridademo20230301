package com.example.fridademo20230301;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FridaActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frida_activity);
        Button button = (Button) findViewById(R.id.next_check2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!aaa.b() || !aaa.c() || !aaa.d() || !aaa.e() || !aaa.f() || !aaa.g() ||
                !aaa.h() || !aaa.i() || !aaa.j() || !aaa.k() || !aaa.l()) {
            Toast.makeText(this, "破解之后,才能进入下一关", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "恭喜破解,进入下一关", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, FridaActivity2.class));
        finishActivity(0);
    }

    private static class aaa {
        public static boolean b() {
            return false;
        }

        public static boolean c() {
            return false;
        }

        public static boolean d() {
            return false;
        }

        public static boolean e() {
            return false;
        }

        public static boolean f() {
            return false;
        }

        public static boolean g() {
            return false;
        }

        public static boolean h() {
            return false;
        }

        public static boolean i() {
            return false;
        }

        public static boolean j() {
            return false;
        }

        public static boolean k() {
            return false;
        }

        public static boolean l() {
            return false;
        }

        private aaa() {
        }
    }

}