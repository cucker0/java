/*
while

①初始化条件
②循环条件
③迭代条件
④循环体

# 格式 ：
①
while (②) {
    ④
    ③
}

# for循环与while循环可以互相转换

运行：javac -encoding utf8 TestWhile.java && java TestWhile
* */

class TestWhile {
    public static void main(String[] args) {

        // 打印1-100的所有偶数，并对所有偶数示和
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
            i++;
        }
        System.out.println("和：" + sum);
    }
}

