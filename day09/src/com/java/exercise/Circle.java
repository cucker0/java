package com.java.exercise;

import java.util.Objects;

public class Circle extends GeometricObject{
    private double radius;

    // 构造器
    public Circle() {
        super();
        radius = 1.0;
    }

    public Circle(double radius) {
        super();
        setRadius(radius);
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    // 方法
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("radius must > 0 !!");
        }
    }

    public double findArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    public boolean equals(Circle c) {
        // override equals()
        if (this == c) {
            return true;
        }
        if (c instanceof Circle && getClass() == c.getClass() && c != null) {
            Circle o = (Circle)c;
            if (radius == o.radius) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Circle{radius=" + radius + "}";
    }
}