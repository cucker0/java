/*
对int[] 数组求最大值、最小值、和、平均值，复制、反转


* */

package com.atguigu.java;

public class TestArray2 {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 11, 14, 87, 731, -12, -88}; // 栈中变量arr，保存了数组在内存堆中的首地址(16进制)
        System.out.println("\narr");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        // 求最大值、最小值、和、平均值
        int max = arr[0], min = arr[0], sum = 0;
        float average;

        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        average = sum / (float)arr.length;
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("sum: " + sum);
        System.out.println("average: " + average);

        // 赋值，数组变量保存的是数组在内存中的首地址
        /*
        int[] arr2 = arr; // 这种赋值，相当于变量arr2也保存了与arr保存的内存地址（即这两个变量都指向了同一个数组），即数组只存在一份数据
                          // 所以操作任意一个数组都会影响另外一个
        System.out.println("arr");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        for (int i = 0; i < arr.length; ++i) {
            if (i % 2 == 0) {
                arr[i] = i;
            }
        }
        System.out.println("\narr");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\narr2");
        for (int i = 0; i < arr2.length; ++i) {
            System.out.print(arr2[i] + "\t");
        }
        */

        // 数组复制（处理方法，重新声明一个数组变量，然后遍历原来的数组一个一个元素赋值给新数组）
        int[] arr3 = new int[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            arr3[i] = arr[i];
        }
        System.out.println("\narr3");
        for (int i = 0; i < arr3.length; ++i) {
            System.out.print(arr3[i] + "\t");
        }

        // 数组反转，第一个元素与倒数第一个元素互换，依次处理
        int temp;
        // 反转 方法一
/*        for (int i = 0; i < arr.length / 2; ++i) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i ];
            arr[arr.length - 1 - i] = temp;
        }*/
        //反转 方法二
        for (int i = 0, j = arr.length - 1; i < j; ++i, --j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println("\narr数组反转");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }

        // 排序
        int tmp;
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =tmp;
                }
            }
        }
        System.out.println("\narr排序");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }

    }
}
