/*
* 主控模块，负责菜单的显示和处理用户操作
* */

package com.java.view;

import com.java.domain.*;
import com.java.service.*;
import com.java.utils.Magic;

import java.util.*;

public class TeamView {
    private static NameListService listService = new NameListService();
    private static TeamsService teamsService = new TeamsService();
    private static EquipmentRepository equipmentRepository = new EquipmentRepository();

    // 构造器
    public TeamView() {}

    // 方法
    /*
    * 主菜单
    * */
    public void enterMainMenu() {
        boolean isExit = false;
        while (true) {
            // 是否退出系统
            if (isExit) {
                break;
            }
            // 列出主菜单
            printMainMenu();
            String item = GetInput.getRaw();
            switch (item) {
                case "a":
                    teamsMenu();
                    break;
                case "b":
                    listAllEmployees();
                    break;
                case "c":
                    recruitingStaff();
                    break;
                case "d":
                    receiveEquipment();
                    break;
                case "e":
                    resignation();
                    break;
                case "f":
                    vocation();
                    break;
                case "g":
                    resumeToWork();
                    break;
                case "h":
                    listAllEquipment();
                    break;
                case "i":
                    addEquipment();
                    break;
                case "q":
                    isExit = true;
                    Storage.save();
                    break;
                default:
                    System.out.println("无此操作选项");
                    break;
            }
        }
    }

    /*
    * 打印主菜单
    * */
    public void printMainMenu() {
        String menu = "-----------------团队调度软件-----------------\n" +
                "\n" +
                "a 团队管理\n" +
                "b 列出所有员工信息\n" +
                "c 招聘员工\n" +
                "d 员工领取设备\n" +
                "e 员工办理离职\n" +
                "f 员工休假\n" +
                "g 员工结束休假/重新入职\n" +
                "h 列出所有设备\n" +
                "i 添加设备\n" +
                "q 退       出\n" +
                "\n" +
                "请选择操作项：";
        System.out.print(menu);
    }

    /*
    * 列出公司所有员工信息
    * */
    private void listAllEmployees() {
        String menu = String.format("-------------------------------------团队调度软件--------------------------------------\n" +
                "\n" +
                "%-4s\t%-16s\t%-4s\t%-4s\t%-12s\t%-10s\t%-8s\t%-12s\t%-8s\t%s\n",
                "ID", "姓名", "性别", "年龄", "工资(￥)", "职位", "状态", "奖金(￥)", "股票", "领用设备" );
        System.out.print(menu);
        for (Employee e : listService.getAllEmployees()) {
            boolean isDesigner = e instanceof Designer;
            String bonusString = isDesigner ? String.format("%.2f", ((Designer) e).getBonus()) : "";
            String stockString = e instanceof Architect ? "" + ((Architect) e).getStock() : "\t";
            System.out.printf("%-4d\t%-16s\t%-4s\t%-4d\t%-12.2f\t%-10s\t%-8s\t%-12s\t%-8s\t%s\n",
                    e.getId(),
                    e.getName(),
                    e.sexString(),
                    e.getAge(),
                    e.getSalary(),
                    e.getDescription(),
                    e.getStatus().getDiscription(),
                    bonusString,
                    stockString,
                    e.listEquipment());
        }
        System.out.println();
    }

    /*
    * 团队管理菜单
    * */
    public void teamsMenu () {
        String menuTitle = "-----------------团队管理-----------------\n\n";
        String aItem = "a 团队人力资源调度\n";
//        listAllTeams();
        String menu = menuTitle +
                aItem +
                "b 列出所有团队\n" +
                "c 新建团队\n" +
                "d 删除团队\n" +
                "q 退出\n" +
                "\n" +
                "选择操作项(回车退出)：";

        while (true) {
            System.out.print(menu);
            String rawCmd = GetInput.getRaw();
            switch (rawCmd) {
                case "q":
                    return;
                case "":
                    return;
                case "a":
                    teamDispatch();
                    break;
                case "b":
                    listAllTeams();
                    break;
                case "c":
                    addTeam();
                    break;
                case "d":
                    deleteTeam();
                    break;
                default:
                    break;

            }

        }

    }

    /*
    * 新建团队
    * */
    public void addTeam() {
        String menu = "-----------------新建团队-----------------\n";
        System.out.println(menu);
        System.out.println("团队名：");
        String name = GetInput.getName();
        Team team = new Team(name);
        teamsService.addTeam(team);
        System.out.println("团队创建成功");
        String tips = "\n" +
                "a 添加岗位需求\n" +
                "q 退出\n" +
                "\n" +
                "选择操作项(回车退出)：";
        System.out.print(tips);
        String ramCmd = GetInput.getRaw();
        if (GetInput.isExit(ramCmd)) {
            return;
        } else if (ramCmd.equals("a")) {
            addTeamPost(team);
        }
    }

    /*
    * 删除团队
    * */
    public void deleteTeam() {
        String menu = "-----------------删除团队-----------------";
        System.out.println(menu);
        listAllTeams();
        System.out.println("选择团队ID(回车退出)：");
        String ramCmd = GetInput.getRaw();
        if (GetInput.isExit(ramCmd)) return;
        int num = GetInput.getNumber(ramCmd);
        teamsService.deleteTeam(num);
    }

    /*
    * 列出所有团队
    * */
    public void listAllTeams() {
        String menu = String.format("-----------------共%d个团队-----------------\n\n" +
                "%-6s\t%s\n", teamsService.getTeamsCount(), "ID", "团队名");
        System.out.print(menu);
        LinkedList<Team> teams = teamsService.getTeams();
        for (int i = 0; i < teams.size(); ++i) {
            System.out.printf("%-6d\t%s\n", teams.get(i).getId(), teams.get(i).getName());
        }
        System.out.println();
    }

    /*
    * 检测team是否为null
    * */
    public boolean checkTeamIsNull(Team team) {
        if (team == null) {
            System.out.println("team对象为null");
            return true;
        }
        return false;
    }

    /*
     * 打印团队调度操作菜单
     * */
    public void printTeamMenu(Team team) {
        if (checkTeamIsNull(team)) return;
        String menu = String.format("-----------------团队调度管理(%s)-----------------\n" +
                "a 列出成员\n" +
                "b 添加成员\n" +
                "c 删除成员\n" +
                "d 查看成员结构\n" +
                "e 调整岗位成员预招人数\n" +
                "f 团队增加一个岗位\n" +
                "g 团队删除一个岗位\n" +
                "q 退出\n" +
                "\n" +
                "选择操作项(回车退出)：", team.getName());
        System.out.print(menu);
    }

    /*
    * 团队调度操作
    * */
    public void teamDispatch() {
        if (teamsService.getTeamsCount() <= 0) {
            System.out.println("暂未创建任何团队，请先创建团队");
            return;
        }
        listAllTeams();
        String menu = "-----------------团队调度管理-----------------\n" +
                "\n" +
                "选择团队id (回车退出)：";
        System.out.print(menu);
        String ramCmd = GetInput.getRaw();
        if (ramCmd.equals("")) {
            return;
        }
        int id = GetInput.getNumber(ramCmd);
        Team team = teamsService.getTeam(id);
        if (checkTeamIsNull(team)) return;

        boolean isExit = false;
        while (true) {
            if (isExit) {
                return;
            }

            printTeamMenu(team);
            String item = GetInput.getRaw(); // 团队调度操作的选项

            // 退出
            if (item.equals("") || item.equals("q")) {
                isExit = true;
            }

            // 相应的选项操作
            switch (item) {
                case "a":
                    listAteamMembers(team);
                    break;
                case "b":
                    addMemberToTeam(team);
                    break;
                case "c":
                    deleteMemterFromTeam(team);
                    break;
                case "d":
                    listTeamMembersStructor(team);
                    break;
                case "e":
                    modifyTeamPostMax(team);
                    break;
                case "f":
                    addTeamPost(team);
                    break;
                case "g":
                    deleteTeamPost(team);
                    break;
                default:
                    System.out.println("无此操作选项");
                    break;

            }
        }
    }

    /*
    * 显示指定团队的成员
     * */
    public void listAteamMembers(Team team) {
        if (checkTeamIsNull(team)) return;
        String menu = String.format("-----------------%s团队成员-----------------\n\n" +
                "%-4s\t%-16s\t%-4s\t%-4s\t%-6s\t%-6s\n", team.getName(),
                "ID", "姓名", "性别", "年龄", "职位", "状态");
        System.out.print(menu);
        for (Employee e : team.getMembers()) {
            System.out.printf("%-4s\t%-16s\t%-4s\t%-4d\t%-6s\t%-6s\n",
                    e.getId(),
                    e.getName(),
                    e.sexString(),
                    e.getAge(),
                    e.getDescription(),
                    e.getStatus().getDiscription()
            );
        }
        System.out.println();
    }

    /*
    * 指定的团队添加成员
    * @param    team
    *           团队对象
    * */
    public void addMemberToTeam(Team team) {
        if (checkTeamIsNull(team)) return;
        listAllEmployees();
        String menu = "选择要添加成员的id (-1或回车退出)：";
        System.out.print(menu);
        String rawCmd = GetInput.getRaw();
        if (rawCmd.equals("")) { // 回车指令
            return;
        }
        int num = GetInput.getNumber(rawCmd);
        if (num == -1) {
            return;
        }

        try {
            team.addMember(num);
        } catch (TeamException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /*
     * 指定的团队删除成员
     * */
    public void deleteMemterFromTeam(Team team) {
        if (checkTeamIsNull(team)) return;
        listAteamMembers(team);
        String menu = "选择要删除成员的id (-1或回车退出)：";
        System.out.print(menu);
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) {
            return;
        }
        int num = GetInput.getNumber(rawCmd);
        if (num == -1) {
            return;
        }

        try {
            team.removeMember(num);
        } catch (TeamException e) {
//                e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    /*
    * 列出指定团队的成员架构
    * */
    public void listTeamMembersStructor(Team team) {
        if (checkTeamIsNull(team)) return;
        System.out.println(team.showMembersStructor());
    }

    /*
    * 调整指定团队的岗位成员预招人数
    * */
    public void modifyTeamPostMax(Team team) {
        if (checkTeamIsNull(team)) return;
        team.showMembersStructor();
        String menu = String.format("-----------------调整%s团队岗位成员预编人数-----------------\n" +
                "回车不修改", team.getName());
//        LinkedHashMap<Class, HashMap> membersStructor = team.getMembersStructor();
        for (Map.Entry<Class, HashMap> entry : team.getMembersStructor().entrySet()) {
            // String[] sArr = entry.getKey().toString().split("\\.");
            System.out.printf("岗位: %-12s\t预编(个): %-12s\t实编(个): %-12s\t预编修改为(回车退出)：",
                    Magic.clazzToPost(entry.getKey()), entry.getValue().get("max"), entry.getValue().get("total"));
            String rawCmd = GetInput.getRaw();
            if (!GetInput.isExit(rawCmd)) {
                int num = GetInput.getNumber(rawCmd);
                team.modifyTeamPostMax(entry.getKey(), num);
            }
        }

    }

    /*
    * 指定的团队增加一个岗位
    * */
    public void addTeamPost(Team team) {
        if (checkTeamIsNull(team)) return;
        String menu = String.format("-----------------%s团队增加一个岗位-----------------\n\n", team.getName());
        System.out.println("\n" +
                "1 程序员\n" +
                "2 设计师\n" +
                "3 架构师\n" +
                "4 普通员工\n" +
                "\n" +
                "选择岗位(回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) {
            return;
        }
        int num = GetInput.getNumber(rawCmd);
        Class clazz = null;
        if (num == 1) {
            clazz = Programmer.class;
        } else if (num == 2) {
            clazz = Designer.class;
        } else if (num == 3) {
            clazz = Architect.class;
        }  else if (num == 4) {
            clazz = GeneralStaff.class;
        }
        if (clazz != null) {
            if (team.getMembersStructor().keySet().contains(clazz)) {
                System.out.println(Magic.clazzToPost(clazz) + "岗位已经存在");
                return;
            }
            System.out.println("预编人数(-1退出)：");
            int max = GetInput.getNumber();
            if (max == -1) return;
            HashMap hMap = new HashMap();
            hMap.put("max", max);
            hMap.put("total", 0);
            team.addPostToMmbersStructor(clazz, hMap);
        }

    }

    /*
     * 指定的团队删除一个岗位，该岗位未加入相应的职位的员工才能被删除
     * */
    public void deleteTeamPost(Team team) {
        if (checkTeamIsNull(team)) return;
        String menu = String.format("-----------------%s团队删除一个岗位-----------------\n\n", team.getName());
        ArrayList<Class> keyList = new ArrayList<>();
        LinkedHashMap<Class, HashMap> membersStructor = team.getMembersStructor();
        Set<Class> keySet = membersStructor.keySet();
        int i = 0;
        String menuTitle = String.format("%-8s\t%s",
                "编号", "岗位");
        System.out.println(menuTitle);
        for (Class clazz : keySet) {
            keyList.add(clazz);
            System.out.printf("%-8d\t%s\n", i, Magic.clazzToPost(clazz));
            ++i;
        }
        System.out.print("\n选择岗位编号(回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) {
            return;
        }
        int num = GetInput.getNumber(rawCmd);
        if (num < keyList.size() && num >= 0) {
            team.deletePostFromMmbersStructor(keyList.get(num));
        } else {
            System.out.println("岗位编号输入错误");
        }
    }

    /*
    * 招聘入职新员工
    * */
    public void recruitingStaff() {
        String menu = "-----------------招聘入职新员工-----------------\n";
        // 岗位
        String post = "a 程序员\n" +
                "b 设计师\n" +
                "c 架构师" +
                "q 退出" +
                "\n" +
                "选择项(回车退出)：";
        System.out.println(menu);
        System.out.println(post);
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) {
            return;
        }

        System.out.println("姓名(e退出)：");
        String name = GetInput.getName();
        if (name.equalsIgnoreCase("e")) {
            return;
        }
        System.out.println("性别(0或回车:女, 1:男)：");
        boolean sex = GetInput.getSex();
        System.out.println("年龄：");
        int age = GetInput.getNumber();
        System.out.println("月工资：");
        double salary = GetInput.getNumber();
        if (rawCmd.equalsIgnoreCase("a")) {
            System.out.println("技能(回车为不填)：");
            String skill = GetInput.getRaw();
            try {
                Programmer programmer = null;
                if (skill.length() > 0) {
                    programmer = new Programmer(name, sex, age, salary, skill);
                } else {
                    programmer = new Programmer(name, sex, age, salary);
                }
                listService.addEmployee(programmer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rawCmd.equalsIgnoreCase("b")) {
            System.out.println("年终奖金, 元(回车表示无)：");
            String ramCmd = GetInput.getRaw();
            double bonus = ramCmd.equals("") ? 0 : GetInput.getNumber(ramCmd);
            try {
                Designer designer = null;
                if (bonus > 0) {
                    designer = new Designer(name, sex, age, salary, bonus);
                } else {
                    designer = new Designer(name, sex, age, salary);
                }
                listService.addEmployee(designer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rawCmd.equalsIgnoreCase("c")) {
            System.out.println("年终奖金, 元(回车表示无)：");
            String ramCmd1 = GetInput.getRaw();
            double bonus = ramCmd1.equals("") ? 0 : GetInput.getNumber(ramCmd1);
            System.out.println("员工股数(回车表示无)：");
            String ramCmd = GetInput.getRaw();
            int stock = ramCmd.equals("") ? 0 : GetInput.getNumber(ramCmd);
            try {
                Architect architect;
                if (stock > 0) {
                    architect = new Architect(name, sex, age, salary, bonus, stock);
                } else {
                    architect = new Architect(name, sex, age, salary);
                }
                listService.addEmployee(architect);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 员工办理离职
    * */
    public void resignation() {
        listAllEmployees();
        String menu = "-----------------员工办理离职-----------------\n";
        System.out.println(menu);
        System.out.print("选择员工id (回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) return;
        int num = GetInput.getNumber(rawCmd);
        NameListService.resignation(num); // 等价于 listService.resignation(num);
    }

    /*
    * 员工休假
    * */
    public void vocation() {
        String menu = "-----------------员工休假-----------------\n";
        System.out.println(menu);
        listAllEmployees();
        System.out.println("选择员工id (回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) return;
        int num = GetInput.getNumber(rawCmd);
        try {
            Employee employee = listService.getEmployee(num);
            employee.vocation();
        } catch (TeamException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    /*
    * 员工结束休假/恢复上班
    * */
    public void resumeToWork() {
        String menu = "-----------------员工结束休假/重新入职-----------------\n";
        System.out.println(menu);
        listAllEmployees();
        System.out.print("选择员工id (回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) return;
        int num = GetInput.getNumber(rawCmd);
        try {
            Employee employee = listService.getEmployee(num);
            employee.resumeToWork();
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    * 列出所有设备
    * */
    public void listAllEquipment() {
        String menu = String.format("-----------------列出设备-----------------\n\n" +
                "%-5s\t%-12s\t%-12s\t%s\n",
                "SN", "状态", "使用者", "描述");
        System.out.print(menu);
        ArrayList<Equipment> list = equipmentRepository.getRepository();
        for (int i= 0; i < list.size(); ++i) {
            System.out.printf("%-5s\t%-12s\t%-12s\t%s\n",
                    list.get(i).getSn(),
                    list.get(i).getStatus().getDiscription(),
                    list.get(i).getUser() != null ? list.get(i).getUser().getName() : "",
                    list.get(i).getDescription()
            );
        }
        System.out.println();
    }

    /*
    * 添加设备
    * */
    public void addEquipment() {
        String menu = "-----------------添加设备-----------------\n" +
                "a PC办公电脑\n" +
                "b 笔记本电脑\n" +
                "c 打印机" +
                "q 退出" +
                "\n" +
                "选择项(回车退出)：";
        System.out.print(menu);
        String rawCmd = GetInput.getRaw();
        if (GetInput.isExit(rawCmd)) {
            return;
        }
        if (rawCmd.equalsIgnoreCase("a")) {
            System.out.println("==添加PC办公电脑==");
            System.out.println("型号：");
            String model = GetInput.getName();
            System.out.println("显示器：");
            String display = GetInput.getName();
            PC pc = new PC(model, display);
            equipmentRepository.addEquipment(pc);
        }
        if (rawCmd.equalsIgnoreCase("b")) {
            System.out.println("==添加笔记本电脑==");
            System.out.println("型号：");
            String model = GetInput.getName();
            System.out.println("价格：");
            double price = GetInput.getNumber();
            NoteBook noteBook = new NoteBook(model, price);
            equipmentRepository.addEquipment(noteBook);
        }
        if (rawCmd.equalsIgnoreCase("c")) {
            System.out.println("==添加打印机==");
            System.out.println("型号：");
            String name = GetInput.getName();
            System.out.println("类型：");
            String type = GetInput.getName();
            Printer printer = new Printer(name, type);
            equipmentRepository.addEquipment(printer);
        }
    }

    /*
    * 员工领取设备
    * */
    public void receiveEquipment() {
        listAllEmployees();
        String menu = "-----------------领取设备-----------------\n" +
                "\n" +
                "选择员工id (回车退出)：";
        String equipmentSelectMenu = "选择设备id (回车退出)：";
        System.out.print(menu);
        String ramCmd = GetInput.getRaw();
        if (GetInput.isExit(ramCmd)) {
            return;
        }
        int employeeId = GetInput.getNumber(ramCmd);
        if (employeeId < 0) {
            return;
        }
        // 选择设备并领取
        while (true) {
            // 打印设备仓库中的设备
            listAllEquipment();
            System.out.print(equipmentSelectMenu);
            String ramCmd2 = GetInput.getRaw();
            if (ramCmd2.equals("")) {
                return;
            }
            int equipmentId = GetInput.getNumber(ramCmd2);
            listService.receiveEquipment(employeeId, equipmentId);
        }
    }

}
