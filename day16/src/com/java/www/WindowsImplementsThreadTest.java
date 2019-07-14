/*
以实现Runnable接口方式写多线程类：
模拟火车站售票，3个窗口同时售票，总票数为100站，ID分别是1-100

* */

package com.java.www;

public class WindowsImplementsThreadTest {
    public static void main(String[] args) {
        Windows2 w1 = new Windows2();

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

class Windows2 implements Runnable {
    private int num = 100;

    // 方法
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.printf("%s窗口卖出一张票, ID: %d\n", Thread.currentThread().getName(), num);
                --num;
            } else {
                break;
            }
        }

    }

}
