/*
题目：
    一个数如果恰好等于它的因子之和，这个数就称为"完数"。（因子：除去这个数本身正的约数）
例如6=1＋2＋3.编程 找出1000以内的所有完数

运行：javac -encoding utf8 PerfectNumber.java && java PerfectNumber
* */

class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("完数：");
        String s = "";
        for (int i = 1, sum = 0; i <= 1000; ++i, sum = 0, s = "") {
            for (int j = 1; j < i; ++j) {
                if (i % j == 0) {
                    sum += j;
                    if (s == "") {
                        s += j;
                    } else {
                        s += " + " + j;
                    }
                }
            }
            if (sum == i) {
                System.out.println(i);
                System.out.println(s);
                System.out.println();
            }
        }

    }
}