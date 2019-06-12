/*
super: 可以用来修饰属性、方法、构造器

* 当子类与父类中有相同的属性时，可以通过"super.属性" 显示的调用父类中声明的属性，
    若想调用子类的同名属性"this.属性" 或直接调用 属性

* 当子类重写了父类的方法后，在子类中需要调用父类中被重写的方法，使用"super.方法名"

* 构造器中使用super()
    在子类中使用"super(形参列表)" 显式的调用父类中指定的构造器
    * 构造器内，super(形参列表) 必须写在首行
    * 同一个构造器，"super(形参列表)" 或 "this(形参列表)" 只能出现一个！！！
    * 构造器中，不显式的调用"this(形参列表)" 或 "super(形参列表)"，默认调用的时父类空参的构造器，即super();
    * 建议设计一个类时，尽量要提供一个空参的构造器！



* */

package com.java.www;

public class Student extends Person{
    private String schoolName;
    int id = 1002; // 学号

    // 构造器
    public Student() {
        super(); // 即使不写，默认也编译器也会加上 super();
    }

    public Student(String name, int age, String schoolName) {
        super(name, age); // 调用了父类中的 Person(String name, int age) { }
        this.schoolName = schoolName;
    }


    // 方法
    public void eat() {
        System.out.println("student eating now ...");
    }

    public void status() {
        eat(); // <==> this.eat();
        super.eat();
    }

    public void showInfo() {
        System.out.println(id); // 本实例的id,相当于this.id
        System.out.println(this.id); // 本实例的id
        System.out.println(super.id); // 父类的id
        System.out.printf("name: %s, age: %d, school name: %s\n", getName(), getAge(), schoolName);
    }

}
