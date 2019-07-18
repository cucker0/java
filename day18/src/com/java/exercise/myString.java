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

5. 对字符串中字符进行自然顺序排序。
提示：
    1）字符串变成字符数组。
    2）对数组排序，选择，冒泡，Arrays.sort();
    3）将排序后的数组变成字符串。

6. 反转每个单词
如：we are here!!!
反转后：!!!here are we



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
    public static String reverseWord(String s) {
        /*
        反转单词
        * */

        String[] sarr = s.split(" ");

        // 处理最后的标点
        String last = sarr[sarr.length -1];

        String[] temp = last.split("!|\\.|\\?|！|。");
        if (temp.length > 0 && temp[0].length() < last.length()) {
            // 第一个标点符号位置的索引
            int index = temp[0].length();
            System.out.println("index: " + index);
            String str = last.substring(index, last.length()) + last.substring(0, index);
            sarr[sarr.length -1] = str;
        }

        // 反转
        for (int L = 0, R = sarr.length - 1; L < R; ++L, --R) {
            String tmp = sarr[L];
            sarr[L] = sarr[R];
            sarr[R] = tmp;
        }

        return String.join(" ", sarr);
    }


    public static String sort(String s) {
        /*
        字符串按自然序列排列内部的字符
        * */
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] ch =  new char[s.length()];
        s.getChars(0, s.length(), ch, 0);
        for (int i = 0; i < s.length(); ++i) {
            int tmp = i;
            for (int j = i + 1; j < s.length(); ++j) {
                if (ch[j] < ch[tmp]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                char ctmp = ch[i];
                ch[i] = ch[tmp];
                ch[tmp] = ctmp;
            }

        }

        String s1 = new String(ch);
        return s1;
    }


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
        // 或下面这种方式
//        char[] ch = s.toCharArray();

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
