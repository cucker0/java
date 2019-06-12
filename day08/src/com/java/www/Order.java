package com.java.www;

public class Order {
    private String orderName;
    int orderId;
    protected double orderPrice; // 订单价格
    public String orderDescription;

    private void privateMethod () {
        System.out.println("private method");
    }

    void defaultMethod() {
        System.out.println("default (blank) method");
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }

    public void publicMethod() {
        System.out.println("public method");
    }

}

