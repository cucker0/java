Queue列队
==


## Queue概念
```text
队列(Queue)是一种经常使用的集合。
Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。
它和List的区别在于，List可以在任意位置添加和删除元素，
而Queue只有两个操作：
* 把元素添加到队列末尾
* 从队列头部取出元素
```

* 生活例子：超市的收银台就是一个队列
    ![](images/超市排队买单.jpg)  


## Queue特点
* 元素只能一头进，一头出
* 元素先进入的先取出，是顺序的
```

## Queue方法
```text
对于具体的实现类，有的Queue有最大队列长度限制，有的Queue没有。
注意到添加、删除和获取队列元素总是有两个方法，
这是因为在添加或获取元素失败时，这两个方法的行为是不同的。
```
* 在Java的标准库中，队列接口Queue定义了以下几个方法
    ```text
    int size()：获取队列长度；
    
    boolean add(E)/boolean offer(E)：添加元素到队尾；
    
    E remove()/E poll()：获取队首元素并从队列中删除；
    
    E element()/E peek()：获取队首元素但不从队列中删除。
    ```

* Queue方法比较

    操作类型\操作失败处理方式 |throw Exception |返回false或null 
    :--- |:--- |:--- 
    添加元素到队尾 |add(E e) |boolean offer(E e) 
    取队首元素并删除 |E remove() |E poll()  
    取队首元素但不删除 |E element() |E peek()  

    ```text
    两套方法可以根据需要来选择使用。
    注意：不要把null添加到队列中，否则poll()方法返回null时，很难确定是取到了null元素还是队列为空。
    ```

## Queue示例
* poll()方法取队列首元素、使用peek()方法取队列首元素对比
    ```java
    import org.junit.Test;
    
    import java.util.List;
    import java.util.Queue;
    import java.util.LinkedList;
  
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
    }
    ```
    [测试源码](src/com/java/queue/QueueTest.java)  
    ```text
    LinkedList即实现了List接口，又实现了Queue接口，
    在使用的时候，如果我们把它当作List，就获取List的引用，
    如果我们把它当作Queue，就获取Queue的引用
    ```

* 示例1
    ```text
    假设我们有一个队列，对它做一个添加操作，如果调用add()方法，
    当添加失败时（可能超过了队列的容量），它会抛出异常
    ```
    ```java
    Queue<String> q = ...
    try {
        q.add("Apple");
        System.out.println("添加成功");
    } catch(IllegalStateException e) {
        System.out.println("添加失败");
    }
    ```

* 示例2:如果我们调用offer()方法来添加元素，当添加失败时，它不会抛异常，而是返回false
    ```java
    Queue<String> q = ...
    if (q.offer("Apple")) {
        System.out.println("添加成功");
    } else {
        System.out.println("添加失败");
    }
    ```
    
* 示例3：当我们需要从Queue中取出队首元素时，如果当前Queue是一个空队列，调用remove()方法，它会抛出异常
    ```java
    Queue<String> q = ...
    try {
        String s = q.remove();
        System.out.println("获取成功");
    } catch(IllegalStateException e) {
        System.out.println("获取失败");
    }
    ```
* 如果我们调用poll()方法来取出队首元素，当获取失败时，它不会抛异常，而是返回null
    ```java
    Queue<String> q = ...
    String s = q.poll();
    if (s != null) {
        System.out.println("获取成功");
    } else {
        System.out.println("获取失败");
    }
    ```