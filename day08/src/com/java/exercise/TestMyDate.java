package com.java.exercise;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2019, 2, 11);
        MyDate d2 = new MyDate(2019, 2, 11);
        MyDate d3 = new MyDate(2019, 6, 18);

        System.out.println(d1 == d2); // false
        System.out.println(d1.equals(d2)); // true
        System.out.println(d1.equals(d3)); // false

    }

}

