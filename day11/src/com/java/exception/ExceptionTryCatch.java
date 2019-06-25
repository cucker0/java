/*
异常处理

## 如何处理异常
异常处理的抓抛模型
* 抛--执行代码时，一旦出现异常，就会在异常的代码处理生成一个应对的异常类的对象，并将此对象抛出（分为自动抛出、手动抛出）
    * 一旦抛出此异常类的对象，程序就终止执行
    * 此异常类的对象抛给方法的调用者
* 抓--抓住上一步抛出的异常类的对象。如何抓取
    * 方式一
    ```
    try {
        // 可能出现异常的代码
    } catch(Exception1 e) {
        // 异常1处理方法
    } catch(Exception2 e) {
        // 异常2处理方法
    } finally {
        // 一定要执行的代码
    }

    ```
注意：
    * finall 是可选的
    * try 块内声明的变量为局部变量。出了try { }就不能被调用了
    * catch 语句内对异常的处理
        - getMessage()    -- 返回String关键错误信息
        - printStackTrace()    -- 打印错误信息
    * 可以多个catch语句，try中抛出的异常类对象从上往下匹配catch中的异常类的类型，一旦匹配就执行catch中的代码
        执行完就跳出后面的catch语句
    * 如果异常处理了，其后的代码继续执行
    * 对于运行时异常，可以不显式的进行处理；对于编译时异常，必须要显式的进行处理
    * 若catch中多个异常类型是"并列"关系，哪个在上都可以
        若catch中多个异常类型是"包含"关系，必须子类异常类放在父类异常类的上面进行处理，否则编译报错。
    * finally中的语句一定会被执行。不管try、catch中是否仍有异常未被处理，以及是否有return语句，除了是明确指定退出程序外，如System.exit(1)
    * try-catch可以嵌套

    * 方式二



* */

package com.java.exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTryCatch {

    // 运行时异常

    // InputMismatchException 输入类型不匹配
    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        try{
            int i16 = sc.nextInt(); // 当输入的不是整数时报错
            System.out.println(i16);
        } catch(InputMismatchException e) {
            System.out.println("输入的类型不匹配");
        }
    }

    // ArrayIndexOutOfBoundsException 数组下标越界
    @Test
    public void test2() {
        int[] iarr = new int[3];
        try {
            System.out.println(iarr[3]);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("下标越界了");
        }
    }

    // ArithmeticException 算术异常
    @Test
    public void test3() {
        try {
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println();
            e.printStackTrace();
        }
    }

    // ClassCastException 类转换异常
    @Test
    public void Test4() {
        try {
            Object b = true;
            String s = (String) b;
            System.out.println(s);
        } catch (ClassCastException e) {
            System.out.println("类型转换出现异常了");
            System.exit(1);
//            return ;
            System.out.println(3/0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("我一定要救那女孩");
        }

        System.out.println("放开那女孩... ...");
    }

    // NullPointerException 空指针异常
    @Test
    public void Test5() {
//        Person p1 = new Person();
//        p1 = null;
//        System.out.println(p1.toString());
//
//        System.out.println("abc");
        try {
            String s1 = new String("AABBCC");
            s1 = null;
            System.out.println(s1.length());
        } catch (NullPointerException e) {
            System.out.println("出现空指针异常了");
            e.printStackTrace();
        }
    }

    // 编译时异常
    @Test
    public void test6() { // 为让编译通过，可抛出错误 public void test6() throws Exception
        FileInputStream fp = null;
        try {
            fp = new FileInputStream(new File("hello.txt"));
            int b;
            while ((b = fp.read()) != -1) {
                System.out.println((char) b);
            }
            fp.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
