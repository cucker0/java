/*

switch编写程序：从键盘上读入一个学生成绩，存放在变量score中，根据score的值输出其对应的成绩等级：

score>=90        等级：A
70=<score<90     等级: B
60=<score<70     等级: C
score<60         等级：D

运行：javac -encoding utf8 Score2.java && java Score2
* */

import java.util.Scanner;

class Score2 {
    public static void main(String[] args) {
        System.out.println("Input score：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Score input erro!!");
        } else {
            score /= 10;
            char level;
            switch (score) {
                case 10:
                case 9:
                    level = 'A';
                    break;
                case 8:
                case 7:
                    level = 'B';
                    break;
                case 6:
                    level = 'C';
                    break;
                default:
                    level = 'D';
            }
            System.out.println(level);
        }
    }
}