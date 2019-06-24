package com.java.exercise;

public class Circle {
    protected double radius;

    // 构造器
    public Circle() {
        super();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // 方法
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
