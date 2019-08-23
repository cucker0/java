/*
* 设备基本属性
*
* */

package com.java.domain;

import com.java.service.TeamException;

public class EquipmentBasic {
    // 类变量
    private static int snInit = 1;

    // 实例属性
    private int sn; // 设备序列号
    private EquipmentStatus status = EquipmentStatus.FREE; // 设备的使用状态，初始状态为空闲
    private Employee user; // 使用者

    // 构造器
    public EquipmentBasic() {
        snInitIncrement();
    }

    public EquipmentBasic(int sn, EquipmentStatus status) throws TeamException {
        if (sn < snInit && sn > 0) {
            this.sn = sn;
            this.status = status;
        } else {
            throw new TeamException("sn无效");
        }
    }

    // 方法
    private void snInitIncrement() {
        sn = snInit;
        ++snInit;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee employee) {
        user = employee;
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

    public static int getSnInit() {
        return snInit;
    }

    public static void setSnInit(int init) {
        if (init >= 1) {
            snInit = init;
        } else {
            System.out.println("snInit无效");
        }
    }
}
