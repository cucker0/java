package com.java.time;

import org.junit.Test;

import java.time.*;

/**
 * java.sql.Date、java.sql.Time、java.sql.Timestamp
 * 与 LocalDate、LocalTime、LocalDateTime互转
 */
public class timeConvert {
    /**
     * LocalDateTime 转 java.sql.Date
     */
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        java.sql.Date sqlDate = new java.sql.Date(ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(ldt.toLocalDate());
        System.out.println(sqlDate); // 2020-03-16
        System.out.println(sqlDate2); // 2020-03-16
    }

    /**
     * java.sql.Date 转 LocalDate
     */
    @Test
    public void test2() {
        java.sql.Date sqlDate = new java.sql.Date((new java.util.Date()).getTime());
        LocalDate localDate = sqlDate.toLocalDate();
        System.out.println(localDate); // 2020-03-16
    }

    /**
     * java.sql.Time 转 LocalTime
     * java.util.Date 转 java.sql.Time
     */
    @Test
    public void test3() {
        java.sql.Time sqlTime = new java.sql.Time((new java.util.Date()).getTime());
//        java.sql.Time sqlTime = new java.sql.Time(Instant.now().toEpochMilli());
        System.out.println(sqlTime); // 22:17:21
        LocalTime localTime = sqlTime.toLocalTime();
        System.out.println(localTime); // 22:17:21
    }

    /**
     * LocalDateTime 转 java.sql.Time
     */
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        java.sql.Time sqlTime = new java.sql.Time(ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(sqlTime); // 22:24:19
    }

    /**
     * java.sql.Timestamp 转 LocalDateTime
     */
    @Test
    public void test5() {
        java.sql.Timestamp timestamp = java.sql.Timestamp.from(Instant.now());
//        java.sql.Timestamp timestamp = new java.sql.Timestamp(Instant.now().toEpochMilli());
//        java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println(timestamp); // 2020-03-16 22:33:27.9015535
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(localDateTime); // 2020-03-16T22:33:27.901553500
    }

    /**
     * LocalDateTime 转 java.sql.Timestamp
     */
    @Test
    public void test6() {
        LocalDateTime ldt = LocalDateTime.now();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(timestamp); // 2020-03-16 22:35:33.806
    }
}
