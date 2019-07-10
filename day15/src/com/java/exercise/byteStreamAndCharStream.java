/*
题目：
分别使用 字节流 和 字符流 完成以下程序：
1、新建一个quanxue.txt文件，利用程序写入以下内容：
"    君子曰：学不可以已。

    青，取之于蓝，而青于蓝；冰，水为之，而寒于水。木直中绳，輮以为轮，其曲中规。虽有槁暴，不复挺者，輮使之然也。
故木受绳则直，金就砺则利，君子博学而日参省乎己，则知明而行无过矣。
"

2、用程序读取 quanxue.txt文件内容，并在控制台打印

3、用程序赋值 quanxue.txt 为 quanxue.txt


* */

package com.java.exercise;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class byteStreamAndCharStream {
    // 1.1 字节流 把字符串 保存到文件
    public void stringToFile1(String s, String filePath) {
        File f = new File(filePath);
        BufferedOutputStream bw = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            bw = new BufferedOutputStream(fos);
            bw.write(s.getBytes());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 1.2 字符流  把字符串 保存到文件
    public void stringToFile2(String s, String filePath){
        BufferedWriter bw = null;
        try {
            bw = null;
            FileWriter fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        String s = "    君子曰：学不可以已。\n" +
                "\n" +
                "    青，取之于蓝，而青于蓝；冰，水为之，而寒于水。木直中绳，輮以为轮，其曲中规。虽有槁暴，不复挺者，輮使之然也。\n" +
                "故木受绳则直，金就砺则利，君子博学而日参省乎己，则知明而行无过矣。";
        String f1 = "E:\\dev\\java_2019\\day15\\testLab\\lab1\\quanxue.txt";
        String f2 = "E:\\dev\\java_2019\\day15\\testLab\\lab1\\quanxue2.txt";
        stringToFile1(s, f1);
        stringToFile2(s, f2);
    }

    // 2.1 字节流 读取文件到控制台
    public void fileToConsole1(String filePath) {
        BufferedInputStream br = null;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            br = new BufferedInputStream(fis);

            // byte[] 转 char[] 方法
            byte[] b = br.readAllBytes();
            Charset cs = Charset.forName("UTF-8");
            ByteBuffer bb = ByteBuffer.allocate(b.length);
            bb.put(b).flip();
            CharBuffer cb = cs.decode(bb);
            char[] c = cb.array();

            System.out.println(c);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 2.2 字符流 读取文件到控制台

    @Test
    public void test2() {
        String f1 = "E:\\dev\\java_2019\\day15\\testLab\\lab1\\quanxue.txt";
        fileToConsole1(f1);

    }

}
