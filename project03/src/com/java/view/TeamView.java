/*
* 主控模块，负责菜单的显示和处理用户操作
* */

package com.java.view;

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
    * 列出公司所有员工信息
    * */
    private void listAllEmployees() {

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
