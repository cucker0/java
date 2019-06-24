package com.java.lab1;

abstract class Employee {
    // 实例变量
    private String name;
    private double number; // 员工工号
    private MyDate birthday;

    // 类变量
    public static int currentMonth;

    // 构造器
    public Employee() {
        super();
    }

    public Employee(String name, double number, MyDate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    abstract double earnings();

    public String toString() {
        return "name=" + name +
                ", number=" + number +
                ", birthday=" + birthday.toDateString();
    }

    public boolean isBirthday() {
        if (currentMonth > 0 && currentMonth <= 12) {
            if (currentMonth == birthday.getMonth()) {
                return true;
            }
        }
        return false;
    }

    public String tips() {
        return isBirthday() ? "这个月你生日，小小100块祝你生日快日" : "";
    }
}
