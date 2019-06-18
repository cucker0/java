package com.java.www;


import org.junit.Test;

public class TestJUnit {
    public static void main(String[] args) {
        String s1 = "AA";
        String s2 = "BB";

        System.out.println(s1.toString());
    }

    @Test
    public void test1() {
        System.out.println("abc");
        Person p1 = new Person("tong le", 23);
        System.out.println(p1.getName() + ", age: " + p1.getAge());
    }

}
