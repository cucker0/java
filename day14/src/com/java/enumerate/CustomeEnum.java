/*
自定义枚举类

* 如果只有一个实例对象，就是单例模式

* */

package com.java.enumerate;

public class CustomeEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        Season spring = Season.SPRING;

        System.out.println(Season.SPRING.getSeasonName());
    }
}

class Season {
    // 1 属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;

    // 构造器
    // 2 private构造器，并初始化属性
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 方法
    // 3 提供public方法访问属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public void show() {
        System.out.println("四季之一");
    }

    // 4 在内的内部创建枚举类的实例，将类的对象声明public static final
    public static final Season SPRING = new Season("spring", "春暖");
    public static final Season SUMMER = new Season("summer", "夏热");
    public static final Season AUTUMN = new Season("autumn", "秋凉");
    public static final Season WINTER = new Season("winter", "冬寒");

}
