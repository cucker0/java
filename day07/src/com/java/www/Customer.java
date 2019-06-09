/*
客户

* */

package com.java.www;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    // 构造器
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 方法
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void showInfo() {
        System.out.printf("Customer [%s, %s] has a account: id is %d, annualInterestRate is %.2f%%, balance is ￥%.2f",
                firstName, lastName, this.getAccount().getId(), this.getAccount().getAnnualInterestRate() * 100, this.getAccount().getBalance()
        );
    }
}
