/*
题目：
修改上题中类和构造器，增加name属性,使得每次创建Person对象的同时初始化对象的age属性值和name属性值。

* */

package com.java.exercise;

public class Person2 {
    public static void main(String[] args) {
        PersonMax p2 = new PersonMax("Benguo", 23);
        p2.showInfo();
    }
}

class PersonMax {
    String name;
    int age;

    // 构造器
    public PersonMax(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void showInfo() {
        System.out.println("naem: " + name +  "\nage: " + age);
    }
}
