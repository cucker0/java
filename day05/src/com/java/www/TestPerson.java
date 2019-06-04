package com.java.www;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "zhang gazi";
        p1.age = 15;
        p1.sex = 1;
        p1.showInfo();
        p1.study();
        p1.showAge();
        p1.addAge();
        p1.showAge();

        Person p2 = new Person();
        p2.name = "白发魔女";
        p2.age = 21;
        p2.sex = 0;
        p2.showInfo();
        p2.study();
        p2.showAge();
        p2.addAge();
        p2.showAge();
        p2.showInfo();
    }
}

class Person {
    /*
    Person class
    * */
    String name;
    int age;
    int sex; // 0：女性    1：男性

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println(age);
        // return; // 加一个返回空白也可以，不会报错，但显多余
    }

    public int addAge() {
        age += 2;
        return age;
    }

    public void showInfo() {
        System.out.println("name:" + name + "  sex:" +  sex);
        System.out.println("age:");
        showAge();
    }
}