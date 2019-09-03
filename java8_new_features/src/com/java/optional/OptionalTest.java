package com.java.optional;

import com.java.ref.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional类
 * 最多只能存放一个值的容器
 *
 *      public static <T> Optional<T> of(T value)
 *          创建指定值为value的Optional类对象
 *          value不能为null，为空时报空指针异常java.lang.NullPointerException
 *
 *      public static <T> Optional<T> ofNullable(T value)
 *      创建指定值为value的Optional类对象
 *          value可以为null，此时Optional对象为空的Optional，不能使用get()取里面的值
 *
 */
public class OptionalTest {
    /**
     * public static <T> Optional<T> of(T value)
     */
    @Test
    public void test1() {
        Employee e = new Employee();
        Optional<Employee> optional = Optional.of(e);
        System.out.println(optional);
        System.out.println();

        Employee e2 = null;
        Optional<Employee> optional2 = Optional.of(e2); // 报异常：java.lang.NullPointerException
        System.out.println(optional2);
    }

    @Test
    public void test2() {
        Employee e = new Employee();
        Optional<Employee> optional = Optional.ofNullable(e);
        System.out.println(optional);
        System.out.println();

        Employee e2 = null;
        Optional<Employee> optional2 = Optional.ofNullable(e2);
        System.out.println(optional2); // Optional.empty
    }
}
