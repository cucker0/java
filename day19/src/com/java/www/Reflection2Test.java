package com.java.www;

import org.junit.Test;

public class Reflection2Test {
    @Test
    public void test1() {
        String className = "com.java.www.Person";
        Class clazz = null;
        try {
            clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            Person p1 = (Person) obj;
            System.out.println(p1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
