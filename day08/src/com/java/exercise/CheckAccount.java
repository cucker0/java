package com.java.exercise;

public class CheckAccount extends Account{
    // 可透支的账户
    private double overdraft; // 可透支额度

    // 构造器
    public CheckAccount(int id, double balance, double annualInterestrate, double overdraft) {
        super(id, balance, annualInterestrate);
        this.overdraft = overdraft;
    }

    // 方法
    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void withdraw(double amount) {
        // 重写 取钱方法
        if (amount <= balance) {
            balance -= amount;
        } else if (amount <= (balance + overdraft)) {
            overdraft = balance + overdraft - amount;
            balance = 0;
        } else {
            System.out.println("超过了可透支额的限额");
        }
    }
}
