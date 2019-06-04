/*
测试 ArrayUtil功能

* */

package com.java.www;

public class TestArrayUtil {
    public static void main(String[] args) {
//        int[] arr = new int[]{11, 33, 7, 5, 99, -1, 30, -200};
        int[] arr = new int[]{3, 7, 5};

        ArrayUtil arr_util = new ArrayUtil();
        int max = arr_util.max(arr);
        int min = arr_util.min(arr);
        int sum = arr_util.sum(arr);
        float average = arr_util.average(arr);
        int[] arr2 = arr_util.copy(arr);
        int[] arr3 = arr_util.reverse(arr);
        int[] arr4 = arr_util.sort(arr);

        for (int i = 0; i < arr4.length; ++i) {
            System.out.println(arr4[i]);
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("sum: " + sum);
        System.out.println("average: " + average);
        System.out.println("copy: " + arr2);
        System.out.println("reverse: " + arr3);
        System.out.println("sort: " + arr4);
        System.out.println("arr id: " + arr);
        System.out.println("arr2 id: " + arr2);
        System.out.println("arr3 id: " + arr3);
        System.out.println("arr4 id: " + arr4);
    }
}
