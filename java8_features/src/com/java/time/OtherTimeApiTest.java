package com.java.time;

import org.junit.Test;

import java.time.*;
import java.util.Set;

public class OtherTimeApiTest {
    /**
     * 遍历所有的时区
     *
     */
    @Test
    public void test1() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);
    }

    @Test
    public void test2() {
        ZoneId zoneId = ZoneId.of("UTC+1");
        ZoneId zoneId1 = ZoneId.of("UTC+8");
        System.out.println(zoneId);
        System.out.println(zoneId1);
    }

    /**
     * Duration 计算两个时间的差值
     *
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 1, 1, 12, 0, 0);

        Duration duration = Duration.between(localDateTime1, localDateTime);
        System.out.println(duration);

        System.out.println(duration.getSeconds() + "秒");
        System.out.println(duration.getNano() + "纳秒");
    }

    @Test
    public void test4() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2019, 1, 1);

        Period period = Period.between(localDate1, localDate);
        System.out.println(period.getDays());
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getUnits());
    }
}
