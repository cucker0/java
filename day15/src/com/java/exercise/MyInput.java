/*
题目：
    Create a program named MyInput.java:
Contain the methods for reading int, double, short, byte and String
value from the keyboard


* */

package com.java.exercise;

import java.io.*;

public class MyInput {
    // 构造器
    public MyInput() {
        super();
    }

    // 方法
    public static String myString() {
        // 从标准输入流 转换 成字符串
        BufferedReader br = null;
        String str = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return str;
    }

    public static int myInt() {
        String s = myString();
        return Integer.parseInt(s);
    }

    public static double myDouble() {
        return Double.parseDouble(myString());
    }

    public static short myShort() {
        return Short.parseShort(myString());
    }

    public static byte myByte() {
        return Byte.parseByte(myString());
    }

    public static boolean myBoolean() {
        return Boolean.parseBoolean(myString());
    }

}
