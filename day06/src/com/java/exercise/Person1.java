/*
题目：
在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18。

* */

package com.java.exercise;

public class Person1 {
    public static void main(String[] args) {
        Person p1 = new Person();
//        p1.setAge(10);
        System.out.println(p1.getAge());

    }
}

class Person {
    private int age;

    // 构造器
    public Person() {
        age = 18;
    }

    public void setAge(int i) {
        age = i;
    }

    public int getAge() {
        return age;
    }
}
