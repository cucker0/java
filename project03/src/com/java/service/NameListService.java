/*
* 负责将Data中的数据封装到LinkedList<Employee>列表中，同时提供相关操作LinkedList<Employee>列表的方法
*
* */

package com.java.service;

import com.java.domain.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class NameListService {
    private LinkedList<Employee> employees = new LinkedList<>(); // 记录所有员工资料，使用LinkedList是因为其有较好的出入、删除效率

    // 构造器
    public NameListService() {}

    // 方法
    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    /*
    * 返回记录所有员工信息的list
    * */
    public LinkedList<Employee> getAllEmployee() {
        return getEmployees();
    }

    /*
    * 查询指定id的员工
    *
    * @param    id
    *           employee id
    * @return   return the employee of the specified id
    *
    * */
    public Employee getEmployee(int id) throws TeamException{
        // 通过遍历list，查询员工
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getId() == id) {
                return e;
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
