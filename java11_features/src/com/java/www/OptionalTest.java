package com.java.www;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类新增方法
 *
 * public boolean isEmpty()
 * 判断此Optional对象的value是否为null
 *
 */
public class OptionalTest {
    @Test
    public void test1() {
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.isEmpty()); // true
    }

}
