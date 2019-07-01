/*
 Set接口

 Collection接口
    |-- List接口
        |-- ArrayList
        |-- LinkedList
        |-- Vector
    |-- Set接口,常用方法都是Collection接口里定义的
        |-- HashSet (主要实现类)
        |-- LinkedHashSet
        |-- TreeSet


## Set特点
* 存储的元素是无序,不可重复的.
* 无序性:不是随机性,是指元素在底层存储的位置是无序,按照一定的方法来确定顺序的.
* 不可重复性:不能像Set中添加相同的元素,也添加不进去

### Set要求(包括HashSet、LinkedHashSet、TreeSet)
* 添加到Set中的元素所在类,一定要重写equals()、hashCode()方法
* 当响Set添加元素时,首先调用此对象所在类的hashCode()方法,计算此对象的哈希值,此哈希值决定了此对象在Set中的存储位置.
若此位置还没有存储对象,则此对象直接存储到这个位置.
若这个位置有存储了对象,那么在通脱调用该对象的equals()方法比较这两个对象是否相同,如果equals()返回false则添加后面这个元素到Set中,否则不添加
* hashCode()方法与equals()方法返回值方向要求一致.即返回表示相同或是不相同


* */


package com.java.www;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

    @Test
    public void test1() {
        Set hset1 = new HashSet();
        hset1.add(11);
        hset1.add(22);
        hset1.add(33);
        hset1.add(new String("AA"));
        hset1.add("BB");
        hset1.add("BB");
        hset1.add(null);
        Dog d1 = new Dog("Lizaza", 2);
        Dog d2 = new Dog("Binli", 1);
        Dog d3 = new Dog("Binli", 1); //  在未重写Dog类的hashCode()方法时,可以添加进去
        hset1.add(d1);
        hset1.add(d2);
        hset1.add(d3);

        System.out.println(hset1.size());
        System.out.println(hset1);

        Iterator ite = hset1.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

        HashSet hset2 = new HashSet();
        hset2.add(66);
        hset2.add(77);
        hset1.addAll(hset2);
        System.out.println(hset1);

        System.out.println(hset1.equals(hset2));
    }

}

class Dog {
    private String name;
    private int age;
    static private int init = 100;

    // 构造器
    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // 方法
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

    public String toString() {
        return "Dog{ " +
                "name='" + name + '\'' +
                ", age=" + age +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (age != dog.age) return false;
        return name != null ? name.equals(dog.name) : dog.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

//        return ++init;

//        return 3;

    }

}
