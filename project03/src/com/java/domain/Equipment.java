/**
* 电子设备接口
*
* */

package com.java.domain;

public interface Equipment {
    // return this equipment description
    // 列出设备信息
    String getDescription();
    // 获取设备使用的状态
    EquipmentStatus getStatus();
    // 设置设备的使用状态
    void setStatus(EquipmentStatus status);
    // 获取设备的SN号
    int getSn();
    // 设置设备使用者
    void setUser(Employee employee);
    // 获取设备使用者
    Employee getUser();
}
