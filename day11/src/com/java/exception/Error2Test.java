/*
OutOfMemoryError: Java heap space

* */

package com.java.exception;

import java.util.ArrayList;
import java.util.List;

public class Error2Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        for (int i = 0; ;++i) {
//            list.add(i);
//        }

        long[] lon = new long[1024 * 1024 * 1024];
    }
}
