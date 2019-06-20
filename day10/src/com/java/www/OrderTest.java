package com.java.www;

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println(o1);
    }
}

class Order {
    private int orderId = 100;
    private String orderName;

    {
        orderId = 200;
        orderName = "mai mai";
    }

    // 构造器
    public Order() {
        super();
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    // 方法
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String toString() {
        return "Order{ orderId=" + orderId +
                ", orderName='" + orderName + "'" +
                " }";
    }
}
