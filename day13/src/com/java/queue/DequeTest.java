package com.java.queue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque双端队列测试
 *
 */

public class DequeTest {
    @Test
    public void test1() {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A");
        deque.offerLast("B");
        deque.offerFirst("C");
        deque.offerFirst("D");
        // 当前队列顺序：D C A B
        System.out.println(deque.pollFirst()); // D
        System.out.println(deque.pollLast()); // B
        System.out.println(deque.pollFirst()); // C
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }

}
