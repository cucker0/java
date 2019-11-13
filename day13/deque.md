Deque
==

# Table Of Contents
* [Deque概念](#Deque概念)
* [Deque特点](#Deque特点)
* [Queue和Deque出队和入队方法比较](#Queue和Deque出队和入队方法比较)
* [Deque示例](#Deque示例)



## Deque概念
```text
Queue队列，元素只能一头进，另一头出
元素允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），即Deque

Deque接口实际上扩展自Queue
```

## Deque特点
* 元素既可以添加到队尾，也可以添加到队首
* 元素既可以从队首获取，又可以从队尾获取
* 避免把null添加到队列

## Queue和Deque出队和入队方法比较

方法\队列类型 |Queue |Deque 
:--- |:--- |:--- 
添加元素到队尾 |add(E e)、offer(E e) |addLast(E e)、offerLast(E e) 
取队首元素并删除 |E remove()、E poll() |E removeFirst()、E pollFirst() 
取队首元素但不删除 |E element()、E peek() |E getFirst()、E peekFirst() 
添加元素到队首 |无 |addFirst(E e)、offerFirst(E e) 
取队尾元素并删除 |无 |E remove()、E pollLast() 
取队尾元素但不删除 |无 |E getLast()、E peekLast() 


## Deque示例
```java
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

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
```

