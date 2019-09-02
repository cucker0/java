package com.java.www;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1() {
        MyInterface person = new MyInterface() {
            @Override
            public void walk() {
                System.out.println("Person walk.");
            }

            @Override
            public String speak(String s) {

                return "Person speak: " + s;
            }
        };

        person.walk();
        System.out.println(person.speak("这是真的吗"));


//        MyInterface dog = () -> System.out.println("Dog walk."); // Multipe non-overriding abstract methos found in interface com.java.www.MyInterface

    }

    /**
     * lambda创建实现自定的函数式接口对象
     */
    @Test
    public void test2() {
        MyInterface2 netbook =  () -> System.out.println("这时一台HUAWEI MateBook X Pro笔记本");

        netbook.getDes();
    }

}
