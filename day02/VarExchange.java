/*
两个int变量互换值
运行：javac -encoding utf-8 VarExchange.java && java VarExchange
* */

class VarExchange {
    public static void main(String[] args) {
        int m = 12;
        int n = 5;
        System.out.println("原值 " + "m:" + m + "   n:" + n);

        // 方法1：增加一个临时变量
//        int temp = m;
//        m = n;
//        n = temp;
//        System.out.println("方法1  " + "m:" + m + "   n:" + n);


        // 方法2：两个变量加一起
        // 当m和n较大时，有可能出现精度损失
//        m = m + n;
//        n = m - n;
//        m = m - n;
//        System.out.println("方法2  " + "m:" + m + "   n:" + n);

        // 方法3：用位的异或运算
        // 无上面两种方法的缺点
        m = m ^ n;
        n = m ^ n; // ==>  (m ^ n) ^ n == m
        m = m ^ n; // ==> (m ^ n) ^ m == n
        System.out.println("方法3  " + "m:" + m + "   n:" + n);

    }

}

