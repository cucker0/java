/*
获取输入指令

* */

package com.java.com;

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
        String s = sc.next().strip();
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

    public static boolean getIsExit() {
        // 获取退出指令，退出指令Y/N
        boolean isExit = false;
        while (true) {
            String s = getRaw();
            if (s.equalsIgnoreCase("y")) {
                isExit = true;
            }
            if (s.length() > 0) {
                break;
            }
        }

        return isExit;
    }

    public static boolean getSex() {
        // 获取性别指令
        // 输入0:女性，其他数字为男性
        if (getRaw().equals("")) { // 回车时表示 默认选择女性
            return true;
        }

        int i = getNumber();
        if (i == 1) {
            return false;
        }
        return true;
    }
    
    public static String getName() {
        // 获取姓名
        while (true) {
            String s = getRaw();
            if (s.length() > 0 && s.length() < 37) {
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

}
