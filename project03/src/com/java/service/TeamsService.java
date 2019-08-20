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
        return teams.get(teamId);
    }

}
