/*
TreeMap

* 按照添加进Map中元素的key指定属性进行排序。所有元素key的对象必须是同一个类，key对象为自定义类对象时要求实现Comparable接口并重写int compareTo(Object obj)方法
    * 自然排序，用对象中的int compareTo(Object obj)方法进行比较排序
    * 定制排序，TreeMap中传入Comparator接口实现对象，要求重写Comparator接口中的int compare(Object o1, Object o2)


* */

package com.java.www;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    @Test
    public void test1() {
        // TreeMap自然排序
        TreeMap tmap1 = new TreeMap();
        tmap1.put(new Person("EE", 22), "河南大学");
        tmap1.put(new Person("GG", 21), "华中科技大学");
        tmap1.put(new Person("AA", 20), "东北大学");
        tmap1.put(new Person("BB", 18), "中山大学");
        tmap1.put(new Person("HH", 18), "复旦大学");

        Set kset1 = tmap1.keySet();
        for (Object k : kset1) {
            System.out.println(k + " : " + tmap1.get(k));
        }

    }

    @Test
    public void test2() {
        // TreeMap定制排序
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Car && o2 instanceof Car) {
                    Car c1 = (Car) o1;
                    Car c2 = (Car) o2;
                    int i = c1.getId() - c2.getId();
                    return i;
                }
                return 0;
            }
        };

        TreeMap tmap2 = new TreeMap(comparator);
        tmap2.put(new Car(1003, "林肯MKX 2018款 2.0T"), 37.88);
        tmap2.put(new Car(1001, "林肯MKZ 2018款 2.0T"), 27.88);
        tmap2.put(new Car(1002, "奥迪Q5L 2018款 40 TFSI 荣享进取型"), 32.92);
        tmap2.put(new Car(1000, "奥迪A8 2018款 A8L 55 TFSI quattro投放版精英型"), 66.83);

        Set kset1 = tmap2.keySet();
        for (Object k : kset1) {
            System.out.println(k + " | 价格: " + tmap2.get(kset1) + "万");
        }

    }
}
