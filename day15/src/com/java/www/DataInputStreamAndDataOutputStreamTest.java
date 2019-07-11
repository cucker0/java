/*
数据流
DataInputStream, DataOutputStream
适用场景：用来处理基本数据类型、String、字节数据

* */

package com.java.www;

import org.junit.Test;

import java.io.*;

public class DataInputStreamAndDataOutputStreamTest {

    public void stringToFile(String filePath, String s) {
    // DataOutputStreat 把字符写入文件
        DataOutputStream dos = null;
        try {
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            dos.writeUTF(s);
            dos.writeBoolean(true);
            dos.writeLong(363910625);
            dos.writeFloat(3.14F);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1() {
        String s = "BAT的智慧城市梦，该醒醒了. 技术标准未统一，政策执行不给力";
        String file = "E:\\dev\\java_2019\\day15\\testLab\\lab1\\data.txt";
        stringToFile(file, s);
    }

    public void fileToConsole(String filePath) {
        // DataInputStream 读取文件到控制台
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            dis = new DataInputStream(fis);

            // 转成字符串，非字符串的将打印乱码
//            byte[] b = new byte[1024];
//            int len;
//            while ((len = dis.read(b)) != -1) {
//                System.out.println(new String(b, 0, len));
//            }

            // 怎么写就怎么读
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readLong());
            System.out.println(dis.readFloat());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() {
        String f = "E:\\dev\\java_2019\\day15\\testLab\\lab1\\data.txt";
        fileToConsole(f);
    }
}
