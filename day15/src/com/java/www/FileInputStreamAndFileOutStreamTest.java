/*
FileInputStream, FileOutputStream

## 英文字符一个字节，中文字符两个字节

## IO流的分类
按操作数据单位分类：字节流bytes stream(8 bit)、字符流character stream(16 bit)
按数据流的方向分类：输入流、输出流
按流的角色分类：节点流、处理流

## IO的类体系
抽象基类                    节点流(文件流)实现类
InputStream                 FileInputStream (字节)
OutputStream                FileOutputStream (字节)
Reader                      FileReader (字符)
Writer                      FileWriter (字符)



* */

package com.java.www;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutStreamTest {
    @Test
    public void test1() {
//        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\QinyuanSpring.Snow.txt");
        // 1. 创建一个File类对象
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\abc.txt");

        FileInputStream fis = null;
        try {
            // 2.创建一个FileInputStream类的对象
            fis = new FileInputStream(file1);
            /*
            int b = fis.read();
            while (b != -1) {
                System.out.print((char) b);
                b =fis.read();
            }
            */
            // 上面代码片段可简写如下
            // 3. 调用FileInputStream对象read()方法，该方法调用一次返回一个字节(对应一个int值)，当读取文件结尾时，返回-1
            for (int b; (b = fis.read()) != -1; ) {
                System.out.print((char) b);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    // 关闭相应的流
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
