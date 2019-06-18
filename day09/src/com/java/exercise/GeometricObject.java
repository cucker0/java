package com.java.exercise;

public class GeometricObject {
    protected String color;
    protected double weight;

    // 构造器
    protected GeometricObject() {
        super();
        color = "white";
        weight = 1.0;
    }

    protected GeometricObject(String color, double weight) {
        super();
        this.color = color;
        this.weight = weight;
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

    public void setWeight() {
        this.weight = weight;
    }



}
