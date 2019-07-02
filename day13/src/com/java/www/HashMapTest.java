/*
HashMap

Collection接口
Map接口
    |-- HashMap: Map接口的主要实现类，存储顺序由key的hash值决定
    |-- LinkedHashMap: 使用链表维护entry添加进map顺序，遍历map时按此顺序
    |-- TreeMap: 按照添加进Map中元素的key指定属性进行排序。所有元素key的对象必须是同一个类，key对象为自定义类对象时要求实现Comparable接口并重写int compareTo(Object obj)方法
    |-- Hashtable
        |-- Properties:


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
int size() 返回map元素个数
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


### HashMap特点
* entry顺序存储顺序与key的hash值有关，与put添加的顺序无关


* */

package com.java.www;

import org.junit.Test;

import java.util.*;

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
        HashMap hmap1 = new HashMap();
        hmap1.put("k1", 11);
        hmap1.put("k2", 22);
        hmap1.put(33, 33);
        hmap1.put(null, null);
        hmap1.put(true, 3.14F);
        hmap1.put(new Person("张剑", 23), "山东人");

        // Object get(Object key) 获取指定key的元素，若key不存在则返回null
        Object obj = hmap1.get("k2");
        System.out.println(obj);
        System.out.println(hmap1.get("kaka"));

        // boolean containsKey(Object key) 当前map所有的key中是否包含指定key，是返回true,否则false
        boolean ckey = hmap1.containsKey("k1");
        System.out.println(ckey);
        System.out.println(hmap1.containsKey("kaka"));

        // boolean containsValue(Object value) 当前map所有的value中是否包含指定的value，是返回true,否则false
        boolean cvalue = hmap1.containsValue(33);
        System.out.println(cvalue);

        // int size() 返回map元素个数
        System.out.println(hmap1.size());

        // boolean isEmpty() 当前map是否为空，是返回true,否则false
        boolean ise = hmap1.isEmpty();
        System.out.println(ise);

        // boolean equals(Object obj) 当前map与指定的obj map是否相等，即所有entry相等
        HashMap hmap2 = new HashMap();
        hmap2.put("k1", 11);
        hmap2.put("k2", 22);
        hmap2.put(33, 33);
        hmap2.put(null, null);
        hmap2.put(true, 3.14F);
        hmap2.put(new Person("张剑", 23), "山东人");

        boolean eq = hmap2.equals(hmap1);
        System.out.println(eq); // true
    }

    @Test
    public void test3() {
        HashMap hmap1 = new HashMap();
        hmap1.put("k1", 11);
        hmap1.put("k2", 22);
        hmap1.put(33, 33);
        hmap1.put(null, null);
        hmap1.put(true, 3.14F);
        hmap1.put(new Person("张剑", 23), "山东人");

        // Set keySet() 获取当前map所有的key，值为Set
        Set kset1 = hmap1.keySet();
        System.out.println(kset1);

        // Collection values() 获取当前map所有的value，值为Collection，顺序与keySet()对应
        Collection vs = hmap1.values();
        System.out.println(vs);

        // Set entrySet() 获取当前map所有的entry，值为Set
        Set entrys = hmap1.entrySet();
        System.out.println(entrys);

        // 遍历key
        Set kset2 = hmap1.keySet();
        for (Object k : kset2) {
            System.out.println(k);
        }
        System.out.println();

        // 遍历values
        Collection vs2 = hmap1.values();
        Iterator ite = vs2.iterator();
        while (ite.hasNext()) { // 也可以用增强for循环（foreach）
            System.out.println(ite.next());
        }
        System.out.println();

        // 遍历 key-value，即遍历entrys

        // 方式一:通过key遍历entrys
        Set kset3 = hmap1.keySet();
        for (Object key: kset3) {
            System.out.println(key + ": " + hmap1.get(key));
        }
        System.out.println();

        // 方式二：通过 entrySet()遍历
        Set entryset2 = hmap1.entrySet();
        for (Object o : entryset2) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

/*        Iterator it = entryset2.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next(); // entry 直接打印为 key=value
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        */
    }

}
