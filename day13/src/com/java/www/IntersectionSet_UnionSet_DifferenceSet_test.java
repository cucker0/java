/*
* 取Set的交集、并集、差集
*
* */

package com.java.www;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSet_UnionSet_DifferenceSet_test {
    private Set<String> result = new HashSet<>();
    private Set<String> set1 = new HashSet<>() {
        {
            add("地下城与勇士");
            add("英雄联盟");
            add("穿越火线");
            add("王者荣耀");
        }
    };
    private Set<String> set2 = new HashSet<>() {
        {
            add("魔兽世界");
            add("地下城与勇士");
            add("慌野逃生");
        }
    };


    @Test
    public void test0() {
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println();
    }

    /**
     * 求两Set交集
     */
    @Test
    public void IntersectionSet() {
        result.clear();

        result.addAll(set1);
        result.retainAll(set2); // 这会覆盖原来的result Set

        test0();
        // set1 ∩ set2, set1交set2
        System.out.println("set1 ∩ set2, set1交set2的 交集：" + result);

/*
// 打印效果
set1: [王者荣耀, 英雄联盟, 地下城与勇士, 穿越火线]
set2: [慌野逃生, 魔兽世界, 地下城与勇士]

set1 ∩ set2, set1交set2的 交集：[地下城与勇士]
* */
    }

    /**
     * 求两Set并集
     * @throws Exception
     */
    @Test
    public void UnionSet() throws Exception{
        result.clear(); // 清除result里的所有元素

        result.addAll(set1);
        result.addAll(set2);

        test0();
        // set1 ∪ set2, set1并set2
        System.out.println("vset1 ∪ set2, set1并set2的 并集：" + result);

/*
// 打印效果
set1: [王者荣耀, 英雄联盟, 地下城与勇士, 穿越火线]
set2: [慌野逃生, 魔兽世界, 地下城与勇士]

vset1 ∪ set2, set1并set2的 并集：[王者荣耀, 慌野逃生, 英雄联盟, 魔兽世界, 地下城与勇士, 穿越火线]
* */
    }

    /**
     * 求两Set差集
     */
    @Test
    public void DifferenceSet() {
        result.clear();

        result.addAll(set1);
        result.removeAll(set2);

        test0();
        System.out.println("set1 - set2，set1减set2 差集：" + result);

        result.clear();

        result.addAll(set2);
        result.removeAll(set1);
        System.out.println("set2 - set1，set2减set1 差集：" + result);

/*
// 打印效果
set1: [王者荣耀, 英雄联盟, 地下城与勇士, 穿越火线]
set2: [慌野逃生, 魔兽世界, 地下城与勇士]

set1 - set2，set1减set2 差集：[王者荣耀, 英雄联盟, 穿越火线]
set2 - set1，set2减set1 差集：[慌野逃生, 魔兽世界]

* */
    }
}
