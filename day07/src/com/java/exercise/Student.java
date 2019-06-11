package com.java.exercise;

import java.io.IOException;

public class Student extends Person {
    // identity nubmer
    private long number;
    // score
    private int math;
    private int english;
    private int computer;

    // 构造器，
    public Student(String n, char s, int a, long k, int m, int e, int c) {
        super(n, s, a);
        this.number = k;
        this.math = m;
        this.english = e;
        this.computer = c;
    }

    // 方法
    public double findAverage(int... nums) {
        /*
        求平均值
        @return: average (double)

        * */
        int sum = 0; // 方法中的局部变量没有初始值，所以这里需要显示初始化
        double average = 0.0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        average = sum / (double)nums.length;
        return average;
    }

    public int maximum(int... nums) {
        int m;
        if (nums.length == 0) {
            throw new RuntimeException("必须输入至少一个数");
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            m = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (m < nums[i]) {
                    m = nums[i];
                }
            }
        }
        return m;
    }

    public int minimum(int... nums) {
        int m;
        if (nums.length == 0) {
            throw new RuntimeException("必须输入至少一个数");
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            m = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (m > nums[i]) {
                    m = nums[i];
                }
            }
        }
        return m;
    }


    public double aver() {
        // average score
        return findAverage(math, english, computer);
    }

    public int max() {
        return maximum(math, english, computer);
    }

    public int min() {
        return minimum(math, english, computer);
    }

    public String toString() {
        String info = String.format("name: %s, number: %d, average score: %.2f\n", this.name, number, aver());
        return info;
    }
}
