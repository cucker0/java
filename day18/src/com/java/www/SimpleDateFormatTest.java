/*
SimpleDateFormatTest类
位于java.text.SimpleDateFormat

## 特点
易于国际化


## 构造器
SimpleDateFormat() 使用默认的本地时间格式构建一个SimpleDateFormat对象
SimpleDateFormat(String pattern) 使用指定的时间格式pattern构建一个SimpleDateFormat对象
SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols)
SimpleDateFormat(String pattern, Locale locale)

## 方法
String format(Date date)  把Date对象转成时间字符串，其父类DateFormat类中的方法
StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition fieldPosition)
Date parse(String source) 把字符串解析成Date，日期的格式要对应上，以1970, 00:00:00 GMT基准时间
Date parse(String text, ParsePosition pos)

void applyLocalizedPattern(String pattern)
void applyPattern(String pattern)
Object clone()
boolean equals(Object obj)
AttributedCharacterIterator	formatToCharacterIterator(Object obj)
Date get2DigitYearStart()
DateFormatSymbols getDateFormatSymbols()
int hashCode()
void set2DigitYearStart(Date startDate)
void setDateFormatSymbols(DateFormatSymbols newFormatSymbols)
String toLocalizedPattern()
String toPattern()


* */

package com.java.www;

import org.junit.Test;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    @Test
    public void test1() {

        // 格式化日期方式1
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(new Date());
        System.out.println(date); // 2019/7/22 下午12:04

        // 格式化日期方式2
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        String d2 = sdf2.format(new Date());
        System.out.println(d2); // 2019-07-22 12:04:48
        System.out.println(sdf3.format(new Date())); // 2019-07-22 12:04:48.048
    }

    @Test
    public void test2() {
        // 字符串转成Date


        String d = "2019/7/19 下午3:41";
        SimpleDateFormat sdf = new SimpleDateFormat();
        try {
            Date date = sdf.parse(d);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        try {
            Date d2 = sdf2.parse("2019-10-1 01:01:01");
            System.out.println(d2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
