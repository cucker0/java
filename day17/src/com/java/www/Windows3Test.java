/*
线程安全

模拟火车站售票，3个窗口同时售票，总票数为100站，ID分别是1-100

此线程存在线程安全问题：存在重票、错票



* */

package com.java.www;

public class Windows3Test {
    public static void main(String[] args) {
        Windows3 w1 = new Windows3();

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

class Windows3 implements Runnable {
    private int num = 100;
//    Object obj = new Object(); // 作为同步监视器必须为同一个
    Dog obj =  new Dog();

    // 方法
    @Override
    public void run() {
        // Object obj = new Object(); // 作为同步监视器必须为同一个。局部变量每次调用分配一个
        while (true) {
//            synchronized(obj) { 这种方法也是可以的
            synchronized(this) { // this表示当前对象，本题中为w1
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

class Dog {

}