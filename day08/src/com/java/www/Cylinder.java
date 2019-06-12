/*
Cylinder: 圆柱
* */
package com.java.www;

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

    public double findArea() {
        // 求圆柱表面积
        double area = super.findArea() * 2 + Math.PI * getRadius() * 2;
        return area;
    }

    public double findVolume() {
        // 计算体积
        return super.findArea() * length;
    }

}
