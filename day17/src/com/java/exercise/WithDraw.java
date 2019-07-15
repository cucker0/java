/*
题目：模拟银行取钱的问题
1.定义一个Account类
1）该Account类封装了账户编号（String）和余额（double）两个属性
2）设置相应属性的getter和setter方法
3）提供无参和有两个参数的构造器
4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
2.提供一个取钱的线程类
1）提供了Account类的account属性和double类的取款额的属性
2）提供带线程名的构造方法
3）run()方法中提供取钱的操作
3.在主类中创建线程进行测试。考虑线程安全问题。



* */


package com.java.exercise;

public class WithDraw {
    public static void main(String[] args) {
        Account2 acc = new Account2("sz101", 3000);

        MyThread mt1 = new MyThread(acc, 100, "取钱1");
        MyThread mt2 = new MyThread(acc, 20, "取钱2");
        MyThread mt3 = new MyThread(acc, 200, "取钱3");

        mt1.start();
        mt2.start();
        mt3.start();

    }
}

class Account2 {
    private String id;
    private double balance;


    // 构造器
    public Account2() {
        super();
    }

    public Account2(String id, double balance) {
        setId(id);
        setBalance(balance);
    }

    // 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void withDraw(double amount) {
        if (amount <= balance) {
            System.out.println("取: ￥" + amount);
            balance -= amount;
            System.out.println("余额:" + balance);
        } else {
            Thread.currentThread().stop();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account2 account2 = (Account2) o;

        if (Double.compare(account2.balance, balance) != 0) return false;
        return id != null ? id.equals(account2.id) : account2.id == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class MyThread extends Thread {
    private Account2 account;
    private double amount;

    // 构造器
    public MyThread(Account2 account, double amount, String threadName) {
        this.account = account;
        this.amount = amount;
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        account.withDraw(amount);
    }
}