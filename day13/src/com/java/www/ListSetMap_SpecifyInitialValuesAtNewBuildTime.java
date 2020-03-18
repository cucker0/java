/*
* List、Set、Map在创建对象时指定初始值
* 格式: new List/Set/Map实现类() {{}};
 * 外面的这个 {} 为匿名类，里面的{}为静态代码块。
 * 这种方式只有jdk >= 9 才支持
 * 
* 注意： 慎用， 非静态内部类/ 匿名内部类包含了外围实例的引用， 如果拥有比外部类更长的生命周期，有内存泄露隐患。
* 另外这种方式生成的对象没有被序列化，正常方式是已经序列化的
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
        List<String> list = new ArrayList<>() { // 创建一个继承于ArrayList 匿名子类对象
            // 静态代码块，在加载类的时候就执行
            {
                add("我的楼兰--云朵"); // this.add("我的楼兰--云朵");
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
        Map<String, Boolean> map1 = new TreeMap<>() {{
            put("北京", true);
            put("天津", false);
            put("深圳", true);
        }};

        System.out.println(map1);
    }

}
