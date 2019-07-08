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
String getName()
String getPath()
String getAbsoluteFile()  获取文件绝对路径
String getAbsolutePath() 获取目录绝对路径
String getParent()
boolean renameTo(File newFile) 重命名文件或目录，当目标文件名、目录名存在是，重名失败

## 文件检测
boolean exists()
boolean canWrite()
boolean canRead()
boolean isFile()
boolean isDirectory()

## 获取常规文件信息
long lastModified()
long length()

##文件相关操作
boolean createNewFile()
boolean delete()

## 目录相关操作
boolean mkDir()
boolean mkDirs()
String[] list()
File[] listFiles()


* */
package com.java.www;

import org.junit.Test;

import java.io.File;


public class FileTest {
    @Test
    public void test1() {
        File file1 = new File("readme.txt");
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");
        File file55 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\gongfu.txt");
        File file3 = new File("E:/dev/java_2019//day15/testLab/lab1/qq.exe");

        ShowMethod.main(new String[]{"java.io.File"});
    }

    @Test
    public void test2() {
        File file1 = new File("readme.txt");
        File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");

        // String getName()
        System.out.println(file1.getName());
        System.out.println(file2.getName());

        // String getPath()
        System.out.println(file1.getParent());
        System.out.println(file2.getParent());
        System.out.println(file55.getParent());


        // String getAbsoluteFile()
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());

        // String getAbsolutePath()
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());

        // String getParent()
        System.out.println(file1.getParent());
        System.out.println(file2.getParent());

        // boolean renameTo(File newName)
        File file4 = new File("readme_rename.txt");
        boolean b = file1.renameTo(file4);
        System.out.println(b);

        File file93 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab2");
        file2.renameTo(file93);
    }

}
