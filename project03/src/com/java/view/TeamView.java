/*
* 主控模块，负责菜单的显示和处理用户操作
* */

package com.java.view;

import com.java.domain.Architect;
import com.java.domain.Designer;
import com.java.domain.Employee;
import com.java.domain.Programmer;
import com.java.service.*;

import java.lang.reflect.Method;
import java.util.LinkedList;

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

    }

    /*
    * 打印主菜单
    * */
    public void printMainMenu() {
        String menu = "-----------------团队调度软件-----------------\n" +
                "\n" +
                "a 列出所有员工信息\n" +
                "b 列出所有团队\n" +
                "c 招聘员工\n" +
                "d 员工领取设备\n" +
                "e 员工办理离职\n" +
                "f 列出所有设备\n" +
                "g 添加设备\n" +
                "q 退       出\n" +
                "\n" +
                "请选择：";
        System.out.println(menu);
    }

    /*
    * 列出公司所有员工信息
    * */
    private void listAllEmployees() {
        String menu = "-------------------------------------团队调度软件--------------------------------------\n" +
                "\n" +
                "ID     姓名      年龄    工资         职位      状态      奖金        股票     领用设备" +
                "\n";
        System.out.println(menu);
        for (Employee e : listService.getAllEmployees()) {
            boolean isDesigner = e instanceof Designer;
            String bonusString = isDesigner ? "" + ((Designer) e).getBonus() : "\t";
            String stockString = e instanceof Architect ? "" + ((Architect) e).getStock() : "\t";
            System.out.printf("%s\t%s\t%d\t%.2f\t%s\t%s\t%s\t%s\t%s",
                    e.getId(),
                    e.getName(),
                    e.getAge(),
                    e.getSalary(),
                    e.getDescription(),
                    e.getStatus(),
                    bonusString,
                    stockString,
                    e.listEquipment());
        }
        System.out.println();
    }

    /*
    * 列出所有团队及相关操作
    * */
    public void teamsMenu () {
        String menu = "-----------------团队调度软件-----------------\n";
        String menuItem1 = String.format("选择团队调度管理%s", teamsService.getTeamsCount() == 0 ?
                "" :
                (teamsService.getTeamsCount() == 1 ? "(0)" : String.format("(0-%s)", teamsService.getTeamsCount() -1))
        );
        listAllTeams();
        String menuItem2 = "a  新建团队\n" +
                "b  删除团队\n" +
                "q  退出\n" +
                "\n" +
                "选择：";
        System.out.println(menu);
        if (teamsService.getTeamsCount() > 0) {
            System.out.println(menuItem1);
        }
        System.out.println(menuItem2);

    }

    /*
    * 列出所有团队
    * */
    public void listAllTeams() {
        String menu = String.format("-----------------共%d个团队-----------------\n", teamsService.getTeamsCount());
        System.out.println(menu);
        LinkedList<Team> teams = teamsService.getTeams();
        for (int i = 0; i < teams.size(); ++i) {
            System.out.printf("%-2d%s\n", i, teams.get(i).getName());
        }
        System.out.println();
    }


    /*
     * 团队操作菜单，操作指定的团队
     * */
    public void teamMenu(Team team) {
        listAteamMembers(team);
        String menu = "a  添加成员\n" +
                "b  删除成员\n" +
                "c  列出成员\n" +
                "d  调整成员架构\n" +
                "q  退出\n" +
                "\n" +
                "选择：";
        System.out.println(menu);
    }

    /*
    * 显示指定团队成员列表操作
     * */
    public void listAteamMembers(Team team) {
        String menu = String.format("-----------------%s团队成员-----------------\n\n" +
                "ID     姓名      年龄   职位      状态\n", team.getName());
        System.out.println(menu);
        for (Employee e : team.getMembers()) {
            System.out.printf("%s\t%s\t%-3d\t%s\t%s",
                    e.getId(),
                    e.getName(),
                    e.getAge(),
                    e.getDescription(),
                    e.getStatus()
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
        listAllEmployees();
        String menu = "选择要添加成员的id (-1或回车退出)：";
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
        listAteamMembers(team);
        String menu = "选择要删除成员的id (-1或回车退出)：";
        String rawCmd = GetInput.getRaw();
        if (rawCmd.equals("")) { // 回车指令
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
    * 招聘入职新员工
    * */
    public void RecruitingStaff() {
        String menu = "-----------------招聘入职新员工-----------------\n";
        // 岗位
        String post = "a   程序员\n" +
                "b  设计师\n" +
                "c  架构师" +
                "q  退出" +
                "\n" +
                "选择项(回车退出)：";
        System.out.println(menu);
        System.out.println(post);
        String rawCmd = GetInput.getRaw();
        if (rawCmd.equals("") || rawCmd.equalsIgnoreCase("q")) {
            return;
        }

        System.out.println("姓名(e退出)：");
        String name = GetInput.getName();
        if (name.equalsIgnoreCase("e")) {
            return;
        }
        System.out.println("年龄：");
        int age = GetInput.getNumber();
        System.out.println("月工资：");
        double salary = GetInput.getNumber();
        if (rawCmd.equalsIgnoreCase("a")) {
            System.out.println("技能：");
            String skill = GetInput.getName();
            try {
                Programmer programmer = new Programmer(name, age, salary, skill);
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
                    designer = new Designer(name, age, salary, bonus);
                } else {
                    designer = new Designer(name, age, salary);
                }
                listService.addEmployee(designer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (rawCmd.equalsIgnoreCase("c")) {
            System.out.println("员工股数(回车表示无)：");
            String ramCmd = GetInput.getRaw();
            int stock = ramCmd.equals("") ? 0 : GetInput.getNumber(ramCmd);
            try {
                Architect architect;
                if (stock > 0) {
                    architect = new Architect(name, age, salary, stock);
                } else {
                    architect = new Architect(name, age, salary);
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
        System.out.println("选择员工id (回车退出)：");
        String rawCmd = GetInput.getRaw();
        if (rawCmd.equals("")) {
            return;
        }
        int num = GetInput.getNumber(rawCmd);
        NameListService.resignation(num); // 等价于 listService.resignation(num);
    }

    /*
    * 列出所有设备
    * */
    public void listAllEquipment() {
        String menu = "-----------------列出设备-----------------\n" +
                "SN\t状态\t\n";

    }

    /*
    * 添加设备
    * */
    public void addEquipment() {
        String menu = "-----------------添加设备-----------------\n";
    }

    /*
    * 员工领取设备
    * */
    public void receiveEquipment() {
        
    }

    /*
    * 程序入口
    * */
    public static void main(String[] args) {

    }

}
