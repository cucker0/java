/*
创建多线程类方式二：通过实现Runable接口
1. 创建一个类实现Runnable接口，并重写public void run()方法
2. 创建一个实现了Runnable接口的类对象
3. 创建Thread对象，把现了Runnable接口的类对象 以形参传递给Thread构造器
4. 启动线程；执行Thread对象生成是的构造器形参对象的run()方法


继承方法多线程 与 实现Runnable接口多线程
* 联系：public class Thread implements Runnable { }，都实现了Runnable接口
* 哪个方式好， 实现Runnable接口方式优于继承方法
    * 实现Runnable接口方式避免了java单继承的局限性
    * 如果多个线程要操作同一份资源（数据），更适合用实现方式


* */

package com.java.www;

public class ImplementsRunnable {
    public static void main(String[] args) {
        // 创建一个实现了Runnable接口的类对象
        PrintNum p1 = new PrintNum();

        // 创建Thread对象，把现了Runnable接口的类对象 以形参传递给Thread构造器
        Thread th1 = new Thread(p1);
        Thread th2 = new Thread(p1);

        // 启动线程；执行Thread对象生成器的构造器形参对象的run()方法
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
