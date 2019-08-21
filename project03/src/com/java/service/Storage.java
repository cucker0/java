/*
* 数据存取
* 功能：
*       * 从文件加载数据，解析文本数据
*       * 从程序保存数据到文件
* */

package com.java.service;

import com.java.domain.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Storage {
    // 保存数据的文件路径，使用绝对路径
    private static final String filePath = "E:\\dev\\java_2019\\project03\\src\\com\\java\\service\\Data.java";
    private static NameListService listService = new NameListService();
    private static TeamsService teamsService = new TeamsService();
    private static EquipmentRepository equipmentRepository = new EquipmentRepository();

    // 构造器
    public Storage() {

    }

    // 方法
    /*
    * 从文件加载数据
    * */
    public void read() {

    }

    /*
    * 从程序保存数据到文件
    * */
    public void save() {

    }

    private void readEmployees() {
        // 设置Employee类的init
        Employee.setInit(Data.EMPLOYEE_INIT);

        // 解析数据
        String[][] employees = Data.EMPLOYEES;
        for (String[] em : employees) {
            int type = Integer.parseInt(em[0]);
            int id = Integer.parseInt(em[1]);
            int teamId = Integer.parseInt(em[2]);
            String statusString = em[3];
            EmployeeStatus status = null;
            try {
                status = EmployeeStatus.valueOf(statusString);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            String name = em[4];
            boolean sex = Boolean.parseBoolean(em[5]);
            int age = Integer.parseInt(em[6]);
            double salary = Double.parseDouble(em[7]);


        }

    }

    private void readTeams() {
        // 设置 Team类的init
        Team.setInit(Data.TEAMS_INIT);

        // 解析字符串数据
        String[][] teams = Data.TEAMS;
        for (String[] t : teams) {
            int id = Integer.parseInt(t[0]);
            String name = t[1];
            LinkedHashMap<Class, HashMap> membersStructor = new LinkedHashMap<>();
            // 遍历字符串形式的岗位描述，如"Programmer,3,1"
            for (int i = 2; i < t.length; ++i) {
                HashMap hMap = new HashMap();
                String postRequirement = t[i];
                String[] postRequirementSplit = postRequirement.split(",");
                String post = postRequirementSplit[0];
                String max = postRequirementSplit[1];
                try {
                    int m = Integer.parseInt(max);
                    Class clazz = null;
                    if (post.equals("Programmer")) {
                        clazz = Programmer.class;
                    } else if (post.equals("Designer")) {
                        clazz = Designer.class;
                    } else if (post.equals("Architect")) {
                        clazz = Architect.class;
                    }
                    if (clazz != null) {
                        hMap.put("max", m);
                        membersStructor.put(clazz, hMap);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            try {
                Team team = new Team(id, name, membersStructor);
                teamsService.addTeam(team);
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void readEquipment() {
        // 设置EquipmentBasic类的snInit
        EquipmentBasic.setSnInit(Data.EQUIPMENT_SN_INIT);

        // 解析设备数据
        String[][] equipment = Data.EQUIPMENT;
        for (String[] e : equipment) {
            int type = Integer.parseInt(e[0]);
            int sn = Integer.parseInt(e[1]);
            String statusSring = e[2];
            EquipmentStatus status = null;
            for (EquipmentStatus eq: EquipmentStatus.values()) {
                if (statusSring.equals(eq.toString())) {
                    status = eq;
                    break;
                }
            }

            if (type == Data.PC) {
                String model = e[3];
                String display = e[4];
                try {
                    PC pc = new PC(sn, model, display, status);
                    equipmentRepository.addEquipment(pc);
                } catch (TeamException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (type == Data.NOTEBOOK) {
                String model = e[3];
                double price = Double.parseDouble(e[4]);
                try {
                    NoteBook noteBook = new NoteBook(sn, model, price, status);
                    equipmentRepository.addEquipment(noteBook);
                } catch (TeamException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (type == Data.PRINTER) {
                String name = e[3];
                String printerType = e[4];
                try {
                    Printer printer = new Printer(sn, name, printerType, status);
                    equipmentRepository.addEquipment(printer);
                } catch (TeamException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

    }
}
