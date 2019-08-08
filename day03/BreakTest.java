/*
break 退出指定层

运行：javac -encoding utf8 BreakTest.java && java BreakTest
* */

class BreakTest {
    public static void main(String[] args) {
        lable1:
        for (int i = 0; i < 4; ++i) {
            System.out.println("i layer: " + i);
            lable2:
            for (int j = 0; j < 4; ++j) {
                System.out.println("j layer: " + j);
                lable3:
                for (int k = 0; k < 4; ++k) {
                    if (k == 2) {
                        break lable2;
                    }
                    System.out.println("k layer: " + k);
                }
            }
        }

        // break whith for
        for (int i = 10, i < 0; --i) {
            System.out.println(i);
            if (i = 5) {
                break;
            }
        }

        // break whith while
        int len = 0;
        while (true) {
            System.out.println(++len);
            if (len > 10) {
                break;
            }
        }
    }


}