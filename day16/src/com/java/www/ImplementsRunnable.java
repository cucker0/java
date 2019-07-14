/*
创建多线程类方式二：通过实现Runable接口
1. 创建一个类实现Runnable接口，并重写public void run()方法
2. 创建一个实现了Runnable接口的类对象
3. 创建Thread对象，把现了Runnable接口的类对象 以形参传递给Thread构造器
4. 启动线程；调用相应的run()方法，这里是p1的run()方法


* */

package com.java.www;

public class ImplementsRunnable {
    public static void main(String[] args) {
        // 创建一个实现了Runnable接口的类对象
        PrintNum p1 = new PrintNum();

        // 创建Thread对象，把现了Runnable接口的类对象 以形参传递给Thread构造器
        Thread th1 = new Thread(p1);
        Thread th2 = new Thread(p1);

        // 启动线程；调用相应的run()方法，这里是p1的run()方法
        th1.start();
        th2.start();


    }
}

class PrintNum implements Runnable {
    // 方法
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }
}
