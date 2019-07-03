/*
LinkedList

## 基于Collectoin新增方法

boolean add(E e) // 在最后一个位置插入一个元素，成功则返回true,否则返回false
void add(int index, E element) // 在指定位置插入给定元素
void addFirst(E e) // 在第一个位置插入一个元素
void addLast(E e) // 在最后一个位置插入一个元素

E remove(int index) // 移除指定下标的元素，并返回该元素
E removeFirst() // 移除第一个元素，并返回该元素
E removeLast() // 移除最后一个元素，并返回该元素

E set(int index, E element) // 更新指定位置的元素，并返回该元素(未更新之前的)

E get(int index) // 获取下标元素
E getFirst() // 获取第一个元素
E getLast() // 获取最后一个元素

Object clone() // 深度克隆当前集合，但集合元素的内部并未克隆，Returns a shallow copy of this {@code LinkedList}. (The elements themselves are not cloned.)

* */

package com.java.www;

import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;

public class LinkedListTest {
    @Test
    public void test1() {
        LinkedList lis1 = new LinkedList();
        lis1.add(11);
        lis1.add(22);
        lis1.add(33);
        lis1.add("AA");
        lis1.add("BB");
        lis1.add(true);
        lis1.add(new Date());
        lis1.addLast(null);

        System.out.println(lis1);

        // E get(int index) // 获取下标元素
        System.out.println(lis1.get(3));

        // E getFirst() // 获取第一个元素
        System.out.println(lis1.getFirst());

        // E getLast() // 获取最后一个元素
        System.out.println(lis1.getLast());

        // void add(int index, E element) // 在指定位置插入给定元素
        lis1.add(2, "我要插入下标2的位子");
        System.out.println(lis1);

        // void addFirst(E e) // 在第一个位置插入一个元素
        lis1.addFirst("我要插队到第一个");

        // void addLast(E e) // 在最后一个位置插入一个元素
        lis1.addLast("我往最后插入");

        System.out.println(lis1);

        // E remove(int index) // 移除指定下标的元素
        System.out.println(lis1.remove(8));
        System.out.println(lis1);
        // E removeFirst() // 移除第一个元素
        System.out.println(lis1.removeFirst());
        System.out.println(lis1);
        // E removeLast() // 移除最后一个元素
        System.out.println(lis1.removeLast());
        System.out.println(lis1);
    }

    @Test
    public void test2() {
        LinkedList lis1 = new LinkedList();
        lis1.add(11);
        lis1.add(22);
        lis1.add(33);
        lis1.add("AA");
        lis1.add(true);
        lis1.add(new Date());
        lis1.addLast(new int[3]);

        System.out.println(lis1);
        // E set(int index, E element) // 更新指定位置的元素，并返回该元素
        System.out.println(lis1.set(4,"balabala"));
        System.out.println(lis1);

        // Object clone() // 深度克隆当前集合，但集合元素的内部并未克隆
        LinkedList lis2 = (LinkedList) lis1.clone();
        System.out.println("lis1 hashCode=" + lis1.hashCode());
        System.out.println("lis2 hashCode=" + lis2.hashCode());
        System.out.println(lis1.equals(lis2));
        System.out.println(lis1.set(0, "MM"));
        System.out.println(lis1);
        System.out.println(lis2);
        System.out.println("lis1:");
        for (int i: (int[]) lis1.getLast()) {
            System.out.println(i);
        }

        System.out.println("lis2: ");
        for (int i: (int[]) lis2.getLast()) {
            System.out.println(i);
        }

        int[] iarr = (int[]) lis1.getLast();
        iarr[0] = 999;
        for (int i: (int[]) lis1.getLast()) {
            System.out.println(i);
        }

        System.out.println("lis2: ");
        for (int i: (int[]) lis2.getLast()) {
            System.out.println(i);
        }
    }
}
