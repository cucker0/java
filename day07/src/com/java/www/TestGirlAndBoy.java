/*
测试Girl、Boy类

* */

package com.java.www;

public class TestGirlAndBoy {
    public static void main(String[] args) {
        Boy gg = new Boy("潇十一郎", 28);
        Girl mm = new Girl("白发魔女");
        Girl mm2 = new Girl("刘诗诗");

        gg.getName();
        gg.marry(mm);
        mm2.marry(gg);
    }
}
