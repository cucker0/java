package com.java.lab1;

public class SalariedEmployee extends Employee{
    private double monthlySalary;

    // 构造器
    public SalariedEmployee(String name, double number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary =  monthlySalary;
    }

    // 方法
    double earnings() {
        if (isBirthday()) {
            return monthlySalary + 100;
        }
        return monthlySalary;
    }

    public String toString() {
        return "SalariedEmployee{ " +
                super.toString() +
                "current month salary=￥" + earnings() +
                " } " +
                tips();
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}

