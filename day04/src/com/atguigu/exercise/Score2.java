/*
题目：
用数组从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
成绩>=最高分-10    等级为’A’
成绩>=最高分-20    等级为’B’
成绩>=最高分-30    等级为’C’
其余                            等级为’D’
* */

package com.atguigu.exercise;

import java.util.Scanner;

public class Score2 {
    public static void main(String[] args) {
        // 输入人数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数：");
        int count = sc.nextInt();

        // 动态初始化数组
        int[] info = new int[count];

        // 输入成绩，判断最高成绩，记录成绩
        int max = 0;
        for (int i = 0; i < count; ++i) {
            System.out.println("输入第" + (i + 1) + "个成绩：");
            info[i] = sc.nextInt();
            max = info[i] > max ? info[i] : max;
        }

        // 遍历数组，给成绩判断等级
        for (int i = 0; i < info.length; ++i) {
            char grade = 'D';
            int difference = max - info[i];
            if (difference <= 10) {
                grade = 'A';
            } else if (difference <= 20) {
                grade = 'B';
            } else if (difference <= 30) {
                grade = 'C';
            }
            System.out.println("student " + i + " socre is " + info[i] + ", grade is " + grade);
        }

    }

}
