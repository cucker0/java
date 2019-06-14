package com.java.exercise;

public class TestGeometricObject {
    public static void main(String[] args) {
        TestGeometricObject t = new TestGeometricObject();
        Circle c1 = new Circle(2.2, "red", 3.1);
        Circle c2 = new Circle(2.2, "red", 3.1);
        MyRectangle m1 = new MyRectangle(1.1, 6, "green", 3.14);
        System.out.println(t.equalsArea(c1, m1));

        t.displayGeometricObject(c1);
        t.displayGeometricObject(m1);
        System.out.println(t.equalsArea(c1, c2));
    }

    public boolean equalsArea(GeometricObject g1, GeometricObject g2) {
//        if (g1.findArea() == g2.findArea()) {
//            return true;
//        } else {
//            return false;
//        }
        return g1.findArea() == g2.findArea();
    }

    public void displayGeometricObject(GeometricObject g) {
        System.out.println(g.findArea());
    }

}
