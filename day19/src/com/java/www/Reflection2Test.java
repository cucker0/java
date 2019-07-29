/*
java反射功能展示


Class.getField(fieldName) 获取运行时类中public修饰的名为fieldName的属性
Class.getDeclaredField(fieldName) 获取运行时类声明了的且名为fieldName的属性，包括private修饰的

* */

package com.java.www;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;

public class Reflection2Test {
    private Class clas = Person.class;

    @Test
    public void test1() {
        // 获取构造器

        String className = "com.java.www.Person";
        Class clazz = null;
        try {
            clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            Person p1 = (Person) obj;
            System.out.println(p1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("获取所有构造器");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    @Test
    public void test2() {
        // 获取父类

        Class<Person> clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass); // class com.java.www.Biology

    }

    @Test
    public void test3() {
        // 获取带泛型的父类

        Class clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();
        System.out.println(type1);

    }

    @Test
    public void test4() {
        // 获取父类的泛型

        Class clazz = Person.class;
        Type type1 = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type1;
        Type[] args = parameterizedType.getActualTypeArguments();
        Class firstArg = (Class) args[0];
        System.out.println(firstArg.getName());

//        for (Type t : args) {
//            System.out.println(t);
//        }
    }

    @Test
    public void test5() {
        // 获取接口实现的接口

        Class[] interfaces = clas.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }
    }

    @Test
    public void test6() {
        // 获取类所在的包

        Package pack = clas.getPackage();
        System.out.println(pack);

    }

    @Test
    public void test7() {
        // 获取注解

        Annotation[] annotations = clas.getAnnotations(); // 只能获取到 RetentionPolicy.RUNTIME 这个生命周期的注解
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }

    }

    @Test
    public void test8() {
        // 获取属性字段

        Field[] fields = clas.getDeclaredFields();
        System.out.println("修饰符 类型 属性名");
        for (Field f : fields) {
            // 获取属性修饰符
            int i = f.getModifiers();
            String modifier = Modifier.toString(i);
            System.out.print(modifier + " ");

            // 获取属性的类型
            Class type = f.getType();
            String[] typeStr = type.toString().split("\\.");
            System.out.print(typeStr[typeStr.length - 1] + " ");

            // 获取属性名
            System.out.print(f.getName());
            System.out.println();
        }

    }

    @Test
    public void test9() {
        // 获取方法

        // 获取此类以及父类的所有public 方法
        Method[] methods = clas.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();

        // 获取此类本身声明的所有方法，包括private方法
        Method[] methods2 = clas.getDeclaredMethods();
        for (Method m : methods2) {
            // 获取方法的异常信息
            System.out.println(m);
            Class[] exceptionArr = m.getExceptionTypes();
            if (exceptionArr.length > 0) {
                System.out.println("方法的异常信息：");
                for (Class e : exceptionArr) {
                    System.out.println(e);
                }
                System.out.println();
            }

        }
    }

    @Test
    public void test10() {
        // 获取内部类
        Class[] innerClazz = clas.getDeclaredClasses();
        for (Class c : innerClazz) {
            System.out.println(c);
        }
    }

    @Test
    public void test12() {
        // 获取指定的属性，并操作该属性

        Person p1 = null;
        try {
            p1 = (Person) clas.newInstance();

            Field name = clas.getField("name");
            name.set(p1, "三强");

            // 获取并做操私有属性
            Field age = clas.getDeclaredField("age");
            age.setAccessible(true); // 设置此属性可操作
            age.set(p1, 22);

            System.out.println(p1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test13() {
        // 获取指定的方法，并调用该方法

        Method m1 = null;
        try {
            Person p1 = (Person) clas.newInstance();
            p1.setName("谢春芳");
            p1.setAge(32);

            // public 无参方法
            m1 = clas.getMethod("getAge");
            Object ret = m1.invoke(p1);
            int age = (Integer) ret;
            System.out.println(age);

            // public 有参方法
            Method m2 = clas.getMethod("speak", String.class);
            Object ret191 = m2.invoke(p1, "生产力决定生产关系");

            // private 有参方法
            Method m3 = clas.getDeclaredMethod("see", int.class, String.class);
            m3.setAccessible(true);
            Object ret194 = m3.invoke(p1, 10, "站着");
            String r194 = (String) ret194;
            System.out.println(r194);

            // 静态方法
            Method m4 = clas.getDeclaredMethod("info");
            m4.invoke(Person.class);
            m4.invoke(null); // 对象null也可以


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test14() {
        // 调用指定的构造器

        try {
            // 空参构造器
            Constructor constructor = clas.getConstructor();
            Object obj = constructor.newInstance();
            System.out.println(obj);

            // 获取带参的构造器
            Constructor constructor2 = clas.getDeclaredConstructor(String.class);
            constructor2.setAccessible(true);
            Person p2 = (Person) constructor2.newInstance("鬼谷子");
            System.out.println(p2);

            // 获取带参的构造器
            Constructor constructor3 = clas.getDeclaredConstructor(String.class, int.class);
            Person p3 = (Person) constructor3.newInstance("孙膑", 33);
            System.out.println(p3);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
