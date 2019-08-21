/*
* 普工员工
* */

package com.java.domain;

public class GeneralStaff extends Employee {

    // 构造器
    public GeneralStaff(String name, int age, double salary) {
        super(name, age, salary);
    }

    public GeneralStaff(String name, boolean sex, int age, double salary) {
        super(name, sex, age, salary);
    }

    // 方法
    @Override
    public String getDescription() {
        return "普通员工";
    }
}
