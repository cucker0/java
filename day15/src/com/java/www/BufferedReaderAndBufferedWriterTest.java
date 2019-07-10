/*
BufferedReader, BufferedWriter

只适合操作文本文件

BufferedReader.readLine() 读取的内容不包括换行符

* */

package com.java.www;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderAndBufferedWriterTest {

    public void copyFile(String src, String dest) {
        /*
        利用BufferedReader、BufferedWriter实现文件复制
        * */

        // 1. 创建File对象
        File f1 = new File(src);
        File f2 = new File(dest);

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // 2. 创建字符流对象
            FileReader fr = new FileReader(f1);
            FileWriter fw = new FileWriter(f2);

            // 3.创建缓冲字符流对象
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            // 4. 读取、写入操作
            // 第一种读取方式，一次读取多个字符
//            char[] c = new char[1024];
//            int len;
//            while ((len = br.read(c)) != -1) {
//                bw.write(c, 0, len);
//                bw.flush();
//            }

            // 第二种读取方式，一次读取一行，内容不包括换行符
            String str = null;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine(); // 新起一行
                bw.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭缓冲流
            try {
                bw.close(); // 同时会自动关闭字符流
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo.txt";
        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo_3.txt";
        copyFile(s1, s2);
    }
}
