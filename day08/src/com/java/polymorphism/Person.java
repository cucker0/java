package com.java.polymorphism;

public class Person {
    protected String name;
    protected int age;
    long id = 101;

    // 构造器
    public Person() {
        name = "盘古";
        age  = 1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk() {
        System.out.println(name + " 在走路");
    }

    public void watchtTv() {
        System.out.println(name + " 在看电视");
    }

}
