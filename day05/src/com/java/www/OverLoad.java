/*
方法重载

题目1：
编写程序，定义三个重载方法并调用。
    方法名为mOL。
    三个方法分别接收一个int参数、两个int参数、一个字符串参数。
    分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
    在主类的main ()方法中分别用参数区别调用三个方法。

题目2：
定义三个重载方法max()，
第一个方法求两个int值中的最大值，
第二个方法求两个double值中的最大值，
第三个方法求三个double值中的最大值，
并分别调用三个方法。


* 概念
>在同一个类中，允许存在一个以上的同名方法，
只要它们的参数个数
或者参数类型不同即可（不同类型的排列顺序有关系）

* 重点
>于返回值类型无关，只看参数列表。
参数列表必须不同
调用时根据参数列表的不同类区别

* */

package com.java.www;

public class OverLoad {
    public static void main(String[] args) {
        OverLoad ol = new OverLoad();
        ol.mOL(3);
        ol.mOL(2, 5);
        ol.mOL("方法重载就是这么牛逼");

        System.out.println(ol.max(22, 33));
        System.out.println(ol.max(2.1, 3.5));
        System.out.println(ol.max(3.14, 9.9, 1.6));
    }

    // mOL重载
    public  int mOL(int i) {
        int m = i * i;
        System.out.println(m);
        return m;
    }
    public  void mOL(int i, int j) {
        System.out.println(i * j);
    }
    public  void mOL(String s) {
        System.out.println(s);
    }

    // max方法重载
    public int max(int i, int j) {
        return i > j ? i : j;
    }

    public double max(double d1, double d2) {
        return d1 > d2 ? d1 : d2;
    }

    public double max(double d1, double d2, double d3) {
        return max(d1, d2) > d3 ?  max(d1, d2) : d3;
    }
}
