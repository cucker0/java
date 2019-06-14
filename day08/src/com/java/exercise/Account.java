/*
继承练习

* */

package com.java.exercise;

public class Account {
    private int id;
    protected double balance;
    private double annualInterestrate; // 年化利率

    // 构造器
    public Account(int id, double balance, double annualInterestrate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestrate = annualInterestrate;
    }

    // 方法
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestrate() {
        return annualInterestrate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestrate(double annualInterestrate) {
        this.annualInterestrate = annualInterestrate;
    }

    public double getMonthlyInterest(){
        return annualInterestrate / 12;
    }

    public void withdraw(double amount) {
        // 取钱
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("您的账户余额不足，取款失败！！！");
        }
    }

    public void deposit(double amount) {
        // 存钱
        if (amount >= 0) {
            balance += amount;
        } else {
            System.out.println("系统出错了...");
        }
    }

}
