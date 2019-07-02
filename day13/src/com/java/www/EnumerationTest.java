/*
Enumeration
是Iterator迭代器的古老版本

* */

package com.java.www;

import org.junit.Test;

import java.util.Enumeration;
import java.util.StringTokenizer;

public class EnumerationTest {
    @Test
    public void test1() {
        Enumeration enumeration = new StringTokenizer("69576acf-b466-4d9d-a7ee-1b817acf5540","-");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }

}
