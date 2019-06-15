/*
== (比较符)
* 基本数据类型：根据基本数据类型的值判断是否相等。相等返回true,否则fase
两端数据类型可以不同，在不同的情况下也可以返回true

* 引用数据类型：比较引用类型变量的地址值是否相等。

equals()
java.lang.Object类是所有类的根父类
String、包装类、File类、Date等这些类重写了equals()方法。比较两个对象的"实体内容"是否完全相等

Object类中的equals():
public boolean equeals(Object obj) {
    return (this == obj);
}

String.equals():
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String aString = (String)anObject;
        if (coder() == aString.coder()) {
            return isLatin1() ? StringLatin1.equals(value, aString.value)
                              : StringUTF16.equals(value, aString.value);
        }
    }
    return false;
}


* */

package com.java.www;

public class TestEquals {
    public static void main(String[] args) {
        TestEquals t = new TestEquals();
        t.test();

        Airplane a1 = new Airplane();
        Airplane a2 = new Airplane();
        System.out.println(a1.equals(a2)); // false, 相当于 a1 == a2，

        String str1 = new String("AA");
        String str2 = new String("AA");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true，原因是String类重写了equals()方法，除了比较引用地址是否相等，还比较字符串内容是否相等


    }

    public void test() {
        int i = 12;
        int j = 12;
        System.out.println(i == j); // true

        char c = 12;
        System.out.println(i == c); // true

        float f = 12.0F;
        System.out.println(i == f); // true

        int k = 65;
        char a = 'A';
        System.out.println(k == a); // true

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1 == obj2); // false

        Airplane ap1 = new Airplane();
        Airplane ap2 = new Airplane();
        Airplane ap3 = ap1;

        System.out.println(ap1 == ap2); // false
        System.out.println(ap1 == ap3); // true

    }

}

class Airplane {
    private double width;
    private double length;
    private double height;
    protected String engine;
    private double[] point; // 飞行坐标

    // 构造器
    public Airplane() {
        point = new double[3];
    }

    // 方法
    public void flight(double x, double y, double z) {
        point[0] += x;
        point[1] += y;
        point[2] += z;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public double[] getPoint() {
        return point;
    }

    public void setPoint(double[] point) {
        this.point = point;
    }
}
