/*
数组小工具
* */


package com.java.www;

public class ArrayUtil {
    public int max(int[] arr) {
        // maximum value
        int max_index = 0; // 设最大值的下标为0
        for (int i = 1; i < arr.length; ++i) {
            if (arr[max_index] < arr[i]) {
                max_index = i;
            }
        }
        return arr[max_index];
    }

    public int min(int[] arr) {
        // minimum value
        int min_index = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[min_index] > arr[i]) {
                min_index = i;
            }
        }
        return arr[min_index];
    }

    public int sum(int[] arr) {
        // sum value
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }
        return sum;
    }

    public float average(int[] arr) {
        // average value
        float ave = sum(arr) / (float)arr.length;
        return ave;
    }

    public int[] copy(int[] arr) {
        // copy array，return the copy array
        int[] arr_new = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            arr_new[i] = arr[i];
        }
        return arr_new;
    }

    public int[] reverse(int[] arr) {
        // reverse array
        int temp;
        for (int i = 0, j = arr.length - 1; i < j; ++i, --j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public int[] sort(int[] arr) {
        // sort array
        int start = 0, end = arr.length - 1;
        arraySortOps(arr, start, end);
        return arr;
    }

    public void printArr(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public int[] arraySortOps(int[] arr, int start, int end) {
        // array quick sort operations 快速排列
        if (arr.length <= 1) {
            return arr;
        }

        if (start < end) {
            int i = start, j = end;
            int base = arr[i]; // 选择一个比较基准数，此时腾出下标为i的坑位

            // 所有数与基准数比较后一轮后，基础数位于中间，小于它位于它的左侧，大于它的位于它的右侧。（此时前区、后区的元素还未排好序，还需要按照此法进行比较，直到每次比较的只剩下两个元素）
            while (i < j) {

                // 后区，从最后一个开始往前逐个与基准数比较，直到有一个比基准数小的
                while (i < j && arr[j] >= base) {
                    --j;
                }
                if (i < j) { // 右边有比基准数小的
                    arr[i] = arr[j]; // 把前面腾出的下标i坑位填上，挖下坑位下标j的坑位
                    ++i; //
                }
                // 前区，从下标为start的开始往后逐个与基准数比较，直到有一个比基准数大的
                while (i < j && arr[i] <= base) {
                    ++i;
                }
                if (i < j) {
                    arr[j] = arr[i]; //
                    --j;
                }
            }

            // 此时i = j，i与j是此消彼长的关系，i加少了，j就会减多些
            arr[i] = base; // 把基准数填到找到的前后区中间，此时已经把比基准数小的放在左边，比基准数大的放在右边
            arraySortOps(arr, start, i - 1); // 前区递归
            arraySortOps(arr,i + 1, end); // 后区递归

        }
        return arr;
    }
}
