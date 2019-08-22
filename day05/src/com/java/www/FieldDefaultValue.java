package com.java.www;

import java.util.*;

public class FieldDefaultValue {
    // 字段(类的成员变量)
    byte b;
    short s;
    int i;
    long lon;

    float f;
    double d;

    boolean bool;

    char c;
    String str;

    String[][] sArr;
    int[] iArr;
    List list;
    Set set;
    Map map;
    Runnable runnable;
    Thread t;

    // static 字段
    static byte sb;
    static short ss;
    static int si;
    static long slon;

    static float sf;
    static double sd;

    static boolean sbool;

    static char sc;
    static String sstr;

    static String[][] ssArr;
    static int[] siArr;
    static List slist;
    static Set sset;
    static Map smap;
    static Runnable srunnable;
    static Thread st;

    // 方法
    public static void main(String[] args) {
        System.out.println("// 静态字段默认值");
        System.out.println("byte: " + sb);
        System.out.println("short: " + ss);
        System.out.println("int: " + si);
        System.out.println("long: " + slon);

        System.out.println("float: " + sf);
        System.out.println("double: " + sd);

        System.out.println(sbool);

        System.out.println("char:==" + sc + "==");
        System.out.println();
        System.out.println("String[][]: " + ssArr);
        System.out.println("int[]: " + siArr);
        System.out.println("List: " + slist);
        System.out.println("Set: " + sset);
        System.out.println("Map: " + smap);
        System.out.println("Runnable接口: " + srunnable);
        System.out.println("Thread类: " + st);

        System.out.println();


        // 非静态字段默认值
        FieldDefaultValue f = new FieldDefaultValue();
        f.print();

    }

    private void print() {
        // 非静态字段默认值
        System.out.println("// 非静态字段默认值");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + lon);

        System.out.println("float: " + f);
        System.out.println("double: " + d);

        System.out.println(bool);

        System.out.println("char:==" + c + "==");
        System.out.println(str);
        System.out.println();
        System.out.println("String[][]: " + sArr);
        System.out.println("int[]: " + iArr);
        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        System.out.println("Map: " + map);
        System.out.println("Runnable接口: " + runnable);
        System.out.println("Thread类: " + t);

    }


}
