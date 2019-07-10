/*
题目：
分别使用 字节流 和 字符流 完成以下程序：
1、新建一个quanxue.txt文件，利用程序写入以下内容：
"    君子曰：学不可以已。

    青，取之于蓝，而青于蓝；冰，水为之，而寒于水。木直中绳，輮以为轮，其曲中规。虽有槁暴，不复挺者，輮使之然也。
故木受绳则直，金就砺则利，君子博学而日参省乎己，则知明而行无过矣。
"

2、用程序读取 quanxue.txt文件内容，并在控制台打印

3、用程序复制 quanxue.txt 为 quanxue.txt


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

    public void fileToConsole3(String filePath) {
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            // 字节流 转 字符流
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
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
    public void fileToConsole2(String filePath) {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
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

    @Test
    public void test2() {
        String f1 = "./testLab/lab1/quanxue.txt";
        fileToConsole1(f1);
        System.out.println("===");
        fileToConsole2(f1);
        System.out.println("===");
        fileToConsole3(f1);

    }

    // 3.1 字节流复制文件
    public void copyFile1(String src, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 3.2 字符流复制文件
    public void copyFile2(String src, String dest) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(dest);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String s = null;
            while ((s = br.readLine()) != null) {
                bw.write(s);
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
    public void test3() {
        String f1 = "./testLab/lab1/quanxue.txt";
        String f2 = "./testLab/lab1/quanxue_3.txt";
        String f3 = "./testLab/lab1/quanxue_4.txt";
        copyFile1(f1, f2);
        copyFile2(f1, f3);
    }

}
