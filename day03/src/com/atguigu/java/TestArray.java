package com.atguigu.java;

public class TestArray {
    public static void main(String[] args) {
        int i5; // int i5 = 12;
        i5 = 12;
        boolean b = true;

        // 定义数组
        // 1.1 声明数据类型，变量名
        String[] names;

        // 1.2 初始化
        // 第一种：静态初始化
        // 初始化数组与给数组元素赋值同时进行
        names = new String[]{"耳朵", "眼睛", "手"};
        int[] nums = {1, 2, 3}; // 特殊初始化，不用new关键字完成，在数组声明的同时完成初始化操作，也被称其为静态初始化。主要原因是因为采用这种初始化的方式，数组的存储空间的分配是由编译器完成的。

        // 第二种：动态初始化
        // 初始化数组与给数组元素赋值分开进行
        int[] scores; // 建议用这各上。也可以写作 int scores[];
        scores = new int[4]; // 初始化4个数组元素。此时的元素值默认为0

        // 如何调用数组元素，通过数组元素的下角标来调用
        // 下角标从0开始，到n-1结束。其中n表示数组的长度
        scores[0] = 88;
        scores[1] = 90;
        scores[3] = 99;



        // 通过数组的length属性获取数组的长度
        for (int i = 0; i < names.length; ++i) {
            System.out.println(names[i]);
        }

        // 遍历数组元素
        for (int i = 0; i < scores.length; ++i) {
            System.out.println(scores[i]);
        }

        System.out.println(nums[2]);
    }
}
