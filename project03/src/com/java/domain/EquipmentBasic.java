/*
* 设备基本属性
*
* */

package com.java.domain;

import com.java.service.EquipmentStatus;

public class EquipmentBasic {
    // 类属性
    private EquipmentStatus status = EquipmentStatus.FREE; // 设备的使用状态，初始状态为空闲

    // 构造器
    public EquipmentBasic() {}

    // 方法
    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }
}
