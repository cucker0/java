/*
reflection 反射

## java反射机制提供的功能
* 在运行时判断任意一个对象所属的类
* 在运行时判断任意一个类的对象
* 在运行时判断任意一个类所具有的成员变量和方法
* 在运行时判断任意一个对象的成员变量和方法
* 生成动态代理

## 反射相关的主要API
* java.lang.Class 代表一个类，是反射的源头
* java.lang.reflect.Method 代表类的方法
* java.lang.reflect.Field 代表类的成员变量
* java.lang.reflect.Constructor 代表类的构造器


Class类

## Class方法
public Field getField(String name)

我们新建源文件如 j.java，在里面创建一个类，通过javac编译该源文件件，生成对应的 类名.class文件，一个类一个class文件。
之后使用java加载（JVM的加载器完成的），class文件加载到内存中，就是一个运行时类，存在缓存区。这个运行时类就是一个
Class的实例。
每个运行时类只加载一次。


有了相应类的运行时类，即Class对象，可有下列功能
* 创建相应运行时类的对象
* 获取相应运行时类的完整结构（属性、构造器、方法、内部类、接口、父类、所在的包、注解、抛出的异常）
* 调用对应的运行时类的指定结构（属性、方法、构造器）
* 反射的应用：动态代理

* */


package com.java.www;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() {
        // 正常创建类的对象方法，即不使用反射
        Person p1 = new Person("田蒙", 30);
        System.out.println(p1);

        p1.speak("给我拿下大唐");

    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取类对应的Class对象
        Class clazz = Person.class;

        // 2. 通过Class对象创建对应的运行时类Person类的对象
        Object obj = clazz.newInstance();
        Person p1 = (Person) obj;
        System.out.println(p1);

        // 通过反射调用运行时类的指定属性
        Field f1 = clazz.getField("name");
        f1.set(p1, "曹操");
        System.out.println(p1);

        // 访问无权限的属性时(如private, 不同下没有权限的)，设置可访问值为true
        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p1, 29);
        System.out.println(p1);

        Method m1 = clazz.getMethod("getName");
        Object obj67 = m1.invoke(p1);
        String name = (String) obj67;
        System.out.println(obj67); // 曹操

        Method m2 = clazz.getMethod("speak", String.class);
        Object obj72 = m2.invoke(p1, "再来一瓶啤酒...");
        System.out.println(obj72); // null, m2 方法是无返回值,void

    }

    @Test
    public void test3() {
        // 获取类的Class实例

        // 方式1：通过运行时类的对象，调用 对象.getClass()
        Person p1 = new Person();
        // 获取对象的运行时类
        Class clazz = p1.getClass();
        System.out.println(p1);
        System.out.println(clazz);

        // 方式2：通过运行时类，调用 类.class
        Class clazz2 = String.class;
        System.out.println(clazz2.getName());

        // 方式3：通过Class的静态方法，调用 public Class Class.forName(String className)
        // className必须是完整路径的
        String className = "com.java.www.Person";
        Class clazz3 = null;
        try {
            clazz3 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz3.getName());

    }

    @Test
    public void test4() {



    }

}
