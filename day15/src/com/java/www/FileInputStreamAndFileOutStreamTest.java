/*
FileInputStream, FileOutputStream

## 英文字符一个字节，中文字符两个字节，UTF-8编码的字符有1-3个字节，第一个字节会标识长度

## IO流的分类
按操作数据单位分类：字节流bytes stream(8 bit)、字符流character stream(16 bit)
按数据流的方向分类：输入流、输出流
按流的角色分类：节点流、处理流

## IO的类体系
流方向           抽象基类                    节点流(文件流)实现类                缓冲流(处理流的一种，可以提升效率)      其他
字节流.输入       InputStream                 FileInputStream(read()是阻塞的)    BufferedInputStream (read()非阻塞的)
字节流.输出       OutputStream                FileOutputStream                   BufferedOutputStream                    Buffered.OutputStream.flush()在动作最后执行一次，保证最后的缓冲内容也被写入
字符流.输入       Reader                      FileReader                         BufferedReader                          BufferedReader.readLine() 读取的内容不包括行尾的换行符
字符流.输出       Writer                      FileWriter                         BufferedWriter                          BufferedWriter.flush()在动作最后执行一次，保证最后的缓冲内容也被写入


FileInputStream 从硬盘读取文件到程序(内存)
FileInputStream.read() 是阻塞的， int read(byte[] b)
BufferedInputStream.read() 非阻塞的

FileOutputStream：void write(byte[], int startIndex, int endIndex);
FileReader: int read(char[] c)
FileWriter: void write(char[], int startIndex, int endIndex)


* */

package com.java.www;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutStreamTest {
    @Test
    public void test1() {
        /*
        FileInputStream 从文件一次一个字节的读取
        FileInputStream.read()，读取一个字节，返回值为字节个数，到文件末尾时返回-1
        不能读取含中文的文本，可能会有乱码，转为字节数与字符数不好匹配,可以读取英文字符及非文本的文件
        * */

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
                    // 关闭输入流
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        /*
        FileInputStream 从文件一次多个字节读取，
        FileInputStream.read(byte[] b)，一次读取个数为b长度，返回值为字节个数，到文件末尾时返回-1
        不能读取含中文的文本，可以读取英文字符及非文本的文件

        * */

//        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\abc.txt");
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\QinyuanSpring.Snow.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file1);
            byte[] b = new byte[24]; // 读取一个大文件，这里会有一个最优值
            int len;
            while ((len = fis.read(b)) != -1) {
                for (int i = 0; i < len; ++i) { // 这里的测试条件不能用b.length，因为到最后一次读取的时候，有可能字节数是不够填满b这个字节数组的，这时候就会打印上一次填充的一部分内容
                    System.out.print((char) b[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3() {
        /*
        FileOutputStream 输出字节流到文件
        fos.write()，右文件存在则覆盖
         * */


        // 1. 创建一个File对象，指定要写入的文件路径
        File file = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\test.txt");

        FileOutputStream fos = null;
        try {
            // 2. 创建一个FileOutputStream的对象，将File的对象作为形参传给FileOutputStream创建对象构造器中
            fos = new FileOutputStream(file);

            // 3. 要写入的字符串转成 字节数组
            byte[] b = "I have a good idea!哈哈" .getBytes();

            // 写入操作
            fos.write(b); // <==> fos.write(b, 0, b.length)
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test4() {
        /*
        复制文件操作，从硬盘读取一个文件，并写入到另外一个文件

        * */
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\gongfu.txt");
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\gongfu_2.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] b = new byte[24];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public boolean copyFile(String src, String dest) {
        /*
        复制文件，所有类型的文件
        src: 源文件路径
        dest: 目标文件路径

        * */
        File f1 = new File(src);
        File f2 = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);
            byte[] b = new byte[24];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        boolean bool = false;
        if (f1.length() == f2.length()) {
            bool = true;
        }
        return bool;
    }

    @Test
    public void test5() {
        String s1 = "E:\\dev\\java_2019\\day15\\testLab\\lab3\\周汇洋-雪域神山.mp3";
        String s2 = "E:\\dev\\java_2019\\day15\\testLab\\lab3\\周汇洋-雪域神山2.mp3";
        boolean b = copyFile(s1, s2);
        System.out.println(b);
    }
}
