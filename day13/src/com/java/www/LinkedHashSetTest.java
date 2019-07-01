/*
LinkedHashSet
* LinkedHashSet使用了链表维护元素添加进集合的顺序.顺序遍历集合元素时按照添加顺序的
* LinkedHashSet插入性能略低于HashSet,但在迭代集合的全部元素时有很好的性能.
* addAll(Set obj) 在当前集合最后添加obj集合中的元素,添加顺序按照obj集合的顺序


* */

package com.java.www;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    @Test
    public void test1() {
        LinkedHashSet lset1 = new LinkedHashSet();
        lset1.add(2.3F);
        lset1.add(33);
        lset1.add("AA");
        lset1.add("AA");
        Ball b1 = new Ball("Basketball");
        Ball b2 = new Ball("Basketball");
        lset1.add(b1);
        lset1.add(b2);



        System.out.println("size: " + lset1.size());
        System.out.println(lset1);

        HashSet lset2 = new HashSet();
        lset2.add(44);
        lset2.add(2);

        lset1.addAll(lset2);
        System.out.println(lset1);
    }
}

class Ball {
    private String name;

    // 构造器
    public Ball() {
        super();
    }

    public Ball(String name) {
        this.name = name;
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        return name != null ? name.equals(ball.name) : ball.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}