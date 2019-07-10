/*
字符流
Reader, Writer
只适合操作文本文件


* */

package com.java.www;

import org.junit.Test;

import java.io.*;

public class FileReaderAndFileWriterTest {
    @Test
    public void test0() {
        /*
        FileReader.read() 一次一个字符读取文件，返回值为字符个数，读取到文件末尾时，返回-1

        * */
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file1);
            int c;
            while ((c = fr.read()) != -1) { // 一次读取一个字符
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1() {
        /*
        File.Reader(char[] c) 一次多个字符从文件读取，返回值为字符个数，读取到文件末尾时，返回-1

        * */
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo.txt");

        FileReader fr = null;
        try {
            fr = new FileReader(file1);
            char[] c = new char[32];
            int len;
            while ((len = fr.read(c)) != -1) {
                String s = new String(c, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2() {
        /*

        * */
        File file = new File("E:\\dev\\java_2019\\day15\\testLab\\lab7\\caodang.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            String s = "操蛋！！！";
            fw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void copyFile(String src, String dest) {
        /*
        使用字符流形式 复制文本文件，只适用于复制文本文件

        * */
        File f1 = new File(src);
        File f2 = new File(dest);

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(f1);
            fw = new FileWriter(f2);

            char[] c = new char[32];
            int len;
            while ((len = fr.read(c)) != -1) {
                fw.write(c, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo.txt";
        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab7\\xiaoshuo_2.txt";
//        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab3\\周汇洋-雪域神山.mp3";
//        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab3\\周汇洋-雪域神山_3.mp3";
        copyFile(s1, s2);
    }

    @Test
    public void test99() {
        /*
        字符串转换成 字符数组
        * */
        String s = new String("sea you late.");
        char[] c = new char[s.length()];
        s.getChars(0, s.length(), c, 0);

        for (char cc : c) {
            System.out.println(cc);
        }
        // System.out.println(c);
    }




}
