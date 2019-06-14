package com.java.exercise;

public class TestCheckAccount {
    public static void main(String[] args) {
        CheckAccount ca = new CheckAccount(1122, 20000, 4.5 / 100, 5000);
        ca.withdraw(5000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());
        ca.withdraw(18000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());
        ca.withdraw(30000);
        System.out.println(ca.getBalance());
        System.out.println(ca.getOverdraft());

    }
}
