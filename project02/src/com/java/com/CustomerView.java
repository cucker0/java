/*
菜单显示及操作

* */

package com.java.com;

public class CustomerView {
    private CustomerList list;

    // 构造器
    public CustomerView() {
        super();
        list = new CustomerList();
    }

    public CustomerView(CustomerList customerList) {
        list = customerList;
    }

    // 方法
    public void mainMenu() {
        // 主菜单
        String menu = "-----------------客户信息管理软件-----------------\n" +
                "\n" +
                "1 添 加 客 户\n" +
                "2 修 改 客 户\n" +
                "3 删 除 客 户\n" +
                "4 客 户 列 表\n" +
                "5 退       出\n" +
                "\n" +
                "请选择(1-5)：";
        System.out.println(menu);
    }

    public void addMenu() {
        // 添加客户操作菜单
        String menu = "---------------------添加客户---------------------\n" +
                "* 标记字段为必填字段，其他字段可以回车留空\n";
        System.out.println(menu);

        System.out.println("* 姓名(Y退出)：");
        String name = GetInput.getName();
        if (name.equalsIgnoreCase("y")) {
            return;
        }
        System.out.println("* 性别( 0:女性, 1:男性，不填为女性)：");
        boolean sex = GetInput.getSex();
        System.out.println("* 年龄：");
        int age = GetInput.getAge();
        System.out.println("电话：");
        String phone = GetInput.getRaw();
        System.out.println("邮箱：");
        String email = GetInput.getEmail();

        Customer customer = new Customer(name, sex, age, phone, email);
        boolean status = list.addCustomer(customer);
        if (status) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------添加失败---------------------");
        }

    }

    public void deleteMenu() {
        // 删除客户操作菜单
        int num = GetInput.getNumber();
        list.deleteCustomer(num);
    }

    public void modifyMenu() {
        // 修改客户操作菜单
        String menu = "---------------------修改客户---------------------\n" +
                "请选择待修改客户编号(-1退出)：";
        System.out.println(menu);
        int index = GetInput.getNumber();
        if (index == -1) {
            return;
        }
        Customer customer = list.getCustomer(index);
        if (customer == null) {
            return;
        }

        String nameDis = String.format("姓名(%s)：<直接回车表示不修改，其他字段也一样>", customer.getName());
        System.out.println(nameDis);
        String rawCmd = GetInput.getRaw();
        String name = rawCmd.equals("") ? customer.getName() : rawCmd;

        String sexDis = String.format("性别(%s)：", customer.getSex());
        rawCmd = GetInput.getRaw();
        boolean sex = rawCmd.equals("") ? customer.getSex() : GetInput.getSex();

    }

    public void showAllCustomers() {
        // 列出所有客户

    }

}
