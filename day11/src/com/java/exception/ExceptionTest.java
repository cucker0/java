/*
java 异常

* */

package com.java.exception;

import org.junit.Test;

import java.util.Scanner;

public class ExceptionTest {

    // InputMismatchException
    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i16 = sc.nextInt(); // 当输入的不是整数时报错
        System.out.println(i16);
    }



}
