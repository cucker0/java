/*
用switch推算出输入日期（年 月  日）是这一年的第几天

注：判断一年是否是闰年的标准：
公历闰年计算
    1、非整百年：能被4整除的为闰年。
    2、整百年：能被400整除的是闰年。(如2000年是闰年，1900年不是闰年)
    3、整百年中：对于数值很大的年份(大于=3200)：这年如果能被3200整除，并且能被172800整除则是闰年。如172800年是闰年，86400年不是闰年（因为虽然能被3200整除，但不能被172800整除）


公元前闰年计算
根据闰年算法，公元4年是闰年，且周期是4年，如果公元有0年，即为闰年。因为公元没有0年，那公元前1年就是是闰年。
    1、非整百年：年数除以4余数为1是闰年，即公元前1、5、9……是闰年；
    2、整百年：年数除以400余数为1是闰年，即公元前401、801……是闰年；
    3、对于数值很大的年份：年数除以3200余数为1则不是闰年且年数除以172800余1又为闰年，即公元前172801……是闰年，864001……年不是闰年。


    1）可以被4整除，但不可被100整除
    2）可以被400整除
    3) 大于等于3200的年份能被3200和172800同时整除

运行：javac -encoding utf8 DateEstimationDays2.java && java DateEstimationDays2
* */

import java.util.Scanner;

class DateEstimationDays2 {
    public static void main(String[] args) {
        System.out.println("请输入一个日期(年 月 日，公元前年份输入负数)：");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt(); // 年
        int m = sc.nextInt(); // 月
        int d = sc.nextInt(); // 日

        if (! (y!=0 && m>0 && d>0)) {
            System.out.println("日期输入错误");
            System.exit(0);
        }

        if (y < 0) {
            y = y*(-1) -1;
        }

        boolean condition1 = (y % 4) == 0;
        boolean condition2 = (y % 100) == 0;
        boolean condition3 = (y % 400) == 0;
        boolean condition4 = (y % 3200) == 0;
        boolean condition5 = (y % 172800) == 0;

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
                if ((y >= 0) && (y < 3200)) {
                    if ((! condition2) && condition1) { // 非整百年闰年
                        sum += 29;
                    } else if (condition3) { // 整百年闰年
                        sum += 29;
                    } else {
                        sum += 28;
                    }
                } else if (y >= 3200) {
                    if ((! condition2) && condition1) {
                        sum += 29;
                    } else if (condition3) { // 能被400整除
                        if (condition4 && (!condition5)) { // 3200倍数年份的平年
                            sum += 28;
                        } else {
                            sum += 29;
                        }
                    } else {
                        sum += 28;
                    }
                }
            case 2:
                sum += 31;
            case 1:
                sum += d; // 每个月当月的第几天
        }

        System.out.println("是当年的第 " + sum + " 天");


    }
}