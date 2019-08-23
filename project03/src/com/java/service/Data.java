/**
* 数据源
* 启动时，把这些数据导入到程序
* 退出时保存数据到此文件
* */

package com.java.service;


public class Data {
    public static final int GeneralStaff = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    /**
    * 员工 数组形式数据
    * */
    public static final int EMPLOYEE_INIT = 13;
    //GeneralStaff  :  10, id, teamId, status, name, sex, age, salary, equipment
    //Programmer:  11, id, teamId, status, name, sex, age, salary, equipment
    //Designer  :  12, id, teamId, status, name, sex, age, salary, equipment, bonus
    //Architect :  13, id, teamId, status, name, sex, age, salary, equipment, bonus, stock
    // equipment, 记录着所有领取设备的SN，SN之间使用","分割
    public static final String[][] EMPLOYEES = {
            {"10", "3", "", "FREE", "马云", "false", "22", "3000.0", "3,5"},
            {"13", "2", "1", "BUSY", "马化腾", "false", "32", "18000.0", "", "15000.0", "2000"},
            {"11", "1", "", "RESIGNED", "李彦宏", "false", "23", "7000.0", "", "C语言"},
            {"11", "4", "", "RESIGNED", "刘强东", "false", "24", "7300.0", "", "C#"},
            {"12", "6", "", "VOCATION", "雷军", "false", "28", "10000.0", "", "5000.0"},
            {"11", "5", "", "FREE", "任志强", "false", "22", "6800.0", "", ""},
            {"12", "7", "", "FREE", "柳传志", "false", "29", "10800.0", "", "5200.0"},
            {"13", "8", "", "FREE", "杨元庆", "false", "30", "19800.0", "", "15000.0", "2500"},
            {"12", "9", "", "FREE", "史玉柱", "false", "26", "9800.0", "", "5500.0"},
            {"11", "10", "2", "BUSY", "丁磊", "false", "21", "6600.0", "", "Java"},
            {"11", "11", "1", "BUSY", "张朝阳", "false", "25", "7100.0", "", "C++"},
            {"12", "12", "", "FREE", "董明珠", "true", "27", "9600.0", "", "4800.0"}
    };

    /**
    * 设备 数组形式数据
    * */
    public static final int EQUIPMENT_SN_INIT = 12;

    //PC      :21, sn, status, model, display
    //NoteBook:22, sn, status, model, price
    //Printer :23, sn, status, name, type
    public static final String[][] EQUIPMENT = {
            {"22", "3", "USING", "联想T4", "6000.0"},
            {"21", "1", "FREE", "戴尔", "NEC17寸"},
            {"21", "2", "FREE", "戴尔", "三星 17寸"},
            {"23", "5", "USING", "佳能 2900", "激光"},
            {"21", "4", "FREE", "华硕", "三星 17寸"},
            {"21", "6", "FREE", "华硕", "三星 17寸"},
            {"23", "7", "FREE", "爱普生20K", "针式"},
            {"22", "8", "FREE", "惠普m6", "5800.0"},
            {"21", "9", "FREE", "戴尔", "NEC 17寸"},
            {"21", "10", "FREE", "华硕", "三星 17寸"},
            {"22", "11", "SCRAP", "惠普m6", "5800.0"}
    };

    /**
    * teams 数组形式数据
    * */
    public static final int TEAMS_INIT = 3;
    // Team: id, name, "post1,max,total", "post2,max,total" ...
    public static final String[][] TEAMS = {
            {"1", "DevelopmentTeam", "Programmer,5,1", "Designer,2,0", "Architect,1,1"},
            {"2", "全能队", "Programmer,5,1"}
    };

}
