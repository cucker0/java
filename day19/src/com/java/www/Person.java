package com.java.www;

import java.io.Serializable;
import java.util.Comparator;

@MyAnnotation(value = "setp 1")
public class Person extends Biology<String> implements MyInterface, Comparator {
    public String name;
    private int age;

    // 构造器
    public Person() {
        super();
        System.out.println("Person空参构造器...");
    }

    private Person(String name) {
        super();
        setName(name);
    }

    @MyAnnotation
    protected Person(String name, int age) {
        super();
        setName(name);
        setAge(age);
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) throws RuntimeException{
        if (name.isEmpty()) {
            throw new RuntimeException("name can't be empty!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new RuntimeException("age must >= 0 and < 150");
        }
        this.age = age;
    }

    private String see(int time, String how) {
        return name + " " + how + " 在看，花费时间：" + time + "s";
    }

    @MyAnnotation(value = "method")
    public void speak(String content) {
        System.out.println(name + "说：" + content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void walk() {
        System.out.println(name + ": walking ...");
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == o2) {
            return 0;
        }

        if (o1 instanceof Person && o2 instanceof Person) {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;
            if (p1.name != p2.name) {
               return p1.name.compareTo(p2.name);
            }
            if (p1.age != p2.age){
                return p1.age - p2.age;
            }
        }

        return 0;
    }

    public static void info() {
        System.out.println("是黄种人");
    }

    // 内部类
    class Wallet extends Pack implements Serializable {
        double balance;
    }


}

class Pack {
    private String material = "牛皮";

    public Pack() {
    }

    public Pack(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}