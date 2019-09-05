package com.java.interfaceFeatures;

/**
 * java 8 接口的改进
 *
 * 默认方法：
 * default修饰，相当于public default 修饰
 *
 * 静态方法：
 * static修饰，相当于public static修饰
 */
public interface MyInterface {
    double PI = 3.1415926;

    // 方法
    // 默认方法
    default void method1() {
        System.out.println("首都");
    }

    public default void method2() {
        System.out.println("上海");
    }

    // 静态方法
    static void method3() {
        System.out.println("我是接口static方法");
    }
}
