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

public enum Status {
    // 类实例，且是类常量
    FREE("FREE"),
    BUSY("BUSY"),
    VOCATION("VOCATION");

    // 属性
    private final String NAME;

    // 构造器
    Status(String name) {
        this.NAME = name;
    };

    // 方法
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return getName();
    }
}
