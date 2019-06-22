/*
interface 接口

* interface是与类等级平级的一个概念
* 接口可以看做是一个特殊的抽象类。
* 接口是常量、抽象方法的集合，只能有常量和抽象方法，不能包含变量、一般的方法
* 没有构造器，也就不能实例化
* 接口定义的是一种功能。此功能可以被类实现（implements）
* 接口里所有的常量都是被  public static final 修饰。不写也会默认加上
* 所有的方法都是被 public abstract 修饰。不写默认也会加上
* 实现接口的类，必须重写所有的抽象方法，才能实例化。若没有重写所有的方法，则此类只能定义为抽象类
* 类可以同时实现多个接口。相当于多重继承。类的继承是单个多层继承的
* 接口可以被接口继承，接口允许多重多层继承，如：interface GG extends AA, DD { }
* 一个类可以同时承继父类、实现接口，必须先写extends，后写implements，如：class EE extends FF implements AA, DD { }
* 与继承关系类似，接口与实现类之间存在多态性

* */

package com.java.www;

public class InterfaceTest {
    public static void main(String[] args) {
        Audi a1 = new Audi("奥迪R8 V10 Spyder", 229.98);
        System.out.println(a1);
        System.out.println(a1.run());
    }
}

interface AA {
    // 常量
    // 接口里所有的常量都是被  public static final 修饰。不写也会默认加上
    public static final int I = 99;
    boolean FLAG = false;
//    int age; // 不能有变量，此处会的报错

    // 方法
    // 抽象方法：所有的方法都是被 public abstract 修饰。不写默认也会加上
    abstract void eat();
    void walk();

}

interface DD {
    int lifeValue();
}


abstract class BB implements AA{

}

class CC implements AA{

    public void eat() {
        System.out.println("eating ...");
    }

    public void walk() {
        System.out.println("walking ...");
    }

}

class FF {
    public boolean status() {
        return true;
    }
}

class EE extends FF implements AA, DD {
    // 多重实现，还可以同时继承一个类
    public void eat() {

    }

    public void walk() {

    }

    public int lifeValue() {
        return 100;
    }
}

interface GG extends AA, DD {
    // 接口允许多重继承
}

//
interface Car {
    public static final int WHEEL = 4;

    // 是自动档
    boolean isAutoGear();
}

interface ChinaCar extends Car {
    /*
    接口继承
    * */
    String NATION = "China";

    String run ();
}


class Audi implements ChinaCar{
    private String model;
    private double price; // 单位：万


    // 构造器
    public Audi() {
        super();
    }

    public Audi(String model, double price) {
        this.model = model;
        this.price = price;
    }

    // 方法
    public boolean isAutoGear() {
        return true;
    }

    public String run() {
        return "120 KM/H在跑";
    }

    public String toString() {
        return "Audi{ " +
                "model='" + model + "'" +
                ", price=" + price + "万" +
                ", isAutoGear=" + isAutoGear() +
                " }";
    }
}


