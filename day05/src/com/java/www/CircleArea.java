/*
题目：
    利用面向对象的编程方法，设计类Circle计算圆的面积


* */

package com.java.www;
import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入圆的半径(单位:m, double):");
        double r = sc.nextDouble();

        Circle cc1 = new Circle();
        cc1.setRadius(r);
        cc1.printArea();

    }
}

class Circle {
    double radius; // 半径

    public void setRadius(double r) {
        radius = r;
    }

    public double calculateArea() {
        double area;
        area = Math.PI * radius * radius;
        return area;
    }

    public void printArea() {
        System.out.println("Area: " + calculateArea());
    }
}
