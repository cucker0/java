/*
生产者、消费者问题

案例
    生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），
如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。

这里可能出现两个问题：
生产者比消费者快时，消费者会漏掉一些数据没有取到。
消费者比生产者快时，消费者会取相同的数据。


* */

package com.java.www;

import java.util.Properties;

public class ProductorConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk(20);
        Productor p1 = new Productor(clerk);
        Customer c1 = new Customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.start();
        t2.start();

    }
}

class Clerk {
    private int num;

    // 构造器
    public Clerk(int num) {
        super();
        this.num = num;
    }

    // 方法
    public synchronized void produce() {
        if (num >= 20 ) { // 停止生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("库存: " + getNum());
            ++num;
            notifyAll();
        }

    }

    public synchronized void consume() {
        if (num <= 0) { // 停止消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("库存: " + getNum());
            --num;
            notifyAll();
        }
    }

    public int getNum() {
        return num;
    }

}


class Productor implements Runnable {
    private Clerk clerk;

    // 构造器
    public Productor(Clerk clerk) {
        super();
        this.clerk = clerk;
    }

    // 方法
    public void produce() {
        clerk.produce();
    }

    @Override
    public void run() {
        // 不停的生产
        while (true) {
            produce();
        }
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    // 构造器
    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    // 方法
    public void consume() {
        clerk.consume();
    }

    @Override
    public void run() {
        // 不停的买
        while (true) {
            consume();
        }
    }
}

