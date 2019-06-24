/*
面向接口编程思想

* */
package com.java.www;

public class USBTest {
    public static void main(String[] args) {
        Computer c1 = new Computer();
        Flash f1 = new Flash();
        Printer p1 = new Printer();
        c1.doWork(f1);
        c1.doWork(p1);
    }
}

interface USB {

    public abstract void start();

    void stop();
}

class Flash implements USB {

    // 方法
    public void start() {
        System.out.println("U盘开始启动");
    }

    public void stop() {
        System.out.println("U盘退出");
    }
}

class Printer implements USB {

    // 方法
    public void start() {
        System.out.println("打印机开始初始化USB");
    }

    public void stop() {
        System.out.println("打印机关闭USB");
    }
}

class Computer{
    private String model="huawei 5288 V5机架服务器";

    // 方法
    public void doWork(USB obj) {
        System.out.println("连接USB设备...");
        obj.start();
        obj.stop();
    }
}
