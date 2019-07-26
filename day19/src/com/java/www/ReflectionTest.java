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




类加载器ClassLoader
    类加载器是用来把类(class)装载时内存的。JVM规范定义了两种类型的类加载器：启动类加载器(bootstrap)和用户定义
加载器(user-defined class loader)。JVM在运行时会产生3个类加载器组成的初始化加载器层次结构：
Bootstrap ClassLoader 引导类加载器：用C++编写，是JVM自带的类加载器，负责java平台核心库，用来加载核心类库。访加载器无法直接获取
Extension ClassLoader 扩展类加载器：负责jre/lib/ext 目录下的jar包或-D java.ext.dirs指定目录下的jar包载入工作库
System ClassLoader 系统类加载器：负责java -classpath 或 -D java.class.path所指定的目录下的类与jar包载入工作，是最常用的加载器


* */


package com.java.www;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

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
        Object obj = clazz.newInstance(); // 代用了空参的Person()构造器
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

        // 方法
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
        Class<String> clazz2 = String.class;
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


        Class<Person> clazz4 = Person.class;
        System.out.println(clazz == clazz4); // true
        System.out.println(clazz == clazz3); // true
        System.out.println();

        // 方式4：类的加载器
        ClassLoader loader = this.getClass().getClassLoader();
        try {
            Class clazz5 = loader.loadClass("java.lang.Math");
            System.out.println(clazz5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        // 类加载器
        ClassLoader loader0 = this.getClass().getClassLoader();
        System.out.println(loader0);

        String className = "java.lang.Math";
        Class clazz = null;
        try {
            clazz = loader0.loadClass(className);
            System.out.println(clazz.getName());
            ClassLoader loader5 = clazz.getClassLoader(); // null
            System.out.println(loader5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        ClassLoader loader1 = ClassLoader.getSystemClassLoader();
        System.out.println(loader1);

        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);

        ClassLoader loader3 = loader2.getParent();
        System.out.println(loader3); // BootStrap ClassLoader 无法直接获取

        Class<Person> clazz1 = Person.class;
        ClassLoader loader4 = clazz1.getClassLoader();
        System.out.println(loader4);

    }

    @Test
    public void test5() {
        // 利用类加载器访问包内的文件，非根路径下的
        ClassLoader loader = this.getClass().getClassLoader();
        String filePath = "com\\java\\www\\conf.property";
        InputStream is = loader.getResourceAsStream(filePath);

        // 或
//        String filePath = "E:\\dev\\java_2019\\day19\\src\\com\\java\\www\\conf.property";
//        InputStream is = null;
//        try {
//            is = new FileInputStream(filePath); // FileInputStream相对路径只能加载根目录下或绝对路径的文件，相对包路径下的文件加载找不到路径
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        Properties properties = new Properties();
        try {
            properties.load(is);
            String host = properties.getProperty("host"); // 等号后的""也会取出来
            String port = properties.getProperty("port");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            System.out.println(host);
            System.out.println(port);
            System.out.println(user);
            System.out.println(password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
