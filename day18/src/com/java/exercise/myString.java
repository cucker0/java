/*
题目：

1. 模拟一个trim方法，去除字符串两端的空格
2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为“abfedcg”
3. 获取一个字符串在另一个字符串中出现的次数。
    比如：获取“ ab”在 “abkkcadkabkebfkabkskab”
    中出现的次数
4. 获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
   提示：将短的那个串进行长度依次递减的子串与较长
   的串比较。

* */

package com.java.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class myString {
    // 构造器
    public myString() {
        super();
    }

    // 方法
    public static List<String> maxSubstring (String s1, String s2) {
        /*
        返回两个字符串最大的相同子串
        * */
        String maxString = s1.length() > s2.length() ? s1 : s2;
        String minString = s1.length() <= s2.length() ? s1 : s2;

        List<String> list = new ArrayList();
        for (int count = minString.length(); count >= 1; --count) { // 假设最大相同长度由minString长度递减，逐个去匹配
            for (int start = 0, end = count - 1 ;end < minString.length() ; ++start, ++end) {
                String subString = minString.substring(start, end);
                if (maxString.contains(subString)) {
                    list.add(subString);
                }
            }
            if (list.size() != 0) {
                return list;
            }
        }

        return list;
    }

    public static int repeatCount(String s1, String s2) {
        /*
        返回字符串s2在字符串s1中出现的次数
        * */
        int i = 0;
        if (s1.length() == 0 || s2.length() == 0 || s1.length() < s2.length()) {
            return 0;
        }


        for (int L = 0; L < s1.length() - s2.length() + 1; ++L) {
            if (s1.startsWith(s2, L)) {
                ++i;
            }
        }

        return i;
    }

    public static String reverse(String s) {
        /*
        反转字符串
        * */
        String str = "";
        for (int i = s.length() -1; i >= 0; --i) {
            str += s.charAt(i);
        }

        return str;
    }


    public static String trim(String s) {
        /*
        去除字符串首尾字符串
        trim方法1
        * */

        char[] ch = new char[s.length()];
        s.getChars(0, s.length(), ch, 0);

        int L = 0; // 首部非空的开始索引
        int R = s.length() - 1; // 尾部非空的结束索引
        if (s.length() == 0) {
            return s;
        }

        // 查找L
        for (; L < s.length(); ++L) {
            if (ch[L] != ' ') {
                break;
            }
        }

        // 查找R
        for (; R >= L; --R) {
            if (ch[R] != ' ') {
                break;
            }
        }
        return new String(ch, L, R - L + 1);
    }

    public static String trim2(String s) {
        /*
        去除字符串首尾字符串
        trim方法2
        * */
        int L = 0; // 首部非空的开始索引
        int R = s.length() - 1; // 尾部非空的结束索引

        if (s.length() == 0) {
            return s;
        }

        for (;L < s.length(); ++L) {
            if (s.charAt(L) != ' ') {
                break;
            }
        }

        for (; R >= L; --R) {
            if (s.charAt(R) != ' ') {
                break;
            }
        }

        return s.substring(L, R + 1);
    }

}
