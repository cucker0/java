/*
Collection


* */

package com.java.www;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class CollectionTest {
    @Test
    public void test1() {
        Collection c1 = new ArrayList();

        // size() 返回集合中元素的个数
        System.out.println(c1.size());

        // add(Object obj) 向集合中添加一个元素
        c1.add(123);
        c1.add("AA");
        c1.add(new Date());
        c1.add("BB");
        System.out.println(c1.size());

        // addAll(Collection coll) 将一个集合所有元素添加到当前集合中
        Collection c2 = Arrays.asList(1, 2, 3);
        c1.addAll(c2);
        System.out.println(c1.size());

        // 查看所有元素
        System.out.println(c1);
        System.out.println(c2);

        // isEmpty() 判断集合是否为空，是返回true，否则false
        System.out.println(c1.isEmpty());

        // clear() 清空合集所有元素
        c1.clear();
        System.out.println(c1);
        System.out.println(c1.isEmpty());

    }

    @Test
    public void test2() {
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add("AA");
        c1.add(new Date());
        c1.add(new String("BB"));
        c1.add(new Person("锅巴佬", 23));
        Person p59 = new Person("老司机", 44);
        c1.add(p59);
        c1.add(new Dog("赛驹", "佳源"));

        // contains(Object obj) 判断集合中是否包含指定的元素obj，如果包含返回true，否则false。
        // 判断方法：用到了类中的equals(Object o)方法
        boolean b60 = c1.contains(123);
        System.out.println(b60);
        System.out.println(c1.contains("AA"));
        System.out.println(c1.contains(p59)); // true
        System.out.println(c1.contains(new Person("老司机", 44))); // false
        System.out.println(c1.contains(new Dog("赛驹", "佳源"))); // true，Dog 已重写了equal(Object o) 方法
        System.out.println(c1.contains("BB"));

    }

}

class Person {
    private String name;
    private int age;

    // 构造器
    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Dog {
    private String name;
    private String master;

    // 构造器
    public Dog() {
    }

    public Dog(String name, String master) {
        this.name = name;
        this.master = master;
    }

    // 方法
    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", master='" + master + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (name != null ? !name.equals(dog.name) : dog.name != null) return false;
        return master != null ? master.equals(dog.master) : dog.master == null;

    }

}