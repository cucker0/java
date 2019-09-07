package com.java.www;

import org.junit.Test;

import java.io.*;

/**
 * java 9关闭 try() 关闭流的改进
 *
 *
 *
 */
public class TryTest {
    /**
     * java 8之前写法
     *
     */
    @Test
    public void test1() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File file = new File("a.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * java 8可以这么写
     */
    @Test
    public void test2() {
        File file = new File("a.txt");
        // java 8要自动关闭流的话，必须写在try后的()里声明流对象
        // 这时声明的流对象为final修饰的，不能再修改
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
//            br = null; // final为常量了，不能再重新赋值
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * java 9 try ()可以管理之前创建的流对象
     *
     */
    @Test
    public void test3() {
        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        try (isr; osw) { // 此时的流对象修改为final修饰的常量了，不能修改
//            isr = null;
            osw.write(isr.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
