/*
* 程序员
*
* */

package com.java.domain;

import com.java.service.EmployeeStatus;

public class Programmer extends Employee{
    // 实例变量
    private int memberId;
    private EmployeeStatus status = EmployeeStatus.FREE; // 程序员默认在岗状态为空闲
    private Equipment equipment;

    // 构造器
    public Programmer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Programmer(String name, int age, double salary, Equipment equipment) {
        this(name, age, salary);
        this.equipment = equipment;
    }

    // 方法
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Programmer{ " +
                getFields() +
                ", memberId: " + memberId +
                "Status: " + status +
                " }";
    }
}
