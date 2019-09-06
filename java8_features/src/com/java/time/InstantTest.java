package com.java.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.Temporal;

/**
 * Instant类
 * 瞬时
 *
 *
 *
 */
public class InstantTest {
    @Test
    public void test1() {
        // now(): 获取0时区的瞬时点(时间戳)
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println();

        // adjustInto(Temporal temporal)
        Temporal temporal = OffsetDateTime.now();
        Temporal temporal1 = instant.adjustInto(temporal);
        System.out.println(temporal1);
        System.out.println(temporal);
        System.out.println();


        // 添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println();

        // toEpochMilli()
        // 获取纪元秒，即自1970-1-1 00:00:00 UTC开始的毫秒
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        System.out.println();

        // 根据指定纪元毫秒创建Instant实例
        Instant instant1 = Instant.ofEpochMilli(1567760691915L);
        System.out.println(instant1);
        // 根据指定纪元秒创建Instant实例
        Instant instant2 = Instant.ofEpochSecond(1567760691L);
        System.out.println(instant2);
        System.out.println();
    }

    /**
     * Instant 与 LocalDateTime互转
     *
     */
    @Test
    public void test2() {
        // Instant 转 LocalDateTime
        Instant instant = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC+8"));

        System.out.println(instant);
        System.out.println(localDateTime);
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // LocalDateTime 转 Instant
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Instant instant1 = localDateTime1.toInstant(ZoneOffset.ofHours(+8));
        System.out.println("localDateTime1: " + localDateTime1);
        System.out.println("instant1: " + instant1);
    }

    /**
     * 格式化与解析时间
     *
     */
    @Test
    public void test3() {
        // 预定义的标准格式
        // ISO_LOCAL_DATE_TIME;
        // ISO_LOCAL_DATE;
        // ISO_LOCAL_TIME
        LocalDateTime localDateTime = LocalDateTime.now();

        // 本地化相关的格式
        // 如：ofLocalizedDateTime(FormatStyle.LONG)


        // 自定义的格式
        // 如：ofPattern("yyyy-MM-ddhh:mm:ss")
    }

}
