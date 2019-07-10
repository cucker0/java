/*
InputStreamReader, OutputStreamWriter 转换流

作用：实现 字节流与字符流的相互转换

InputStreamReader: 字节流 --> 字符流，解码
OutputerStreamWriter: 字符流 --> 字节流，编码
适用于需要同时操作到 字节流 和 字符流


* */

package com.java.www;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderAndOutputStreamWriterTest {
    public void copyFile(String src, String dest) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 解码
            File f1 = new File(src);
            FileInputStream fis = new FileInputStream(f1);
            // 字节流 转 字符流，转换时要指定字符集
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);

            // 编码，这里到着看比较容易理解，从bw.write(str)往上看
            File f2 = new File(dest);
            FileOutputStream fos = new FileOutputStream(f2);
            // 字符流 转 字节流，转换时要指定字符集
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            // 字符写(输出)缓冲流
            bw = new BufferedWriter(osw);
            String str = null;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo.txt";
        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo_4.txt";
        copyFile(s1, s2);
    }
}
