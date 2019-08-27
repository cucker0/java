/*
* List、Set、Map在创建对象时指定初始值
*
* */

package com.java.www;

import org.junit.Test;

import java.util.*;

public class ListSetMap_SpecifyInitialValuesAtNewBuildTime {
    /**
     * List在创建对象时指定初始值
     */
    @Test
    public void test1() {
        List<String> list = new ArrayList<>() {
            {
                add("我的楼兰--云朵");
                add("你还是从前的你吗--天籁天");
                add("我是你的格桑花--欣宝儿");
            }
        };

        System.out.println(list);
    }

    /**
     * Set在创建对象时指定初始值
     */
    @Test
    public void test2() {
        Set<Integer> set1 = new LinkedHashSet<>() {{
            add(3);
            add(1);
            add(4);
        }};
        System.out.println(set1);
    }

    /**
     * Map在创建对象时指定初始值
     */
    @Test
    public void test3() {
        Map<String, Boolean> map1 = new TreeMap<>() {
            {
                put("北京", true);
                put("天津", false);
                put("深圳", true);
            }
        };

        System.out.println(map1);
    }

}
