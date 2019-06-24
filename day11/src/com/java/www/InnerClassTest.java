/*
类的第5个成员：内部类
* 类的内部可以再定义类。外面的类：外部类，里面定义的类：内部类
* 内部类分类：成员内部类（声明在类的方法外），局部内部类（声明在类的方法里）
* 成员内部类
    * 是外部类的一个成员
        - 可以右修饰符(private、protected、public, default)
        - static、final
        - 可以调用外部类的属性方法
    * 具有类的特点
        - 可以指定为 abstract类
        - 可以在其内部定义属性、方法、构造器
* 局部内部类

* 内部类重点
    * 如何创建成员内部类的对象
    * 如何区分调用外部类、内部类的变量，尤其是重名时，this.xx, 外部类.this.xx
    * 局部内部类的使用



* */

package com.java.www;

public class InnerClassTest {
    public static void main(String[] args) {
        // 创建非静态内部类，必须先创建外部累的对象，通过外部类的对象调用内部类的构造器
        Person p1 = new Person("钟侃扎", 24);
        Person.Bird b1 = p1.new Bird("Polly", 500);
        System.out.println(b1);
        b1.showInfo();

        // 创建静态内部类，直接通过外部类调用静态内部类的构造器
        Person.Dog d1 = new Person.Dog("皮卡丘", "yello");
        System.out.println("");
        System.out.println(d1);

    }
}

class Person {
    private String name;
    private int age;

    // 构造器
    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public String toString() {
        return "Person{ " +
                "name=" + name +
                ", age=" + age +
                " }";
    }

    public void show() {
        System.out.println("我是person类方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 非静态成员内部类
    class Bird {
         private String name;
         private double weight;

         // 构造器
        public Bird() {
            System.out.println("我是 非静态成员内部类 构造器");
        }

        public Bird(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        // 方法

        @Override
        public String toString() {
            return "Person.Bird{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight + "g" +
                    ", master='" + Person.this.name + '\'' +
                    '}';
        }

        public void showInfo() {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }

    }

    // 静态成员内部类
    static class Dog {
        private String name;
        private String color;

        // 构造器
        Dog() {
            System.out.println("我是 静态成员内部类 构造器");
        }

        public Dog(String name, String color) {
            this.name = name;
            this.color = color;
        }

        // 方法
        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}


