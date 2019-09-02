package com.java.www;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 举例: (o1, o2) -> Integer.compare(o1, o2);
 * 格式:
 *      ->: lambda操作符(或叫箭头操作符)
 *      ->左边: lambda形参列表 (其实就是接口中的抽象方法的形参列表)
 *      ->右边: lambda体 (其实就是接口抽象方法的重写后的方法体)
 *
 * Lambda表达式的本质：创建一个实现函数式接口的匿名类的实例
 *      写lambda表达式时，要清楚函数式接口的抽象方法的结构，方法名，形参列表，返回值
 *
 * 函数式接口：只包含一个抽象方法的接口，称为函数式接口
 *
 * Lambda表达式的使用：(分为6中情况)
 *      语法格式1：无参, 无返回值
 *      语法格式2：有一个参数，无返回值
 *      语法格式3：数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
 *      语法格式4：Lambda 值需要一个参数时，参数的小括号可以省略
 *      语法格式5：Lambda 需要两个或两个以上的参数，有多条执行语句，并且可以有返回值
 *      语法格式6：当Lambda体只有一条语句时，若有return与大括号，可以一起省略，且这两者要么一起省略，要么一起保留
 *
 * 总结：
 *      ->左边: Lambda 形参列表的参数类型可以省略(类型推断)
 *              如果lambda形参列表只有一个参数时，包裹形参列表的小括号()可以省略
 *      ->右边: Lambda体使用一对{ }包裹，
 *              如果lambda体只有一条语句时(包括只有一条return语句)，可以一起省略一对{ }和return关键字,
 *              这种情况下的{}与return要么一起省略，要么一起保留
 *
 * */
public class LambdaTest2 {
    /**
     * 语法格式1：无参, 无返回值
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("身是菩提树，心如明镜台;时时勤拂拭，莫使惹尘埃。");
            }
        };

        r1.run();
        System.out.println("\n// --------------------\n");

        Runnable r2 = () -> System.out.println("菩提本无树,明镜亦非台;本来无一物,何处惹尘埃。");
        r2.run();
    }

    /**
     * 语法格式2：有一个参数，无返回值
     */
    @Test
    public void test2() {
        /*
        Consumer接口 内容如下：

        public interface Consumer<T> {
            void accept(T t);

            default Consumer<T> andThen(Consumer<? super T> after) {
                Objects.requireNonNull(after);
                return (T t) -> { accept(t); after.accept(t); };
            }

        }
        * */


        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("谎言和誓言的区别？");
        System.out.println("\n// --------------------\n");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("一个是听的人信了，一个是说的人信了");

    }

    /**
     * 语法格式3：数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
     */
    @Test
    public void test3() {
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("一个是听的人信了，一个是说的人信了");
        System.out.println("\n// --------------------\n");

        // Lambda 简化写法
        Consumer<String> consumer2 = (s) -> System.out.println(s);
    }

    /**
     * 类型推断示例
     */
    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>(); // 类型推断，
        ArrayList<String> list2 = new ArrayList<String>(); // 不省略的形式

        int[] intArr = {1, 2, 5}; // 类型推断
        int[] intArr2 = new int[]{1, 2, 5}; // 不省略的形式

    }

    /**
     * 语法格式4：Lambda 值需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test5() {
        // 对比 test4()
        // Consumer<String> consumer = (String s) -> System.out.println(s);

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("千里冰封，万里雪飘。");
    }

    /**
     * 语法格式5：Lambda 需要两个或两个以上的参数，有多条执行语句，并且可以有返回值
     */
    @Test
    public void test6() {
        // jdk 8之前的写法。创建一个 匿名内部类的实例
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println("比较结果：" + comparator.compare(10, 18));
        System.out.println("\n// --------------------\n");

        // Lambda 写法
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println("比较结果：" + comparator1.compare(10, 18));

    }


    /**
     * 语法格式6：当Lambda体只有一条语句时，若有return与大括号，可以一起省略，且这两者要么一起省略，要么一起保留
     */
    @Test
    public void test7() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(33, 44));
        System.out.println("\n// --------------------\n");

        // Lambda 写法

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(33, 44));

    }


}
