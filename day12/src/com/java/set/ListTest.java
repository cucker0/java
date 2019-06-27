/*
List接口

* 在集合Collection类的基础上添加下面的方法：
Object get(int index) // 获取指定下标元素
void add(int index, Object ele) // 指定下标插入一个元素
boolean addAll(int index, Collection eles) // 把一个集合所有元素插入指定下标处
Object remove(int index) // 移除指定下标的元素
Object set(int index, Object ele) // 重置指定下标元素值(更新)
int indexOf(Object obj) // 给定对象首次出现的下标位置，没有则返回 -1
int lastIndexOf(Object obj) // 给定对象最后一次出现的下标位置，没有则返回 -1
List subList(int fromIndex, int toIndex) // List切片处理，截取[开始下标，结束下标)为新的List，注意是左闭右开，相当于取一个子集

* List常用方法
    - 增 add(Object obj)
    - 删 remove(int index)
    - 改 set(int index, Object obj)
    - 查 get(int index)
    - 插 add(int index, Object obj)
    - 长度 size()

* */

package com.java.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    @Test
    public void test1() {
        List lis = new ArrayList();
        lis.add(11);
        lis.add(22);
        lis.add(33);
        lis.add(44);
        System.out.println(lis);

        // Object get(int index)
        System.out.println(lis.get(2));

        // void add(int index, Object ele)
        lis.add(1, 22.22);
        System.out.println(lis);

        // boolean addAll(int index, Collection eles)，插入成功返回true,否则返回false
        List lis2 = new ArrayList();
        lis2.add(88);
        lis2.add(99);
        lis.addAll(1, lis2);
        System.out.println(lis);

        // Object remove(int index)
        lis.remove(0);
        System.out.println(lis);

        // Object set(int index, Object ele)
        lis.set(0, 777);
        System.out.println(lis);

        // int indexOf(Object obj)
        System.out.println(lis.indexOf(44));

        // int lastIndexOf(Object obj)
        lis.add(22); // 在最后一个下标后添加一个元素
        System.out.println(lis.lastIndexOf(22));

        // List subList(int fromIndex, int toIndex)
        System.out.println(lis.subList(1, 3));

    }

}
