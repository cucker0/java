/*
手动抛出异常

* 格式：throw 异常类的对象，如：throw new RuntimeException("类型不一样");
* throw 语句行后不能有其他语句。
* 抛出的异常类型，若是RuntimeException 可以不用显式的处理
* 若是Exception异常，必须显式的处理，因为Exception异常包含了编译时异常


* */

package com.java.www;

public class ThrowTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(3.1);
        Circle c2 = new Circle(3.1);
        System.out.println(c1.compareTo(c2));
        System.out.println(c1.compareTo(new Integer(3)));

    }
}

class Circle {
    // 实例变量
    private double radius;

    // 构造器
    public Circle() {
        super();
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // 方法
    public int compareTo(Object obj) {
        /*
        0: 相等
        1: 当前对象大于obj
        -1:当前对象小于obj
        * */

        if (this == obj) {
            return 0;
        }
        if (obj == null) {
            throw new RuntimeException("比较的对象不能为null");
        }
        if (this.getClass() != obj.getClass()) {
            throw new RuntimeException("类型不一样"); // 手动抛出异常
        }
        if (obj instanceof Circle) {
            Circle o = (Circle) obj;
            if (radius > o.radius) {
                return 1;
            } else if (radius == o.radius) {
                return 0;
            } else {
                return -1;
            }
        } else {
//            return -2;
            throw new RuntimeException("类型不一样"); // 手动抛出异常对象
        }

    }


}
