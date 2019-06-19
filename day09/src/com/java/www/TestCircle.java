/*
static属性应用

* */

package com.java.www;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.1);
        Circle c2 = new Circle(2.1);
        System.out.println(Circle.getTotal());

        System.out.println(c1.getDescription());
        Circle.setDescription("我是一个大大的圆");
        System.out.println(c1.getDescription());
    }
}

class Circle {
    private double radius;
    private static String description = "我是一个圆";
    private static int total; // to save the new class account;

    // 构造器
    public Circle(double radius) {
        super();
        this.radius = radius;
        Circle.total++;
    }

    // 方法
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Circle.description = description;
    }

    public static int getTotal() {
        return Circle.total;
    }
}
