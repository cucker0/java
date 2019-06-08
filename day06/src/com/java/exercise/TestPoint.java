/*
题目：
定义一个“点”（Point）类用来表示三维空间中的点（有三个坐标）。要求如下：
    1）可以生成具有特定坐标的点对象。
    2）提供可以设置三个坐标的方法。
    3）提供可以计算该“点”距原点距离平方的方法。

* */

package com.java.exercise;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.showCoordinate();
        p1.setCoordinate(0, 3, 4);
        p1.showCoordinate();
        System.out.println(p1.distanceToO());
    }
}

class Point {
    private double x, y, z;

    // 构造器
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(double x) {
        // 只输入一个坐标值时为x轴值，y、z值为0
        this.x = x;
        y = 0;
        z = 0;
    }

    public Point(double x, double y) {
        //输入两值时，分别为x、y轴值，z轴值为0
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Point() {
        x = 0;
        y = 0;
        z = 0;
    }

    // 方法
    public double[] getCoordinate() {
        // 获取坐标值，{x, y, z}
        double[] coordinate_value = new double[3];
        coordinate_value[0] = x;
        coordinate_value[1] = y;
        coordinate_value[2] = z;
        return coordinate_value;
    }

    public void showCoordinate() {
        // 打印坐标值
        System.out.printf("%f, %f, %f", x, y, z);
        System.out.println();
    }

    public void setCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceToO() {
        double sqrt_sum = Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0); // Math.pow(a, b),b为指数，如果要表示开根，则可以用 1.0 / x
        return Math.sqrt(sqrt_sum); // 与 Math.pow(sqrt_sum, 1.0 / 2); 等同
    }


}