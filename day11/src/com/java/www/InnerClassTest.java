/*
类的第5个成员：内部类
* 类的内部可以再定义类。外面的类：外部类，里面定义的类：内部类
* 内部类分类
    * 成员内部类（声明在类的方法外）
    * 局部内部类（声明在类的方法里）
* 成员内部类
    * 是外部类的一个成员
        - 可以用修饰符(private、protected、public, default)，外部内只能有public 或default
        - static、final
        - 可以调用外部类的属性方法
    * 具有类的特点
        - 可以指定为 abstract类
        - 可以在其内部定义属性、方法、构造器
* 局部内部类
    * 常用方法：使其返回值为局部内部类或接口的对象。这个类或接口在方法内部创建
    * 没有修饰符
    * 匿名内部类

* 内部类重点
    * 如何创建成员内部类的对象
        - 静态成员内部类创建对象
            Person p1 = new Person("钟侃扎", 24);
            Person.Bird b1 = p1.new Bird("Polly", 500);
        - 静态成员内部类创建对象
            Person.Dog d1 = new Person.Dog("皮卡丘", "yello");
    * 如何区分调用外部类、内部类的变量，尤其是重名时
        - 内部类的变量：this.xx,
        - 外部类的变量：外部类.this.xx
    * 局部内部类的使用
    * Inner class的名字不能与包含它的类名相同
    * 非static的内部类中的成员不能声明为static的，只有在外部类或static的内部类中才可声明static成员



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
    /*
    成员内部类
    * */

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

        // 同名变量的访问
        public void showInfo() {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
            System.out.println(Person.this);
            show();
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


//
class OutClass {
    /*
    局部内部类
    * */

    // 下面这种方式使用较少
    public void method1() {
        class InnerClass {

        }
    }

    // 常用方法：使其返回值为某个类或接口的对象。这个类或接口在方法内部创建
    public Comparable getComparable() {
        // 1.创建一个实现Comparable接口的类（局部内部类）
         class MyComparable implements Comparable {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        // 2.返回一个实现类的对象
        return new MyComparable();
    }

    public Comparable getComparable2() {
        // 匿名方式的接口实现类对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 1;
            }
        };
    }
}

