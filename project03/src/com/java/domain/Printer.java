/*
* 打印机
*
* */

package com.java.domain;

import com.java.service.EquipmentStatus;
import com.java.service.TeamException;

public class Printer extends EquipmentBasic implements Equipment {
    // 实例变量
    private String name;
    private String type;

    // 构造器
    public Printer(String name) {
        super();
        this.name = name;
    }

    public Printer(String name, String type) {
        this(name);
        this.type = type;
    }

    public Printer(int sn, String name, String type, EquipmentStatus status) throws TeamException {
        super(sn, status);
        setName(name);
        this.type = type;
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0 && name.length() <= 36) {
            this.name = name;
        } else {
            System.out.println("Printer name field length must be greater than 0 and less than or equal to 36");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.length() > 0 && type.length() <= 36) {
            this.type = type;
        } else {
            System.out.println("Printer type field length must be greater than 0 and less than or equal to 36");
        }
    }

    @Override
    public String getDescription() {
        return  "Printer{ " +
                "sn: " + getSn() +
                ", name: '" + + '\'' +
                " }";
    }

    @Override
    public String toString() {
        return "Printer{ " +
                "sn: " + getSn() +
                ", name: '" + + '\'' +
                ", type: '" + type + '\'' +
                ", status: " + this.getStatus() +
                " }";
    }

}



