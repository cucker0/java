package com.java.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Date;

/**
 * LocalDateTime类
 *
 *
 */
public class LocalDateTimeTest {
    /**
     * Date 创建指定年、月、日的Date对象
     */
    @Test
    public void testDate() {
        // 偏移量

        // 如向创建一个日期为 2025-3-10
        Date date = new Date(2025, 3, 10);
        Date date1 = new Date(2025 - 1900, 3 - 1, 10);
        System.out.println("new Date(2025, 3, 10): " + date); // new Date(2025, 3, 10): Fri Apr 10 00:00:00 CST 3925
        System.out.println("new Date(2025 - 1900, 3 - 1, 10): " + date1); // new Date(2025 - 1900, 3 - 1, 10): Mon Mar 10 00:00:00 CST 2025
    }

    /**
     * LocalDate、LocalTime、LocalDateTime测试
     *
     * LocalDateTime测试的使用频率最高
     */
    @Test
    public void test0() {
        // now(): 获取当前日期/当前时间/当前日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("LocalDate.now(): " + localDate);
        System.out.println("LocalTime.now(): " + localTime);
        System.out.println("LocalDateTime.now(): " + localDateTime);
        System.out.println();


        // of(): 按指定的年、月、日、时、分、秒创建LocalDateTime对象，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 10, 1, 20, 8, 8);
        System.out.println("LocalDateTime.of(2025, 10, 1, 20, 8, 8): " + localDateTime1);
        System.out.println();

        // getXxx(): 获取相应的字段属性
        System.out.println("getYear(): " + localDateTime.getYear());
        System.out.println("getDayOfMonth(): " + localDateTime.getDayOfMonth());
        System.out.println("getDayOfYear(): " + localDateTime.getDayOfYear());
        System.out.println("getMonth(): " + localDateTime.getMonth());
        System.out.println("getMonthValue(): " + localDateTime.getMonthValue());
        System.out.println("getDayOfWeek(): " + localDateTime.getDayOfWeek());
        System.out.println();

        // withXxx(int t): 复制此LocalDateTime对象，设置复制的对象字段Xxx为t，最后返回复制后LocalDateTime对象
        // 不修改当前的LocalDateTime对象。体现出不变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(10);
        System.out.println("localDateTime.withDayOfMonth(10): " + localDateTime2);
        System.out.println("localDateTime: " + localDateTime);
        System.out.println();

        // plusXxx(int t): 增加时间t，向前拨时间t，返回调整好后的LocalDateTime对象，不修改当前的LocalDateTime对象
        System.out.println("localDateTime1: " + localDateTime1);
        LocalDateTime localDateTime3 = localDateTime1.plusDays(7);
        System.out.println("localDateTime1.plusDays(7): " + localDateTime3);
        System.out.println("localDateTime1: " + localDateTime1);
        System.out.println();

        // minusXxx(int t): 减少时间t，向后拨时间t，返回调整好后的LocalDateTime对象，不修改当前的LocalDateTime对象
        LocalDateTime localDateTime4 = localDateTime1.plusDays(7);
        System.out.println("localDateTime1.plusDays(7): " + localDateTime4);
        System.out.println("localDateTime1: " + localDateTime1);


        // 获取日期部分、获取时间部分
        LocalDate localDate1 = localDateTime1.toLocalDate();
        LocalTime localTime1 = localDateTime1.toLocalTime();
        System.out.printf("%s的日期部分: %s\n", localDateTime1, localDate1);
        System.out.printf("%s的时间部分: %s\n", localDateTime1, localTime1);
        System.out.println();

        // LocalDate + LocalTime 组合转LocalDateTime
        LocalDate localDate2 = LocalDate.now();
        LocalTime localTime2 = LocalTime.of(00, 00, 00);
        LocalDateTime localDateTime5 = LocalDateTime.of(localDate2, localTime2);
        System.out.println(localDateTime5);
    }

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
        // 先把LocalDateTime对象转Instant瞬时对象
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);
    }

    /**
     * 格式化与解析时间
     */
    @Test
    public void test8() {
        /* 自定义的格式 */
        // 时间格式化为字符串
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String dateTime = LocalDateTime.now(ZoneId.of("+8")).format(formatter1);
        System.out.println(dateTime);


        // 字符串解析成时间
        String dateTimeStr = "2019-09-06 11:11:28";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTimeStr, df);
        System.out.println(dateTime1);


         /*
         预定义的标准格式
         ISO_LOCAL_DATE_TIME;
         ISO_LOCAL_DATE;
         ISO_LOCAL_TIME
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(formatter.format(localDateTime));
        System.out.println();


        /*
        * 本地化相关的格式
        *
        * 如：ofLocalizedDateTime(FormatStyle.LONG)
        * */
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(formatter2.format(localDateTime));
        System.out.println();
    }

    @Test
    public void test9() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC+6"));

        LocalDateTime localDateTime = LocalDateTime.now();
        Temporal temporal = localDateTime.adjustInto(zonedDateTime);
        System.out.println(temporal);
        System.out.println(localDateTime);
    }
}
