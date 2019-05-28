/*
三元运算
格式：(条件表达式) ? 表达式1 : 表达式2
要求：表达式1与表达式2的数据类型要一样，因为最终的结果就是表达式1或表达式2
执行：javac -encoding utf8 ThreeElementOperation.java && java ThreeElementOperation
* */

class ThreeElementOperation {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int max = (i > j) ? i : j;
        System.out.println("两个数：i=" + i + "  j=" + j);
        System.out.println("大的数为：" + max);

        String msg = (i > j) ? "i大" : "j大";
        System.out.println(msg);

        String str1 = (i > j) ? "i大" : (i == j) ? "i与j相等" : "j大";
        System.out.println(str1);

        // 用三元运算符输入三个数中最大的数
        int x = 33;
        int y = 40;
        int z = 50;
        int m = (x > y) ? x : (y > z) ? y : z;
        System.out.println("x、y、z分别为："+ x + y + z + "其中最大的数为");
        System.out.println(m);


    }
}