/*
* 员工类
*
* */

package com.java.domain;

import com.java.service.EmployeeStatus;
import com.java.service.EquipmentStatus;
import com.java.service.Team;
import com.java.service.TeamException;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Employee { // 抽象类
    // 类变量
    private static int init = 1; // 员工编号初始值

    // 实例变量
    private int id; // 员工编号
    private String name;
    private int age;
    private boolean sex; // true: 女, false:男
    private double salary; // 薪水
    private LinkedList<Equipment> equipment = new LinkedList<>(); // 该员工领取的办公设备
    private EmployeeStatus status = EmployeeStatus.FREE; // 员工默认在岗状态为空闲，即未加入任何团队
    private Team team; // 已加入的团队，一个员工只能加入一个团队，默认值是null

    // 构造器
    public Employee() {}

    // 省略性别为女性
    public Employee(String name, int age, double salary) {
        initIncrement();
        setName(name);
        setAge(age);
        sex = true;
        setSalary(salary);
    }

    public Employee(String name, boolean sex, int age, double salary) {
        initIncrement();
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        setName(name);
        setAge(age);
        this.sex = sex;
        setSalary(salary);
    }

    public Employee(int id, String name, boolean sex, int age, double salary) throws TeamException {
        if (id < init) {
            this.id = id;
            setName(name);
            setAge(age);
            this.sex = sex;
            setSalary(salary);
        } else {
            throw new TeamException("id无效");
        }
    }

    // 方法
    private void initIncrement() {
        id = init;
        ++init;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        if (init >= 1) {
            Employee.init = init;
        }
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
            System.out.println("Employee name字段长度为[1- 36]");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Employee age范围(0, 150]");
        }
    }

    public boolean getSex() {
        return sex;
    }

    /*
    * 获取String型的sex
    * */
    public String sexString() {
        return sex ? "女" : "男";
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Employee salary[0, +∞)");
        }
    }

    /*
     * 获取该员工领取的所有设备
     * @return  equipment
     *          保存所有设备信息的LinkedList
     * */
    public LinkedList<Equipment> getEquipment() {
        return equipment;
    }

    /*
    * 列出此员工领取的所有设备
    * */
    public String listEquipment() {
        StringBuilder sb = new StringBuilder();
        Iterator<Equipment> iterator = equipment.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().getDescription());
            sb.append(", ");
        }
        return sb.toString();
    }

    /*
     * 领取设备
     * @prama   aEquipment
     *          一件设备
     * @return  true/false
     *          操作状态
     * */
    public boolean receiveEquipment(Equipment aEquipment) {
        if (aEquipment.getStatus() == EquipmentStatus.FREE) {
            boolean status = equipment.add(aEquipment);
            if (status) {
                aEquipment.setStatus(EquipmentStatus.USING);
            }
            return status;
        } else if (aEquipment.getStatus() == EquipmentStatus.USING) {
            System.out.println("设备已经被领用");
        } else if (aEquipment.getStatus() == EquipmentStatus.SCRAP) {
            System.out.println("设备已经作废处理了");
        }
        return false;
    }

    /*
    * 回收(归还)指定的设备
    * @prama   aEquipment
    *          一件设备
    * @return  true/false
    *          操作状态
    * */
    public boolean recycleEquipment(Equipment aEquipment) {
        if (equipment.contains(aEquipment)) {
            if (equipment.remove(aEquipment)) {
                aEquipment.setStatus(EquipmentStatus.FREE);
                return true;
            }
        }
        return false;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /*
    * 员工退出团队
    * */
    public void quitTeam() {
        if (team != null) {
            try {
                team.removeMember(this);
            } catch (TeamException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    /*
    * 获取员工的岗位名
    * @return   String形式的岗位名
    * */
    public String getPost() {
        Class clazz = this.getClass();
        String sArr[] = clazz.toString().split("\\.");
        return sArr.length > 0 ? sArr[sArr.length -1] : "";
    }

    public String getFields() {
        return " id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sexString() +
                ", salary=" + salary +
                ", status=" + status;
    }
    @Override
    public String toString() {
        return "Employee{" +
                getFields() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // 列出员工基本信息。抽象方法
    public abstract String getDescription();

    /*
     * 员工离职
     * */
    public void resignation() {
        // 退出已经加入的团队
        quitTeam();
        // 员工状态设置为离职
        setStatus(EmployeeStatus.RESIGNED);
        // 归还所有领取的设备
        for (Equipment eq :equipment) {
            recycleEquipment(eq);
        }
    }

    /*
    * 员工休假
    * */
    public boolean vocation() {
        if (status == EmployeeStatus.VOCATION) {
            System.out.println("该员工正在休假中");
            return false;
        }
        return true;
    }
}
