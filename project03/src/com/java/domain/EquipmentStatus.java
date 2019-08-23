/*
* 设备使用状态
* 自定义枚举类，不使用JDK自带的 enum
* 设备状态有：
*   FREE 空闲，可以被领取
*   USING 使用中，已经别领取
*   SCRAP 已报废，设备做报废处理了
*
* */

package com.java.domain;

public class EquipmentStatus {
    // 类常量
    public static final EquipmentStatus FREE = new EquipmentStatus("FREE", "待用");
    public static final EquipmentStatus USING = new EquipmentStatus("USING", "使用中");
    public static final EquipmentStatus SCRAP = new EquipmentStatus("SCRAP", "已作废");

    // 类变量
    private static EquipmentStatus[] installs = new EquipmentStatus[]{FREE, USING, SCRAP};

    // 实例变量
    private final String NAME;
    private final String DISCRIPTION;

    // 构造器
    private EquipmentStatus(String name, String discription) {
        NAME = name;
        this.DISCRIPTION = discription;
    }

    // 方法
    public String getName() {
        return NAME;
    }

    public String getDiscription() {
        return DISCRIPTION;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static EquipmentStatus[] values() {
        // return all instance of this class
        return installs;
    }
}
