/*
测试Account、Customs类程序


* */


package com.java.www;


public class TestBanking {
    public static void main(String[] args) {
        Customer cc1 = new Customer("Jane ", "Smith");
        Account acc1 = new Account(1000, 2000, 1.23 / 100);
        cc1.setAccount(acc1);

        acc1 = cc1.getAccount();
        acc1.deposit(100);
        acc1.withdraw(960);
        acc1.withdraw(2000);
        cc1.showInfo();

    }
}
