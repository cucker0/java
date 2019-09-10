package com.atguigu.java;

import java.util.Arrays;

/**
 * Arrays类
 * 操作数组的工具类
 *
 *
 */
public class ArraysTest {
    public static void main(String[] args) {
        /*
        * public static boolean equals(int[] a, int[] a2)
        * 比较两个数组是否相等
        * */

        int[] arr1 = new int[]{11, 22, 3, 44, 6};
        int[] arr2 = new int[]{11, 22};
        boolean b = Arrays.equals(arr1, arr2);
        System.out.println(b);
        System.out.println();

        /*
        * public static String toString(int[] a)
        * 数组转成字符串
        * */
        System.out.println(Arrays.toString(arr1)); // [11, 22, 3, 44, 6]
        System.out.println();

        /*
        * public static void fill(int[] a, int val)
        * 数组中所有的元素填充为指定的值val
        * */
        Arrays.fill(arr2, 3);
        System.out.println("Arrays.fill(arr2, 3): ");
        System.out.println(Arrays.toString(arr2)); // [3, 3]
        System.out.println();

        /*
        * public static void sort(int[] a)
        * 数组排序
        * */
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1)); // [3, 6, 11, 22, 44]
        System.out.println();


        /*
        * public static int binarySearch(int[] a, int key)
        * 二分查找指定的值的索引位置。要求数组已经排序好
        * 返回值为负数时，表示没有找到
        * */

        int[] arr3 = new int[]{3, 5, -3, 0, 10, 66, 1};
        int i = Arrays.binarySearch(arr3, 3);
        System.out.println(i); // -5
        Arrays.sort(arr3); // 排序
        int i2 = Arrays.binarySearch(arr3, 3);
        System.out.println(i2); // 3
    }
}
