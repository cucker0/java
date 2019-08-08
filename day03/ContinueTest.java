/*
continue 跳过指定层的本次循环

运行：javac -encoding utf8 ContinueTest.java && java ContinueTest
* */

class ContinueTest {
    public static void main(String[] args) {
        // 跳过指定层的本次循环
        lable1:
        for (int i = 0; i < 4; ++i) {
            System.out.println("i layer: " + i);
            lable2:
            for (int j = 0; j < 4; ++j) {
                System.out.println("j layer: " + j);
                lable3:
                for (int k = 0; k < 4; ++k) {
                    if (k == 2) {
                        continue lable1;
                    }
                    System.out.println("k layer: " + k);
                }
            }
        }

        // continue with for
        System.out.println();
        for (int h = 0; h < 10; ++h) {
            System.out.println("h: " + h);
            if (h = 5) {
                continue;
            }
        }

        // continue whith while
        int x = 10
        while (true) {
            --x;
            System.out.println(x);
            if (x = 7) {
                continue;
            }
            if (x <= 0) {
                break;
            }
        }


    }
}