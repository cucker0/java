package com.java.www;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java 10 集合新增创建不可变集合的方法
 * static Xxx<E> copyOf(Collection<E> coll)
 * 根据集合创建只读集合对象
 * 如果coll为只读集合，则直接返回coll
 * 如果coll可读写集合，则根据coll元素调用of(T t)方法创建一个新的只读集合，不改变原来的coll
 */
public class CollectionsMapTest {
    @Test
    public void test1() {
        List<String> list = List.of("aa", "bb", "cc");
        var list2 = List.copyOf(list);
        System.out.println(list == list2); // true
        System.out.println();

        var map = Map.of("k1", 11, "k2", 22);
        var map2 = Map.copyOf(map);
        System.out.println(map == map2); // true
    }

    @Test
    public void test2() {
        var list = new ArrayList<String >();
        list.add("一阳指");
        var list2 = List.copyOf(list);
        System.out.println(list == list2); // false
        System.out.println();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("k1", 55);
        var map2 = Map.copyOf(map);
        System.out.println(map == map2); // true
    }
}
