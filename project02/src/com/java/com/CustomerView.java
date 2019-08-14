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
        /*
        主菜单
        * */
        while (true) {
            printMainMenu();
            int num = GetInput.getNumber();
            boolean isExit = false;
            switch (num) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    modifyMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    showAllCustomers();
                    break;
                case 5:
                    System.out.print("是否退出系统(Y/N)：");
                    isExit = GetInput.getIsYes();
                    break;
                default:
                    System.out.println("无此选项\n");
            }
            // 退出系统
            if (isExit) {
                break;
            }
        }
    }

    public void printMainMenu() {
        // 打印主菜单
        String menu = "-----------------客户信息管理软件-----------------\n" +
                "\n" +
                "1 添 加 客 户\n" +
                "2 修 改 客 户\n" +
                "3 删 除 客 户\n" +
                "4 客 户 列 表\n" +
                "5 退       出\n" +
                "\n" +
                "请选择(1-5)：";
        System.out.print(menu);
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
        String menu = "---------------------删除客户---------------------\n" +
                "请选择待删除客户编号(-1退出)：\n" +
                "客户编号: 0 - " + list.getTotal() + "\n",
                menuEndSuccess = "---------------------删除完成---------------------",
                menuEndFail = "---------------------删除失败---------------------";
        System.out.println(menu);

        if (list.getTotal() == 0) {
            System.out.println("暂无客户资料，请添加\n");
            return;
        }

        int index = GetInput.getNumber();
        if (index == -1) {
            return;
        }
        System.out.print("确认是否删除(Y/N)：");
        if (!GetInput.getIsYes()) {
            return;
        }
        boolean status = list.deleteCustomer(index);
        if (status) {
            System.out.println(menuEndSuccess);
        } else {
            System.out.println(menuEndFail);
        }
    }

    public void modifyMenu() {
        // 修改客户操作菜单
        String menu = "---------------------修改客户---------------------\n" +
                "请选择待修改客户编号(-1退出)：",
                menuEndSuccess = "---------------------修改客户信息成功---------------------\n",
                menuEndFail = "---------------------修改客户信息失败---------------------\n";
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
        boolean sex = rawCmd.equals("") ? customer.getSex() : GetInput.getSex(rawCmd);

        String ageDis = String.format("年龄(%s)：", customer.getAge());
        System.out.println(ageDis);
        rawCmd = GetInput.getRaw();
        int age = rawCmd.equals("") ? customer.getAge() : GetInput.getAge(rawCmd);

        String phoneDis = String.format("电话(%s)：", customer.getPhone());
        System.out.println(phoneDis);
        rawCmd = GetInput.getRaw();
        String phone = rawCmd.equals("") ? customer.getPhone() : rawCmd;

        String emailDis = String.format("邮箱(%s)：", customer.getEmail());
        System.out.println(emailDis);
        rawCmd = GetInput.getRaw();
        String email = rawCmd.equals("") ? customer.getEmail() : GetInput.getEmail(rawCmd);

        try {
            Customer customerNew = new Customer(name, sex, age, phone, email);
            boolean status = list.modifyCustomer(index, customerNew);
            if (status) {
                System.out.println(menuEndSuccess);
                System.out.println(customerNew);
            } else {
                throw new RuntimeException("修改客户信息失败");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(menuEndFail);
        }
    }

    public void showAllCustomers() {
        // 列出所有客户
        String menu = "---------------------------客户列表---------------------------\n" +
                "编号  姓名       性别    年龄   电话                   邮箱\n",
                menuEnd = "-------------------------客户列表完成-------------------------\n\n";
        System.out.println(menu);
        for (int i = 0; i < list.getTotal(); ++i) {
            Customer c = list.getCustomer(i);
            String custStr = String.format("%d\t\t%-20s\t\t%s\t\t%d\t\t%s\t\t%s\n", i + 1, c.getName(), c.getSex(), c.getAge(), c.getPhone(), c.getEmail());
            System.out.println(custStr);
        }
        System.out.println(menuEnd);
    }

}
