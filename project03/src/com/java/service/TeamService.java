/*
* 关于开发团队成员的管理：添加、删除等
*
* */

package com.java.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TeamService {
    private static LinkedList<Team> teams = new LinkedList<>(); // 保存所有的team信息

    // 构造器
    public TeamService() {
        super();
    }

    // 方法
    /*
    * 生成团队
    * */
    public void generateTeams() {
        LinkedHashMap<String, Integer> membersStructor = new LinkedHashMap<>();
        membersStructor.put("Programmer", 3);
        membersStructor.put("Designer", 2);
        membersStructor.put("Architect", 1);
        Team t1 = new Team("DevelopmentTeam", membersStructor);

    }

    /*
    * 添加指定的team到teams
    * */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /*
    * 从teams中删除指定的team
    * 只有无成员的team才能被删除
    * */
    public void deleteTeam(Team team) {
        if (team.getMembersCount() == 0) {
            teams.remove(team);
        }
    }

    public LinkedList<Team> getTeams() {
        return teams;
    }

    public int getTeamCount() {
        return teams.size();
    }

}
