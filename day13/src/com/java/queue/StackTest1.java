package com.java.queue;

import java.util.Deque;
import java.util.LinkedList;

public class StackTest1 {
    public static void main(String[] args) {
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    /**
     * 把指定的十进制数字转换为十六进制数
     *
     * @param n: 十进制数字
     * @return: 转换为16进制后的字符串
     */
    // 方法
    static String toHex(int n) {
        Deque<Character> q = new LinkedList<>();
        int m = n;
        Character r = '0';
        while (m != 0) {
            if (m < 16) {
                r = toSingleHex(m);
                m = 0;
                if (r == null) {
                    break;
                }
                q.push(r);
                break;
            }
            r = toSingleHex(m % 16);
            m = (int) (m / 16);
            if (r == null) {
                continue;
            }
            q.push(r);
        }

        String s = "";
        while (q.peek() != null) {
            s += q.pop();
        }
        return s;
    }

    /**
     * @param n: 一个十六进制数的十进制整数
     * @return: 转成十六进制字符串
     *     转换失败，返回null
     */
    static Character toSingleHex(int n) {
        int offset = (int) 'A' - 10;
        if (n >= 0 && n <= 15) {
            if (n < 10) {
                return Integer.toString(n).charAt(0);
            } else {
                return (char) (n + offset);
            }
        }
        return null;
    }
}
