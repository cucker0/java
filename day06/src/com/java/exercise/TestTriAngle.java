/*
题目：
编写两个类，TriAngle和TestTriAngle，
其中TriAngle中声明私有的底边长base和高height，
同时声明公共方法访问私有变量；
另一个类中使用这些公共方法，计算三角形的面积。


* */

package com.java.exercise;
import java.util.Scanner;

public class TestTriAngle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入三角形的底(单位cm):");
        double base = sc.nextDouble();
        System.out.println("输入三角形的高(单位cm):");
        double height = sc.nextDouble();
        TriAngle ta = new TriAngle(base, height);
        System.out.println("面积：" + ta.findArea());
    }
}

class TriAngle {
    private double base, height;

    // 构造器
    public TriAngle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    // 方法
    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double findArea() {
        double area = 1.0 / 2* base * height;
        return area;
    }
}