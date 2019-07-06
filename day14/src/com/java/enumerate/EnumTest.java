/*
枚举类
枚举类特点：类的对象个数是有限个数确定，一般个数都很少

* 枚举类要求
    * 格式 enum ClassName { }
    * 创建的类实例对象只能放在类的第一行，不要其他修饰，使用","分隔多个实例对象，结尾;
    * 属性是使用private final修饰
    * 无修饰的构造器
* 常用方法
    * T[] values() 获取枚举类的所有实例组成的数组，返回值为数组T[]
    * T valueOf(String instanceName) 通过实例名获取类对应的实例对象，不存在的实例名，报 IllegalArgumentException 异常
* 枚举类实现接口
    * 可以在枚举类中实现接口
    * 也可以每个实例对象中都实现接口，这是与一般类不同的，可以让不同的枚举类对象调用各自重写的方法，执行效果不一样


* */

package com.java.enumerate;

public class EnumTest {
    public static void main(String[] args) {
        Season2 season1 = Season2.SUMMER;
        System.out.println(season1);
        System.out.println(Season2.AUTUMN.getSeasonDesc());
        Season2.AUTUMN.show();
        System.out.println();

        // T[] values()
        Season2[] sArr = Season2.values();
        for (Season2 s : sArr) {
            System.out.println(s);
        }
        System.out.println();

        // T valueOf(String instanceName)
        Season2 s28 = Season2.valueOf("WINTER");
        System.out.println(s28);
        try {
        Season2 s33 = Season2.valueOf("AA"); // valueOf(String instanceName) 不存在的实例名，报 IllegalArgumentException 异常
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // Thread.State 枚举类
        Thread.State[] tsArr = Thread.State.values();
        for (Thread.State t : tsArr) {
            System.out.println(t);
        }
        System.out.println();

        // 枚举类特殊实现测试
        Season4.WINTER.show();
        System.out.println(Season4.AUTUMN.getSeasonName());
        Season4.AUTUMN.show();

    }


}

enum Season2 {
    // 创建类的实例对象只能放在第一行，多个实例之间用","分隔,
    SPRING ("spring", "春暖"),
    SUMMER ("summer", "夏热"),
    AUTUMN ("autumn", "秋凉"),
    WINTER ("winter", "冬寒");
    // 如果构造器中无参数，写成 SPRING, SUMMER, AUTUMN, WINTER;

    // 1 属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;

    // 构造器，默认已经是 private,写上也不会出错
    Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 方法
    // 提供public方法访问属性
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
        System.out.println("四季之一: " + seasonName);
    }

}
