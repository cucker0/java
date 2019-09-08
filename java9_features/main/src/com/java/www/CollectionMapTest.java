package com.java.www;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

}
