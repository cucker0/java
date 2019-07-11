/*
RandomAccessFile， 支持文件随机访问（即可以跳转文件的任意位置开始读取）

* 即可以充当输入流，又可以充当输出流，也可以同时充当输入流、输出流
* 支持从文件的开头读取、写入
* 支持从文件任意位置读取、写入（覆盖）


* */

package com.java.www;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public void copyFile(String src, String dest) {
        /*
        RandomAccessFile 实现复制文件
        * */
        File f1 = new File(src),
                f2 = new File(dest);
        RandomAccessFile raf1 = null,
                raf2 = null;
        try {
            raf1 = new RandomAccessFile(f1, "r");
            raf2 = new RandomAccessFile(f2, "rw");

            byte[] b = new byte[1024];
            int len;
            while ((len = raf1.read(b)) != -1) {
                raf2.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab8\\xh.txt",
                s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab8\\xh_2.txt";
        copyFile(s1, s2);
    }

    @Test
    public void test2() {
        // 在指定位置开始写入(覆盖)
        File file = new File("E:\\dev\\java_2019\\day15\\testLab\\lab8\\random.txt");
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            // 移动文件指针
            raf.seek(2);
            raf.write("qq".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //

}
