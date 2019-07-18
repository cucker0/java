package com.java.exercise;

import org.junit.Test;

import java.util.List;

public class test {
    String s = "    sasa轻轻松松  okok  ";


    @Test
    public void test1() {
        String s8 = "   qiuqiu3344  轻轻松松 ssll   ";
//        String s8 = "   a   ";
        String s9 = myString.trim(s8);
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

    @Test
    public void test5() {
        String s = "abcwerthelloyuiodefellob先进技术";
        System.out.println(myString.sort(s));

    }

    @Test
    public void test6() {
        String s = "we are here。。。";
        System.out.println(myString.reverseWord(s));
    }

    @Test
    public void test7() {
        char[] ch = new char[]{'b', 'u', 'f', 'f', 'e', 'r'};
        String s1 = new String(ch);
        System.out.println(s1);

        String[] sarr = new String[]{"qq", "tengxun", "shenzhen"};
        String s2 = String.join("", sarr);
        System.out.println(s2);
    }
}
