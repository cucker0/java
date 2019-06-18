package com.java.exercise;

public class Order {
    private int orderId;
    private String orderName;

    // 构造器
    public Order() {
        super();
    }

    public Order(int orderId, String orderName) {
        setOrderId(orderId);
        setOrderName(orderName);
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Order) {
            Order o = (Order)obj;
            if (orderId == o.orderId && orderName == o.orderName) {
                return true;
            }
        }
        return false;
    }

}
