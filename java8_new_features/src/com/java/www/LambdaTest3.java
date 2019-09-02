package com.java.www;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java 内置的函数式接口
 *
 *      函数接口                     抽象方法                   备注
 *      消费型接口:Consumer<T>       void accept(T t)
 *      供给型接口:Supplier<T>       T get()
 *      函数型接口:Function<T, R>    R apply(T t)
 *      断定型接口:Predicate<T>      boolean test(T t)
 *      BiFunction<T, U, R>          R apply(T t, U u)          Function的子接口
 *      UnaryOperate<T>              T apply(T t)               BiFunction的子接口
 *      BinaryOperate<T, T>          T apply(T t1, T t2)
 *      BiConsumer(T, U)             void accept(T t, U u)
 *      BiPredicate<T, U>            boolean test(T t, U u)
 *      ToIntFunction<T>             int applyAsInt(T value)
 *      ToLongFunction<T>            long applyAsLong(T value);
 *      ToDoubleFunction<T>          double applyAsDouble(T value);
 *      IntFunction<R>               R apply(int value);
 *      LongFunction<R>              R apply(long value);
 *      DoubleFunction<R>            R apply(long value);
 *
 */


public class LambdaTest3 {
    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Consumer<T>
     */
    @Test
    public void test1() {
        happyTime(600, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(String.format("花了￥%s与女友吃了个烛光晚餐", aDouble));
            }
        });

        System.out.println("\n// --------------------\n");

        // lambda写法
        happyTime(1000, money -> System.out.println(String.format("花了￥%s与女友吃了个烛光晚餐", money)));

    }

    /**
     * 根据给定的规则，过滤指定集合中字符串，并返符合条件的元素组成的新的集合。具体规则有Predicate的test方法决定
     * @param list
     *          指定的集合
     * @param predicate
     *          判断规则
     * @return 返符合条件的元素组成的新的集合
     */
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    /**
     * 过滤list中含"京"的元素
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "天津", "西京", "南京", "东京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        System.out.println("\n// --------------------\n");

        // lambda写法
        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);
    }

}
