/*
Cylinder: 圆柱
* */
package com.java.exercise;

public class Cylinder extends Circle{
    private double length;

    // 构造器
    Cylinder() {
        length = 1; // it will auto exchange to double
    }

    // 方法
    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double findVolume() {
        // 计算体积
        return this.findArea() * length;
    }

    public double findSurfaceArea() {
        // 求面积
        return this.findArea() * 2 + Math.PI * this.getRadius() * 2 * length;
    }
}
