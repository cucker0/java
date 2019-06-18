package com.java.exercise;

public class TestCirle {
    public static void main(String[] args) {
        Circle c1 = new Circle(3.0);
        c1.setColor("red");
        Circle c2 = new Circle(3.0);
        c2.setColor("black");

        System.out.println(c1.getColor() == c2.getColor()); // false
        System.out.println(c1.equals(c2)); // true
        System.out.println("c1 radius: " + c1.toString());
    }
}
