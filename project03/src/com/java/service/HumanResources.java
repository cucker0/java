/*
* 人力资源，用户保存员工信息
*
* */

package com.java.service;

import com.java.domain.Employee;
import com.java.domain.Equipment;

import java.util.ArrayList;

public class HumanResources {
    private static ArrayList<Employee> employees = new ArrayList<>();

    // 构造器
    public HumanResources() {}

    // 方法
    /*
    * 员工入职
    * */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /*
    * 查询指定id的员工
    * @param    id
    *           员工id
    * @return   对应id的员工对象，为空着为null
    * */
    public Employee getEmployee(int id) {
        for (Employee em : employees) {
            if (em.getId() == id) {
                return em;
            }
        }
        return null;
    }

    /*
     * 查询指定姓名的员工
     * @param    name
     *           员工姓名
     * @return   对应姓名的员工对象数组，为空着为null
     * */
    public Employee[] getEmployee(String name) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee em : employees) {
            if (em.getName().equals(name)) {
                list.add(em);
            }
        }
        if (list.size() != 0) {
            return (Employee[]) list.toArray();
        }
        return null;
    }
}
