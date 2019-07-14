/*
以实现Runnable接口方式写多线程类：
模拟火车站售票，3个窗口同时售票，总票数为100站，ID分别是1-100

此线程存在线程安全问题：存在重票、错票

* 线程安全问题存在的原因
    * 由于一个在操作共享数据过程中，为执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题
* 如何解决线程安全问题
    * 必须让一个线程操作共享数据完毕后，其他线程才有机会参与共享数据的操作
* java如何实现线程的安全：线程的同步机制
    * 方式一：同步代码块
    ```
    synchronized(同步监视器) {
        // 需要被同步的代码块（操作共享数据的代码）
    }

    1. 共享数据：多个线程共同操作的同一个数据（变量）
    2. 同步监视器：有任意一个类的对象来充当。哪个线程获取到此监视器，谁就执行{ } 内被同步的代码。俗称：锁
    3. 要求所有的线程共用一把锁，

    注意：在实现的多线程方式中，线程同步，可以使用this充当锁。但是在继承的方式慎用this，要考虑对象只有一个

    静态方法中：可以使用类本身充当锁

    ```

    * 方式二：同步方法
        将操作共享数据的方法声明为 synchronized, 此方法为同步方法。能够保证当一个线程在执行时，其他线程
        在外登台此线程执行完此方法

        同步方法的锁：this，这是默认的，也无法手动指定

线程同步弊端：效率变低了，因为同一时间只能有一个线程访问共享数据

只有需要操作共享数据的常才需要考虑线程的同步

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
