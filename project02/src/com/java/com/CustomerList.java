/*
存放、管理Customer

* */

package com.java.com;

import java.util.Arrays;

public class CustomerList{
    // 类变量
    private static Customer[] customers;

    // 实例变量
    private int total; // 记录添加的用户数量，相当于计数器，默认值为0，也可以这样写：private int total = 0
    private int defaultLength = 10; // 保存客户数量的最大值，默认值，创建CustomerList对象时可指定该值

    // 构造器
    public CustomerList() {
        // 默认创建10个客户的保存位置
        super();
        customers = new Customer[defaultLength];
    }

    public CustomerList(int num) {
        // 指定计划保存客户的个数
        super();
        if (num > 0) {
            customers = new Customer[num];
        } else {
            System.out.println("指定的保存客户数量必须大于0, 现在使用默认的值" + defaultLength);
            customers = new Customer[defaultLength];
        }
    }

    // 方法
    private boolean totalAdd() {
        // 计数器加1
        if (total >= 0 && total < customers.length) {
            ++total;
            return true;
        }
        return false;
    }

    private boolean totalDel() {
        // 计算器减1
        if (total > 0 && total <= customers.length) {
            --total;
            return true;
        }

        return false;
    }

    public int getTotal() {
        // 获取已经添加的客户数量
        return total;
    }

    public boolean addCustomer(Customer customer) {
        // 添加一个客户
        if (total < customers.length) {
            for (int i = 0; i <= total -1; ++i) {
                if (customer.equals(customers[i])) { // 已经有该客户了
                    System.out.println("该用户已经存在");
                    return false;
                }
            }
            customers[total] = customer;
            totalAdd();
            return true;
        }
        System.out.printf("存放客户的数组已经存放满了，已经存放了%d个客户\n", customers.length);
        return false;
    }

    public boolean deleteCustomer(int index) {
        // 删除一个指定index的客户
        // 从删除位置开始，把后面的客户向前移动一位。或者把最后一个客户补到这个位置来

        if (checkIndex(index)) {
            if (total == 0) {
                System.out.println("存放客户的数组里一个客户的信息也没有");
                return false;
            }

            if (index == total -1) { // 该客户是存放于最后位置的客户
                customers[index] = null;
            } else {
/*
                // 方法1：对customer数组逐个移动数据
                for (; index + 1 <= total - 1; ++index) {
                    customers[index] = customers[index + 1];
                }
                customers[total - 1] = null; // 最后位置的数据重置为null
*/

                // 方法2：最后的客户移到删除位置来
                customers[index] = customers[total -1];
                customers[total - 1] = null;
            }
            totalDel();
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        // 删除一个指定客户
        for (int i = 0; i < total - 1; ++i) {
            if (customer.equals(customers[i])) { // 找到了该客户
                return deleteCustomer(i);
            }
        }
        System.out.println("该客户不存在");
        return false;
    }

    public boolean modifyCustomer(int index, Customer customer) {
        // 修改客户信息
        if (checkIndex(index)) {
            for (int i = 0; i <= total - 1; ++i) {
                if (customer.hashCode() == customers[i].hashCode()) {
                    System.out.println("未改动");
                    return false;
                }
            }
            customers[index] = customer;
            return true;
        }
        return false;
    }

    public Customer getCustomer(int index) {
        // 获取指定客户
        Customer customer = null;
        if (checkIndex(index)) {
            try {
                customer = customers[index];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    public Customer[] getAllCustomers() {
        // 获取所有客户
        Customer[] customers2 = new Customer[total];
        System.arraycopy(customers, 0, customers2, 0, total); // 数组切片

        // 手动复制
/*        for (int i = 0; i < total; ++i) {
            customers2[i] = customers[i];
        }*/
        return customers2;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public boolean checkIndex(int index) {
        // 检测指定的index是否合法
        if (index >= 0 && index <= total -1) {
            return true;
        }
        System.out.println("客户index值不合法");
        return false;
    }

    @Override
    public String toString() {
        return "CustomerList{" +
                "\n\tcustomers=" + Arrays.toString(customers) +
                ", \n\ttotal=" + total +
                "\n}";
    }
}
