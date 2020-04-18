package com.java.www;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;


public class LinkedHashMapReverse {

    /**
     * 反转LinkedHashMap对象的元素排序
     *
     * @param map LinkedHashMap对象
     * @param reverseSelf 返回原map对象还是新map对象
     *                    true: 反转原LinkedHashMap对象并返回
     *                    false: 返回新map对象
     * @param <K> map的key泛型
     * @param <V> map的value泛型
     * @return 与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     */
    public static <K, V> LinkedHashMap<K, V> reverse(LinkedHashMap<K,V> map, boolean reverseSelf) {
        LinkedHashMap<K, V> reverseMap = new LinkedHashMap<>();
        ListIterator<Map.Entry<K, V>> iterator = new ArrayList<>(map.entrySet())
                .listIterator(map.entrySet().size());
        while (iterator.hasPrevious()) {
            Map.Entry<K, V> entry = iterator.previous();
            reverseMap.put(entry.getKey(), entry.getValue());
        }
        if (reverseSelf) {
            map.clear();
            map.putAll(reverseMap);
            return map;
        }
        return reverseMap;
    }

    /**
     * 返回一个与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     * 返回的LinkedHashMap对象是一个新对象，不是原LinkedHashMap对象
     *
     * @param map LinkedHashMap对象
     * @param <K> map的key泛型
     * @param <V> map的value泛型
     * @return 与指定LinkedHashMap元素顺序相反的LinkedHashMap对象
     */
    public static <K, V> LinkedHashMap<K, V> reverse(LinkedHashMap<K,V> map) {
        return reverse(map, false);
    }

    public static void main(String[] args) {
        // 测试
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("k1", 10);
        map.put("k2", 20);
        map.put("k3", 30);
        map.put("k4", 40);
        map.put("k5", 50);
        LinkedHashMap<String, Integer> reverse = reverse(map);
        System.out.println("reverse: " + reverse);
        System.out.println("原map: " + map);
        System.out.println("=================");
        LinkedHashMap<String, Integer> reverse1 = reverse(map, true);
        System.out.println("reverse1: " + reverse1);
        System.out.println("原map: " + map);
    }
}
