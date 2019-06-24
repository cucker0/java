package com.java.exercise;

public class TestInterface {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(1.1);
        ComparableCircle c2 = new ComparableCircle(3.1);
        ComparableCircle c3 = new ComparableCircle(3.1);
        System.out.println(c1.compareTo(c2));
        System.out.println(c2.compareTo(c3));
        System.out.println(c3.compareTo(c1));

        System.out.println();
        ComparableRectangle r1 =  new ComparableRectangle(2, 3);
        ComparableRectangle r2 =  new ComparableRectangle(3, 2);
        ComparableRectangle r3 =  new ComparableRectangle(3, 5);
        System.out.println(r1.compareTo(r2));
        System.out.println(r1.compareTo(r3));
        System.out.println(r3.compareTo(r2));
    }
}
