/*
动态代理


* */

package com.java.proxy;

import com.java.www.MyAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Factory {
    void make();
}

class HuaweiFactory implements Factory {

    // 构造器
    public HuaweiFactory() {
        super();
    }

    // 方法
    @Override
    public void make() {
        System.out.println("华为松山湖生产基地生产了100000 部手机");
    }

}

class MyInvocationHandler implements InvocationHandler {
    Object obj; // 实现了接口的被代理类的对象

    // 构造器
    public MyInvocationHandler() {
        super();
    }

    // 方法
    public Object getProxyInstance(Object obj) {
        /*
        本方法作用：
        1. 给被代理的对象实例化
        2. 返回一个代理类的对象

        * */

        this.obj = obj;
        // 使用反射，根据被代理类动态生成代理对象
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 当通过代理类的对象发起对被重写方法的调用时，都会转为对invoke方法的调用

        Object returnVal = method.invoke(obj, args);
        System.out.println("实现的invoke方法被调用了");
        return returnVal;
    }
}


public class DynamicProxyTest {
    public static void main(String[] args) {
        // 1. 创建被代理类对象
        HuaweiFactory huawei = new HuaweiFactory();
        // 2. 创建一个 实现了 InvocationHandler接口的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        // 调用getProxy获取 动态生成代理类对象
        Object obj = handler.getProxyInstance(huawei);
        Factory haproxy = (Factory) obj;
        haproxy.make(); // 转到对动态代理类对象的invoke()方法的调用
        System.out.println();

        //
        NikeClothFactory nikeFc = new NikeClothFactory();
        Object obj2 = handler.getProxyInstance(nikeFc);
        ClothFactory fc = (ClothFactory) obj2;
        fc.product();
    }
}
