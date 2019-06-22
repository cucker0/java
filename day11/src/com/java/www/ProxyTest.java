/*
代理模式(接口的应用)
proxy

* */

package com.java.www;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy p1 = new Proxy();
        p1.action();
    }

}


interface AbstractProxy {
    /*
    定义代理接口
    * */

    void action();
}

class RealServer implements AbstractProxy{
    // real server

    // 构造器
    public RealServer() {
        super();
    }

    // 方法
    public void action() {
        System.out.println("Real server starting");
        System.out.println("Real server executing ...");
        System.out.println("Real server end");
    }
}

class Proxy implements AbstractProxy {
    // 代理
    RealServer rs;

    // 构造器
    public Proxy() {
        super();
        rs = new RealServer();
    }

    // 方法
    public void action() {
        System.out.println("成功创建代理");
        rs.action();
    }

}


