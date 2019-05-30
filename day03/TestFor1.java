/*
for循环

格式：
①初始化条件
②循环条件
③迭代条件
④循环休

for (①; ②; ③) {
    ④;
}

运行：javac -encoding utf8 TestFor1.java && java TestFor1
* */

class TestFor1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("测试" + i);
        }

        System.out.println("\n\n");

        int j = 0;
        for (System.out.print("a "); j < 4; System.out.print("b "), j++) {
            System.out.print("c ");
        } // 结果：a c b c b c b c b


        System.out.println("\n");
        // 打印100以内自然数中所有的偶数、所有偶数的和、偶数的个数
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 100; i++ ) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
                count += 1;
            }
        }
        System.out.println("和：" + sum);
        System.out.println("个数：" + count);


    }
}