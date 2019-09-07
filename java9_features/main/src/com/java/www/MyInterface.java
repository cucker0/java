package com.java.www;

/**
 * java 9 接口改进
 *
 * 抽象类、接口异同
 * 异： *二者的定义
 *      * 声明的方式
 *      * 内部的结构（java 7, java 8, java 9分别说明）
 *      * 抽象类单重继承，接口可以多重继续
 * 同：都不能实例化，以多态的方式使用
 *
 *
 *
 */
public interface MyInterface {
    // java 7: 只能声明全局常量(public static final修饰) 和抽象方法(public abstract默认修饰)
    void method1();

    // java 8: 可以声明默认方法、静态方法
    default void method2() {
        System.out.println("method2() 默认方法");
        method4();
    }

    static void method3() {
        System.out.println("method3() static方法");
    }

    // java 9: 可以声明私有方法
    private void method4() {
        System.out.println("method4() private方法");
    }

}
