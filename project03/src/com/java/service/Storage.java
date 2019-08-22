/*
* 数据存取
* 功能：
*       * 从文件加载数据，解析文本数据
*       * 从程序保存数据到文件
* */

package com.java.service;

import com.java.domain.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Storage {
    // 保存数据的文件路径，使用绝对路径
    private static final String filePath = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "com" +
            File.separator + "java" +
            File.separator + "service" +
            File.separator + "Data.java";
    private static NameListService listService = new NameListService();
    private static TeamsService teamsService = new TeamsService();
    private static EquipmentRepository equipmentRepository = new EquipmentRepository();
    // 保存数据的文档头
    private static final String documentHead = "/*\n" +
            "* 数据源\n" +
            "* 启动时，把这些数据导入到程序\n" +
            "* 退出时保存数据到此文件\n" +
            "* */\n" +
            "\n" +
            "package com.java.service;\n" +
            "\n" +
            "\n" +
            "public class Data {\n" +
            "    public static final int GeneralStaff = 10;\n" +
            "    public static final int PROGRAMMER = 11;\n" +
            "    public static final int DESIGNER = 12;\n" +
            "    public static final int ARCHITECT = 13;\n" +
            "\n" +
            "    public static final int PC = 21;\n" +
            "    public static final int NOTEBOOK = 22;\n" +
            "    public static final int PRINTER = 23;\n\n";

    // 保存数据的文档尾
    private static final String documentTail = "}\n";

    // 构造器
    public Storage() {

    }

    // 方法
    /*
    * 从文件加载数据
    * 注意：加载顺序
    *   设备->团队->员工
    * 员工数据要最后加载，因为员工要重新执行领取设备、加入团队操作
    * */
    public static void read() {
        readTeams();
        readEquipment();
        readEmployees();
    }

    /*
    * 从程序保存数据到文件
    * 注意保存顺序：
    *   文档头 -> 其他数据 -> 文档尾
    *
    * */
    public static void save() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(documentHead);
            bw.flush();
            bw.write(saveEployees());
            bw.flush();
            bw.write(saveEquipment());
            bw.flush();
            bw.write(saveTeams());
            bw.flush();
            bw.write(documentTail);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
            if (status == null) {
                return;
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
                        restoreEmployee(p, teamId, equipmentString, status);
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
                        restoreEmployee(d, teamId, equipmentString, status);
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
                        restoreEmployee(a, teamId, equipmentString, status);
                    } catch (TeamException e) {
                        e.printStackTrace();
                    }
                    break;
                case Data.GeneralStaff:
                    try {
                        GeneralStaff g = new GeneralStaff(id, name, sex, age, salary);
                        restoreEmployee(g, teamId, equipmentString, status);
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
    * @param    status
    *           员工状态
    * */
    private static void restoreEmployee(Employee employee, int teamId, String equipmentString, EmployeeStatus status) {
        if (employee == null || status == null) {
            return;
        }
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
        // 设置员工的状态这步必须在完成加入团队处理后之后，因为状态不为FREE的加不了团队
        employee.setStatus(status);
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

    private static String saveTeams() {
        // String[][] TEAMS 数组头
        String str = String.format("    /*\n" +
                "    * teams 数组形式数据\n" +
                "    * */\n" +
                "    public static final int TEAMS_INIT = %s;\n" +
                "    // Team: id, name, \"post1,max,total\", \"post2,max,total\" ...\n" +
                "    public static final String[][] TEAMS = {\n",
                Team.getInit());
        // 遍历团队数组
        // 格式：id, name, "post1,max,total", "post2,max,total" ...
        for (int i = 0; i < teamsService.getTeams().size(); ++i) {
            Team t = teamsService.getTeams().get(i);
            String aTeam = "            {";
            aTeam += String.format("\"%s\", \"%s\"%s", t.getId(), t.getName(), teamMembersStructorToString(t));

            if (i == teamsService.getTeams().size() -1) {
                aTeam += "}\n";
            } else {
                aTeam += "},\n";
            }
            str += aTeam;
        }

        // String[][] TEAMS 数组尾
        str += "    };\n\n";
        return str;
    }

    /*
    * 指定团队的成员结构转换成String
    * */
    private static String teamMembersStructorToString(Team team) {
        String str = "";
        LinkedHashMap<Class, HashMap> membersStructor = team.getMembersStructor();
        // 格式：, "Programmer,3,1", "Designer,2,1", "Architect,1,0"
        for (Map.Entry<Class, HashMap> entry : membersStructor.entrySet()) {
            String[] clazzStringArr = entry.getKey().toString().split("\\.");
            str += String.format(", \"%s,%s,%s\"", clazzStringArr[clazzStringArr.length - 1], entry.getValue().get("max"), entry.getValue().get("total"));
        }
        return str;
    }

    private static String saveEquipment() {
        // String[][] EQUIPMENT头
        String str = String.format("    /*\n" +
                "    * 设备 数组形式数据\n" +
                "    * */\n" +
                "    public static final int EQUIPMENT_SN_INIT = %s;\n" +
                "\n" +
                "    //PC      :21, sn, status, model, display\n" +
                "    //NoteBook:22, sn, status, model, price\n" +
                "    //Printer :23, sn, status, name, type\n" +
                "    public static final String[][] EQUIPMENT = {\n",
                EquipmentBasic.getSnInit());

        // 遍历设备数据
        for (int i = 0; i < EquipmentRepository.getRepository().size(); ++i) {
            Equipment eq = EquipmentRepository.getRepository().get(i);
            // 一个设备信息数组头
            String equipment = "            {";

            // 拼接字段
            //PC      :21, sn, status, model, display
            //NoteBook:22, sn, status, model, price
            //Printer :23, sn, status, name, type
            if (eq.getClass() == PC.class) {
                PC pc = (PC) eq;
                equipment += String.format("\"21\", \"%s\", \"%s\", \"%s\", \"%s\"",
                        eq.getSn(), eq.getStatus(), pc.getModel(), pc.getDisplay());
            } else if (eq.getClass() == NoteBook.class) {
                NoteBook nb = (NoteBook) eq;
                equipment += String.format("\"21\", \"%s\", \"%s\", \"%s\", \"%s\"",
                        eq.getSn(), eq.getStatus(), nb.getModel(), nb.getPrice());
            } else if (eq.getClass() == Printer.class) {
                Printer p = (Printer) eq;
                equipment += String.format("\"21\", \"%s\", \"%s\", \"%s\", \"%s\"",
                        eq.getSn(), eq.getStatus(), p.getName(), p.getType());
            }

            // 一个设备信息数组头
            if (i == EquipmentRepository.getRepository().size() -1) {
                equipment += "}\n";
            } else {
                equipment += "},\n";
            }
            str += equipment;
        }

        // String[][] EQUIPMENT尾
        str += "    };\n\n";
        return str;
    }

    private static String saveEployees() {
        // String[][] EMPLOYEES 数组头
        String str = String.format("    /*\n" +
                "    * 员工 数组形式数据\n" +
                "    * */\n" +
                "    public static final int EMPLOYEE_INIT = %s;\n" +
                "    //GeneralStaff  :  10, id, teamId, status, name, sex, age, salary, equipment\n" +
                "    //Programmer:  11, id, teamId, status, name, sex, age, salary, equipment\n" +
                "    //Designer  :  12, id, teamId, status, name, sex, age, salary, equipment, bonus\n" +
                "    //Architect :  13, id, teamId, status, name, sex, age, salary, equipment, bonus, stock\n" +
                "    // equipment, 记录着所有领取设备的SN，SN之间使用\",\"分割\n" +
                "    public static final String[][] EMPLOYEES = {\n",
                Employee.getInit());
        // 遍历员工数据
        for (int i = 0; i < NameListService.getEmployees().size(); ++i) {
            Employee e = NameListService.getAllEmployees().get(i);
//            System.out.println("1 debug===  " + e);
            // 一个员工信息数组头
            String employee = "            {";
            // 员工类型
            if (e.getClass() == GeneralStaff.class) { // GeneralStaff
                employee += String.format("\"10\"%s", employeeGeneralFieldToString(e));
            } else if (e.getClass() == Programmer.class) { // Programmer
                Programmer p = (Programmer) e;
                employee += String.format("\"11\"%s, \"%s\"", employeeGeneralFieldToString(e), p.getSkill() == null ? "" : p.getSkill());
            } else if (e.getClass() == Designer.class) { // Designer
                Designer d = (Designer) e;
                employee += String.format("\"12\"%s, \"%s\"", employeeGeneralFieldToString(e), d.getBonus());
            } else if (e.getClass() == Architect.class) { // Architect
                Architect a = (Architect) e;
                employee += String.format("\"13\"%s, \"%s\", \"%s\"", employeeGeneralFieldToString(e), a.getBonus(), a.getStock());
            }

            // 一个员工信息数组尾
            if (i == NameListService.getEmployees().size() -1) {
                employee += "}\n";
            } else {
                employee += "},\n";
            }
            str += employee;

        }

        // String[][] EMPLOYEES 数组尾
        str += "    };\n\n";
        return str;
    }

    /*
    * 员工通用字段转换成String
    * 通用字段：id, teamId, status, name, sex, age, salary, equipment
    * */
    private static String employeeGeneralFieldToString(Employee e) {
        if (e == null) {
            return "";
        }
        String str = String.format(", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\"",
                e.getId(),
                e.getTeam() == null ? "" : e.getTeam().getId(),
                e.getStatus(),
                e.getName(),
                e.getSex(),
                e.getAge(),
                e.getSalary(),
                e.getEquipmentIdToString()
        );
        return str;
    }

}
