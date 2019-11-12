package com.java.queue;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue测试
 *
 * 放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级。
 *
 * 果我们要放入的元素并没有实现Comparable接口怎么办？
 * PriorityQueue允许我们提供一个Comparator对象来判断两个元素的顺序
 */
public class PriorityQueueTest {
    @Test
    public void test1() {
        Queue<String> q = new PriorityQueue<>();
        // 添加元素到队列
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");

        // 取首元素
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为此时队列是空的
        /*
        * 我们放入的顺序是"apple"、"pear"、"banana"，
        * 但是取出的顺序却是"apple"、"banana"、"pear"，
        * 这是因为从字符串的排序看，"apple"排在最前面，"pear"排在最后面。
        * */
    }


    @Test
    public void test2() {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        User u1 = new User("Bob", "A10");
        User u2 = new User("Alice", "A2");
        User u3 = new User("Boss", "V1");
        User u4 = new User("Cucker", "A3");
        q.offer(u1);
        q.offer(u2);
        q.offer(u3);

        System.out.println(q.poll()); // Boss/V1
        q.offer(u4); // 插入的顺序没有影响取出的顺序
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // Cucker/A3
        System.out.println(q.poll()); // Bob/A10
        System.out.println(q.poll()); // null，此时队列为空
    }
}

class User {
    public String name;
    public String number;

    // 构造器
    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // 方法
    @Override
    public String toString() {
        return name + "/" + number;
    }
}

/**
 * 银行用户排队排序比较器
 */
class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        // 两人号码开头字母相同，直接比较数字大小
        if (o1.number.charAt(0) == o2.number.charAt(0)) {
            Integer n1 = Integer.parseInt(o1.number.substring(1));
            Integer n2 = Integer.parseInt(o2.number.substring(1));
            return n1.compareTo(n2);
        }
        // o1号码以V开头,优先级高，需要排到前面去
        if (o1.number.charAt(0) == 'V') {
            return -1;
        }
        return 1;
    }
}