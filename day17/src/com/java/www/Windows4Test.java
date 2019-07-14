/*
线程安全

模拟火车站售票，3个窗口同时售票，总票数为100站，ID分别是1-100

此线程存在线程安全问题：存在重票、错票



* */

package com.java.www;

public class Windows4Test {
    public static void main(String[] args) {
        Windows4 w1 = new Windows4();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("1号");
        t2.setName("2号");
        t3.setName("3号");

        t1.start();
        t2.start();
        t3.start();


    }
}

class Windows4 implements Runnable {
    private int num = 100;


    // 方法
    @Override
    public void run() {
        while (true) {
            show();
        }

    }

    // 同步方法
    synchronized void show() {
        if (num > 0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s窗口卖出一张票, ID: %d\n", Thread.currentThread().getName(), num);
            --num;
        }
    }

}
