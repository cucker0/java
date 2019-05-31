/*
数组动态初始化，声明后的元素的默认值

* */

package com.atguigu.java;

public class TestArray {
    public static void main(String[] args) {
        // 基本数据类型的数组：byte, short, int long, float, double, char, boolean

        // # byte, short, int, long 数组元素默认值：0
        byte[] bb = new byte[4];
        bb[0] = 1;
        short[] ss = new short[4];
        int[] ii = new int[4];
        long[] longs = new long[3];

        System.out.println("byte[] bb");
        for (int i = 0; i < bb.length; ++i) {
            System.out.println(bb[i]);
        }

        System.out.println("short[] ss");
        for (int i = 0; i < ss.length; ++i) {
            System.out.println(ss[i]);
        }

        System.out.println("int[] ii");
        for (int i = 0; i < ii.length; ++i) {
            System.out.println(ii[i]);
        }

        System.out.println("long[] longs");
        for (int i = 0; i < longs.length; ++i) {
            System.out.println(longs[i]);
        }

        // # float, double数组元素默认值：0.0
        float[] ff = new float[4];
        double[] dd = new double[5];

        System.out.println("float[] ff");
        for (int i = 0; i < ff.length; ++i) {
            System.out.println(ff[i]);
        }

        System.out.println("double[] dd");
        for (int i = 0; i < dd.length; ++i) {
            System.out.println(dd[i]);
        }

        // # char 数组元素默认值：空白(即不输出任何东西) '\0'
        char[] cc = new char[7];

        System.out.println("char[] cc");
        for (int i = 0; i < cc.length; ++i) {
            System.out.println(cc[i]);
        }

        // # boolean数组元素默认值：false
        boolean[] booleans = new boolean[3];

        System.out.println("boolean[] booleans");
        for (int i = 0; i < booleans.length; ++i) {
            System.out.println(booleans[i]);
        }

        // 引用类型数组元素默认值：null
        String[] strs = new String[5];

        System.out.println("String[] strs");
        for (int i = 0; i < strs.length; ++i) {
            System.out.println(strs[i]);
        }

        Person[] pp = new Person[3];

        System.out.println("Person[] pp");
        for (int i = 0; i < pp.length; ++i) {
            System.out.println(pp[i]);
        }
    }
}

class Person {

}
