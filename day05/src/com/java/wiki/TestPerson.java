/*
题目：
创建程序,在其中定义两个类：
Person和TestPerson类。
定义如下：
    用setAge()设置人的合法年龄(0~130)，
    用getAge()返回人的年龄。
    在TestPerson类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性。
* */

package com.java.wiki;

import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println("请输入年龄(0 - 130]：");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        p1.setAge(age);
        System.out.println(p1.getAge() + "岁");
    }
}

class Person {
    private int age;

    public void setAge(int n) {
        if (n > 0 && n <= 130) {
            age = n;
        } else {
            System.out.println("输入的年龄不合法，年龄范围(0 - 130]");
        }
    }

    public int getAge() {
        return age;
    }
}