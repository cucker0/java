/*
Boy class

* */

package com.java.www;

public class Boy {
    private String name;
    private int age;

    // 构造器

    public Boy(String name) {
        this.name = name;
    }

    public Boy(String name, int age) {
        this(name);
        this.age = age;
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl) {
        System.out.printf("我是[%s], 我要和仙女[%s]结婚了，感谢大家的光临！", this.name, girl.getName());
        System.out.println();
    }

    public void shout(Girl girl) {
        System.out.printf("新郎官[%s]大声喊道:“[%s], 我一百个愿意！！！”\n", this.name, girl.getName());
    }
}
