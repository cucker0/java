package com.java.exercise;

public class MyDate {
    private int year;
    private int month;
    private int day;

    // 构造器
    public MyDate() {
        super();
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 方法
    public void setDate(int year, int month, int day) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("年份不能为负数");
        }

        if (month > 0) {
            this.month = month;
        } else {
            System.out.println("月份不能为负数");
        }

        if (day > 0) {
            this.day = day;
        } else {
            System.out.println("天不能为负数");
        }
    }

    // overrides equals method
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MyDate) {
            MyDate d = (MyDate)obj;
            if (year == d.year && month == d.month && day == d.day) {
                return true;
            }
        }
        return false;
    }

}
