package com.java.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * java 9 Stream 接口新增方法
 *
 * default Stream<T> takeWhile(Predicate<? super T> predicate)
 * 从此Stream对象由前往后去元素，当出现一个不符合predicate判断条件的停止取元素操作。
 * 与  Stream<T> filter(Predicate<? super T> predicate) 是有区别的
 *
 * default Stream<T> dropWhile(Predicate<? super T> predicate)
 *  从此Stream对象由前往后舍去元素，当出现一个不符合predicate判断条件的停止舍去元素操作
 *  与takeWhile(Predicate predicate) 是互为反操作
 *
 * java 8已经有此方法
 * public static<T> Stream<T> of(T t)、 public static<T> Stream<T> of(T... values)
 * 当只添加一个元素时，则该元素不能为null,否则报NullPointerException异常，添加过个元素时，允许元素为null，且允许出现多个null
 *
 * public static<T> Stream<T> ofNullable(T t)
 * 创建一个只能包含一个元素的Steam对象，如果该元素为null，则返回一个空的Stream对象
 *
 * public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) 重载方法
 * 创建无限流方法
 * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) 在java 8已经存在
 *
 *
 */
public class StreamApiTest {
    /**
     * default Stream<T> takeWhile(Predicate<? super T> predicate)
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(21, 33, 34, 55, 79, 11, 23, 99, 10);
        Stream<Integer> stream = list.stream();
//        Stream<Integer> stream = list.parallelStream(); // 并行流同样适用
        stream.takeWhile(i -> i < 70).forEach(System.out::println);
/*
// 打印结果
21
33
34
55
*/

    }

    /**
     * default Stream<T> dropWhile(Predicate<? super T> predicate)
     *
     */
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(21, 33, 34, 55, 79, 11, 23, 99, 10);
        Stream<Integer> stream = list.stream();
        stream.dropWhile(i -> i < 70).forEach(System.out::println);
/*
// 打印结果
79
11
23
99
10
* */
    }

    /**
     * public static<T> Stream<T> ofNullable(T t)
     */
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, null);
        stream.forEach(System.out::println);
        System.out.println();

//        Stream<Object> stream1 = Stream.of(null);
        Stream<Integer> stream2 = Stream.of(11, null, 33, 6, null, 6);
        stream2.forEach(System.out::println);
        System.out.println();

        Stream<Object> objectStream = Stream.ofNullable(null);
//        System.out.println(stream1.count()); // 0
        System.out.println(objectStream.findAny()); // Optional.empty
        Stream<Integer> stream1 = Stream.ofNullable(33);
//        System.out.println(stream1.count()); // 1
        System.out.println(stream1.findFirst()); // Optional[33]
//        Stream.ofNullable(33, 44); 只能包含单个元素
    }

    /**
     * public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
     *
     */
    @Test
    public void test4() {
        // java 8已经存在的创建无限流方法。四种创建Stream对象的方法之一
        Stream<Integer> stream = Stream.iterate(0, e -> e + 1).limit(10);
        stream.forEach(System.out::println);
        System.out.println();

        // java 9 重载的iterate方法
        Stream<Integer> stream2 = Stream.iterate(0, e -> e < 10, e -> e + 2);
        stream2.forEach(System.out::println);

    }
}
