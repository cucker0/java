package com.java.www;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * String类新增方法
 *
 * public boolean isBlank()
 * 判断此字符串是否为空白是，制表符、换行符等不算内容
 *
 *
 * public String strip()
 * 去除收尾空白，功能与public String trim()相同，但效率更高
 *
 *
 * public String stripLeading()
 * 去除首部空白
 *
 * public String stripTrailing()
 * 去除尾部空白
 *
 * public String repeat(int count)
 * 返回一个此字符串重复count拼接的新字符串
 *
 * public Stream<String> lines()
 * 返回使用换行符分隔此字符串后组成的Stream。此时可以调用Stream对象的count()方法获取行数
 *
 */
public class StringTest {
    @Test
    public void test1() {
        // public boolean isBlank()
        String str = "   \t   \tddee   \n  \t";
        System.out.println("isBlank(): " + str.isBlank()); // false
        System.out.println("\"  \t \".isBlank(): " + "  \t ".isBlank()); // true


        // public String strip()
        System.out.printf("strip(): -----%s----\n", str.strip()); // strip(): -----ddee----

        // public String stripLeading()
        System.out.printf("stripLeading(): -----%s----\n", str.stripLeading());
        // stripLeading(): -----ddee
        //  	----

        // public String stripTrailing()
        System.out.printf("stripTrailing(): -----%s----\n", str.stripTrailing()); // stripTrailing(): -----   	   	ddee----

        // public String repeat(int count)
        System.out.println("\"abc\".repeat(3): " + "abc".repeat(3)); // abcabcabc

        // public Stream<String> lines()
        String str2 = "China and \nKazakhstan agreed on Wednesday \nto develop a permanent ";
        Stream<String> lines = str2.lines();

        System.out.println(lines.count());
    }

}
