/*
输入两个正整数m和n，求其最大公约数和最小公倍数

运行：javac -encoding utf8 MaxDivisorAndMaxMultiple.java && java MaxDivisorAndMaxMultiple
* */

import java.util.Scanner;

class MaxDivisorAndMaxMultiple {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数：");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int max, min, max_divisor = 0, min_multiple = 0;
        max = num1 > num2 ? num1 : num2;
        min = num1 ^ num2 ^ max; // 通过位异或交换值

        // 最大公约数
        for (int i = min; i >= 1; --i) { // 对min从大到小遍历
            if (min % i == 0 && max % i == 0) {
                max_divisor = i;
                break;
            }
        }

        // 最小公倍数
        for (int i = 1; i <= min; ++i) {
            if ((max * i) % min == 0) {
                min_multiple = max * i;
                break;
            }
        }

        System.out.println("最大公约数：" + max_divisor);
        System.out.println("最小公倍数：" + min_multiple);
    }
}