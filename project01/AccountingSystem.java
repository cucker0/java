/*
家庭记账
==

# 目标
* 模拟实现一个基于文本界面的《家庭记账软件》
* 掌握初步的编程技巧和调试技巧
* 主要涉及以下知识点
    * 变量的定义
    * 基本数据类型的使用
    * 循环语句
    * 分支语句
    * 方法声明、调用和返回值的接收
    * 简单的屏幕输出格式控制

# 需求说明
* 模拟实现基于文本界面的《家庭记账软件》。
* 该软件能够记录家庭的收入、支出，并能够打印收支明细表。
* 项目采用分级菜单方式。主菜单如下：
```text
-----------------家庭收支记账软件-----------------
1 收支明细
2 登记收入
3 登记支出
4 显示余额
5 退 出
请选择(1-5)：


运行：javac -encoding utf-8 AccountingSystem.java &&  java AccountingSystem
* */

// package com.java.www;

import java.util.Scanner;
import java.lang.Thread;

public class AccountingSystem {
    // 程序入口
    public static void main(String[] args) {
        Accounting accounting = new Accounting();
        accounting.selectMenu();
    }
}

class Accounting {
    double balance = 10000; // 用户余额
    String detail = ""; // 收支明细

    public void selectMenu() {
        /*
        主菜单选择操作
        * */
        while (true) {
            printMenu();
            int num = GetInput.getInputNumber();
            String isExit = "";
            switch (num) {
                // 收支明细
                case 1:
                    printDetail();
                    break;
                // 登记收入
                case 2:
                    recordIncome();
                    break;
                // 登记支出
                case 3:
                    recordPay();
                    break;
                // 显示余额
                case 4:
                    printBalance();
                    break;
                //退出
                case 5:
                    System.out.println("是否退出系统(Y/N)");
                    isExit = GetInput.getInputExit();
                    break;
            }
            if (isExit.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void printMenu() {
        /*
        打印菜单
        * */
        String menu = "" +
                "-----------------家庭收支记账软件-----------------\n" +
                "1 收支明细\n" +
                "2 登记收入\n" +
                "3 登记支出\n" +
                "4 显示余额\n" +
                "5 退 出\n" +
                "请选择(1-5)：\n";
        System.out.println(menu);
    }

    public void recordIncome() {
        /*
        登记收入
        * */
        String menu = "" +
                "-----------------登记收入-----------------\n" +
                "退出登记收入菜单(输入E)\n";
        System.out.println(menu);
        while (true) {
            System.out.println("本次收入说明(E退出)：");
            String item = GetInput.getItemName();
            if (item.equalsIgnoreCase("e")) {
                break;
            }
            System.out.println("本次收入金额(￥)：");
            double price = GetInput.getPrice();
            balance += price;
            detail += String.format("%s\t\t+￥%.2f\t\t%s\n", "收入", price, item);
        }
    }

    public void recordPay() {
        /*
        登记支出
        * */
        String menu = "" +
                "-----------------登记支出-----------------\n" +
                "退出登记收入菜单(输入E)\n";
        System.out.print(menu);
        while (true) {
            System.out.println("本次支出说明(E退出)：");
            String item = GetInput.getItemName();
            if (item.equalsIgnoreCase("e")) {
                break;
            }
            System.out.println("本次支出金额(￥)：");
            double price = GetInput.getPrice();
            balance -= price;
            detail += String.format("%s\t\t-￥%.2f\t\t%s\n", "支出", price, item);
        }
    }

    public void printDetail() {
        String menu = "" +
                "-----------------当前收支明细记录-----------------\n" +
                "收支\t\t金额(￥)\t\t说明\n";
        System.out.print(menu);
        System.out.println(detail);
    }

    public void printBalance() {
        System.out.printf("账户余额：￥%.2f\n", balance);
    }

    public double getBalance() {
        return balance;
    }
}

class GetInput {
    /*
    获取键盘输入的指令
    * */

    private static Scanner sc = new Scanner(System.in);
    private static String error_info = "输入错误！请重新输入";

    //构造器

    // 方法
    public static int getInputNumber() {
        /*
        获取输入的菜单数字
        * */
        int num = 0;

        while (true) {
            try {
                num = sc.nextInt();
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println(error_info);
                sc.next();
                continue;
            }
            if (num >= 1 && num <= 5) {
                break;
            } else {
                System.out.println(error_info);
            }
        }

        return num;
    }

    public static String getInputExit() {
        /*
        获取退出确认指令
        * */
        String isExit = "n";
        while (true) {
            try {
                String str = sc.next().strip();
                if (str.equalsIgnoreCase("y")) {
                    isExit = "y";
                }
            } catch (Exception e) {
                System.out.println(error_info);
                continue;
            }
            break;
        }
        return isExit;
    }

    public static double getPrice() {
        /*
        获取输入的价格
        * */
        double price = 0.0;
        while (true) {
            String str = sc.next();
            try {
                int p1 = Integer.parseInt(str);
                price = p1;
            } catch (Exception e) {
                try {
                    price = Double.parseDouble(str);
                } catch (NumberFormatException ex) {
                    // ex.printStackTrace();
                    System.out.println(error_info);
                    continue;
                }
            }
            if (price >= 0) {
                break;
            }
        }
        return price;
    }

    public static String getItemName() {
    /*
    获取收支项目名
    * */
        String item = "";
        while (true) {
            try {
                item = sc.next().trim();
            } catch (Exception e) {
                System.out.println(error_info);
                continue;
            }
            if (item.length() > 0) {
                break;
            }
        }
        return item;
    }
}