package com.java.www;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * lambda表达式举例
 */

public class LambdaTest {
    /**
     * 匿名内部类，之前的方式
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实例");
            }
        };

        Thread t = new Thread(runnable);
        t.start();

    }

    /**
     * Lambda表达式
     */
    @Test
    public void test2() {
//        Runnable runnable = () -> System.out.println("Hello Lambda");
        Runnable runnable = () -> System.out.println(String.format("%s: Hello Lambda", Thread.currentThread().getName()));

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();

    }

    /**
     * 原来使用匿名内部类实例作为参数传递
     */
    @Test
    public void test3() {
        // TreeSet使用定制排序
        Comparator<String> comparator = new Comparator<String>() { // 创建一个 实现了Comparator接口的匿名内部类的 对象
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        };

        TreeSet<String> treeSet = new TreeSet<>(comparator);

    }

    /**
     * Lambdai表达式实现的内部类对象
     */
    @Test
    public void test4() {
        Comparator<String> comparator = (o1, o2) -> {
            return -Integer.compare(o1.length(), o2.length());
        };
        // 上面的lambda表达式也可以简写成这样的
        Comparator<String> comparator1 = (o1, o2) -> -Integer.compare(o1.length(), o2.length());

        TreeSet<String> treeSet = new TreeSet<>(comparator);
        TreeSet<String> treeSet1 = new TreeSet<>(comparator1);

        System.out.println(comparator1.compare("abc", "abdf"));
    }
}
