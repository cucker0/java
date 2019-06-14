package com.java.exercise;

public class TestAccount {
    public static void main(String[] args) {
        Account acc = new Account(1122, 20000, 4.5 / 100);
        acc.withdraw(2500);
        acc.deposit(3000);
        System.out.println(acc.getBalance());
        System.out.println(acc.getMonthlyInterest());
    }
}
