package com.example.fridademo20230301.Dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicCheck implements CheckInterface {
    public static byte[] b = {-29, -127, -118, -29, -126, -127, -29, -127, -89, -29, -127, -88, -29, -127, -122, 33};

    @Override
    public boolean check(byte[] bytes) {
        if (Arrays.equals(b,bytes)) {
            return true;
        }


        return false;
    }
}