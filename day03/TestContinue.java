/*
continue 跳转指定层

运行：javac -encoding utf8 TestContinue.java && java TestContinue
* */

class TestContinue {
    public static void main(String[] args) {
        lable1:
        for (int i = 0; i < 4; ++i) {
            lable2:
            for (int j = 0; j < 4; ++j) {
                lable3:
                for (int k = 0; k < 4; ++k) {
                    if (k == 2) {
                        continue lable1;
                    }
                    System.out.println("k layer: " + k);
                }
                System.out.println("j layer: " + j);
            }
            System.out.println("i layer: " + i);
        }
    }
}