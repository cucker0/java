/*
类的多态特性应用

* */


package com.java.polymorphic;

import java.util.concurrent.TimeoutException;

public class TestAnimal {
    public static void main(String[] args) {
        Animal an1 = new Dog();
        an1.eat();
        an1.jump();
//        an1.bark(); // 不能直接调用

        System.out.println();
        Animal an2 = new Cat("卢布朵");
        an2.eat();
        an2.jump();

        System.out.println();
        TestAnimal t = new TestAnimal();
        t.call(an1);
        t.call(an2);
        t.hobby(an1);
        t.hobby(an2);



    }

    void call(Animal animal) {
        if (animal instanceof Dog) {
            Dog an = (Dog)animal;
            an.call();
        } else if (animal instanceof Cat) {
            Cat an = (Cat)animal;
            an.call();
        }
    }

    public void hobby(Animal animal) {
        if (animal instanceof Dog) {
            Dog dd = (Dog)animal;
            dd.call();
        } else if (animal instanceof Cat) {
            Cat cc = (Cat)animal;
            cc.fishFarming();
        }
    }
}

class Animal {
    protected String name;

    // constructor
    public Animal() {

    }

    public Animal(String name) {
        setName(name);
    }

    // method
    public void eat() {
        System.out.println("进食");
    }

    public void jump() {
        System.out.println("跳");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {


    public void eat() {
        System.out.println("狗吃肉");
    }

    public void jump() {
        System.out.println("狗急跳墙");
    }

    public void call() {
        // 狗吠叫
        System.out.println("汪汪汪...");
    }
}

class Cat extends Animal {

    // constructor
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    // method
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void jump() {
        System.out.println("猫跳上墙");
    }

    public void fishFarming() {
        // 种鱼
        System.out.println("猫种鱼");
    }

    public void call() {
        System.out.println("猫喵喵叫...");
    }

}
