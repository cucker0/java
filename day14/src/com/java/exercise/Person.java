package com.java.exercise;

public class Person {
    private String name;
    private int age;

    // 构造器
    public Person() {
        super();
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

    @MyTiger("whiteTiger")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ " +
                " name='" + name + '\'' +
                ", age=" + age +
                " }";
    }
}
