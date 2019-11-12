package com.java.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Stack、Queue遍历
 *
 */

public class StackQueueBianli {
    /**
     * 遍历Queue
     */
    @Test
    public void test1() {
        // 新建Queue，并插入元素
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; ++i) {
            q.offer(i);
        }

        // 集合遍历方式，元素不会被移除
        for (Integer e : q) {
            System.out.print(e);
        }
        System.out.println("\n-------------\n");

        // 队列遍历方式，元素逐个被移除

        while (q.peek() != null) {
            System.out.print(q.poll());
        }
        System.out.println("\n-------------\n");
    }

    /**
     * 遍历Stack
     */
    @Test
    public void test2() {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 5; ++i) {
            s.push(i);
        }

        // 集合方式遍历，元素不会被移除
        for (Integer e : s) {
            System.out.print(e);
        }
        System.out.println("\n-------------\n");

        // 栈弹出遍历方式，元素逐个被移除
//        while (s.peek() != null) {     // 不健壮的判断方式，容易抛异常，正确写法是下面的
        while (!s.empty()) {
            System.out.print(s.pop());
        }
    }

}
