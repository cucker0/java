package com.java.www;

public class Thread3Test {
    public static void main(String[] args) {
        SubThread4 st1 = new SubThread4();
        SubThread5 st2 = new SubThread5();
        st1.setName("偶数");
        st2.setName("奇数");

        st1.start();
        st2.start();

        //  匿名类方法新建线程
        new Thread() {
            public void run() {
                for (int i = 0; i < 3; ++i) {
                    System.out.println(i);
                }
                System.out.println(currentThread().getPriority());
            }

        }.start();


    }
}

class SubThread4 extends Thread {
    private int num = 100;

    // 方法
    @Override
    public void run() {
        for (int i = 0; i < num; ++i) {
            if (i % 2 == 0) {
                System.out.println(currentThread().getName() + ": " + i);
            }
        }
    }

}

class SubThread5 extends Thread {
    private int num = 100;

    // 方法
    @Override
    public void run() {
        for (int i = 0; i < num; ++i) {
            if (i % 2 != 0) {
                System.out.println(currentThread().getName() + ": " + i);
            }
        }
    }

}
