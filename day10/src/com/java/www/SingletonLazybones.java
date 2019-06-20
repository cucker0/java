/*
懒汉式单例
可能在线程安全问题。

* */

package com.java.www;

public class SingletonLazybones {
    // 类变量
    // 定义私有静态的该类的对象实例为null
    private static SingletonLazybones instance = null;

    // 构造器
    // 定义私有的空参构造器
    private SingletonLazybones() {}

    // 方法
    // 定义公共静态的方法返回实例，并判断实例是否为null，为null时新建该实例
    public static SingletonLazybones getInstance() {
        if (instance == null) {
            instance = new SingletonLazybones();
        }
        System.out.println(instance);
        return instance;
    }
}
