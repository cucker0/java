/*
题目：
输出所有的水仙花数，所谓水仙花数是指一个3
   位数，其各个位上数字立方和等于其本身。
    例如： 153 = 1*1*1 + 3*3*3 + 5*5*5

运行：javac -encoding utf8 Daffodils.java && java Daffodils
* */

class Daffodils {
    public static void main(String[] args) {
        System.out.println("水仙花数：");
        for (int i = 100; i < 1000; i++) {
            int h = i / 100; // 百位
            int t = (i - h * 100) / 10; // 十位
            int b = i % 10; // 个位

            if (i == (h * h * h + t * t * t + b * b * b)) {
                System.out.println(i);
            }
        }
    }
}