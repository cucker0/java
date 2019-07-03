/*
题目：
请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来

Scanner 在循环中异常的处理

* */

package com.java.exercise;

import java.util.*;

public class InputIntegerTest {
    private static List box = new ArrayList();
    private int count = 10;

    // 构造器
    public InputIntegerTest() {
        super();
    }

    public InputIntegerTest(int count) {
        setCount(count);
    }

    // 方法
    public static void main(String[] args) {
        InputIntegerTest t1 = new InputIntegerTest();
        t1.input();
//        t1.input2();
        t1.showBox();
    }

    public void setCount(int count) throws RuntimeException {
        if (count > 0) {
            this.count = count;
        } else {
            throw new RuntimeException("count必须大于0");
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("请随机输入%d个整数：\n", count);
        for (int i = 1; i <= count; ++i) {
            System.out.printf("输入第%d个数：\n", i);
            try {
                int r = sc.nextInt();
                box.add(r);
            } catch (InputMismatchException e) {
                 --i;
                 sc.next(); // Finds and returns the next complete token from this scanner.会清除Scanner内存缓存，不做这步处理会死循环
            }
        }
    }

    public void input2() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("请随机输入%d个整数：\n", count);
        for (int i = 1; i <= 10; ++i) {
            System.out.printf("输入第%d个数：\n", i);
            String line = sc.nextLine();
            try {
                int r = Integer.parseInt(line);
                box.add(r);
            } catch (NumberFormatException e) {
                --i;
            }
        }
    }

    public static void showBox() {
        Collections.sort(box);
        Collections.reverse(box);
        System.out.println("输出结果：");
        for (Object obj : box) {
            System.out.print(obj  + " ");
        }
    }

}

