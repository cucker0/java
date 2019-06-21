/*
interface 接口

* interface是与类等级平级的一个概念
* 接口可以看做是一个特殊的抽象类。
* 接口是常量、抽象方法的集合，不能包含变量、一般的方法
* 接口定义的是一种功能。次功能可以被类实现（implements）

* */

package com.java.www;

public class InterfaceTest {
}

interface AA {
    // 常量
    // 接口里所有的常量都是被  public static final 修饰。不写也会默认加上
    public static final int I = 99;
    boolean FLAG = false;

    // 方法
    // 抽象方法：所有的方法都是被 public abstract 修饰。不写默认也会加上
    abstract void eat();
    void walk();
}

abstract class BB implements AA{

}

