package com.java.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class OtherTimeApiTest {
    /**
     * 遍历所有的时区
     *
     */
    @Test
    public void test0() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);
    }

    @Test
    public void test1() {
        ZoneId zoneId = ZoneId.of("UTC+1");
        ZoneId zoneId1 = ZoneId.of("UTC+8");
        System.out.println(zoneId);
        System.out.println(zoneId1);
    }

    /**
     * ChronoUnit
     * 计算时间差，使用于 LocalDateTime、LocalTime、LocalDate
     */
    @Test
    public void test2() {
        LocalDate localDate = LocalDate.of(2018, 10, 1);
        LocalDate localDate1 = LocalDate.of(2019, 1, 10);
        long days = ChronoUnit.DAYS.between(localDate, localDate1);
        System.out.println(days);
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.of(2017, 2, 1, 8, 10, 30);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 10, 2, 12, 1, 0);
        System.out.println(ChronoUnit.YEARS.between(localDateTime, localDateTime1) + "年");
        System.out.println(ChronoUnit.MONTHS.between(localDateTime, localDateTime1) + "月");
        System.out.println(ChronoUnit.DAYS.between(localDateTime, localDateTime1) + "天");
        System.out.println(ChronoUnit.HOURS.between(localDateTime, localDateTime1) + "时");
        System.out.println(ChronoUnit.MINUTES.between(localDateTime, localDateTime1) + "分");
        System.out.println(ChronoUnit.SECONDS.between(localDateTime, localDateTime1) + "秒");
    }

    /**
     * Duration 计算两个时间的差值，相差的秒
     *
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 10, 1, 12, 0, 0);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 10, 2, 12, 0, 0);

        Duration duration = Duration.between(localDateTime, localDateTime1);
        System.out.println(duration);

        System.out.println(duration.getSeconds() + "秒");
        System.out.println(duration.getNano() + "纳秒");
    }

    /**
     * Period获取两日期相差多少年月日
     *
     */
    @Test
    public void test4() {
        LocalDate localDate = LocalDate.of(2018, 10, 1);
        LocalDate localDate1 = LocalDate.of(2019, 1, 10);

        Period period = Period.between(localDate, localDate1);
        System.out.printf("相差：%s年%s月%s日\n", period.getYears(), period.getMonths(), period.getDays());
    }


}
