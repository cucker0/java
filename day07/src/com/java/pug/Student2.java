package com.java.pug;

public class Student2 extends Person {
    // override 方法重写
    public void showInfo() {
        // super.showInfo(); // 这是调用父类方法
        System.out.printf("我是神舟大学学生，我叫%s, 我今年%d岁", this.getName(), this.getAge());
    }
}
