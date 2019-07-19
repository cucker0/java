/*
题目：
    按照 三天打鱼，两天晒网的。从1990-1-1 开始这么做，问今天是打鱼还是晒网？

* */

package com.java.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExercise {
    public static void main(String[] args) {
        String d1 = "2014-05-12";
        mydate(d1);

    }

    public static void mydate(String d) {
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        Date origin = new Date();
        Date date = new Date();

        try {
            origin = sdf.parse("1990-01-01");
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Date origin = new Date(1990, 1, 1);

        long millions = date.getTime() - origin.getTime();
        int days = (int) (millions / 1000 / 86400);
        System.out.println("days: " + days);
        switch (days % 5) {
            case 4:
                System.out.println("晒网");
                break;
            case 3:
                System.out.println("晒网");
                break;
            default:
                System.out.println("打鱼");

        }

    }

}
