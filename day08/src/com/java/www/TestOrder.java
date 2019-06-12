package com.java.www;

public class TestOrder {
    public static void main(String[] args) {
        // 同一个包下权限修饰符测试
        Order o1 = new Order();

        // private (不能访问)
        // o1.orderName = "发过香水"; // private 的属性除其所在类内部能访问，其他地方都不能访问
        // o1.privateMethod();

        // default (无修饰符)
        o1.orderId = 35613;
        o1.defaultMethod();

        // protected
        o1.orderPrice = 2000.00;
        o1.protectedMethod();

        // public
        o1.orderDescription = "这是法国香水大卖商场商6.1订单";
        o1.publicMethod();
    }

}
