package com.java.www;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 钻石操作符的升级(<>)
 *
 * 主要用于泛型
 *
 *
 */
public class DiamondOperator {
    @Test
    public void test1() {
        // 创建一个继续于HashSet的匿名内部类
        Set<String> set = new HashSet<>(){};
        set.add("AA");
        set.add("BB");
        set.add("CC");
        set.add("DD");

        for (String s : set) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>(){ // 创建一个继续于HashSet的匿名内部类
            { // 这对{}为静态代码块
                add("GG");
                add("JJ");
                add("MM");
                add("DD");
            }
        };

        set.forEach(System.out::println);
    }

}
