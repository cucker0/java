/*
账户

* */

package com.java.www;

public class Account {
    private int id;
    private double balance; // 余额
    private double annualInterestRate; // 年化利率

    // 构造器
    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    // 方法
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double num) {
        // 取款
        if (num <= balance) {
            balance -= num;
            System.out.printf("成功取出: ￥%.2f\n", num);
        } else {
            System.out.println("您的账户余额不足，取款失败。");
        }
    }

    public void deposit(double num) {
        // 存款
        if (num >= 0) {
            balance += num;
            System.out.printf("成功存入: ￥%.2f\n", num);
        } else {
            System.out.println("系统异常...");
        }
    }

}

