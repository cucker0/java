/*
* 关于开发团队成员的管理：添加、删除等
*
* */

package com.java.service;

import com.java.domain.Architect;
import com.java.domain.Designer;
import com.java.domain.Programmer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TeamsService {
    private static LinkedList<Team> teams = new LinkedList<>(); // 保存所有的team信息

    // 构造器
    public TeamsService() {
        super();
    }

    // 方法
    /*
    * 生成团队
    * */
    public void generateTeams() {
        LinkedHashMap<Class, HashMap> membersStructor = new LinkedHashMap<>();
        HashMap post1 = new HashMap(); // 岗位要求
        post1.put("max", 3);
        post1.put("total", 0);
        HashMap post2 = new HashMap();
        post2.put("max", 2);
        post2.put("total", 0);
        HashMap post3 = new HashMap();
        post3.put("max", 1);
        post3.put("total", 0);
        membersStructor.put(Programmer.class, post1);
        membersStructor.put(Designer.class, post2);
        membersStructor.put(Architect.class, post3);
        Team t1 = new Team("DevelopmentTeam", membersStructor);
        addTeam(t1);
    }

    /*
    * 添加指定的team到teams
    * @param    team
    *           团队对象
    * @return   true/false
    *           本次操作状态
    * */
    public boolean addTeam(Team team) {
        if (team != null) {
            return teams.add(team);
        }
        return false;
    }

    /*
    * 从teams中删除指定的team
    * 只有无成员的team才能被删除
    * @param    team
    *           团队对象
    * @return   true/false
    *           本次操作状态
    * */
    public boolean deleteTeam(Team team) {
        if (team == null) return false;
        if (team.getMembersCount() == 0) {
            return teams.remove(team);
        }
        System.out.println("该团队还有其他成员，不能被删除");
        return false;
    }

    /*
     * 从teams中删除指定id的team
     * 只有无成员的team才能被删除
     * @param       teamId
     *              团队id
     * @return      true/false
     *              本次操作状态
     * */
    public boolean deleteTeam(int teamId) {
        Team team = getTeam(teamId);
        return deleteTeam(team);
    }

    public LinkedList<Team> getTeams() {
        return teams;
    }

    public int getTeamsCount() {
        return teams.size();
    }

    /*
    * 通过指定的team id查找team
    * @prama    teamId
    *           团队id
    * @return   a team
    * */
    public Team getTeam(int teamId) {
        if (teamId >= 0) {
            for (Team t : teams) {
                if (t.getId() == teamId) {
                    return t;
                }
            }
        }
        System.out.println(String.format("没有ID为%s的团队", teamId));
        return null;
    }

}
