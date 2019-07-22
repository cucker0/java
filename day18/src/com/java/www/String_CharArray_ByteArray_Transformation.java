/*
String、字节数组、字符数组之间的转化

* */

package com.java.www;

import org.junit.Test;

import java.nio.charset.Charset;

public class String_CharArray_ByteArray_Transformation {
    @Test
    public void test1() {
        // ## 字符串与基本数据类型、包装类之间转换

        // * 字符串 -> 基本数据类型、包装类：调用 相应包装类.parseXxx(String str)   其中Xxx为相应的基本数据类型
        String s1 = "1000";
        String s2 = "true";
        int i1 = Integer.parseInt(s1);
        System.out.println(i1);
        boolean b1 = Boolean.parseBoolean(s2);
        System.out.println(b1);
        Float f1 = Float.parseFloat("2.2F");
        System.out.println(f1);
        double d1 = Double.parseDouble("3.14");
        System.out.println(d1);
        System.out.println("====");

        // * 基本数据类型、包装类 -> 字符串：调用String.valueOf(T obj)  // T 为int、boolean、byte等基本数据类型
        int i28 = 993611;
        boolean b29 = false;
        long L30 = 996513233L;
        float f31 = 2.664F;
        Integer I33 =new Integer("77");
        Character c36 = new Character('c');
        Boolean B37 = new Boolean("true");

        System.out.println(String.valueOf(i28));
        System.out.println(String.valueOf(b29));
        System.out.println(String.valueOf(L30));
        System.out.println(String.valueOf(f31));
        System.out.println(String.valueOf(I33));
        System.out.println(String.valueOf(c36));
        System.out.println(String.valueOf(B37));
    }

    @Test
    public void test2() {
        // ## 字符串与字节数组的相互转换
        // * 字符串 -> 字节数组：字符串对象.getBytes()
        String s1 = "jjcfkj乘法口诀";
        byte[] b = s1.getBytes();
        for (int i = 0; i < b.length; ++i) {
            System.out.print(b[i] + " ");
            System.out.println((char) b[i]); // 如果有中文时出现乱码
        }
        System.out.println();

        // * 字节数组 -> 字符串：new String(byte[] b)
        byte[] b61 = new byte[]{97, 98, 99, 100, 101, 102, 103,};
        String s62 = new String(b61);
        System.out.println(s62);
        byte[] b64 = new byte[]{-24, -76, -72, -26, -104, -109, -26, -120, -104};
        System.out.println(new String(b64));

//        byte[] b67 = "贸易战".getBytes();
//        for (byte  bb : b67) {
//            System.out.print(bb + ", ");
//        }
    }

    @Test
    public void test3() {
        // ## 字符串与字符数据的转换
        // * 字符串 -> 字符数组：

        // 方式1: 字符串对象.toCharArray()
        String s1 = "I hava a dream!";
        char[] ch = s1.toCharArray();
        for (char c : ch) {
            System.out.print(c + ".");
        }
        System.out.println();

        // 方法2：String.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        char[] ch2 = new char[s1.length()];
        s1.getChars(0, s1.length(), ch2, 0);
        for (int i = 0; i < ch2.length; ++i) {
            System.out.print(ch2[i] + "_");
        }

    }

    @Test
    public void test4() {
        // * 字符数组 -> 字符串
        char[] ch = new char[]{'许', '上', '等', '愿', ',', '做', '中', '等', '事', ',', '享', '下', '等', '福', '.'};
        String s1 = new String(ch);
        System.out.println(s1);
    }

}
