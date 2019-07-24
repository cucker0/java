/*
注解Annotation

* 符号：@
* 三个常用的Annotation
    * @Override 限定重写父类方法，该注释只能用于方法，显式的指明方法要重写，如果权限修饰、方法名等有错误能有提示
    * @Deprecated 用于表示某个程序元素（类，方法等）已经过时，仍能正常正常运行和使用，一般表示有更好的方法，建议使用新方法，生成的doc api中有Deprecated标识
    * @SuppressWarnings 抑制编译器警告
* 自定义一个注解
格式：public @interface MyAnnotation { }


* 元注解
    JDK 的元注解 用于修饰其他 Annotation 定义
    * Retention 指定注解的生命周期，可以保留到哪个阶段，
        可选值：
        RetentionPolicy.SOURCE 编译器直接丢弃这种策略的注释
        RetentionPolicy.CLASS 编译器将把注释记录在 class 文件中. 当运行 Java 程序时, JVM 不会保留注解。 这是默认值
        RetentionPolicy.RUNTIME 编译器将把注释记录在 class 文件中. 当运行 Java 程序时, JVM 会保留注释. 程序可以通过反射获取该注释
    * Target 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
        可选值：
        TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE, MODULE
    * Documented 用于指定被该元 Annotation 修饰的 Annotation 类将被 javadoc 工具提取成文档
    * Inherited 被它修饰的 Annotation 将具有继承性.如果某个类使用了被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解




* */

package com.java.annotation;


import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

public class AnnotationTest {
    public static void main(String[] args) {
        Student s1 = new Student("Linda", 22);
        s1.walk();
        s1.show();

        Person p1 = new Person("小八路",18);

        @SuppressWarnings({"rawtypes", "unused"})
        List list =  new ArrayList();

        @SuppressWarnings({"unused"})
        boolean b = true;

    }
}

@Deprecated
class Person {
    protected String name;
    protected int age;

    // 构造器
    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void eat() {
        System.out.println("人吃东西");
    }

    public void walk() {
        System.out.println("人走路");
    }

    @Deprecated
    public void show() {
        System.out.println("name: " + name + ", age: " + age);
    }

}

@MyAnnotation(value = {"well"})
class Student extends Person{

    // 构造器
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    // 方法
    /*
    // 快速发现有错误的地方
    @Override
    public void walk(String how) {

    }
    */

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


