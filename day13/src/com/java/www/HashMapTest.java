/*
HashMap


Map常用方法
### 添加、删除操作方法
Object put(Object key, Object value)  添加一个元素到HashMap中
Object remove(Object key) 删除指定key的元素
void putAll(Map t) 把Map t中所有元素添加到当前Map中
void clear() 清除当前map中所有元素

### 元素查询操作方法
Object get(Object key) 获取指定key的元素，若key不存在则返回null
boolean containsKey(Object key) 当前map所有的key中是否包含指定key，是返回true,否则false
boolean containsValue(Object value) 当前map所有的value中是否包含指定的value，是返回true,否则false
int size() 返回map长度
boolean isEmpty() 当前map是否为空，是返回true,否则false
boolean equals(Object obj) 当前map与指定的obj map是否相等，即所有entry相等

### 元视图操作方法
Set keySet() 获取当前map所有的key，值为Set
Collection values() 获取当前map所有的value，值为Collection
Set entrySet() 获取当前map所有的entry，值为Set

### Map特点
* Map的key、value都可以为null
* key使用Set存储，不可重复，value使用Collection存储，可以重复
* put()添加元素到map时，如果前面已经存在一个相同的key，那么新的key对应的value将覆盖旧的value



* */

package com.java.www;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    @Test
    public void test1() {
        // Object put(Object key, Object value)  添加一个元素到HashMap中
        HashMap hmap1 = new HashMap();
        hmap1.put("k1", 11);
        hmap1.put("k2", 22);
        hmap1.put("k2", 33); // 将覆盖上面的"k2"对应的值
        hmap1.put(33, 33);
        hmap1.put(null, null);
        hmap1.put(true, 3.14F);
        hmap1.put(new Person("张剑", 23), "山东人");


        System.out.println(hmap1.size());
        System.out.println(hmap1);

        // Object remove(Object key) 删除指定key的元素
        hmap1.remove(true);
        System.out.println(hmap1);

        // void putAll(Map t) 把Map中所有元素添加到当前Map中
        HashMap hmap2 = new HashMap();
        hmap2.put("cn", "中国");
        hmap2.put(86, "China");
        hmap1.putAll(hmap2);

        System.out.println(hmap1);

        // void clear() 清除当前map中所有元素
        hmap1.clear();
        System.out.println(hmap1);

    }

    @Test
    public void test2() {
        // Object get(Object key) 获取指定key的元素，若key不存在则返回null
        // boolean containsKey(Object key) 当前map所有的key中是否包含指定key，是返回true,否则false
        // boolean containsValue(Object value) 当前map所有的value中是否包含指定的value，是返回true,否则false
        // int size() 返回map长度
        // boolean isEmpty() 当前map是否为空，是返回true,否则false
        // boolean equals(Object obj) 当前map与指定的obj map是否相等，即所有entry相等

    }

    @Test
    public void test3() {
        // Set keySet() 获取当前map所有的key，值为Set
        // Collection values() 获取当前map所有的value，值为Collection
        // Set entrySet() 获取当前map所有的entry，值为Set

    }

}
