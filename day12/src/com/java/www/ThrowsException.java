/*
异常处理方式二：手动抛出异常
在方法的声明处，显式的抛出该异常对象的类型
* 格式：public void readFile() throws FileNotFoundException, IOException { }
* 当在此方法内部出现异常时，会抛出一个异常类的对象，抛给方法的调用者
* 异常对象可以逐层向上抛，一直到main方法中。在向上抛的时候，可以用try-catch-finally进行处理
* main()方法中抛出异常时到JVM中

java异常处理模型：抓抛模型
* 抓
    * try-catch-finally
    * throws 异常的类型  （在方法声明处，{ }前）
* 抛
    * 自动抛出
    * 手动抛出：throw 异常类的对象


* */

package com.java.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsException {
    public static void main(String[] args){
        try {
            method2();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        method3();
    }

    public static void readFile() throws FileNotFoundException, IOException {
        FileInputStream fs = new FileInputStream(new File("guide.txt"));
        int b;
        while ((b = fs.read()) != -1) {
            System.out.println((char) b);
        }
        fs.close();
    }

    public static void method2() throws FileNotFoundException, IOException {
        readFile();
    }

    public static void method3() {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
