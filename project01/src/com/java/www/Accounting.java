/*
System.out.printf("%-16s\t\t%s ￥%.2f\t\t%s\n", m.get("type"), flag, (double) m.get("price"), m.get("item"));
%-16s 表示16个字符长度，左对齐
%16s 表示16个字符长度，右对齐

* */

package com.java.www;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

class Accounting {
    private double balance = 10000; // 用户余额
    private ArrayList<HashMap> database; // 用于保存收支明细的列表, ArrayList类已经序列化，List是接口，未实现序列化
    private String filePath = "./database.db"; // 用于保存收支明细的文件
//    private ObjectInputStream objectInputStream; // 对象输入流
//    private ObjectOutputStream objectOutputStream; // 对象输出流
// 同时打开 对象输对输入、输出流有操作有异常，objectInputStream打开后，后续的代码不执行

    // 构造器
    public Accounting() {
        super();
        fileIsExists();
        read();
    }

    // 方法
    public void fileIsExists() {
        // 文件是否存在，不存在则创建
        File f = new File(filePath);
        if (!f.exists()) {
            try {
                f.createNewFile();
                init();
            } catch (IOException e) {
                // e.printStackTrace();
                System.out.println("创建文件异常");
            }
        }
    }

    private void init() {
        // 首次使用时 初始化数据库
        database = new ArrayList();
        save();
    }

    private void save() {
        // 保存database数据到文件
        ObjectOutputStream objectOutputStream = null;
        try {
            if (database != null) {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath)); // 创建对象输出流时 文件内容全部被替换为4个字节
                objectOutputStream.writeObject(database);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void read() {
        // 从文件读取数据
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = objectInputStream.readObject();
//            System.out.println(obj);
            database = (ArrayList) obj;
            if (database == null) {
                init();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
//            System.out.println("read: NullPointerException");
            init();
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("read: IOException");
            init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//            System.out.println("read: ClassNotFoundException");
            init();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
                // 退出系统
                save();
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
        HashMap hmap = new HashMap(); // 记账格式 {"type": "income/pay", "price": xx.xx, "item": item}
        while (true) {
            System.out.println("本次收入说明(E退出)：");
            String item = GetInput.getItemName();
            if (item.equalsIgnoreCase("e")) {
                break;
            }
            System.out.println("本次收入金额(￥)：");
            double price = GetInput.getPrice();
            balance += price;
            hmap.put("type", "income");
            hmap.put("price", price);
            hmap.put("item", item);
            database.add(hmap);
        }
        save();
    }

    public void recordPay() {
        /*
        登记支出
        * */
        String menu = "" +
                "-----------------登记支出-----------------\n" +
                "退出登记收入菜单(输入E)\n";
        System.out.print(menu);
        HashMap hmap = new HashMap(); // 记账格式 {"type": "income/pay", "price": xx.xx, "item": item}
        while (true) {
            System.out.println("本次支出说明(E退出)：");
            String item = GetInput.getItemName();
            if (item.equalsIgnoreCase("e")) {
                break;
            }
            System.out.println("本次支出金额(￥)：");
            double price = GetInput.getPrice();
            balance -= price;
/*            HashMap hmap = new HashMap() { // 此写法为序列化
                {
                    put("type", "pay");
                    put("price", price);
                    put("item", item);
                }
            };
            database.add(hmap);*/

            hmap.put("type", "pay");
            hmap.put("price", price);
            hmap.put("item", item);
            database.add(hmap);
        }
        save();
    }

    public void printDetail() {
        String menu = String.format("" +
                "-----------------当前收支明细记录-----------------\n" +
                "%-16s\t\t￥%s\t\t%s\n", "收支", "金额(￥)", "说明");
        System.out.print(menu);
        if (database != null) {
            for (HashMap m : database) {
                String flag = m.get("type") == "pay" ? "-" : "+";
                System.out.printf("%-16s\t\t%s ￥%.2f\t\t%s\n", m.get("type"), flag, (double) m.get("price"), m.get("item"));
            }
        }
        System.out.println();
    }

    public void printBalance() {
        System.out.printf("账户余额：￥%.2f\n", balance);
    }

    public double getBalance() {
        return balance;
    }
}
