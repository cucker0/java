/*
* 员工在岗状态类
* 此类为枚举类
*
* 状态包括：
*   FREE 空闲，未加入任何团队
*   BUSY 已经加入团队
*   VOCATION 正在休假
* */

package com.java.service;

public enum EmployeeStatus {
    // 类实例，且是类常量
    FREE("FREE", "正常"), // 正常，未加入团队
    BUSY("BUSY", "已入团队"), // 已经加入团队
    VOCATION("VOCATION", "休假中"), // 休假中
    RESIGNED("RESIGNED", "已离职"); // 已离职

    // 属性
    private final String NAME;
    private final String DISCRIPTION;

    // 构造器
    EmployeeStatus(String name, String discription) {
        this.NAME = name;
        this.DISCRIPTION = discription;
    };

    // 方法
    public String getName() {
        return NAME;
    }

    public String getDiscription() {
        return DISCRIPTION;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
