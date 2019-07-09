/*
File类
java.io.File

* 凡是与输入、输出相关的类、接口都定义在java.io包下
* File是一个类，有构造器，创建的对象对应着一个文件或目录
* File类中的方法只涉及到创建、删除、重命名文件或目录，不能操作文件内容。文件内容的操作需要使用IO流
* File对象常作为参数传递给流的构造器
* windows平台下路径写法：
    "E:\\dev\\java_2019\\day15\\testLab\\lab1"
    "E:/dev/java_2019//day15/testLab/lab1"
* public File(String pathname)
* public File(String parent,String child)

## 访问文件名
String getName() 获取文件名
String getPath() 获取路径
String getAbsoluteFile()  获取文件绝对路径
String getAbsolutePath() 获取目录绝对路径
String getParent() 获取父路径
boolean renameTo(File newFile) 重命名文件或目录，当目标文件名、目录名存在时，则重名失败

## 文件检测
boolean exists() 是否存在
boolean canWrite() 是否能写
boolean canRead() 是否可读
boolean isFile() 是否为文件
boolean isDirectory() 是否为目录
boolean canExecute() 是否可执行

## 获取常规文件信息
long lastModified() 返回文件、目录修改时间戳
long length() 字节长度，The length, in bytes, of the file denoted by this abstract pathname

## 文件相关操作
boolean createNewFile() 创建新文件，父目录不存在时，报IOException异常；若文件存在，创建失败
boolean delete() 删除文件或空目录，非空目录删除失败

## 目录相关操作
boolean mkDir() 创建目录，父目录不存在时创建失败
boolean mkDirs() 创建多层目录，若父目录不存在时，父目录一同创建
String[] list() 列出指定路径下的文件和目录，只显示当前层的，返回String数组
File[] listFiles() 列出指定路径下的文件和目录，只显示当前层的，返回File数组

## 设置属性
boolean setReadOnly()
boolean setLastModified()
boolean setWritable()
boolean setExecutable()

* */
package com.java.www;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileTest {
    @Test
    public void test1() {
        File file1 = new File("readme.txt"); // 只有一层的文件名，getParent()获取的父路径为null，获取getPath也只能获取到当前的文件名
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");
        File file3 = new File("E:/dev/java_2019//day15/testLab/lab1/qq.exe");

        ShowMethod.main(new String[]{"java.io.File"});
    }

    @Test
    public void test2() {
        // 访问文件名

        File file1 = new File("readme.txt");
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");
        File file55 = new File("E:/dev/java_2019/day15/testLab/lab1/gongfu.txt");

        // String getName()
        System.out.println("getName: " + file1.getName());
        System.out.println("getName: " + file2.getName());

        // String getPath()
        System.out.println("getPath: " + file1.getPath());
        System.out.println("getPath: " + file2.getPath());
        System.out.println("完整路径的getPath：" + file55.getPath());

        // String getAbsoluteFile()
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());

        // String getAbsolutePath()
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());

        // String getParent()
        System.out.println("getParent: " + file1.getParent());
        System.out.println("getParent: " + file2.getParent());

        // boolean renameTo(File newName)
        File file4 = new File("readme_rename.txt");
        boolean b = file1.renameTo(file4);
        System.out.println(b);

        File file93 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab2");
        file2.renameTo(file93);
    }

    @Test
    public void test3() {
        // 获取常规文件信息
        File file1 = new File("readme.txt");
        File file2 = new File("E:/dev/java_2019/day15/testLab/lab1/gongfu.txt");

        //long lastModified() 修改信息
        long lon = file1.lastModified();
        Date date = new Date(lon);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); // 显示毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //显示到秒
        System.out.println(sdf.format(date));
        System.out.println(file2.lastModified());

        //long length() 长度
        System.out.println(file1.length());
        System.out.println(file2.length());

    }

    @Test
    public void test4() {
        // ## 文件相关操作


        //boolean createNewFile() 创建新文件
//        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab2\\test.txt");
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\test.txt");


        try {
            boolean b = file1.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //boolean delete() 删除文件
        boolean b2 = file1.delete();
        System.out.println("file1.delete(): " + b2);
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");
        File file3 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab3");
        System.out.println(file2.delete());
        System.out.println(file3.delete());
    }

    @Test
    public void test5() {
        // ## 目录相关操作


        // boolean mkDir() 创建目录，父目录不存在时创建失败
        File file1 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab4");
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab5\\bin");
        boolean b1 = file1.mkdir();
        System.out.println(b1);
        System.out.println(file2.mkdir());

        // boolean mkDirs() 创建目录，若父目录不存在时，父目录一同创建
        File file3 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab6\\bin");
        boolean b3 = file3.mkdirs();
        System.out.println(b3);

        // String[] list() 列出指定路径下的文件和目录
        File file4 = new File("E:\\dev\\java_2019\\day15\\testLab");
        String[] sArr = file4.list();
        for (String s : sArr) {
            System.out.println(s);
        }

        // File[] listFiles() 列出指定路径下的文件和目录
        File file5 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");
        File[] fArr = file5.listFiles();
        for (int i = 0; i < fArr.length; ++i) {
            System.out.println(fArr[i]);
        }
    }

    @Test
    public void test6() {
        // ## 文件检测

        File file1 = new File("readme.txt");
        File file2 = new File("E:/dev/java_2019/day15/testLab/lab1");

        // boolean exists() 是否存在
        boolean b1 = file1.exists();
        System.out.println(b1);
        System.out.println(file2.exists());

        // boolean canWrite() 是否能写
        boolean b2 = file1.canWrite();
        System.out.println(b2);
        System.out.println(file2.canWrite());

        // boolean canRead() 是否可读
        boolean b3 = file1.canRead();
        System.out.println(b3);
        System.out.println(file2.canRead());

        // boolean isFile() 是否为文件
        boolean b4 = file1.isFile();
        System.out.println(b4);
        System.out.println(file2.isFile());

        // boolean isDirectory() 是否为目录
        boolean b5 = file1.isDirectory();
        System.out.println(b5);
        System.out.println(file2.isHidden());

    }

}
