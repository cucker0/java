/*
题目:
1. 定义一个Employee类，
该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
并为每一个属性定义 getter, setter 方法；
并重写 toString 方法输出 name, age, birthday

MyDate类包含:
private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；

创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
分别按以下两种方式对集合中的元素进行排序，并遍历输出：

1). 使Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。

提示：Employee类是否需要重写equals()方法？MyDate类呢？

* */

package com.java.exercise;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeTest {
    @Test
    public void test1() {
        TreeSet tset1 = new TreeSet();
        tset1.add(new Employee("Lucy", 19, new MyDate(2000, 1, 3)));
        tset1.add(new Employee("Harry", 18, new MyDate(2001, 12, 3)));
        tset1.add(new Employee("Eric", 23, new MyDate(1996, 6, 1)));
        tset1.add(new Employee("Epson", 15, new MyDate(2004, 10, 1)));
        tset1.add(new Employee("Leida", 11, new MyDate(2008, 1, 3)));


        for (Object o : tset1) {
            System.out.println(o);
        }

    }

    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee2 && o2 instanceof Employee2) {
                    Employee2 e1 = (Employee2) o1;
                    Employee2 e2 = (Employee2) o2;
                    int i = e1.getBirthday().getYear() - e2.getBirthday().getYear();
                    if (i == 0) {
                        i = e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
                        if (i == 0) {
                            i = e1.getBirthday().getDay() - e2.getBirthday().getDay();
                            if (i == 0) {
                                i = e1.getName().compareTo(e2.getName());
                            }
                        }
                    }
                    return i;
                }
                return 0;
            }
        };

        TreeSet tset2 = new TreeSet(comparator);
        tset2.add(new Employee2("Lucy", 19, new MyDate(2000, 1, 3)));
        tset2.add(new Employee2("Harry", 18, new MyDate(2001, 12, 3)));
        tset2.add(new Employee2("Eric", 23, new MyDate(1996, 6, 1)));
        tset2.add(new Employee2("Epson", 15, new MyDate(2004, 10, 1)));
        tset2.add(new Employee2("Leida", 11, new MyDate(2008, 1, 3)));
        tset2.add(new Employee2("Linda", 11, new MyDate(2008, 1, 3)));


        for (Object o : tset2) {
            System.out.println(o);
        }

    }

}
