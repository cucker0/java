/*
TreeSet

* 向TreeSet集合中添加的元素必须是同一种类型的数据,不包含自动转换的过来的数据
* String、int、float、long等已经重写int compareTo(Object o)方法,这些类型数据组成的TreeSet默认从小到大排序
* 向TreeSet集合添加元素时有两种排序方法:
    * 自然排序
    * 定制排序
* 自然排序(使用compareTo方法进行比较是否相同)
    * 自定义的来要 实现java.lang.Comparable接口并重写int compareTo(Object o)方法,compareTo()方法返回值为0时,表示这两个对象相同
        在此方法中,指定该类按照哪些属性排序.
    * 向TreeSet集合中添加元素时,首先调用对象的int compareTo(Object o)方法进行比较,若返回值为0,则认为这两个对象是相同的.
        这通情况下该元素就添加不进来
    * int compareTo(Object o)、int hashCode()、boolean equals()三个方法取值方向要求同时一致,
* 定制排序(使用与不能更改类的场景)
    * set1:创建一个实现了Comparator接口的对象,重写int compare(Object o1, Object o2)方法
    * set2:把set1中创建的comparator对象以形参传入TreeSet构造器
    * 使用定制排序是不需要实现自定义类的Comparable接口,如果有实现,则定制排序优先

* */

package com.java.www;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void treeSet() {
        TreeSet tset1 = new TreeSet();
        tset1.add(66.1F);
        tset1.add(22F);
        tset1.add(33.3F);
//        tset1.add("BB"); // ClassCastException异常,cannot be cast to class java.lang.Comparable

        System.out.println(tset1); // [22.0, 33.3, 66.1]

        //
        TreeSet tset2 = new TreeSet();
        tset2.add("FF");
        tset2.add("AA");
        tset2.add("GG");
        tset2.add("DD");


        System.out.println(tset2); // [AA, DD, FF, GG]
    }

    @Test
    public void treeSet2() {
        /*
        TreeSet自然排序
        * */
        TreeSet tset3 = new TreeSet();
        tset3.add(new Person("GG", 12)); // 当Person未实现Comparable接口,报:java.lang.ClassCastException: class com.java.www.Person cannot be cast to class java.lang.Comparable
        tset3.add(new Person("CC", 18));
        tset3.add(new Person("BB", 10));
        tset3.add(new Person("MM", 10));

        Iterator ite = tset3.iterator();
        for (;ite.hasNext() ;) {
            System.out.println(ite.next());
        }

    }

    @Test
    public void treeTest3() {
        /*
        TreeSet定制排序
        * */

        // set1:创建一个实现了Comparator接口的对象,重写int compare(Object o1, Object o2)方法
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Car && o2 instanceof Car) {
                    Car c1 = (Car) o1;
                    Car c2 = (Car) o2;
                    int i = c1.getId() - c2.getId();
                    if (i == 0) {
                        i =  c1.getModel().compareTo(c2.getModel());
                    }
                    return i;
                }
                return 0;
            }
        };

        // set2:把set1中创建的comparator对象以形参传入TreeSet构造器
        TreeSet tset4 = new TreeSet(comparator);
        tset4.add(new Car(103, "宝马X3"));
        tset4.add(new Car(103, "宝马X6"));
        tset4.add(new Car(101, "奥迪Q5L"));
        tset4.add(new Car(104, "瑞虎8"));

        for (Object i : tset4) {
            System.out.println(i);
        }

    }

}
