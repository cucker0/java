/*
泛型接口

* */

package com.java.www;

public interface USB<T> {
    public abstract void start(T t);
    void stop(T t);
}
