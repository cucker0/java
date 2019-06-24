package com.java.lab1;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] ems = new Employee[3];
        ems[0] = new SalariedEmployee("步惊云", 201, new MyDate(2000, 6, 24), 9000);
        ems[1] = new HourlyEmployee("雄霸", 202, new MyDate(1990, 1, 1), 3001, 192);
        ems[2] = new SalariedEmployee("步惊云", 201, new MyDate(1992, 7, 19), 16000);

        Scanner sc = new Scanner(System.in);
        System.out.println("please input the current month:");
        Employee.currentMonth = sc.nextInt();

        for (int i = 0; i < ems.length; ++i) {
            System.out.println(ems[i]);
        }
    }
}
