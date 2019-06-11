package com.java.pug;

public class Person {
    private String name;
    private int age;

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
        System.out.println(name + "走路");
    }

    public void speek() {
        System.out.println(name + "说话");
    }

    public void showInfo() {
        System.out.printf("name: [%s], age: %s years old\n", name, age);
    }
}
