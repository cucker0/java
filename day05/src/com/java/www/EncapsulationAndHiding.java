/*
java封装、隐藏

* */

package com.java.www;

public class EncapsulationAndHiding {
    public static void main(String[] args) {
        Animal dog1 = new Animal();
        dog1.setLegs(4);
        dog1.setLegs(-100); // 不合法的数字
        System.out.println(dog1.getLegs());
        
    }

}

class Animal {
    private int legs;
    public void setLegs(int i) {
        if (i < 0 || i > 100) {
            System.out.println("输入的数字不合法");
        } else {
            legs = i;
        }
    }

    public int getLegs() {
        return legs;
    }
}