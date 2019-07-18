package com.java.exercise;

import org.junit.Test;

import java.util.List;

public class test {
    String s = "    sasa轻轻松松  okok  ";


    @Test
    public void test1() {
        String s8 = "   qiuqiu3344  轻轻松松 ssll   ";
//        String s8 = "   a   ";
        String s9 = myString.trim2(s8);
        System.out.println("#" + s9 + "#");
        System.out.println("#" + s8 + "#");

    }

    @Test
    public void test2() {
        String str = myString.reverse(s);
        System.out.println(str);

    }

    @Test
    public void test3() {
        String s1 = "abab";
        String s2 = "ab";
        System.out.println(myString.repeatCount(s1, s2));
    }

    @Test
    public void test4() {
        String str1 = "abcwerthelloyuiodefellob";
        String str2 = "cvhellobnm";

        List<String> list = myString.maxSubstring(str2, str1);
        System.out.println(list);
    }

}
