/*
算术运算

运算符：+(正) -(负) + - * / % ++ -- =(赋值) +(连接)
* */

public class TestArithmetic {
    public static void main(String args[]) {
        // 除：/
        int i10 = 12;
        int j = i10 / 5;
        double d12 = i10 / 5;
        double d13 = (double)i10 / 5;
        double d14 = i10 / 5.0;

        System.out.println("j: " + j); // 2
        System.out.println("d12: " + d12); // 2.0
        System.out.println("d13: " + d13); // 2.4
        System.out.println("d14: " + d14); // 2.4

        // 取模(取余数)：%
        // 结果符号与被模数相同
        // 模数的符号为负号时忽略
        int i22 = 13 % 5;
        int i23 = -13 % 5;
        int i24 = 13 % (-5);
        int i25 = -13 % (-5);

        System.out.println("i22: " + i22); // 3
        System.out.println("i23: " + i23); // -3
        System.out.println("i24: " + i24); // 3
        System.out.println("i25: " + i25); // -3

        // 前++：先自增1，后做运算
        // 后++：后自增1，先做运算

        int i35 = 10;
        int i36 = ++i35;
        System.out.println("i35: " + i35); // 11
        System.out.println("i36: " + i36); // 11

        int i38 = 10;
        int i39 = i38++;
        System.out.println("i38: " + i38); // 11
        System.out.println("i39: " + i39); // 10

        // 前--：先自减1，后做计算
        // 后--：后自减1，先做计算
        int i47 = 11;
        int i48 = --i47;
        System.out.println("i47: " + i47); // 10
        System.out.println("i48: " + i48); // 10

        int i52 = 11;
        int i53 = i52--;
        System.out.println("i52: " + i52); // 10
        System.out.println("i53: " + i53); // 11

        // +连接符，除加号功能外另一个功能
        System.out.println("5 + 5 = " + 5 + 5);
        System.out.println('*' + '\t' + '*'); // 93，这里字符用''引起来，为char类型数据
        System.out.println("*" + "\t" + "*"); // *       *

    }

}