package com.java.www;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 局部变量类型推断使用情况、不适用情况
 *
 */
public class LocalVariableInferenceTest {
    /**
     * 局部变量的初始化
     *
     */
    @Test
    public void test1() {
        var num = 10;

        var list = new ArrayList<>(); // list元素的类型为Object
        var list2 = new ArrayList<Integer>(); // list元素的类型为Integer
        list2.add(78);
        System.out.println(list2);

        var arr = new int[]{1, 5, 8};
        System.out.println();
    }

    /**
     * forEach增添循环
     */
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(11, 22, 1, 33);
        for (var e : list) {
            System.out.println(e);
            System.out.println(e.getClass());
            System.out.println();
        }
    }

    /**
     * for遍历
     */
    @Test
    public void test3() {
        for (var i = 0; i < 10; ++i) {
            System.out.println(i);
        }

    }


    // 下面的几个方法中的实例都是不适用的

    /**
     * 变量初始值为null，不适用var类型推断
     */
    @Test
    public void test4() {
//         var str = null;
    }

    /**
     * lambda表达式，不适用于var类型推断
     */
    @Test
    public void test5() {
        // 正常写法
        Supplier<Double> supplier =  () -> Math.random();
        System.out.println(supplier.get());

//         var  supplier2 =  () -> Math.random(); // 不适用
    }

    /**
     * 方法引用中使用类型推断，不适用
     */
    @Test
    public void test6() {
        // 正常写法
        Consumer<String> consumer = System.out::println;

        // 不适用
//        var consumer2 = System.out::println;
    }

    /**
     * 为数组静态初始化，不适用
     */
    @Test
    public void test7() {
        // 正常写法
        int[] arr = {11, 99, 88};

//        var arr2 = {11, 99, 88}; // 不适用
    }

    /**
     * 没有初始化的局部变量声明，不适用
     */
    @Test
    public void test8() {
//        var flag;
    }

    /**
     * 方法的返回类型，不适用
     */
//    public var getAge() {
//        return 1;
//    }

    /**
     * 方法的参数类型，不适用
     */
//    public void show(var name) {
//        System.out.println(name);
//    }

    /**
     * 构造器的参数类型，不适用
     */
//    public LocalVariableInferenceTest(var id) {
//        super();
//    }

    /**
     * 字段属性，不适用
     *
     */
//    private var name = "Li li";
//    private var age = 23;
//    private var height;

    /**
     * catch块中的异常类型，不适用
     */
    @Test
    public void test13() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("abc.txt"));
        }
//        catch (var e) {} // 不适用
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
