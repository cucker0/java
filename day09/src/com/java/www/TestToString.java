/*
Object类的toString方法：
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    * 当我们打印一个对象的引用时，实际上默认调用的就是这个对象的toString()方法
    * 打印的对象所在的类没有重写Object类中的toString()方法时，调用的toString()就是继承Object中的方法，返回 类型@hashCode
    * 打印的对象所在的类被重写了toString()方法时，调用的就是被重写后的toString()方法

    重写的toString()常常这样写：返回对象的属性信息
    如：
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
* */

package com.java.www;

import java.util.Date;

public class TestToString {
    public static void main(String[] args) {
        Person p1 = new Person("Shitou", 33);
        System.out.println(p1.toString()); // com.java.www.Person@b4c966a
        System.out.println(p1); // com.java.www.Person@b4c966a，打印变量时，调用的是该实体的toString方法

        // String, 包装类, File, Date等类默认就已经重写了toString()方法
        String s1 = "AA";
        String s2 = new String("BB");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s2);

        Date d = new Date();
        System.out.println(d); // Tue Jun 18 15:05:41 CST 2019
    }
}

class Person {
    private String name;
    private int age;

    // 构造器
    public Person() {

    }

    public Person(String name, int age) {
        super();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

/*    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    */
}
