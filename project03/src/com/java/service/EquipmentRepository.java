/*
* 设备仓库
*
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
    /*
    * 添加设备
    * @param    aEquipment
    *           要添加的设备
    * */
    public void addEquipment(Equipment aEquipment) {
        repository.add(aEquipment);
    }

    /*
    * 查询指定sn的设备
    * @param    sn
    *           要查询的设备的sn
    * */
    public static Equipment getEquipment(int sn) {
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
