/*
java参数传递，是值传递

# 规则
    * 形参是基本数据类型：将实参的值传递给形参的基本数据类型的变量
    * 形参是引用数据类型（类，数组、String）：将实参的引用类型变量的值（对应的堆空间的对象实体的内存首地址）传递给形参的引用类型变量
    这里主要是跟引用数据类型变量保存的值为堆内存首地址。效果相当于传的是堆对象实体的指针
* */

package com.java.www;

public class ArgumentTransfer {
    public static void main(String[] args) {
        int x = 3, y = 7;
        System.out.printf("origin, x: %d, y: %d", x, y);
        System.out.println();

        // swap x,y
//        int temp = x;
//        x = y;
//        y = temp;

        ArgumentTransfer at = new ArgumentTransfer();
        at.swap(x, y); // x的值传递给m, y的值 传递给n

        System.out.printf("Swaped, x: %d, y: %d", x, y); // Swaped, x: 3, y: 7
        System.out.println();


        DataSwap ds = new DataSwap();
        System.out.println("ds.i: " + ds.i + ", ds.j: " + ds.j);
        at.swap(ds);
        System.out.println("ds.i: " + ds.i + ", ds.j: " + ds.j);

        String aa = "aa";
        String bb = aa;
        System.out.println("aa.hashCode(内存地址): " + aa.hashCode()); // 3104
        System.out.println("bb.hashCode(内存地址): " + bb.hashCode()); // 3104   说明String型的变量保存的是对象实体的内存首地址，是引用类型


    }

    public void swap(int m, int n) {
        // swap the value of two variables
        int t = m;
        m = n;
        n = t;
    }

    public void swap(DataSwap d) {
        int temp = d.i;
        d.i = d.j;
        d.j = temp;
    }
}

class DataSwap {
    int i = 5, j = 25;
}