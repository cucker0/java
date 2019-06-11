package com.java.exercise;

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("居里夫人", 'f',36, 66215, 99, 90, 87 );
        System.out.println("average score: " + s1.aver());
        System.out.println("max score: " + s1.max());
        System.out.println("min score: " + s1.min());
        System.out.println(s1.toString());
    }
}
