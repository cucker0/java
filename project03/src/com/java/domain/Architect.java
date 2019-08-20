/*
* 架构师
*
* */

package com.java.domain;

public class Architect extends Employee {
    // 属性
    private int stock; // 持有的股票数量

    // 构造器
    public Architect(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Architect(String name, int age, double salary, int stock) {
        this(name, age, salary);
//        this.stock = stock;
        setStock(stock);
    }

    // 方法
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Architect's stock number must be greater than 0 or equal 0");
        }
    }

    @Override
    public String toString() {
        return "Architect{" +
                getFields() +
                ", stock=" + stock +
                '}';
    }

    @Override
    public String getDescription() {
        return "架构师";
    }
}
