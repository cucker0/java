/*
题目：
for实现从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。

运行：javac -encoding utf8 ClassStatistics.java && java ClassStatistics
* */

import java.util.Scanner;

class ClassStatistics {
    public static void main(String[] args) {
        System.out.println("请输入n个整数，输入0时自动退出并统计输入的正数与负数个数");
        Scanner sc = new Scanner(System.in);
        int positive_count = 0; // 正数个数
        int negative_count = 0; // 负数个数
        int temp;
        for (; ; ) {
            System.out.println("输入一个整数：");
            temp = sc.nextInt();
            if (temp > 0) {
                positive_count += 1;
            } else if (temp < 0) {
                negative_count += 1;
            } else {
                break;
                //return;
            }
        }
        System.out.println("正数个数：" + positive_count);
        System.out.println("负数个数：" + negative_count);
    }
}