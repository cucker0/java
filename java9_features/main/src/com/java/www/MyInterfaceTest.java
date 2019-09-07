package com.java.www;

public class MyInterfaceTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.method2();
    }
}

class Shop implements MyInterface {

    @Override
    public void method1() {
        System.out.println("new shop come soon ...");
    }
}