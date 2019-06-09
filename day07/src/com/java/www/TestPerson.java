package com.java.www;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("何必达", 25);
        Person p2 = new Person("汪三牛", 23);
        p1.showInfo();
        p2.showInfo();
    }
}

class Person {
    private String name;
    private int age;

    // 构造器
    public Person() { // 构造器1

    }

    public Person(String name) { // 构造器2
        this.name = name;
        System.out.println("这是构造器2");
    }

    public Person(String name, int age) {
        this(name);  // this指构成重载的构造器，这里会根据传参的情况匹配到 构造器2
        this.age = age; // this.age:表示当在正在创建的对象
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // this.name: 表示对象的属性
        // name: 是形参
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInfo() {
        System.out.println("姓名: " + this.name + ", 年龄: " +  age);
    }

}
