/*
static方法的应用
测试 ArrayUtil功能

* */

package com.java.www;

public class TestArrayUtil {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 34, 7, 5, 99, -1, 30, -200};

//        ArrayUtil ArrayUtil = new ArrayUtil();
        int max = ArrayUtil.max(arr);
        int min = ArrayUtil.min(arr);
        int sum = ArrayUtil.sum(arr);
        System.out.println("arr:" + arr);
        ArrayUtil.printArr(arr);

        float average = ArrayUtil.average(arr);
        int[] arr2 = ArrayUtil.copy(arr);

        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("sum: " + sum);
        System.out.println("average: " + average);
        ArrayUtil.reverse(arr);
        System.out.println("arr reverse:" + arr);
        ArrayUtil.printArr(arr);

        System.out.println("copy:" + arr2);
        ArrayUtil.printArr(arr2);


        ArrayUtil.printArr(arr);

        ArrayUtil.sort(arr);
        System.out.println("arr 排序：");
        ArrayUtil.printArr(arr);
    }
}
