package com.java.www;

import org.junit.Test;

import java.util.*;

public class CollectionMapTest  {
    /**
     * 创建一个只读的集合
     *
     * Collections.unmodifiableXxx(T t)
     */
    @Test
    public void test1() {
        List<String> list = new ArrayList<>(){
            {
                add("tome");
                add("jarry");
                add("jampshon");
                add("dany");
            }
        };
        list.add("babery");
        // 创建一个只读集合
        List<String> list2 = Collections.unmodifiableList(list);
        list2.forEach(System.out::println);
//        list2.add("lisa"); // 报异常 java.lang.UnsupportedOperationException

    }

    @Test
    public void test2() {
        // 同样 创建一个只读集合。把一个可读写的集合转成只读集合
        List<Integer> list = Collections.unmodifiableList(Arrays.asList(22, 111, 33));
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(11, 22, 33)));
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>(){
            {
                put("kk", 66);
                put("qq", 77);
                put("mm", 99);
            }
        });
        list.add(99);
        set.add(44);
        map.put("jj", 100);
    }

    /**
     * java 9中创建只读集合
     * Xxx.of()
     * Map.ofEntries()
     */
    @Test
    public void test3() {
        List<Integer> list = List.of(11, 33, 55);
        list.forEach(System.out::println);
//        list.add(66); // 报java.lang.UnsupportedOperationException 异常

        Set<Integer> set = Set.of(33, 22, 55, 66);
//        set.add(66); // 不可修改

        // 创建只读Map方式1
        Map<String, Integer> map = Map.of("k1", 33, "k2", 55, "k3", 99);
        map.forEach((k, v) -> System.out.println(k + ": "+ v));
        map.put("k5", 77); // 不可修改

        // 创建只读Map方式2
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("k1", 33), Map.entry("k2", 66));
        map1.put("k3", 88); // 不可修改
    }

}
