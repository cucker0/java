/*
九九乘法表

运行：javac -encoding utf8 MultiplicationTable99.java && java MultiplicationTable99
* */

class MultiplicationTable99 {
    public static void main(String[] args) {
        /*
1 * 1 = 1
1 * 2 = 2   2 * 2 = 4
1 * 3 = 3   2 * 3 = 6   3 * 3 = 9
...

        * */

        for (int i = 1; i <= 9; ++i) { // 9行
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " * " + i + " = " + (j * i) + '\t');
            }
            System.out.println();

        }

    }
}