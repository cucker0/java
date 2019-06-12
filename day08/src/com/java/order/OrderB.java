package com.java.order;

import com.java.www.Order;

public class OrderB {
    public static void main(String... args) {
        // 不同包权限修饰符测试
        Order o2 = new Order();

        // private (不能访问)
        // o2.orderName = "老板货";
//        o2.privateMehtod();

        // default (不能访问)
        // o2.orderId = 314000;
//        o2.defaultMethod();

        // protected (不能访问)
        // o2.orderPrice = 100.00;
//        o2.protectedMethod();

        // public
        o2.orderDescription = "人造肉订单";
        o2.publicMethod();
    }

}

class OrderBig extends Order {
    // 继承的子类
    public void showInfo() {
        // protected (可以访问到)
        orderPrice = 100.00;
        protectedMethod();

        // public (可以访问到)
        orderDescription = "人造肉订单很赚钱";
        publicMethod();

    }
}
