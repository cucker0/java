/*
线程之间的通信

wait() 线程执行到wait()，就释放当前的锁
notify() 唤醒一个wait()线程
notifyAll() 唤醒所有的wait()线程

题目：
使用两个线程打印 1-100，线程1、线程2交替打印

* */

package com.java.www;

public class ThreadCommunicationTest {
    public static void main(String[] args) {
        ThreadCommunication tc = new ThreadCommunication();
        Thread t1 = new Thread(tc);
        Thread t2 = new Thread(tc);

        t1.setName("唐");
        t2.setName("宋");

        t1.start();
        t2.start();
    }
}

class ThreadCommunication implements Runnable {
    private int num = 100;

    // 方法
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                System.out.println(Thread.currentThread().getName() + ": " + num);
                --num;
                if (num <= 1) {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
