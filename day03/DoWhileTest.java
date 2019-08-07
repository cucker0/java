/*
do-while

# 基本要素
①初始化条件
②循环条件
③迭代条件
④循环体

# 格式：
①
do {
    ④
    ③
} while (②);

# do-while与while区别：do-while至少会执行一次


运行：javac -encoding utf8 DoWhileTest.java && java DoWhileTest
* */

class DoWhileTest {
    public static void main(String[] args) {
        // 打印1-100的所有偶数，并对所有偶数示和
        int sum = 0;
        int i = 1;
        do {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
            i++;
        } while (i <= 100);
        System.out.println("和：" + sum);

        // do-while 与 while区别
        int j = 10;
        do {
            System.out.println(j);
        } while (j < 10);

        while (j < 10) {
            System.out.println(j);
        }

    }
}