package com.java.queue;

import org.junit.Test;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * queue队列测试
 *
 * 要避免把null添加到队列
 *
 * LinkedList即实现了List接口，又实现了Queue接口，
 * 在使用的时候，如果我们把它当作List，就获取List的引用，
 * 如果我们把它当作Queue，就获取Queue的引用
 */


public class QueueTest {
    /**
     * poll()方法取队列首元素
     */
    @Test
    public void test1() {
        Queue<String> q = new LinkedList<>();
        // 添加元素到队列
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 从队列中取出元素
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // null,因为此时队列是空的
        System.out.println(q.poll()); // null
    }

    /**
     * 使用peek()方法取队列首元素
     */
    @Test
    public void test2() {
        Queue<String> q = new LinkedList<>();
        // 添加元素到队列
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // peek()每次取的元素都相同，因为该方法不删除元素
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
    }

    @Test
    public void test3() {
        // 这是一个List:
        List<String> list = new LinkedList<>();
        // 这是一个Queue:
        Queue<String> queue = new LinkedList<>();

    }
}