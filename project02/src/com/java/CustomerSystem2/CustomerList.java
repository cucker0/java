/*
存放、管理Customer

使用单例模式

* */

package com.java.CustomerSystem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerList{
    // 类变量
    private static ArrayList<Customer> customers = load();
    private static CustomerList instance = new CustomerList();

    // 构造器
    private CustomerList() {}

    // 方法

    public int getTotal() {
        // 获取已经添加的客户数量
        return customers.size();
    }

    public boolean addCustomer(Customer customer) {
        // 添加一个客户
        try {
            for (int i = 0; i <= customers.size() -1; ++i) {
                if (customer.equals(customers.get(i))) { // 已经有该客户了
                    System.out.println("该用户已经存在");
                    return false;
                }
            }
            try {
                boolean status = customers.add(customer);
                if (status) {
                    save();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int index) {
        // 删除一个指定index的客户

        if (checkIndex(index)) {
            if (customers.size() == 0) {
                System.out.println("暂未保存有客户信息");
                return false;
            }
            try {
                Customer customer = customers.remove(index);
                if (customer != null) {
                    save();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteCustomer(Customer customer) {
        // 删除一个指定客户
        if (customers.contains(customer)) {
            if (customers.remove(customer)) {
                save();
                return true;
            }
        }
        System.out.println("该客户不存在");
        return false;
    }

    public boolean modifyCustomer(int index, Customer customer) {
        // 修改客户信息
        if (checkIndex(index)) {
            for (int i = 0; i <= customers.size() - 1; ++i) {
                if (customer.hashCode() == customers.get(i).hashCode()) {
                    System.out.println("未改动");
                    return false;
                }
            }
            try {
                Customer customer1 = customers.set(index, customer);
                if (customer1 != null) {
                    save();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Customer getCustomer(int index) {
        // 获取指定客户
        Customer customer = null;
        if (checkIndex(index)) {
            try {
                customer = customers.get(index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    public ArrayList<Customer> getAllCustomers() {
        // 获取所有客户
        // 自然排序，即添加的顺序
        return getCustomers();
    }

    public ArrayList<Customer> getAllCustomers(String sortKey) {
        // 获取所有客户，按指定字段排序
        ArrayList<Customer> list = CloneUtils.clone(customers);
        System.out.println(list);
        // 比较id
        Comparator comparator1 = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int i = 0;
                i = o1.getId() - o2.getId();
                return i;
            }
        };

        // 比较age
        Comparator comparator2 = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return 0;
            }
        };

        if (sortKey == "id") {
            Collections.sort(list, comparator1);
        } else if (sortKey == "age") {
            Collections.sort(list, comparator2);
        }
        return list;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean checkIndex(int index) {
        // 检测指定的index是否合法
        if (index >= 0 && index <= customers.size() -1) {
            return true;
        }
        System.out.println("客户index值不合法");
        return false;
    }

    public static CustomerList getInstance() {
        // 获取实例
        return instance;
    }

    private static ArrayList load() {
        // 从文件加载数据
        ArrayList list = Storage.read();
        return (list != null) ? list : new ArrayList<>();
    }

    public static void save() {
        // 保存数据到文件
        Storage.save(customers);
    }
}
