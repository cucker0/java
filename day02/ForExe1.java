/*
题目：
编写程序FooBizBaz.java，从1循环到150并在每行打印一个值，另外在每个3的倍数行上打印出“foo”,在每个5的倍数行上打印“biz”,
在每个7的倍数行上打印输出“baz”。

运行：javac -encoding utf8 ForExe1.java && java ForExe1
* */

class ForExe1 {
    public static void main(String[] args) {

        for (int i = 1; i <= 150; i++) {
            if (i % 3 == 0) {
                System.out.println(i + "foo");
            } else if (i % 5 == 0) {
                System.out.println(i + "biz");
            } else if (i % 7 == 0) {
                System.out.println(i + "baz");
            } else {
                System.out.println(i);
            }
        }
    }
}