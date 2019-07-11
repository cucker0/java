/*
对象流
ObjectInputStream, ObjectOutputStream

要求
* 类要可序列化
* 类的属性可序列化
* 提供一个版本号，private static final long serialVersionUID = 354126654L;
* static, transient修饰的性能不能被序列化，取到的值为 null

writeObject(p1); // 写入的对象p1所属类要序列化，属性也要可序列化，未实现序列化报 NotSerializableException 异常
类实现序列化，实现 Serializable类即，该类没有方法。



对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制数据流，存储到硬盘中文件中
对象的反序列化过程：将硬盘中文件通过ObjectInputStream转换为相应的对象

String, Integer等常用类已经实现序列化


* */

package com.java.www;

import org.junit.Test;

import java.io.*;

public class ObjectInputStreamAndObjectOutputSteamTest {
    @Test
    public void test1() {
        // 将对象写入文件

        Person p1 = new Person("大侠", 23, new Pet("dog"));
        Person p2 = new Person("牛旺", 22, new Pet("bird"));

        ObjectOutputStream oos = null;
        try {
            File file = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\object.txt");
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(p1); // 写入的对象p1所属类要序列化，未实现序列化报 NotSerializableException 异常
            oos.flush();
            oos.writeObject(p2);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() {
        // 将对象从文件中读取
        ObjectInputStream ois = null;
        try {
            // 1. 创建File对象
            File file = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1\\object.txt");
            // 2. 创建FileInputStream对象
            FileInputStream fis = new FileInputStream(file);
            // 3. 创建ObjectInputStream对象
            ois = new ObjectInputStream(fis);
            Object p1 = ois.readObject();
            Object p2 = ois.readObject();
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

}

class Person implements Serializable {
    private static final long serialVersionUID = 354126654L;
    private String name;
    private int age;
    private Pet pet; // Pet 也需要可序列化
    private static String nation = "China";

    // 构造器
    public Person() {
        super();
    }

    public Person(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    // 方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
                ", pet=" + pet +
                ", nation=" + Person.nation +
                '}';
    }
}

class Pet implements Serializable {
    private String name;

    // 构造器
    public Pet() {}
    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
