/*
客户信息管理系统增强版

程序入口

* */

package com.java.CustomerSystem2;

public class CustomerSystem {
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        CustomerList list = customerView.getList();
        // 添加客户资料
        Customer customer1 = new Customer("西河凤", true, 23, "138 2666 1333", "xihef@qq.com");
        Customer customer2 = new Customer("肖思琪", false, 30, "142 2666 1333", "xiaosiqi@163.com");
        Customer customer3 = new Customer("马道", false, 28, "133 2666 1333", "madao@hotmail.com");
        Customer customer4 = new Customer("王守山", true, 21, "135 2666 1333", "wangshoushan@gmail.com");
        Customer customer5 = new Customer("雷锋", true, 21, "135 2666 1333", "wangshoushan@gmail.com");
        Customer customer6 = new Customer("胡小雪", true, 22, "135 2666 1335", "wangshoushan@gmail.com");
        Customer customer7 = new Customer("地根生", true, 55, "135 2666 1334", "wangshoushan@gmail.com");
        Customer customer8 = new Customer("立法正", true, 18, "135 2666 1336", "wangshoushan@gmail.com");
        Customer customer9 = new Customer("牛根生", true, 33, "135 2666 1337", "wangshoushan@gmail.com");
        Customer customer10 = new Customer("顾雪丽", true, 18, "135 2666 1338", "wangshoushan@gmail.com");
        Customer customer11 = new Customer("启达贵", true, 25, "135 2666 1339", "wangshoushan@gmail.com");
        list.addCustomer(customer1);
        list.addCustomer(customer2);
        list.addCustomer(customer3);
        list.addCustomer(customer4);
        list.addCustomer(customer5);
        list.addCustomer(customer6);
        list.addCustomer(customer7);
//        list.addCustomer(customer9);
//        list.addCustomer(customer10);
        list.addCustomer(customer11);
        list.addCustomer(customer11);

        // 进入主菜单
        customerView.mainMenu();
    }
}
