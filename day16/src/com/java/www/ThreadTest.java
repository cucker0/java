/*
多线程
Thread类位于 java.lang包下

创建多线程类方式一：继承java.lang.Thread类
* 要重写Thread类的run()方法，方法内实现要完成的功能
* 一个线程只能执行一次start()
* 执行线程对象的start()的作用
    1. 新启动一个线程
    2. 调用相应的run()方法
* 直接调用run()方法不会新启动一个线程


* */


package com.java.www;

public class ThreadTest {
    public static void main(String[] args) {
        // 创建可多线程类的对象
        SubThread st1 = new SubThread();
        // 调用Thread的start()方法：新启动一个线程；调用相应的run()方法
        st1.start();
        System.out.println(st1.getState());
        st1.start(); // 已经启动的线程再start() 报IllegalThreadStateException异常

        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

}

class SubThread extends Thread {

    // 构造器
    public SubThread() {
        super();
    }

    // 方法
    // 重写Thread类的run()方法，方法内为此子线程要完成的功能
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

}