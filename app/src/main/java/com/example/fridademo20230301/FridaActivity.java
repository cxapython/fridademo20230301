package com.example.fridademo20230301;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class FridaActivity extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frida_activity);
        Button button = (Button) findViewById(R.id.next_check2);
        button.setOnClickListener(this);
//        if (Debug.isDebuggerConnected()) {
//            Toast.makeText(this, "Debug from vm", Toast.LENGTH_LONG).show();
//        }
//
//        if (new a().new a0().a()) {
//            Toast.makeText(this, "检测到设备Root", Toast.LENGTH_LONG).show();
//            finish();
//        }

    }

    @Override
    public void onClick(View view) {
        aaa ains = new aaa();
        if (!ains.b() || !ains.c() || !ains.d() || !aaa.e() || !aaa.f() || !aaa.g() ||
                !aaa.h() || !aaa.i() || !aaa.j() || !aaa.k() || !aaa.l() ||
                !Arrays.equals(ains.aaa, new String[]{"知", "识"}) || ains.bbb==0) {
            Toast.makeText(this, "破解之后,才能进入下一关", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "恭喜破解,进入下一关", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, FridaActivity2.class));
        finishActivity(0);
    }

    private static class aaa {
        private String[] aaa = null;
        private boolean next = false;
        private int bbb = 0;

        public  boolean b() {
            return false;
        }

        public  boolean c() {
            return false;
        }

        public  boolean d() {
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
                this.aaa = new String[]{"知", "道"};
        }

        public String aaa(){
            return "233";
        }
        public void bbb() {
            this.next=true;
            this.bbb=2;
        }
    }

}