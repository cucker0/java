/*
静态代理

* */

package com.java.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory fc = new NikeClothFactory();
        ProxyFactory proxy = new ProxyFactory(fc);
        proxy.product();

    }
}

interface ClothFactory {
    void product();
}

class NikeClothFactory implements ClothFactory{
    // 被代理类
    @Override
    public void product() {
        System.out.println("Nike制衣厂生产了10000件");
    }
}

class ProxyFactory implements ClothFactory {
    // 代理类

    ClothFactory fc;

    // 构造器
    public ProxyFactory(ClothFactory fc) {
        this.fc = fc;
    }

    // 方法
    @Override
    public void product() {
        System.out.println("代理 开始生产...");
        fc.product();
    }
}

