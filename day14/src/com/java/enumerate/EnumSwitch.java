/*
把枚举类作为switch的表达式，枚举类实例对象名字作为case子句值

* */

package com.java.enumerate;

public class EnumSwitch {
    public static void main(String[] args) {
        enumSwitch(Season2.AUTUMN);
        enumSwitch(Season2.SUMMER);
    }

    public static void enumSwitch(Season2 s) {
        switch (s) {
            case SPRING:
                System.out.println("我是春节");
                break;
            case SUMMER:
                System.out.println("我是夏季");
                break;
            case AUTUMN:
                System.out.println("我是秋季");
                break;
            case WINTER:
                System.out.println("我是冬季");
                break;
            default:
                System.out.println("Season2 枚举类中无此对象");
        }

    }

}
