/*
多维数组，这里以二维数组为例

* 声明数组是就需要确定长度（显式或隐式）
* 多维数组所有的元素类型必须为制定的类型，且只能有一种数据类型

* */

package com.atguigu.java;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[] score1 = new int[6];

        // 二维数组
        // # 声明二维数组(可以先声明二维数组变量，后初始化； 也可以声明并初始二维数组)
        int[][] score2;
        String[][] names; // 也可以写成 String[] names[];
                            // 或 String names[][];
                            // 但不建议这两种方式

        String[][] names2;

        // #.静态初始化
        score2 = new int[][]{{3, 5, 7}, {2, 9}, {33, 11}};
        // 同时声明和静态初始化
        int[][] nums = new int[][]{{11, 22}, {1}, {44, 3,}};
        int[][] num3 = {{3, 5, 7}, {2}, {33, 11}}; // 省略格式。

        // # 动态初始化
        names = new String[6][5]; // 动态初始化一，6表示第一层数组的长度，5表示第二层数组的长度，即每个二层数组长度都为5
        names2 = new String[6][]; // 动态初始化二，6表示第一层的长度
        String[][] names3 = new String[8][3];
        names[0][0] = "s00";
        names[3][1] = "狗子";

//        names2[0] = new String[3];
//        names2[1] = new String[5];
//        names2[3] = new String[2];


        String[][] obj = names2;
        // 每一层的数组都有length属性
        for (int i = 0; i < obj.length; ++i) {
            if (obj[i] != null) { // 避免报错：Exception in thread "main" java.lang.NullPointerException
                for (int j = 0; j < obj[i].length; ++j) {
                    System.out.println(obj[i][j]);
                }
            }
            System.out.println();
        }

    }
}
