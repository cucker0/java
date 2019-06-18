package com.java.exercise;

public class TestOrder {
    public static void main(String[] args) {
        Order o1 = new Order(2100, "tencent");
        Order o2 = new Order(2100, "tencent");
        Order o3 = o1;
        Order o4 = new Order(3100, "alibaba");

        System.out.println(o1 == o2); // false
        System.out.println(o1.equals(o2)); // true
        System.out.println();
        System.out.println(o1 == o3); // true
        System.out.println(o2.equals(o4)); // fase

    }
}
