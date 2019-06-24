package com.java.lab1;

public class MyDate {
    private int year;
    private int month;
    private int day;

    // 构造器
    public MyDate() {
        super();
    }

    public MyDate(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 方法
    public String toDateString() {
        return String.format("%d年%d月%d日", year, month, day);
    }

    public void setMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
