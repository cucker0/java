/*
* 设备基本属性
*
* */

package com.java.domain;

import com.java.service.EquipmentStatus;

public class EquipmentBasic {
    // 类变量
    private static int snInit = 0;

    // 实例属性
    private int sn; // 设备序列号
    private EquipmentStatus status = EquipmentStatus.FREE; // 设备的使用状态，初始状态为空闲

    // 构造器
    public EquipmentBasic() {
        snInitIncrement();
    }

    // 方法
    private void snInitIncrement() {
        sn = snInit;
        ++snInit;
    }

    public int getSn() {
        return sn;
    }

    public EquipmentStatus getStatus() {
        return status;
    }

    public void setStatus(EquipmentStatus status) {
        this.status = status;
    }
}
