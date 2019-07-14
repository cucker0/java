/*
继承式线程安全修复


* */

package com.java.www;

public class Windows1Test {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("1号");
        w2.setName("2号");
        w3.setName("3号");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Windows extends Thread {
    private static int num = 100;
    private static Object obj = new Object();

    // 方法
    public void run() {
        while (true) {
//            synchronized (this) { // 本题中的this表示：w1, w2, w3。这样就不是同一个锁，有问题
            synchronized (obj) {
                if (num > 0) {
                    // 增加两次数据造作之间的时间，错票更容易出现
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.printf("%s窗口卖出一张票, ID: %d\n", Thread.currentThread().getName(), num);
                    --num;
                } else {
                    break;
                }
            }
        }
    }

}