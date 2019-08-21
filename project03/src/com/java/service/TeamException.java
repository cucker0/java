/*
* 自定义异常类
* */

package com.java.service;

public class TeamException extends Exception{
    static final long serialVersionUID = -7034897190745766001L; // 版本

    // 构造器
    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }

}
