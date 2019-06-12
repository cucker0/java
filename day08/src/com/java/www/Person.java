package com.java.www;

public class Person {
    private String name;
    private int age;
    int id = 1001; // 身份证

    // 构造器
    public Person() {
        // 这里默认有一个 super(); 调用的即 Object类中的空参构造器，Object类时跟类
        this.name = "AA";
        age = 1;
        System.out.println("Person 无参构造器");
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
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

    public void eat() {
        System.out.println("eating");
    }

    public void sleep() {
        System.out.println("sleeping");
    }
}
