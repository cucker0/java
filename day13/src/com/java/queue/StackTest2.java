package com.java.queue;

import java.util.Stack;

/**
 * 计算中缀表达式
 *
 */
public class StackTest2 {
    public static void main(String[] args) {
        String exp = "1 + 2 * (9 - 5)";
        SuffixExpression se = compile(exp);
        int result = se.execute();
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        // todo:
        // 去掉表达式中空格
        exp = exp.replaceAll(" ", "");
        String reg = "\\([-]{0,1}\\d+([+-\\\\*\\/]{1}\\d+)*\\)";
        String reg2 = "\\([-]{0,1}\\d+([+-\\\\*\\/]{1}\\d+)*\\)"; // 一个括号运算式
        Stack<Integer> sNum = new Stack<>();
        Stack<String> sOperational = new Stack<>();


        return new SuffixExpression();
    }
}

class SuffixExpression {
    int execute() {
        // todo:
        return 0;
    }

}