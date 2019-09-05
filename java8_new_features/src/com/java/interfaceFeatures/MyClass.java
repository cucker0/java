package com.java.interfaceFeatures;

/**
 * 接口冲突
 *
 * 实现多个接口时，有接口方法名冲突时，要重写此方法
 */
public class MyClass implements Myfunc, Named{
    @Override
    public String getName() {
        return Named.super.getName();
    }
}


interface Myfunc {
    default String getName() {
        return "Java8";
    }
}

interface Named {
    default String getName() {
        return "my name";
    }
}
