package com.java.www;

public class PhoneUSB<T> implements USB<T> { // 也可是指定泛型的类型，如：public class PhoneUSB implements USB<String> { }
    @Override
    public void start(T t) {
        System.out.printf("启动手机USB连接，使用技术：%s\n", t);
    }

    @Override
    public void stop(T t) {
        System.out.printf("关闭手机USB连接，使用技术：%s\n", t);
    }
}
