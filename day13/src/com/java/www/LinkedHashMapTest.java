/*
LinkedHashMap

### 特点
* 使用链表维护Map中元素的put添加顺序，遍历LinkedHashMap时的顺序就是entry的添加顺序

* */

package com.java.www;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    @Test
    public void test1() {
        LinkedHashMap lmap1 = new LinkedHashMap();
        lmap1.put("AA", "AA");
        lmap1.put("苹果", 12);
        lmap1.put("香蕉", 3.5F);
        lmap1.put(138, "移动");
        lmap1.put(null, null);
        lmap1.put(new Person("高司令", 64), "java之父");

        Set entryset1 = lmap1.entrySet();
        for (Object o : entryset1) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


}
