package com.java.exercise;

public class Person {
    protected String name;
    protected char sex; // m:male, f:femal
    protected int age;

    // 构造器
    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    // 方法
    public String toString() {
        if (sex == 'm') {
            return "male";
        } else if (sex == 'f') {
            return "female";
        } else {
            return "error";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
