/*
abstract 抽象类
只能修饰 类、方法
目的：让继承的子类去实现(重写方法)

* abstract修饰类：抽象类
    * 不能被实例化
    * 抽象类有构造器（凡是类都有构造器）
    * 有抽象方法的类一定是抽象类
    * 抽象类可以没有抽象方法
    * abstract于访问权限修饰符顺序可先可后，建议先权限修饰符，再abstract。如：public abstract class aa { }

* abstract修饰方法：抽象方法
    * 格式：没有方法体，包括{ }也不能有，即没有{}块。如：public abstract void walk();
    * 抽象方法只保留方法的功能，具体的执行交给继承该抽象的子类去实现，实现方法：子类重写抽象方法
    * 有抽象方法的抽象类的子类，必须实现（重写）所有的抽象方法，才能实例化
    * 抽象类的子类，可以为抽象类，可以只实现一部分抽象方法，还可以再添加新的抽象方法。那么子类必须实现多层父类的抽象方法

* 注意事项
    * abstract不能于private、final、static修饰符公用
    * 不能修饰属性、构造器

* */

package com.java.www;

public class AbstractTest {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.eat();
//        System.out.println(p1);

        Person s1 = new Student("灵气", 30); // 多态
        System.out.println(s1);

        Worker w1 = new Worker();
        w1.walk();

    }
}

abstract class Person {
    private String name;
    protected int age;
//    protected abstract double height; // 不能修饰属性

    // 构造器
    public Person() {
        super();
    }

    /*
    // 不能修饰构造器
    public abstract Person(String name) {
        super();
        this.name = name;
    }
    */

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void eat() {
        System.out.println("eating");
    }

    public abstract void walk();

//    public static abstract void sleep(); // abstract不能与static一起

//    private abstract void see(); // abstract不能与 private一起

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person{" +
                " name='" + name + "'" +
                ", age=" + age +
                " }";
    }

}

class Worker extends Person {

    // 构造器
    public Worker() {
        super();
    }

    // 方法
    public void eat() {
        System.out.println("工人吃饭");
    }

    public void walk() {
        System.out.println("工人走路");
    }

}

class Student extends Person {
    // constructor
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    // methods
    public void eat() {
        System.out.println("student eating");
    }

    public void walk() {
        System.out.println("student walking");
    }

}

abstract class Man extends Person {
    public void walk() {
        System.out.println("男人走路");
    };

    public abstract void smoking();
}

class Driver extends Man {
    @Override
    public void smoking() {
        System.out.println("帅气地吸烟");
    }
}