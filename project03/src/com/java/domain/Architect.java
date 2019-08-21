/*
* 架构师
* 有年终奖、员工股
* */

package com.java.domain;

import com.java.service.TeamException;

public class Architect extends Designer {
    // 属性
    private int stock; // 持有的股票数量

    // 构造器
    // 女性
    public Architect(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Architect(String name, boolean sex, int age, double salary) {
        super(name, sex, age, salary);
    }

    public Architect(String name, boolean sex, int age, double salary, double bonus, int stock) {
        super(name, sex, age, salary, bonus);
        setStock(stock);
    }

    public Architect(int id, String name, boolean sex, int age, double salary, double bonus, int stock) throws TeamException {
        super(id, name, sex, age, salary, bonus);
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
