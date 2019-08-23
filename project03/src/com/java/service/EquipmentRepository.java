/**
* 设备管理操作
*   1. 设备仓库，保存所有设备信息
*   2. 提供设备的相关操作
* */

package com.java.service;

import com.java.domain.Equipment;

import java.util.ArrayList;

public class EquipmentRepository {
    // 类变量
    private static ArrayList<Equipment> repository = new ArrayList<>();

    // 构造器
    public EquipmentRepository() {

    }

    // 方法
    /**
    * 添加设备
    * @param    aEquipment
    *           要添加的设备
    * */
    public void addEquipment(Equipment aEquipment) {
        repository.add(aEquipment);
    }

    /**
    * 查询指定sn的设备
    * @param    sn
    *           要查询的设备的sn
    * */
    public static Equipment getEquipment(int sn) {
        // 遍历repository，查找设备
        for (Equipment e : repository) {
            if (e.getSn() == sn) {
                return e;
            }
        }
        return null;
    }

    public static ArrayList<Equipment> getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return "EquipmentRepository{" +
                repository +
                "}";
    }
}
