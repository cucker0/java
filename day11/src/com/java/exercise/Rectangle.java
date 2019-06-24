/*
矩形

* */

package com.java.exercise;

public class Rectangle {
    private double wide;
    private double length;

    // 构造器
    public Rectangle() {
        super();
    }

    public Rectangle(double wide, double length) {
        this.wide = wide;
        this.length = length;
    }

    // 方法
    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findArea() {
        return Math.PI * wide * length;
    }

}
