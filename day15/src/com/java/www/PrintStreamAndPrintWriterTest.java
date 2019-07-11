/*
PrintStream 字节打印流，
PrintWriter 字符打印流

构造器
PrintStream(OutputStream out, boolean autoFlush)


System.err : The "standard" error output stream
System.in : The "standard" input stream
System.out : the "standard" output stream

* */

package com.java.www;

import org.junit.Test;

import java.io.*;

public class PrintStreamAndPrintWriterTest {
    @Test
    public void test1() {
        // 从标准输出流中导向到 打印流输出
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\ascii.txt"));

            // 创建打印流,
            PrintStream ps = new PrintStream(fos, true);
            if (ps != null) {
                // 把标准输出流设置到指定的打印流中，ps是写到文件
                System.setOut(ps);
            }

            // 测试，把ASCII字符写到文件
            for (int i = 0; i <= 255; ++i) {
                System.out.print((char) i);
                if (i % 64 == 0) { // 每x个字符换一行
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        // PrintWriter 字符打印流 输出字符串到文件
        String file = ".\\testLab\\lab1\\print.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file, "UTF-8");
            String s = "Nature：蚂蚁机器人弹跳力惊人，还会分工合作";
            pw.write(s); // 这也能写入到文件
//            pw.print(s); // 也能写入到文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    @Test
    public void test3() {
        // PrintStream 字节打印流 输出字符串到文件
        PrintStream ps = null;
        try {
            String fileName = "./testLab/lab1/print2.txt";
            ps = new PrintStream(fileName, "UTF-8");
            String s = "52亿次机器人每月来电，最终谁能战胜电信诈骗？";
            ps.write(s.getBytes());
            ps.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }

    }

}
