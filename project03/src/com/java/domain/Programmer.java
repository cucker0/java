/*
* 程序员
*
* */

package com.java.domain;

import com.java.service.EmployeeStatus;

public class Programmer extends Employee{
    // 实例变量
    private int memberId;


    // 构造器
    public Programmer(String name, int age, double salary) {
        super(name, age, salary);
    }

    // 方法
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Programmer{ " +
                getFields() +
                ", memberId: " + memberId +
                " }";
    }
}
