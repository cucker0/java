/*
PrintStream 打印流

构造器
PrintStream(OutputStream out, boolean autoFlush)


System.err : The "standard" error output stream
System.in : The "standard" input stream
System.out : the "standard" output stream

* */

package com.java.www;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    @Test
    public void test1() {
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

}
