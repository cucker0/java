/*
* 变量之间的运算：（不考虑boolean。即char, byte, short, int, long, float, double）
* 1 自动类型转换
* 2 强制类型转换
* */

class TestVariable2 {
    public static void main(String[] args) {
        /*
        ## 自动类型转换，
        :>当容量小的数据类型与容量大的数据类型做运算时，容量小的会自动转换为容量大的数据类型：
        char, byte, short ==> int ==> long ==> float ==> double
        :>当char,byte,short之间做运算时，默认的结果为int类型。
        * */
        int i1 = 20;
        short s1 = 100;
        int i2 = i1 + s1;
        float f1 = 28.8F;
        float f2 = 3.14F;
        float f3 = f1 + f2;
        // float f4 = f2 + 12.9; //  报错，因为12.9 默认为double型

        float f5 = f1 + i1;
        long l1 = 999999L;
        float f6 = l1; // long型可以赋值给float型

        System.out.println("i2: " + i2);
        System.out.println("f3: " + f3);
        System.out.println("f6: " + f6);

        char c1 = 'c';
        int i3 = 3;
        int i4 = i3 + c1;
        System.out.println(i4);

        short ss1 = 88;
        byte bb1 = 127;
        char cc1 = 'q';

        // short ss2 = ss1 + bb1; // 使用int型以确保数据精确度
        int ii1 = ss1 + bb1;
        short ss3 = 99;
        // short ss4 = ss1 + ss3; // 范围可能会超过出short,使用int型以确保数据精确度
        System.out.println("ii1: " +  ii1);

        // ## 强制类型转换
        /*
        :>容量大的转换为容量小的，要使用强制类型转换符：(类型)变量
        * */

        long long2 = 123456L;
        int i52 = (int) long2;
        System.out.printf("i52: " + i52);
    }

}
