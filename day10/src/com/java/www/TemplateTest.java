/*
模板方法设计模式

* */

package com.java.www;

public class TemplateTest {
    public static void main(String[] args) {
        MySort s1 = new MySort(1000);
        s1.spendTime();
    }
}

abstract class Template {
    abstract void code();

    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.printf("spend time: %ds\n", end - start);
    }
}

class MySort extends Template {
    private int num;

    // 构造器
    public MySort() {
        super();
    }

    public MySort(int num) {
        this.num = num;
    }

    // 方法
    public void code() {
        /*
        求给定数的范围内所有的质数
        * */
        for (int i = 2; i <= num; ++i) {
            boolean flag = true;
            for (int j = 2; j < Math.pow(i, 1.0/2); ++j) {  // Math.pow(num, 1.0/2) 根号2
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
