/*
类的构造器

类的第三个成员：构造器(constructor)，也可以叫构造方法
构造器的作用：创建对象，给对象进行初始化。
与python的class __init__(self):类似

pythhon中的构造器(构造函数): __init__(self):
python中的析构函数(销毁类实体): __del__(self):

* 设计类时，若不显式声明类的构造器的话，程序会提供一个默认的构造器（空参）
* 一旦显式的定义了类的构造器，默认的构造器就不再提供
* 声明构造器格式：权限修饰符 类名(形参) {  }        // 注意跟方法不同的是没有返回值类型
* 类的多个构造器之间构成重载(Over Load)

* */

package com.java.www;

import java.util.Date;

public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person(); // 为什么可以执行这个方法。因为默认已经提供了一个空参的构造器。
        p.setName("黄药师");
        p.setAge(41);
        System.out.println(p.getName() + ", " + p.getAge() + "岁");

        Person p2 = new Person("黄蓉");
        System.out.println(p2.getName() + ", " + p2.getAge() + "岁");

        Person p3 = new Person("小龙女", 23);
        System.out.println(p3.getName() + ", " + p3.getAge() + "岁");
    }
}


class Person {
    // 属性
    private String name;
    private int age;

    // 构造器
    public Person() {

    }

    public Person(String n) {
        name = n;
    }

    public Person(String n, int age) {
        name = n;
        this.age = age;
    }

    // 方法
    public void setName(String n) {
        name = n;
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
}

