package com.java.optional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optaional类 新增方法
 *
 * public Stream<T> stream()
 * 把Optional对象转成一个Stream流
 *
 */
public class OptionalTest {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>(){
            {
                add(11);
                add(33);
                add(22);
            }
        };
        Optional<List<Integer>> optional = Optional.ofNullable(list);
        Stream<List<Integer>> stream = optional.stream();
        stream.forEach(System.out::println);
    }

}
