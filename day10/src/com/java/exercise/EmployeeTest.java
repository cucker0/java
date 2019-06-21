/*
题目：
    编写一个Employee类，声明为抽象类，包含如下三个属性：name，id，salary。
提供必要的构造器和抽象方法：work()。
对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。


* */

package com.java.exercise;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new CommonEmployee("莉莉", 10001, 9000);
        System.out.println(e1);
        e1.work();

        System.out.println();
        Manager m1 = new Manager("力天", 2, 50000);
        m1.setBonus(88000);
        m1.work();
        m1.showInfo();

    }
}

abstract class Employee {
    // 实例变量
    private String name;
    private long id;
    private double salary; // 工资

    // 构造器
    public Employee() {
        super();
    }

    public Employee(String name, long id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // 方法
    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return this.getClass() + "{" +
                " name=\"" + name + '"' +
                ", id=" + id +
                ", salary=" + salary +
                " }";
    }
}


class CommonEmployee extends Employee {
    /*
    普通员工
    * */

    // constructor
    public CommonEmployee() {
        super();
    }

    public CommonEmployee(String name, long id, double salary) {
        super(name, id, salary);
    }

    // methods
    public void work() {
        System.out.printf("[%s] common empolyee hard working.\n", getName());
    }
}


class Manager extends Employee {
    private double bonus;

    // 构造器
    public Manager(String name, long id, double salary) {
        super(name, id, salary);
    }

    // 方法
    public void work() {
        System.out.printf("[%s] Manager happy working.\n", getName());
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void showInfo() {
        this.toString();
        System.out.printf("bonus: %s￥\n", getBonus());
    }
}
