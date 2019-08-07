/*
比较两个矩形是否相等
* */

package com.java.exercise;

public class ComparableRectangle extends Rectangle implements CompareObject{

    // 构造器
    public ComparableRectangle(double wide, double length){
        super(wide, length);
    }

    // 方法
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return -2;
        }
        if (this.getClass() == o.getClass()) {
            Rectangle obj = (Rectangle) o;
            if (findArea() == obj.findArea()) {
                return 0;
            } else if (findArea() > obj.findArea()) {
                return 1;
            } else {
                return -1;
            }
        }

        return -2;
    }
}
