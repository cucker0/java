package com.java.www;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        System.out.println(cy.findVolume());

        Cylinder cy2 = new Cylinder();
        cy2.setLength(3);
        cy2.setRadius(6);
        System.out.println(cy2.findVolume());
        System.out.println(cy2.findArea());
    }
}
