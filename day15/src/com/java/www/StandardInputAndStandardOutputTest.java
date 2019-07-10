/*
标准输入、输出流 System.in, System.out，都为字节流

题目：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。



* */


package com.java.www;

import org.junit.Test;

import java.io.*;

public class StandardInputAndStandardOutputTest {
    @Test
    public void test1() {
        BufferedReader br = null;

        try {
            // 接受标准输入流
            InputStream is = System.in;
            // 输入流字节流 转 字符流
            InputStreamReader isr = new InputStreamReader(is);

            br = new BufferedReader(isr);
            String s = null;
            while (true) {
                System.out.println("请从输入任意字符串（e或exit退出）：");
                s = br.readLine();
                if (s.equalsIgnoreCase("e") || s.equalsIgnoreCase("exit")) {
                    break;
                }
                String s2 = s.toUpperCase();
                System.out.println(s2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
