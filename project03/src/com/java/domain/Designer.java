/*
* 设计师
*
* */

package com.java.domain;

public class Designer extends Employee {
    // 实例变量
    private double bonus; // 年终奖金

    // 构造器
    public Designer(String name, boolean sex, int age, double salary) {
        super(name, sex, age, salary);
    }

    // 省略性别为女性
    public Designer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Designer(String name, boolean sex, int age, double salary, double bonus) {
        super(name, sex, age, salary);
        this.bonus = bonus;
    }

    // 方法
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus > 0) {
            this.bonus = bonus;
        } else {
            System.out.println("bonus must be greater than 0");
        }
    }

    @Override
    public String toString() {
        return "Designer{" +
                getFields() +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public String getDescription() {
        return "设计师";
    }
}
