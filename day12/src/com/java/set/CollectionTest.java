/*
Collection

+ 存储对象可以考虑：数组、集合
+ 数组存储对象特点
    - 一旦创建，其长度不可变
    - 真实的数组存放的对象个数不可知

+ 集合
    - Collection接口
        |--List接口，存储有序的、可以重复的元素
            |--ArrayList（元素内存中存储是连续的）、LinkedList（链式列表，应用场景：频繁插入/删除）、Vector(比较古老、线程安全，比较慢)
        |--Set接口，存储无序、不可重复的元素
            |--HashSet、LinkedHashSet、TreeSet
    - Map接口，存储"键-值"对数据
        |--HashMap、LinkedHashMap、TreeMap、Hashtable(子类：Properties)

* */

package com.java.set;


import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test1() {
        Collection c1 = new ArrayList();

        // size() 返回集合中元素的个数
        System.out.println(c1.size());

        // add(Object obj) 向集合中添加一个元素
        c1.add(123);
        c1.add("AA");
        c1.add(new Date());
        c1.add("BB");
        System.out.println(c1.size());

        // addAll(Collection coll) 将一个集合所有元素添加到当前集合中
        Collection c2 = Arrays.asList(1, 2, 3);
        c1.addAll(c2);
        System.out.println(c1.size());

        // 查看所有元素
        System.out.println(c1);
        System.out.println(c2);

        // isEmpty() 判断集合是否为空，是返回true，否则false
        System.out.println(c1.isEmpty());

        // clear() 清空合集所有元素
        c1.clear();
        System.out.println(c1);
        System.out.println(c1.isEmpty());

    }

    @Test
    public void test2() {
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add("AA");
        c1.add(new Date());
        c1.add(new String("BB"));
        c1.add(new Person("锅巴佬", 23));
        Person p59 = new Person("老司机", 44);
        c1.add(p59);
        c1.add(new Dog("赛驹", "佳源"));

        // contains(Object obj) 判断集合中是否包含指定的元素obj，如果包含返回true，否则false。
        // 判断方法：用到了类中的equals(Object o)方法。若使用了自定义类要重写equals()方法
        boolean b60 = c1.contains(123);
        System.out.println(b60);
        System.out.println(c1.contains("AA"));
        System.out.println(c1.contains(p59)); // true
        System.out.println(c1.contains(new Person("老司机", 44))); // false
        System.out.println(c1.contains(new Dog("赛驹", "佳源"))); // true，Dog 已重写了equal(Object o) 方法
        System.out.println(c1.contains("BB"));

        // containsAll(Collection coll) 判断当前集合是否包含coll集合中所有的元素。即判断一个集合是否为当前集合的子集
//        Collection c2 = Arrays.asList(123, "AA");
        Collection c2 = new ArrayList();
        c2.add(123);
        c2.add("AA");
        System.out.println(c1.containsAll(c2)); // true

        // retainAll(Collectoin coll) 保留一个集合coll与当前集合的交集给当前集合，会覆盖当前集合
        Collection c3 = Arrays.asList("AA", 123, "other"); // 这种方式的集合元素不能被删除
        c1.retainAll(c3);
        System.out.println(c1);

        // remove(Object obj) 删除集合中的obj元素。若删除成功返回true,否则返回false
        System.out.println(c2.remove(123)); // true
        System.out.println(c2); // 打印：[AA]

    }

    @Test
    public void test3() {
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add("AA");
        c1.add(new Date());
        c1.add("BB");
        System.out.println(c1);

        Collection c2 = new ArrayList();
        c2.add(123);
        c2.add("AA");
        c2.add(3.14);

        // removeAll(Collection coll) 从当前集合中删除与另外一个集合coll的交集所有元素。即 当前集合 - coll集体的差集。
        c1.removeAll(c2);
        System.out.println(c2);
        System.out.println(c1);

        // equals(Object obj) 判断一个集合obj与当前集合两者所有的元素是否都相等。
        Collection c111 = new ArrayList();
        Collection c112 = new ArrayList();
        c111.add(108);
        c111.add("aux");

        c112.add(108);
        c112.add("aux");

        System.out.println(c111.equals(c112));

        // hashCode() 获取当前集合的hash值
        System.out.println(c111.hashCode());
        System.out.println(c112.hashCode());

        // toArray() 将集合转化成数组
        Collection c126 = new ArrayList();
        c126.add(new Person("王大仙", 12));
        c126.add(33);
        c126.add("haha");
        System.out.println(c126);

        Object[] obj = c126.toArray();
        for (int i = 0; i < obj.length; ++i) {
            System.out.println(obj[i]);
        }

        // iterator() 返回一个Iterator接口实现类对象，可用于遍历集合
        System.out.println();

        // 方式1，
        System.out.println("集合遍历方式1");
        Iterator iter = c126.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());

        // 方式2
        System.out.println("集合遍历方式2");
        Iterator iter2 = c126.iterator();
        for (int i = 0; i < c126.size(); ++i) {
            System.out.println(iter2.next());
        }

        // 方式3
        System.out.println("集合遍历方式3");
        Iterator ite3 = c126.iterator();
/*
        while (ite3.hasNext()) {
            System.out.println(ite3.next());
        }
        */

        for (; ite3.hasNext(); ) {
            System.out.println(ite3.next());
        }
    }

}

class Person {
    private String name;
    private int age;

    // 构造器
    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Dog {
    private String name;
    private String master;

    // 构造器
    public Dog() {
    }

    public Dog(String name, String master) {
        this.name = name;
        this.master = master;
    }

    // 方法
    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", master='" + master + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (name != null ? !name.equals(dog.name) : dog.name != null) return false;
        return master != null ? master.equals(dog.master) : dog.master == null;

    }

}