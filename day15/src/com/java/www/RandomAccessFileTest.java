/*
RandomAccessFile， 支持文件随机访问（即可以跳转文件的任意位置开始读取）

* 即可以充当输入流，又可以充当输出流，也可以同时充当输入流、输出流
* 支持从文件的开头读取、写入
* 支持从文件任意位置读取、写入（覆盖）


* */

package com.java.www;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.LinkedList;

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


    @Test
    public void test3() {
        // 实现插入效果，在3后插入"--"，适合单行情况
        RandomAccessFile raf = null;
        try {
            String filePath = "E:\\dev\\java_2019\\day15\\testLab\\lab8\\random.txt";
            raf = new RandomAccessFile(filePath, "rw");
            System.out.println("默认文件指针: "  + raf.getFilePointer());
            raf.seek(4);
            // 把要插入位置后面的内容先保存起来，这时候调用raf.readLine()后，文件指针移到最后去了。
            System.out.println("文件指针：" + raf.getFilePointer());
            String s = raf.readLine();
//            System.out.println("操作后文件指针" + raf.getFilePointer());
            // 再把文件指针移动到要插入的位置
            raf.seek(4);
            raf.write("--".getBytes());
            raf.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileInsert(String filePath, String s, long lon) {
        // 在指定位置插入内容
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            raf.seek(lon);

            // 方法1
//            byte[] b = new byte[1024];
//            int len;
//            StringBuffer sb = new StringBuffer();
//            while ((len = raf.read(b)) != -1) {
//                sb.append(new String(b, 0, len));
//            }
//            raf.seek(lon);
//            raf.write(s.getBytes());
//            raf.write(sb.toString().getBytes());

            // 方法2
            byte[] b = new byte[1024];
            int len;
            LinkedList<Byte> list = new LinkedList<>();
            while ((len = raf.read(b)) != -1) {
                for (int i = 0; i < len; ++i) {
                    list.add(b[i]);
                }
            }
            raf.seek(lon);
            raf.write(s.getBytes());
            for (Byte by : list) {
                raf.write(by);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5() {
        String filePath = "E:\\dev\\java_2019\\day15\\testLab\\lab8\\random2.txt";
        String s = "我是插入的内容";
        fileInsert(filePath, s, 4);
    }



}
