/*
* 团队属性、团队成员的管理：添加、删除等
*
* */

package com.java.service;

import com.java.domain.Employee;

import java.util.*;

public class Team {
    private static int init = 1; // 团队id初始值
    private int id; // 团队id
    private String name; // team name
    private LinkedHashMap<String, HashMap> membersStructor = new LinkedHashMap<>(); // 团队成员结构要求，如：{ "Programmer": {"max": 3, "total":2}, "Designer": {"max": 2, "total":0}, "Architect": {"max": 1, "total":20 }
    private LinkedList<Employee> members = new LinkedList<>(); // 团队成员

    // 构造器
    public Team() {
        super();
        idProcess();
    }

    public Team(String name) {
        setName(name);
        idProcess();
    }

    public Team(String name, LinkedHashMap<String, HashMap> membersStructor) {
        setName(name);
        setMembersStructor(membersStructor);
        idProcess();
    }

    // 方法
    private void idProcess() {
        id = init;
        ++init;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0 && name.length() <= 36) {
            this.name = name;
        } else {
            System.out.println("团队名长度范围: (0, 36]");
        }
    }

    public LinkedHashMap<String, HashMap> getMembersStructor() {
        return membersStructor;
    }

    public void setMembersStructor(LinkedHashMap<String, HashMap> membersStructor) {
        this.membersStructor = membersStructor;
    }

    public String showMembersStructor() {
        String str = "";
        if (membersStructor != null) {
            Set<Map.Entry<String, HashMap>> entrysSet = membersStructor.entrySet();
            str += "{\n";
            for (Map.Entry<String, HashMap> entry : entrysSet) {
                str += String.format("岗位: %s, 预招:%s个, 实招:%s个\n", entry.getKey(), entry.getValue().get("max"), entry.getValue().get("total"));
            }
            str += "}";
        }
        return str;
    }

    public LinkedList<Employee> getMembers() {
        return members;
    }

    public String showMembers() {
        String str = "";
        if (members != null) {
            str += "{";
            for (Employee e : members) {
                str += "'" + e.getName() +"', \n";
            }
            str += "}";
        }

        return str;
    }

    public int getMembersCount() {
        return members.size();
    }

    /*
    * 添加指定成员到memebers 列表中
    * */
    public void joinTeam(Employee member) throws TeamException{
        if (member != null) {
            if (!members.contains(member)) {
                members.addLast(member);
            } else {
                throw new TeamException("");
            }
        }
    }

    /*
    * 指定的成员退出团队
    * */
    public void quitTeam(String member) {
        members.remove(member);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return name != null ? name.equals(team.name) : team.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Team{" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", membersStructor=" + showMembersStructor() + "\n" +
                ", members=" + members + "\n" +
                '}';
    }
}
