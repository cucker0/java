package com.java.polymorphic;

public class Man extends Person {
    private String moustacheType; // 胡子类型：8字须，山羊胡，络腮胡
    long id = 102;

    // 构造器
    public Man() {
        super();
    }

    public Man(String name, int age, String moustacheType) {
        super(name, age);
        this.moustacheType = moustacheType;
    }

    // 方法
    public void showMoustache() {
        System.out.println("moustacheType: " + moustacheType);
    }

    public void walk() {
        System.out.println("男人: " + name + " 在走路");
    }
}
