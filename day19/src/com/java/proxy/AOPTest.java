/*
AOP(Aspect Orient Programming) 面向切面编程

功能类似 python 的装饰器

* */

package com.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    void info();

    void fly();
}

class SuperMan implements Human {
    // 方法
    @Override
    public void info() {
        System.out.println("超人蜘蛛侠");
    }

    @Override
    public void fly() {
        System.out.println("蜘蛛侠吐丝在城市里飞");
    }
}

class Play {
    public void method1() {
        System.out.println("打牌...");
    }

    public void method2() {
        System.out.println("KTV...");
    }

}

class goInvocationHandler implements InvocationHandler {
    Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Play p = new Play();

        p.method1();
        Object ret = method.invoke(obj, args);
        p.method2();
        return ret;
    }
}

class MyProxy {
    // 动态创建一个代理类的对象

    // 方法
    public static Object getProxyInstance(Object obj) {
        goInvocationHandler hander = new goInvocationHandler();
        hander.setObj(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), hander);
    }

}


public class AOPTest {
    public static void main(String[] args) {
        SuperMan man = new SuperMan();
        Object obj = MyProxy.getProxyInstance(man);
        Human human = (Human) obj;

        human.info();
        System.out.println();
        human.fly();
        System.out.println();

        //
        NikeClothFactory nikeFc = new NikeClothFactory();
        ClothFactory fc = (ClothFactory) MyProxy.getProxyInstance(nikeFc);
        fc.product();
    }
}


