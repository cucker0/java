/*
接口与实现接口的类之间存在多态

* */

package com.java.www;

public class InterfacePolymorphicTest {
    public static void main(String[] args) {

        Duck d1 = new Duck();
        InterfacePolymorphicTest.ru(d1); // 相当于 runner r = new Duck();
        InterfacePolymorphicTest.sw(d1); // 相当于 swimer r = new Duck();
        System.out.println(InterfacePolymorphicTest.fl(d1)); // 相当于 flier r = new Duck();

    }

    // 多态
    public static void ru(runner r) {
        r.run();
    }

    public static void sw(swimer s) {
        s.swim();
    }

    public static String fl(flier f) {
        return f.fly();
    }
}

interface runner {
    void run();
}

interface swimer {
    public abstract void swim();
}

interface flier {
    String fly();
}

class Duck implements runner, swimer, flier {

    // 构造器
    public Duck() {
        super();
    }

    // 方法
    public void run() {
        System.out.println("两脚掌跑路");
    }

    public void swim() {
        System.out.println("河水里游");
    }

    public String fly() {
        return "展翅飞翔";
    }
}