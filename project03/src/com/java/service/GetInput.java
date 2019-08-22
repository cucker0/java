/*
获取输入指令

* */

package com.java.service;

import java.util.Scanner;

public class GetInput {
    // 类属性
    private static Scanner sc = new Scanner(System.in);
    private static String errorInfo = "输入错误，请重新输入";

    // 构造器
    public GetInput() {}

    // 方法
    public static String getRaw() {
        // 获取原生指令，返回去除空格的字符串
//        String s = sc.next().strip();
        String s = sc.nextLine().strip();
        return s;
    }

    public static int getNumber() {
        // 获取int指令,
        // 数字菜单 1 - 5
        int num = 0;
        while (true) {
            String s = getRaw();
            if (s.length() > 0) {
                try {
                    num = Integer.parseInt(s);
                    return num;
                } catch (NumberFormatException e) {
//                e.printStackTrace();
                    System.out.println(errorInfo);
                }

            }
        }
    }

    public static boolean isDigital(String s) {
        if (s.length() > 0) {
            try {
                int num = Integer.parseInt(s);
                // 不报错则解析成功成功
                return true;
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static int getNumber(String s) {
        int num = -400;
        if (isDigital(s)) {
            return Integer.parseInt(s);
        }
        return num;
    }

    public static boolean getIsYes() {
        // 获取是否确定指令，指令Y/N
        boolean isYes = false;
        String s = getRaw();
        if (s.equalsIgnoreCase("y")) {
            isYes = true;
        }
        return isYes;
    }

    public static boolean getSex() {
        // 获取性别指令
        // 输入 1:男性，其他数字为女性
        String rawCmd = getRaw();
        if (rawCmd.equals("")) { // 回车时表示 默认选择女性
            return true;
        }
//        System.out.println("getSex === 1.debug  ");
        int i = getNumber(rawCmd);
//        System.out.println("getSex === 2.debug  ");
        if (i == 1) {
            return false;
        }
        return true;
    }

    public static boolean getSex(String s) {
        int i = getNumber(s);
        if (i == 1) {
            return false;
        }
        return true;
    }

    public static String getName() {
        // 获取姓名
        while (true) {
            String s = getRaw();
            if (s.length() > 0 && s.length() <= 64) {
                return s;
            }
        }
    }

    public static int getAge() {
        // 获取年龄
        for (; ; ) {
            int age = getNumber();
            if (age > 0 && age < 151) {
                return age;
            } else {
                System.out.println("年龄不合法，范围(0, 150]");
            }
        }
    }

    public static int getAge(String s) {
        int age = getNumber(s);
        if (age > 0 && age < 151) {
            return age;
        }
        System.out.println("年龄不合法，范围(0, 150]");
        return getAge();
    }

    public static String getEmail() {
        // 获取邮箱地址
        // s.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") 名称允许汉字、字母、数字，域名只允许英文域名
        // 汉字在正则表示为[\u4e00-\u9fa5]
        while (true) {
            String s = getRaw().toLowerCase();
            if (s.isEmpty()) {
                return "";
            }
            if (s.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
                return s;
            } else {
                System.out.println("邮箱地址不合法，请重新输入");
            }
        }
    }

    public static String getEmail(String s) {
        if (s.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            return s;
        }
        return getEmail();
    }

    /*
    * 判断指定的字符串是否为退出指令
    * */
    public static boolean isExit(String s) {
        if (s.equals("") ||
                s.equalsIgnoreCase("q") ||
                s.equalsIgnoreCase("exit") ||
                s.equalsIgnoreCase("quit")
        ) {
            return true;
        }
        return false;
    }
}
