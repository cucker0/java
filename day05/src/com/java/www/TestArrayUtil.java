/*
测试 ArrayUtil功能

* */

package com.java.www;

public class TestArrayUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 34, 7, 5, 99, -1, 30, -200};

        ArrayUtil arr_util = new ArrayUtil();
//        int max = arr_util.max(arr);
//        int min = arr_util.min(arr);
//        int sum = arr_util.sum(arr);
//        System.out.println("arr:" + arr);
//        arr_util.printArr(arr);
//
//        float average = arr_util.average(arr);
//        int[] arr2 = arr_util.copy(arr);
//
//        System.out.println("max: " + max);
//        System.out.println("min: " + min);
//        System.out.println("sum: " + sum);
//        System.out.println("average: " + average);
//        arr_util.reverse(arr);
//        System.out.println("arr reverse:" + arr);
//        arr_util.printArr(arr);
//
//        System.out.println("copy:" + arr2);
//        arr_util.printArr(arr2);


        arr_util.printArr(arr);

        arr_util.sort(arr);
        System.out.println("arr 排序：");
        arr_util.printArr(arr);
    }
}
