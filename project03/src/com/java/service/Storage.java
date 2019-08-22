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
import java.util.LinkedList;

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
    * 注意：加载顺
    *   设备->团队->员工
    * */
    public static void read() {
        readTeams();
        readEquipment();
        readEmployees();
    }

    /*
    * 从程序保存数据到文件
    * */
    public static void save() {

    }

    private static void readEmployees() {
        // 设置Employee类的init
        Employee.setInit(Data.EMPLOYEE_INIT);

        // 解析数据
        String[][] employees = Data.EMPLOYEES;
        for (String[] em : employees) {
            int type = Integer.parseInt(em[0]);
            int id = Integer.parseInt(em[1]);
            int teamId = -1;
            try {
                teamId = Integer.parseInt(em[2]);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
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
            String equipmentString = em[8]; // 已领取的设备sn, 多个sn之间使用,分割

            switch (type) {
                case Data.PROGRAMMER:
                    String skill = em.length == 10 ? em[9] : "";
                    try {
                        Programmer p = new Programmer(id, name, sex, age, salary, skill);
                        restoreEmployee(p, teamId, equipmentString);
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case Data.DESIGNER:
                    double bonus = -1.0;
                    try {
                        bonus = Double.parseDouble(em[9]);
                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
                    }
                    try {
                        Designer d = new Designer(id, name, sex, age, salary, bonus);
                        restoreEmployee(d, teamId, equipmentString);
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case Data.ARCHITECT:
                    bonus = -1.0;
                    try {
                        bonus = Double.parseDouble(em[9]);
                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
                    }
                    int stock = Integer.parseInt(em[10]);
                    try {
                        Architect a = new Architect(id, name, sex, age, salary, bonus, stock);
                        restoreEmployee(a, teamId, equipmentString);
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case Data.GeneralStaff:
                    try {
                        GeneralStaff g = new GeneralStaff(id, name, sex, age, salary);
                        restoreEmployee(g, teamId, equipmentString);
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
            }


        }

    }

    /*
    * 领取的设备，重新领取
    * @param    equipmentString
    *           设备序列号字符串，如："3,5"
    * @param    employee
    *           员工
    * */
    private static void receiveEquipment(String equipmentString, Employee employee) {
        if (equipmentString.contains(",")) {
            String[] equipmentArr = equipmentString.split(",");
            for (String eq : equipmentArr) {
                try {
                    int equipmentSn = Integer.parseInt(eq);
                    employee.receiveEquipment(equipmentRepository.getEquipment(equipmentSn));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 从文件中读取员工数，恢复员工数据
    * @param    employee
    *           员工对象
    * @param    teamId
    *           已加入的team id
    * @param    equipmentString
    *           设备序列号字符串，如："3,5"
    * */
    private static void restoreEmployee(Employee employee, int teamId, String equipmentString) {
        listService.addEmployee(employee);
        receiveEquipment(equipmentString, employee);
        if (teamId != -1) {
            try {
                teamsService.getTeam(teamId).addMember(employee);
            } catch (TeamException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    private static void readTeams() {
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
                        hMap.put("total", 0);
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

    private static void readEquipment() {
        // 设置EquipmentBasic类的snInit
        EquipmentBasic.setSnInit(Data.EQUIPMENT_SN_INIT);

        // 解析设备数据
        String[][] equipment = Data.EQUIPMENT;
        for (String[] e : equipment) {
            int type = Integer.parseInt(e[0]);
            int sn = Integer.parseInt(e[1]);
            String statusSring = e[2];
            if (statusSring.equals("USING")) { // 从文件加载数据时，员工会重新领取设备，所以原来被领取的重新表示为FREE
                statusSring = "FREE";
            }
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
