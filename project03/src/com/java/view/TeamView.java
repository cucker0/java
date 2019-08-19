/*
* 主控模块，负责菜单的显示和处理用户操作
* */

package com.java.view;

import com.java.domain.Architect;
import com.java.domain.Designer;
import com.java.domain.Employee;
import com.java.service.EquipmentRepository;
import com.java.service.NameListService;
import com.java.service.Team;
import com.java.service.TeamsService;

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
                "1 列出所有员工信息\n" +
                "2 列出所有团队\n" +
                "3 招聘员工\n" +
                "4 列出所有设备\n" +
                "5 添加设备\n" +
                "6 退       出\n" +
                "\n" +
                "请选择(1-6)：";
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
        for (Employee e : listService.getAllEmployee()) {
            boolean isDesigner = e instanceof Designer;
            String bonusString = isDesigner ? "" + ((Designer) e).getBonus() : "\t";
            String stockString = e instanceof Architect ? "" + ((Architect) e).getStock() : "\t";
            System.out.printf("%s\t%s\t%d\t%.2f\t%s\t%s\t%s\t%s\t%s",
                    e.getId(),
                    e.getName(),
                    e.getAge(),
                    e.getSalary(),
                    e.getPost(),
                    e.getStatus(),
                    bonusString,
                    stockString,
                    e.listEquipment());
        }
        System.out.println();
    }

    /*
    * 显示团队列表，列出所有团队
    * */
    public void listAllTeams () {

    }

    /*
    * 团队操作菜单，操作指定的团队
    * */
    public void teamMenu(Team team) {

    }

    /*
    * 显示团队成员列表操作
     * */
    public void showTeamMembers(Team team) {

    }

    /*
    * 指定的团队添加成员
    * @param    team
    *           团队对象
    * */
    public void addMemberToTeam(Team team) {

    }

    /*
    * 指定的团队删除成员
    * */
    public void deleteMemterFromTeam(Team team) {

    }

    /*
    * 招聘员工
    * */
    public void RecruitingStaff() {

    }

    /*
    * 添加设备
    * */
    public void addEquipment() {

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
