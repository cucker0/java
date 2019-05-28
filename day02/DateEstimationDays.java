/*
编写程序：从键盘上输入2019年的“month”和“day”，要求通过程序输出输入的日期为2014年的第几天。
运行：javac -encoding utf8 DateEstimationDays.java && java DateEstimationDays
* */

import java.util.Scanner;

class DateEstimationDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int m = sc.nextInt();
        System.out.println("请输入日期：");
        int d = sc.nextInt();

        // 这里巧妙的利用了switch-case 无break的特性
        // 从case1、到case反过来看逐步看容易理解

        int sum = 0;
        switch (m) {
            case 12:
                sum += 30;
            case 11:
                sum += 31;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                sum += 28;
            case 2:
                sum += 31; //加1月份的天数
            case 1:
                sum += d; // 这里的d相关于每个月的第x天
        }

        System.out.println(m + "月" + d + "日 是2019年第" + sum + "天");
    }
}