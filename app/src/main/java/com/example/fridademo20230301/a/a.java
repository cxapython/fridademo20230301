package com.example.fridademo20230301.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class a {
     public class a0{
        public boolean a() {
            boolean z;
            boolean z2;
            String readLine="";
            String str = android.os.Build.TAGS;
            if (str != null && str.contains("test-keys")) {
                return true;
            }
            String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
            int i2 = 0;
            while (true) {
                if (i2 >= 10) {
                    z = false;
                    break;
                } else if (new File(strArr[i2]).exists()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return true;
            }
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
                readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                process.destroy();
            } catch (Throwable unused) {
                if (process != null) {
                    process.destroy();
                }
            }
            if (readLine != null) {
                z2 = true;
                return !z2;
            }
            z2 = false;
            if (!z2) {
            }

            return false;
        }


    }
        public static boolean a(int port) {
            try {
                InetAddress address = InetAddress.getByName("127.0.0.1");
                InetSocketAddress socketAddress = new InetSocketAddress(address, port);
                Socket socket = new Socket();
                socket.connect(socketAddress);
                socket.close();
                return true;
            } catch (Exception e) {
                return false;
            }

    }
}
