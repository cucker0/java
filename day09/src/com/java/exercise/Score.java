/*
题目：

利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
提示：
    数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩。
    创建Vector对象：Vector v=new Vector();
    给向量添加元素：v.addElement(obj);   //obj必须是对象
    取出向量中的元素：Object  obj=v.elementAt(0);
    注意第一个元素的下标是0，返回值是Object类型的。
    计算向量的长度：v.size();
    若与最高分相差
        10分内：A等；
        20分内：B等；
        30分内：C等；
        其它：D等

* */

package com.java.exercise;

import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.Vector;

public class Score {
    private Vector v; // set集合
    private int max;

    // 构造器
    public Score() {
        super();
        v = new Vector();
    }


    // 方法
    public void addAScore(Object i){
        /*
        add a socre
        * */
        v.addElement(i);
    }

    public void inputScore() {
        /*
        input score
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("从键盘读入学生成绩（以负数代表输入结束）:");
        while (true) {
            int score = sc.nextInt();
            if (score < 0) {
                break;
            }
            if (max < score) {
                max = score;
            }
//            Integer score1 = new Integer(score); // 装箱
//            addAScore(score1);
            addAScore(score); // 自动装箱，因为这里是要传一个Object 类型的对象
        }
/*
        for (; ; ) {
            int score = sc.nextInt();
            if (score < 0) {
                break;
            }
            addAScore(score);
        }
        */
    }

    public Vector getV() {
        return v;
    }

    public Integer getAScore(int index) {
        if (v.size() == 0) {
            return null;
        }
        if (index <= v.size() || index >= 0) {
            return (Integer) v.elementAt(index);
        }
        return null;
    }

    public void showScore() {
        for (int i = 0; i < v.size(); ++i) {
            char level = 'D';
//            Integer ss = (Integer) v.elementAt(i);
//            int score = ss.intValue(); //
            int score = (Integer) v.elementAt(i); // 自动拆箱
            if (max - score <= 10) {
                level = 'A';
            } else if (max - score <= 20) {
                level = 'B';
            } else if (max - score <= 30) {
                level = 'C';
            }
            System.out.printf("score: %d, level: %s\n", score, level);
        }
    }
}

