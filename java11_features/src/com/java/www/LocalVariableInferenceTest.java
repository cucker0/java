package com.java.www;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 局部变量类型推断
 *
 * 在var上添加注解的语法格式
 *
 */
public class LocalVariableInferenceTest {
    @Test
    public void test1() {
        Consumer<String> consumer = (t) -> System.out.println(t.toUpperCase());
        Consumer<String> consumer1 = (@Deprecated String t) -> System.out.println(t.toUpperCase());

        // 错误写法
//        Consumer<String> consumer2 = (@Deprecated t) -> System.out.println(t.toUpperCase());


        Consumer<String> consumer3 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
}
