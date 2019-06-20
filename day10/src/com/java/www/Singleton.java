/*
饿汉式单例
建议使用饿汉式单例模式

# 单例的设计模式
* 解决的问题：使得一个类只能够创建一个对象
* 实现
    * 在类的内部创建一个私有静态的该类的对象
    * 定义一个private 空参构造器
    * 定义一个public静态方法回返上面定义的实例


* */

package com.java.www;

public class Singleton {
    // 类变量
    private static Singleton instance = new Singleton();

    // 构造器
    private Singleton() {
        super();
    }

    // 方法
    public static Singleton getInstance() {
        return instance;
    }
}
