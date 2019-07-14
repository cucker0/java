/*
题目：
银行有一个账户。
有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。

* */

package com.java.exercise;

public class exer1 {
    public static void main(String[] args) {
        Account acc = new Account();
        Customer c1 = new Customer("马九", acc);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);

        t1.setName("储户1");
        t2.setName("储户2");

        t1.start();
        t2.start();

        System.out.println(c1);
    }
}

class Account {
    private int id;
    private double balance;
    private static int init = 1000;

    // 构造器
    public Account() {
        super();
        id = ++init;
    }

    // 方法
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RuntimeException("余额不足！");
        }
    }

    public synchronized void deposit(double amount) {
        balance += amount;
//        try {
//            Thread.currentThread().sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + ":--" + "当前余额：" + balance);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}

class Customer implements Runnable{
    private String name;
    private Account account;

    // 构造器
    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    // 方法
    // 转账
    public void transfer(Account account, double amount) {
        if (this.account.getBalance() >= amount) {
            this.account.withdraw(amount);
            account.deposit(amount);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; ++i) {
            account.deposit(1000);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}


