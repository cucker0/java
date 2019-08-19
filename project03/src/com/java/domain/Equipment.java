/*
* 电子设备接口
*
* */

package com.java.domain;

import com.java.service.EquipmentStatus;

public interface Equipment {
    // return this equipment description
    String getDescription();
    EquipmentStatus getStatus();
    void setStatus(EquipmentStatus status);
    int getSn();
}
