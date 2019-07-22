/*
Date类
位于java.util.Date

另外还有一个java.sql.Date，这个主要用于数据库相关的


与时间相关的类
* System.currentTimeMillis();
* Date：java.util.Date、java.sql.Date
* SimpleDateFormat
* Calendar


## 构造器
Date()
Date(int year, int month, int date) // Deprecated
Date(int year, int month, int date, int hrs, int min) // Deprecated
Date(int year, int month, int date, int hrs, int min, int sec) // Deprecated
以上三个构造器以1900-01-01 00:00:00 GMT为基准时间

Date(long date) 以1970-01-01, 00:00:00 GMT为基准的，毫秒差值
Date(String s) // Deprecated

## 方法
boolean after(Date when)
boolean before(Date when)
Object clone()
int compareTo(Date anotherDate)
boolean equals(Object obj)
static Date from(Instant instant)
int getDate() // Deprecated
int getDay() // Deprecated
int getHours() // Deprecated
int getMinutes() // Deprecated
int getMonth() // Deprecated
int getSeconds() // Deprecated
int getTime() 返回自 1970-1-1 00:00:00 GMT 以来此Date对象表示的毫秒数
int getTimezoneOffset()
int getYear() // Deprecated
int hashCode() // Deprecated
static long parse(String s)
void setDate(int date)  // Deprecated
void setHours(int hours) // Deprecated
void setMinutes(int minutes) // Deprecated
void setMonth(int month) // Deprecated
void setSecondes(int secondes) // Deprecated
void setTime(long time)
void setYear(int year) // Deprecated
String toGMTString() // Deprecated
Instant toInstant()
String toLocaleString() // Deprecated
String toString() 把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)，zzz是时间标准
static long UTC(int year, int month, int date, int hrs, int min, int sec) // Deprecated

## java.sql.Date构造器
Date(int year, int month, int day)  //Deprecated
Date(long date)

## java.sql.Date方法
int getHours() // Deprecated
int getMinutes() // Deprecated
int getSeconds() // Deprecated
void setHours(int i) // Deprecated
void setMinutes(int i) // Deprecated
void setSeconds(int i)  // Deprecated
void setTime(long date) 重置此时间
Instant toInstant()
LocalDate toLocalDate() 把此Date转成本地时间格式
String toString() // Formats a date in the date escape format yyyy-mm-dd.
static Date valueOf(LocalDate date)  从本地时间格式的LocalDate获取Date实例
static Date valueOf(String s) 从字符串中获取Date实例

过时的方法到SimpleDateFormat中找


* */

package com.java.www;

import org.junit.Test;

import java.util.Date;

public class DateTest {
    @Test
    public void test1() {
        Date d1 = new Date();
        System.out.println(d1.toString());
        System.out.println(d1.getTime());


        d1.setTime(1563519640199L);
        System.out.println(d1);
        System.out.println();
    }

    @Test
    public void test2() {
        java.sql.Date d1 = new java.sql.Date(1563519640199L);
        System.out.println(d1.toString());

    }

}
