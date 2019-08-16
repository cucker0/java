/*
* 设备使用状态
* 自定义枚举类，不使用JDK自带的 enum
* 设备状态有：
*   FREE 空闲，可以被领取
*   USING 使用中，已经别领取
*   SCRAP 已报废，设备做报废处理了
*
* */

package com.java.service;

public class EquipmentStatus {
    // 类常量
    private static final EquipmentStatus FREE = new EquipmentStatus("FREE");
    private static final EquipmentStatus USING = new EquipmentStatus("USING");
    private static final EquipmentStatus SCRAP = new EquipmentStatus("SCRAP");

    // 实例变量
    private final String NAME;

    // 构造器
    private EquipmentStatus(String name) {
        NAME = name;
    }

    // 方法
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return getName();
    }
}
