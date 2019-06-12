package com.java.www;

import java.awt.image.CropImageFilter;

public class TestDog {
    public static void main(String[] args) {
        Dog dd = new Dog();
        dd.setName("卡卡西");
        dd.setAge(5);
        dd.setMaster("朱茵");

        dd.showInfo();
        System.out.println(dd.toString()); // print heap object momery address
    }

}

class Creator {
    // 造物主
    private int age;

    // 构造器
    public Creator() {
        super();
        System.out.println("class Creator's constructor");
    }

    // 方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class Animal extends Creator{
    // 动物
    private String name;

    // 构造器
    public Animal() {
        super();
        System.out.println("class Animal's constructor");
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    // 狗
    private String master; // 主人

    // 构造器
    public Dog() {
        super();
        System.out.println("class Dog's constructor");
    }

    // 方法
    public String Dog() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void showInfo() {
        System.out.printf("name: %s, master: %s, age: %s\n", getName(), master, getAge());
    }

}