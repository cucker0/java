/*
题目：
(1)定义Person类,有4个属性：String name; int age; String school;
      String major
(2)定义Person类的3个构造方法:
第一个构造方法Person(String n, int a)设置类的name和age属性；
第二个构造方法Person(String n, int a, String s)设置类的name, age 和school属性；
第三个构造方法Person(String n, int a, String s, String m)设置类的name, age ,school和major属性；
(3)在main方法中分别调用不同的构造方法创建的对象，并输出其属性值。

* */

package com.java.exercise;

public class Person3 {
    public static void main(String[] args) {
        Student s1 = new Student("Ke nan", 18);
        Student s2 = new Student("包青天", 23, "刑侦大学");
        Student s3 = new Student("裘千仞", 41, "东海龙宫", "忍术");
        s1.showInfo();
        s2.showInfo();
        s3.showInfo();

    }
}

class Student {
    private String name;
    private int age;
    private String school;
    private String major;

    // 构造器
    public Student(String n, int a) {
        name = n;
        age = a;
    }

    public Student(String n, int a, String s) {
        name = n;
        age = a;
        school = s;
    }

    public Student(String n, int a, String s, String m) {
        this.name = n;
        this.age = a;
        this.school = s;
        this.major = m;
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

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void showInfo() {
        System.out.printf("name:%s age:%d school:%s major:%s", name, age, school, major);
        System.out.println();
    }
}
