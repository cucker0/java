/*
* 团队属性、团队成员的管理：添加、删除等
*
* */

package com.java.service;

import com.java.domain.Employee;
import com.java.utils.Magic;

import java.util.*;

public class Team {
    private static int init = 1; // 团队id初始值
    private int id; // 团队id
    private String name; // team name
    private LinkedHashMap<Class, HashMap> membersStructor = new LinkedHashMap<>(); // 团队成员结构要求，如：{ Programmer: {"max": 3, "total":2}, Designer: {"max": 2, "total":0}, Architect: {"max": 1, "total":20 }
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

    public Team(String name, LinkedHashMap<Class, HashMap> membersStructor) {
        setName(name);
        setMembersStructor(membersStructor);
        idProcess();
    }

    public Team(int id, String name, LinkedHashMap<Class, HashMap> membersStructor) throws TeamException {
        if (id < init) {
            this.id = id;
            setName(name);
            setMembersStructor(membersStructor);
        } else {
            throw new TeamException("无效id");
        }
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

    public LinkedHashMap<Class, HashMap> getMembersStructor() {
        return membersStructor;
    }

    public void setMembersStructor(LinkedHashMap<Class, HashMap> membersStructor) {
        this.membersStructor = membersStructor;
    }

    /*
    * 添加一个岗位要求到成员结构要求membersStructor中
    * @param    post
    *           岗位名
    * @param    postRequirements
    *           岗位需求
    * @return   返回操作的状态成功/失败
    * */
    public boolean addPostToMmbersStructor(Class post, HashMap postRequirements) {
        if (!membersStructor.keySet().contains(post)) {
            membersStructor.put(post, postRequirements);
            return true;
        } else {
            System.out.println("本团队已经存在此岗位");
        }
        return false;
    }

    /*
    * 从成员结构要求membersStructor中删除指定的岗位需求
    * @param    post
    *           岗位名
    * @return   返回操作的状态成功/失败
    * */
    public boolean deletePostFromMmbersStructor(Class post) {
        if (membersStructor.keySet().contains(post)) {
            // 该岗位未加入相应的员工才能被删除
            if ((int) membersStructor.get(post).get("total") == 0) {
                membersStructor.remove(post);
                return true;
            } else {
                System.out.println("本团队中该岗位还有其他员工，不能删除");
            }
        }
        return false;
    }

    /*
    * 修改岗位需求
    * @param    post
    *           指定要修改的岗位名
    * @param    postRequirements
    *           新的岗位需求
    * @return   返回操作的状态成功/失败
    * */
    public boolean modifyPostMembersStructor(Class post, HashMap postRequirements) {
        if (membersStructor.keySet().contains(post)) {
            if (membersStructor.get(post).equals(postRequirements)) {
                System.out.println("新的岗位需求与原来的一样");
                return false;
            }
            membersStructor.put(post, postRequirements);
            return true;
        }
        System.out.println("不存在此岗位");
        return false;
    }

    /*
    * 修改指定岗位的预招人数
    * @param    num
    *           新的预招人数
    * */
    public boolean modifyTeamPostMax(Class post, int num) {
        if (membersStructor.keySet().contains(post)) {
            int total = (int) membersStructor.get(post).get("total");
            if (num > total) {
                membersStructor.get(post).put("max", num);
                return true;
            }
        }
        return false;
    }

    /*
    * 查询指定岗位的需求
    * @param    post
    *           岗位名
    * @return   岗位的需求，为空则返回null
    * */
    public HashMap getPostRequirements(Class post) {
        if (membersStructor.keySet().contains(post)) {
            return membersStructor.get(post);
        }
        return null;
    }

    public String showMembersStructor() {
        String str = "";
        if (membersStructor != null) {
            Set<Map.Entry<Class, HashMap>> entrysSet = membersStructor.entrySet();
            str += String.format("-----------------%s团队成员结构-----------------\n\n" +
                    "%-12s\t%-12s\t%-12s\n", name, "岗位", "预编(个)", "实编(个)");
            for (Map.Entry<Class, HashMap> entry : entrysSet) {
//                String[] sArr = entry.getKey().toString().split("\\.");
//                str += String.format("%-12s\t%-12s\t%-12s\n", sArr[sArr.length -1], entry.getValue().get("max"), entry.getValue().get("total"));
                str += String.format("%-12s\t%-12s\t%-12s\n", Magic.clazzToPost(entry.getKey()), entry.getValue().get("max"), entry.getValue().get("total"));
            }
            str += "\n";
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
    * 指定员工岗位是否包是含在本团队岗位要求中
    * @param    member
    *           成员(员工)
    * @return   int形式的检查结果
    *           0:本团队无该员工职位对应的岗位
    *           1:该员工职位对应的岗位人数已满
    *           2:该员工职位对应的岗位人数还未满
    *           -1:团队岗位结构数据membersStructor出现了异常
    * */
    public int postCheck(Employee member) {
        Class clazz1 = member.getClass();
        if (membersStructor.keySet().contains(clazz1)) {
            HashMap postRequirements = getPostRequirements(member.getClass());
            if (postRequirements != null) {
                int max = (int) postRequirements.get("max");
                int total = (int) postRequirements.get("total");
                if (total >= 0 && total <= max) {
                    if (max == total) {
                        return 1;
                    } else {
                        return 2;
                    }
                } /*else {
                    return -1;
                }*/
            }
            return -1;
        }
        return 0;
    }

    /*
    * 添加指定成员到memebers 列表中
    * @param    member
    *           员工
    * */
    public boolean addMember(Employee member) throws TeamException{
        if (member != null) {
            if (members.contains(member)) {
                throw new TeamException("该员工已在本团队中\n");
            } else if (member.getStatus() == EmployeeStatus.FREE) {
                int ret = postCheck(member);
                HashMap postRequirements = getPostRequirements(member.getClass());
                if (ret == 0) {
                    throw new TeamException(String.format("本团队不需要%s岗位，无法添加\n", member.getPost()));
                } else if (ret == 1) {
                    throw new TeamException(String.format("%s团队%s岗位只需要%d个成员,已经满员\n", name, member.getPost(), (int) postRequirements.get("max")));

                } else if (ret == 2) { // 团队的该岗位人数未满，添加成员
                    // members 添加该加工
                    boolean status = members.add(member);
                    if (status) {
                        // 更新团队成员结构
                        int i = (int) postRequirements.get("total");
                        ++i;
                        postRequirements.put("total", i);
                        // 更新该员工的加入团队状态
                        member.setStatus(EmployeeStatus.BUSY);
                        // 设置该加工已经加入的团队
                        member.setTeam(this);
                    }
                    return status;
                }
            } else if (member.getStatus() == EmployeeStatus.BUSY) {
                throw new TeamException(String.format("该员工已是%s团队的成员\n", member.getTeam().getName()));
            } else if (member.getStatus() == EmployeeStatus.VOCATION) {
                throw new TeamException("该员正在休假，无法添加\n");
            }
        }
        return false;
    }

    /*
     * 添加指定id的成员到memebers 列表中
     * @param    member
     *           员工
     * */
    public boolean addMember(int memberId) throws TeamException{
        Employee employee = NameListService.getEmployee(memberId);
        return addMember(employee);
    }

    /*
    * 指定的成员退出团队
    * */
    public boolean removeMember(Employee member) throws TeamException {
        if (members.contains(member)) {
            // 更新团队的成员结构
            int total = (int) membersStructor.get(member.getClass()).get("total");
            --total;
            membersStructor.get(member.getClass()).put("total", total);
            // members中删除该成员
            return members.remove(member);
        }
        throw new TeamException(String.format("%s团队中无此员工，删除失败", name));
    }

    /*
    * 指定id的成员退出团队
    * */
    public boolean removeMember(int memberId) throws TeamException {
        Employee employee = NameListService.getEmployee(memberId);
        return removeMember(employee);
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

    public static void setInit(int init) {
        if (init >= 1) {
            Team.init = init;
        }
    }

    public static int getInit() {
        return init;
    }
}
