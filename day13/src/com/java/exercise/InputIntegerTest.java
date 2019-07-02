/*
题目：
请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来

* */

package com.java.exercise;

import java.util.*;

public class InputIntegerTest {
    private static List box = new ArrayList();

    public static void main(String[] args) {
        input();
        showBox();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请随机输入10个整数：");
        for (int i = 1; i <= 10; ++i) {
            System.out.printf("输入第%d个数：\n", i);
            try {
                int r = sc.nextInt();
                box.add(r);
            } catch (InputMismatchException e) {
                 --i;
                continue;
            }
        }
    }

    public static void showBox() {
        Collections.sort(box);
        Collections.reverse(box);

        for (Object obj : box) {
            System.out.println("输出结果：");
            System.out.print(obj  + " ");
        }
    }

}

