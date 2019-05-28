/*
题目：
从键盘输入三个数字，用if-else把这三个数从小到大排序打印出来


* */

import java.util.Scanner;

class SortIf3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个整数：");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if (num1 > num2) {
            if (num3 > num1) {
                System.out.printf("%d %d %d", num2, num1, num3);
            } else if (num3 < num2) {
                System.out.printf("%d %d %d", num3, num2, num1);
            } else {
                System.out.printf("%d %d %d", num2, num3, num1);
            }
        } else {
            if (num3 > num2) {
                System.out.printf("%d %d %d", num1, num2, num3);
            } else if (num3 < num1) {
                System.out.printf("%d %d %d", num3, num1, num2);
            } else {
                System.out.printf("%d %d %d", num1, num3, num2);
            }
        }


    }
}