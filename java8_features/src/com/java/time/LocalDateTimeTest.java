package com.java.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

/**
 * LocalDateTime类
 *
 *
 */
public class LocalDateTimeTest {
    /**
     * now()
     */
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2019-09-06T09:41:03.737523900
    }

    /**
     * static LocalDateTime now​(Clock clock)
     * 获取指定时钟现在的时间
     */
    @Test
    public void test2() {
        Clock clock = Clock.systemDefaultZone();
        Clock clock1 = Clock.systemUTC(); // SystemClock[Z]，0时区
        Clock clock3 = Clock.system(ZoneId.of("UTC+09:00")); // 东9区

        LocalDateTime now = LocalDateTime.now(clock3);
        System.out.println(now); // 2019-09-06T10:00:26.084664100
    }

    /**
     * 时区
     * UTC：Coordinated Universal Time，世界标准时间，世界统一时间，国际协调时间。由原子钟提供
     *      建议使用UTC
     * GMT：Greenwish Mean Time，格林威治标准时间，这是UTC的民间名称。GMT=UTC
     *      理论上来说，格林尼治标准时间的正午是指当太阳横穿格林尼治子午线时（也就是在格林尼治上空最高点时）的时间。
     *      由于地球在它的椭圆轨道里的运动速度不均匀，这个时刻可能和实际的太阳时相差16分钟
     * CST：China Standard Time，北京时间，中国标准时间。东8区时间，即UTC+8
     */
    @Test
    public void test3() {
        // 0时区
        ZoneId zoneId = ZoneId.of("UTC");
        ZoneId zoneId1 = ZoneId.of("UTC+0");
        ZoneId zoneId2 = ZoneId.of("UTC+00:00");
        ZoneId zoneId3 = ZoneId.of("Z");

        System.out.println(zoneId);
        System.out.println(zoneId1);
        System.out.println(zoneId2);
        System.out.println(zoneId3);
        System.out.println();

        // 东1区
        ZoneId e1 = ZoneId.of("UTC+1");
//        ZoneId e1 = ZoneId.of("UTC+01:00");
        System.out.println(e1); // UTC+01:00
        System.out.println();

        // 西2区
        ZoneId w2 = ZoneId.of("UTC-2");
        System.out.println(w2); // UTC-02:00

        // 时区甚至可以指定非整点的时区
        ZoneId e8 = zoneId.of("UTC+08:30");
        System.out.println(e8);

        // GMT时间也类似
        ZoneId zoneId4 = zoneId.of("GMT+2");
        System.out.println(zoneId4);
    }

    /**
     * 即获取指定时区的时间
     *
     */
    @Test
    public void test4() {
        ZoneId zoneId = ZoneId.of("UTC+07:00");
        LocalDateTime now = LocalDateTime.now(zoneId);
        System.out.println(now);
    }


    @Test
    public void test5() {
        LocalDateTime now = LocalDateTime.now();
        int yDay = now.getDayOfYear();
        System.out.println(yDay);
    }

    @Test
    public void test6() {
        LocalDateTime now = LocalDateTime.now();

        long aLong = now.getLong(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println(aLong);
    }

    /**
     * 获取时间戳
     */
    @Test
    public void test7() {
        // 获取纪元秒，时间戳
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);

        //  获取纪元毫秒，时间戳
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
    }

    /**
     * LocalDateTime与String互转
     */
    @Test
    public void test8() {
        // 时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String dateTime = LocalDateTime.now(ZoneId.of("+8")).format(formatter);
        System.out.println(dateTime);


        // 字符串串时间
        String dateTimeStr = "2019-09-06 11:11:28";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTimeStr, df);
        System.out.println(dateTime1);
    }
}
