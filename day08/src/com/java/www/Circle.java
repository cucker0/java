/*
Circle: 圆

* */
package com.java.www;

public class Circle {
    private double radius;

    // 构造器
    Circle() {
        radius = 1;
    }

    // 方法
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        // 计算圆的面积
        return Math.PI * radius * radius;
    }
}
