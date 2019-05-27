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
        System.out.println(i + "," + j + " 大的数为：" + max);

        String msg = (i > j) ? "i大" : "j大";
        System.out.println(msg);

    }
}