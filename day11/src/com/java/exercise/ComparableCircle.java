package com.java.exercise;

public class ComparableCircle extends Circle implements CompareObject {

    // 构造器
    public ComparableCircle() {
        super();
    }

    public ComparableCircle(double radius) {
        super(radius);
    }


    // 方法
    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return -2;
        }
        if (this.getClass() == o.getClass()) {
            Circle c = (Circle) o;
            if (radius == c.radius) {
                return 0;
            } else if (radius > c.radius) {
                return 1;
            } else {
                return -1;
            }
        }
        return -2;
    }
}
