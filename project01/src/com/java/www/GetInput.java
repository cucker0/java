package com.java.www;

import java.util.Scanner;

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
