/*
如题：
从键盘输入小明的期末成绩。
当成绩为100分时，奖励一辆BMW；
当成绩为（80，99]时，奖励一个台iphone xs；
当成绩为[60,80]时，奖励一本参考书；
其它时，什么奖励也没有。

运行：javac -encoding utf8 Score.java && java Score
* */

import java.util.Scanner;

class Score {
    public static void main(String[] args){
        System.out.println("请输入你的成绩(分)：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        if (score == 100) {
            System.out.println("奖励一辆BMW");
        } else if (score > 80 && score <= 99) {
            System.out.println("奖励一个台iphone xs");
        } else if (score >= 60 && score <= 80 ) {
            System.out.println("奖励一本参考书");
        } else {
            System.out.println("什么奖励也没有");
        }
    }
}