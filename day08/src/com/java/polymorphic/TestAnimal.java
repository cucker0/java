/*
类的多态特性应用

* */


package com.java.polymorphic;

public class TestAnimal {
    public static void main(String[] args) {

    }

}

class Animal {
    protected String name;

    // constructor
    public Animal() {

    }

    // method
    public void eat() {
        System.out.println("进食");
    }

    public void jump() {
        System.out.println("跳");
    }
}

class Dog extends Animal {


    public void eat() {
        System.out.println("狗吃肉");
    }

    public void jump() {
        System.out.println("狗急跳墙");
    }



}
