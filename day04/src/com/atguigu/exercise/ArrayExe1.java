/*
题目：
(1)定义类Pritimive，在类中定义一个有3个元素的boolean类型的数组t作为其成员变量。数组元素未赋值。
	ArrayExe1，在AArrayExe1的main()方法中创建Pritimive对象d，输出其成员变量t的三个元素值。
	练习目的：检验基本数据类型数组创建时的自动赋值。
(2)给对象d的成员变量t赋值为{true,true,true}，并输出t的三个元素值。

* */

package com.atguigu.exercise;

public class ArrayExe1 {
    public static void main(String[] args) {
        // 创建Pritimive的对象d
        Pritimive d = new Pritimive();

        for (int i = 0; i < d.t.length; ++i) {
            System.out.println(d.t[i]);
        }

        // 遍历d并更新值
        for (int i = 0; i < d.t.length; ++i) {
            d.t[i] = true;
        }
        for (int i = 0; i < d.t.length; ++i) {
            System.out.println(d.t[i]);
        }
    }
}

class Pritimive {
    boolean[] t = new boolean[3];
}


