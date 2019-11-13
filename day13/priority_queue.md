PriorityQueue
==

## PriorityQueue概念
```text
我们知道，Queue是一个先进先出（FIFO）的队列。

在银行柜台办业务时，我们假设只有一个柜台在办理业务，但是办理业务的人很多，怎么办？

可以每个人先取一个号，例如：A1、A2、A3……然后，按照号码顺序依次办理，实际上这就是一个Queue。

如果这时来了一个VIP客户，他的号码是V1，虽然当前排队的是A10、A11、A12……但是柜台下一个呼叫的客户号码却是V1。

这个时候，我们发现，要实现“VIP插队”的业务，用Queue就不行了，因为Queue会严格按FIFO的原则取出队首元素。

我们需要的是优先队列：PriorityQueue

```

## PriorityQueue特点
```text
* PriorityQueue和Queue的区别在于，它的出队顺序只与元素的优先级有关，与插入顺序无关

* 对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素

* 放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级

* 放入PriorityQueue的元素所性类未实现Comparable，则需要通过Comparator自定义排序算法
```

## PriorityQueue示例
* 示例1
    ```java
    import org.junit.Test;
    
    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Queue;
    
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
    }
    ```

* 示例2:模拟银行办理业务排队
    ```java
    import org.junit.Test;
    
    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Queue;
  
    public class PriorityQueueTest {
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
    ```
    ```text
    实现PriorityQueue的关键在于提供的UserComparator对象，它负责比较两个元素的大小（较小的在前）。
    UserComparator总是把V开头的号码优先返回，只有在开头相同的时候，才比较号码大小。
    ```

* 小结
    ```text
    PriorityQueue实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。
    
    PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），
    也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）
    ```