package com.java.exercise;

public class GeometricObject {
    /*
    几何形状
    * */

    protected String color;
    protected double weight;

    // 构造器
    protected GeometricObject(String color, double weight) {

    }

    // 方法
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea() {
        // 求面积
        return 0.0;
    }

}

class Circle extends GeometricObject {
    private double radius;

    // 构造器
    public Circle(double radius, String color, double weigh) {
        super(color, weigh);
        this.radius = radius;
    }

    // 方法
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        // cacl circle area
        System.out.println("find Circle area");
        return Math.PI * radius * radius;
    }

}

class MyRectangle extends GeometricObject{
    // Rectangle
    private double width;
    private double height;

    // 构造器
    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        setWidth(width);
        setHeight(height);
    }

    // 方法
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("宽必须大于0");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("高必须大于0");
        }
    }

    public double findArea() {
        System.out.println("find MyRectangle area");
        return width * height;
    }

}