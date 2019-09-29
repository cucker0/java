package com.java.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

/**
 * DateTimeFormatter
 * 格式化或解析日期、时间
 * 类似于SimpleDateFormat
 *
 */
public class DateTimeFormatterTest {
    /*
    方式1：预定义的标准格式

    ISO_LOCAL_DATE_TIME;
    ISO_LOCAL_DATE;
    ISO_LOCAL_TIME
    * */
    @Test
    public void test1() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(str);
        System.out.println();

        // 解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2019-09-29T16:48:23.617253");
        System.out.println(parse); // {},ISO resolved to 2019-09-29T16:48:23.617253
        System.out.println();

    }

    @Test
    public void test2() {
        /*
        方式2：本地化相关的格式

        如：DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)、
        DateTimeFormatter.ofLocalizedDate()
        应用于:LocalDateTime、LocalDate
        FormatStyle.SHORT; //2019/9/29 下午4:56
        FormatStyle.MEDIUM; // 2019年9月29日 下午4:59:51
        FormatStyle.LONG; // 要求时间对象设置时区，2019年9月29日 UTC+08:00 下午5:28:31

        只适用于LocalDate的：
        FormatStyle.FULL
        * */

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2); // 2019/9/29 下午4:56

        // 格式化
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC+8"));
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC+8"));
        String s3 = formatter2.format(zonedDateTime);
        System.out.println(s3);

        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String s4 = formatter3.format(zonedDateTime);
        System.out.println(s4);
        System.out.println();


        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String s5 = formatter4.format(LocalDate.now());
        System.out.println(s5);
        System.out.println();

        // 解析
        TemporalAccessor parse = formatter2.parse("2019年9月29日 UTC+08:00 下午5:35:53");
        System.out.println(parse); // {InstantSeconds=1569749753},ISO,UTC+08:00 resolved to 2019-09-29T17:35:53
    }

    /*
    方式3：自定义的格式

    如：DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")
    * */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String s = formatter.format(localDateTime); // 2019-09-29 05:44:27
        System.out.println(s);
        System.out.println();

        // 解析
        TemporalAccessor accessor = formatter.parse("2019-09-29 05:44:30");
        System.out.println(accessor); // {MilliOfSecond=0, MinuteOfHour=44, MicroOfSecond=0, SecondOfMinute=30, HourOfAmPm=5, NanoOfSecond=0},ISO resolved to 2019-09-29

    }

}
