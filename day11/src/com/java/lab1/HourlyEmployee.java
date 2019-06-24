/*
按小时计算工资的员工

* */

package com.java.lab1;

public class HourlyEmployee extends Employee{
    private double wage;
    private double hour;

    // 构造器
    public HourlyEmployee(String name, double number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage; // 每小时工价
        this.hour = hour;
    }

    // 方法
    @Override
    double earnings() {
        if (isBirthday()) {
            return wage * hour + 100;
        }
        return wage * hour;
    }

    public String toString() {
        return "HourlyEmployee{ " +
                super.toString() +
                ", salary=￥" + earnings() +
                ", wage=￥" + wage + "/hour" +
                ", hour=" + hour +
                " } " +
                tips();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
