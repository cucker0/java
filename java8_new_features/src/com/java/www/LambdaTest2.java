package com.java.www;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 举例: (o1, o2) -> Integer.compare(o1, o2);
 * 格式:
 *      ->: lambda操作符(或叫箭头操作符)
 *      ->左边: lambda形参列表 (其实就是接口中的抽象方法的形参列表)
 *      ->右边: lambda体 (其实就是接口抽象方法的重写后的方法体)
 *
 * Lambda表达式的本质：作为接口的实例，且该接口只定义了一个抽象方法。
 * Lambda表达式的使用：(分为6中情况)
 * 语法格式1：无参, 无返回值
 * 语法格式2：有一个参数，无返回值
 *
 *
 *
 * */
public class LambdaTest2 {
    /**
     * 语法格式1：无参, 无返回值
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("身是菩提树，心如明镜台;时时勤拂拭，莫使惹尘埃。");
            }
        };

        r1.run();
        System.out.println("\n// --------------------\n");

        Runnable r2 = () -> System.out.println("菩提本无树,明镜亦非台;本来无一物,何处惹尘埃。");
        r2.run();
    }

    /**
     * 语法格式2：有一个参数，无返回值
     */
    @Test
    public void test3() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("谎言和誓言的区别？");
        System.out.println("\n// --------------------\n");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("一个是听的人信了，一个是说的人信了");

    }

}
