/*
模拟火车站售票，3个窗口同时售票，总票数为100站，ID分别是1-100

* */

package com.java.www;

public class WindowsTest {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("w1");
        w2.setName("w2");
        w3.setName("w3");

        w1.start();
        w2.start();
        w3.start();
    }

}

class Windows extends Thread {
    private static int num = 100;

    // 方法
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.printf("%s窗口卖出一张票, ID: %d\n", currentThread().getName(), num);
                --num;
            } else {
                break;
            }
        }

    }

}
