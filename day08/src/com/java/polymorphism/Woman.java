package com.java.polymorphism;

public class Woman extends Person{
    private String hairStyle; // 发型：空气刘海，长发披肩，假男型
    long id = 102;

    // 构造器
    public Woman() {
        super();
    }

    public Woman(String name, int age, String hairStyle) {
        super(name, age);
        this.hairStyle = hairStyle;
    }

    // 方法
    public void showHairStyle() {
        System.out.println("hairStyle: " + hairStyle);
    }

    public void walk() {
        System.out.println("女人: " + name + " 在走路");
    }

    public void watchtTv() {
        System.out.println("女人: " + name + " 在看电视");
    }
}
