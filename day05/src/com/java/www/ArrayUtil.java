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
//        arraySortOps(arr, start, end);
        arraySortOps2(arr, start, end);
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
                    arr[i] = arr[j]; // 把前面腾出的下标i坑位填上，挖下下标j的坑位
                    ++i; // 此时，刚刚填好的坑位i明显比基准数小了，所以前区这个位就不用再比较了
                }
                // 前区，从下标为start的开始往后逐个与基准数比较，直到有一个比基准数大的
                while (i < j && arr[i] <= base) {
                    ++i;
                }
                if (i < j) { // 左边有比基准数大的
                    arr[j] = arr[i]; // 把前面腾出的下标j坑位填上，挖下下标i的坑位
                    --j; // 此时，刚刚填好的坑位j明显比基准数大了，所以后区这个位就不用再比较了
                }
            }

            // 此时i = j，i与j是此消彼长的关系，i加少了，j就会减多些
            arr[i] = base; // 把基准数填到找到的前后区中间，此时已经把比基准数小的放在左边，比基准数大的放在右边
            arraySortOps(arr, start, i - 1); // 前区递归
            arraySortOps(arr,i + 1, end); // 后区递归

        }
        return arr;
    }

    public int[] arraySortOps2(int[] arr, int start, int end) {
        // 快速排序
        if (arr.length <= 1) {
            return arr;
        }

        if (start < end) {
            int i = start, j = end;
            int base = arr[i]; // 腾出下标为i的位置

            while (i < j) {
                // 后区，从最后一个开始往前逐个与基准数比较，直到有一个比基准数小的
                while (i < j) {
                    if (arr[j] < base) {
                        arr[i] = arr[j]; // 填上前面的下标i坑，挖下下标j的坑位
                        ++i; // 此时前区的下标i位不用再比较了，已经确定比基准数小
                        printArr(arr);
                        break;
                    }
                    --j;
                }


                // 前区，从下标为start的开始往后逐个与基准数比较，直到有一个比基准数大的
                while (i < j) {
                    if (arr[i] > base) {
                        arr[j] = arr[i]; // 填上上面的下标j坑位，挖下下标为i的坑位
                        --j; // 此时前区的下标j位不用再比较了，已经确定比基准数大
                        printArr(arr);
                        break;
                    }
                    ++i;
                }

            }

            // 此时小于基准数的移到了前区，大于的移到了后区，且i == j
            arr[i] = base;
            printArr(arr);
            arraySortOps2(arr, start, i - 1);
            arraySortOps2(arr,i + 1, end);

        }

        return arr;
    }
}
