/*
死锁

出现原因
* 都在等对方释放锁


写程序时尽量避免死锁
如何避免死锁：
* 专门的算法、原则
* 尽量少用同步资源的定义

* */

package com.java.www;

public class ThreadDeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        StringBuffer sb = new StringBuffer();

        DeadLock1 d1 = new DeadLock1(lock1, lock2, sb);
        DeadLock2 d2 = new DeadLock2(lock1, lock2, sb);

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.setName("d1");
        t2.setName("d2");

        t1.start();
        t2.start();

    }
}

class DeadLock1 implements Runnable {
    private Object lock1;
    private Object lock2;
    private StringBuffer sb;

    // 构造器
    public DeadLock1(Object lock1, Object lock2, StringBuffer sb) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sb = sb;
    }

    // 方法
    @Override
    public void run() {
        synchronized(lock1) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append("A");
            synchronized(lock2) { // 必须获得了lock1、lock2 锁执行权才能往下执行
                sb.append("B");
                System.out.println(Thread.currentThread().getName() + ": " + sb);
        }
        }

    }
}

class DeadLock2 implements Runnable {
    private Object lock1;
    private Object lock2;
    private StringBuffer sb;

    // 构造器
    public DeadLock2(Object lock1, Object lock2, StringBuffer sb) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sb = sb;
    }

    // 方法
    @Override
    public void run() {
        synchronized (lock2) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append("C");
            synchronized(lock1) { // 必须获得了lock1、lock2 锁执行权才能往下执行
                sb.append("D");
                System.out.println(Thread.currentThread().getName() + ": " + sb);
            }
        }
    }
}




