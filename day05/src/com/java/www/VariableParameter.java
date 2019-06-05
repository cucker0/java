/*
可变个数形参


* */

package com.java.www;

public class VariableParameter {
    public static void main(String[] args) {
        VariableParameter vp = new VariableParameter();
        vp.showMessage(new String[]{"aa", "bb"});
        vp.showBooks();
        vp.showBooks("侠客行");
        vp.showBooks("神雕侠侣", "射雕英雄传", "倚天屠龙记");
    }

    public void showMessage(String[] msg) {
        System.out.println("字符串数组形参方法...");
        for (int i = 0; i < msg.length; ++i ) {
            System.out.print(msg[i] + " ");
        }
        System.out.println();
    }

    // showBooks方法的重载
    public void showBooks(String book) {
        System.out.println("与可变形参方法构成重载的showBooks\n " + book);
    }

    public void showBooks(String... books) {
        System.out.println("形参个数可变方法showBooks");
        for (int i = 0; i < books.length; ++i) {
            System.out.print(books[i] + " ");
        }
    }
}
