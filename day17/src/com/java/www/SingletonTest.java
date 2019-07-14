/*
懒汉式单例模式，线程安全问题修复

* */

package com.java.www;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        Class cls = Singleton.class;
        System.out.println(cls);
    }
}

class Singleton {
    private static Singleton instance = null;

    // 构造器
    private Singleton() {
    }

    // 方法
    public static Singleton getInstance() {
        if (instance == null) {
            // 线程同步，保证线程安全
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
