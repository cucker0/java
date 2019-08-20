/*
* 程序员
*
* */

package com.java.domain;

import com.java.service.EmployeeStatus;

public class Programmer extends Employee{
    // 实例变量
    private String skill; // 技能：java/php/pythons ...


    // 构造器
    public Programmer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Programmer(String name, int age, double salary, String skill) {
        this(name, age, salary);
        setSkill(skill);
    }

    // 方法
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        if (skill.length() > 0 && skill.length() <= 36) {
            this.skill = skill;
        } else {
            System.out.println("invalid skill name");
        }
    }

    @Override
    public String toString() {
        return "Programmer{ " +
                getFields() +
                ", skill: '" + skill + '\'' +
                " }";
    }

    @Override
    public String getDescription() {
        return "程序员";
    }
}
