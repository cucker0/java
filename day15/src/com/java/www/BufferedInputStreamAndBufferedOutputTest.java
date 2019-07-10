package com.java.www;

import org.junit.Test;

import java.io.*;

public class BufferedInputStreamAndBufferedOutputTest {
    public void copyFile(String src, String dest) {
        /*
        BufferedInputStream, BufferedOutputStream 实现文件的复制
        * */

        // 1. 创建File文件对象
        File f1 = new File(src);
        File f2 = new File(dest);

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 2. 创建输入流、输出流对象
            FileInputStream fr = new FileInputStream(f1);
            FileOutputStream fw = new FileOutputStream(f2);

            // 3. 创建缓冲输入流、缓冲输出流对象
            bis = new BufferedInputStream(fr);
            bos = new BufferedOutputStream(fw);

            byte[] b = new byte[1024]; // 一次读取1024个字节
            int len;
            // 4. 读取、写入
            while ((len = bis.read(b)) != -1) { // 这里也可以不传，BufferedInputStream.read()有一个默认长度的字节数组来接受，默认大小为8192
                bos.write(b, 0, len);
                bos.flush(); // 刷新输出缓冲流，防止有未写的
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭缓冲流
            try {
                bis.close(); // 会同自动关闭相应的fr流
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\Airship.png";
        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\Airship_2.png";
        copyFile(s1, s2);
    }

}
