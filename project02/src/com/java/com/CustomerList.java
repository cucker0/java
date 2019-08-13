/*
存放Customer

* */

package com.java.com;

public class CustomerList {
    private Customer[] customers;
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
        if (total >= 0 && total < customers.length - 1) {
            ++total;
            return true;
        }
        System.out.println("已经存放满了...");
        return false;
    }

    private boolean totalDel() {
        // 计算器减1
        if (total > 0 && total < customers.length) {
            --total;
            return true;
        }
        
        return false;
    }

    public int getTotal() {
        // 获取已经添加的客户数量
        return total;
    }

    public void addCustomer(Customer customer) {
        // 添加一个客户
        if (totalAdd()) {
            customers[total -1] = customer;
        }
    }

    public void deleteCustomer(int index) {
        // 删除一个指定客户
        // 从删除位置开始，把后面的客户向前移动一位。或者把最后一个客户补到这个位置来

        if (checkIndex(index)) {
            if (index == total) { // 存放于最后位置的客户
                customers[index] = null;
            } else {
                for (; index <= total; ++index) {
                    customers[index] = customers[index + 1];
                }
            }
        }


    }

    public void modifyCustomer(int index, Customer customer) {
        // 修改客户信息
    }

    public Customer getCustomer(int index) {
        // 获取指定客户
        return null;
    }

    public Customer[] getAllCustomers() {
        // 获取所有客户
        return getCustomers();
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public boolean checkIndex(int index) {
        // 检测指定的index是否合法
        if (index >= 0 && index <= total) {
            return true;
        }
        System.out.println("客户index值不合法");
        return false;
    }

}
