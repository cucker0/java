/*
枚举类实现接口

* */


package com.java.enumerate;

/*
public class EnumImplementsInterface {
}
*/

interface Info {
    void show();
}

enum Season3 implements Info {
    // 创建类的实例对象只能放在最前面，多个实例之间用","分隔,
    SPRING ("spring", "春暖"),
    SUMMER ("summer", "夏热"),
    AUTUMN ("autumn", "秋凉"),
    WINTER ("winter", "冬寒");

    // 1 属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;

    // 构造器，默认已经是 private
    Season3(String seasonName, String seasonDesc) {
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

    @Override
    public void show() {
        System.out.println("四季之一: " + seasonName);
    }

}


enum Season4 implements Info {

    // 特殊的实现
    SPRING ("spring", "春暖") {
        public void show() {
            System.out.println("春眠不觉晓");
        }
    },
    SUMMER ("summer", "夏热") {
        public void show() {
            System.out.println("夏日炎炎");
        }
    },
    AUTUMN ("autumn", "秋凉") {
        public void show() {
            System.out.println("秋风煞爽");
        }
    },
    WINTER ("winter", "冬寒") {
        public void show() {
            System.out.println("千里冰封，万里雪飘");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    Season4(String seasonName, String seasonDesc) {
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

}
