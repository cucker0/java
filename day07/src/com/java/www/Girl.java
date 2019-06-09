/*
Girl class
* */

package com.java.www;

public class Girl {
    private String name;

    // 构造器
    public Girl() {
        name = "女娲";
    }

    public Girl(String name) {
        this.name = name;
    }

    // 方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void marry(Boy boy) {
        System.out.printf("我是[%s]，[%s]我想嫁给你，你愿意吗？", this.name, boy.getName());
        System.out.println();
        boy.shout(this); // this指当前这个Girl实例自身
    }
}
