/*
String, StringBuffer, StringBuilder 执行效率比较


## 特点

* String
    * 不可变字符序列

* StringBuffer
    * 可变字符序列
    * 效率一般，线程安全

*StringBuilder
    * 可变字符序列
    * 执行效率高
    * 线程不安全


三者效率比较：
StringBuilder > StringBuffer > String

* */

package com.java.www;

import org.junit.Test;

public class String_StringBuffer_StringBuilder_efficiency {
    @Test
    public void test1() {
        long startTime = 0L;
        long endTime = 0L;
        int times = 40000;

        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间（ms）：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间（ms）：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间（ms）：" + (endTime - startTime));

    }

}
