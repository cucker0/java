/*
数组一旦初始化，其长度不可变。
这是它的优点也是它的缺点

* */

package com.atguigu.java;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] ii = new int[]{2, 3, 5};
        // 因数组的长度不可变，没法扩容，若想添加元素个数，只能新增一个类型相同的数组，指定更大的长度，并把数据重新插入进来
        int[] jj = new int[10];
        for (int i = 0; i < ii.length; ++i) {
            jj[i] = ii[i];
        }

        for (int i = 0; i < jj.length; ++i) {
            System.out.println(jj[i]);
        }

    }
}
