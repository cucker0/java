/*
逻辑运算符
& 逻辑与
| 逻辑或
! 逻辑非
^ 逻辑异或
&& 短路与
||

运行：javac -encoding utf-8 LogicTest.java &&  java LogicTest
* */

class LogicTest {
    public static void main(String[] agrs) {
        boolean a = true;
        boolean b = false;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a & b => " + (a & b));
        System.out.println("a | b => " + (a | b));
        System.out.println("!a => " + (!a));
        System.out.println("a ^ b => " + (a ^ b));
        System.out.println("a && b => " + (a && b));
        System.out.println("a || b => " + (a || b));
        System.out.println("############\n\n");

        // & 与 &&区别：
        /*
        &：无论左边为true还是false,右边都会进行运算
        &&：当左边为false时，右边不再进行运算，还可规避右边的错误
        只有当左边为false时，&与&&才有区别，其他情况两都一样
        建议使用 &&
        * */
        boolean c = false;
        int i27 = 10;
        if (c & (i27++) > 0) {
            System.out.println("结果为true");
        } else {
            System.out.println("结果为false");
        }
        System.out.println("i27: " + i27); // 11

        int i35 = 10;
        if (c && (i35++) > 0) {
            System.out.println("结果为true");
        } else {
            System.out.println("结果为false");
        }
        System.out.println("i35: " + i35); // 10

        /*
        if (c & 10 / 0 == 0) { // javac能正常编译，java运行时报错：Exception in thread "main" java.lang.ArithmeticException: / by zero
            System.out.println("情况1：。。。");
        } else {
            System.out.println("情况2：。。。");
        }
        */

        if (c && 10 / 0 == 0) { // 正常
            System.out.println("情况1：。。。");
        } else {
            System.out.println("情况2：。。。");
        }

        System.out.println("###\n\n");

        // |与||区别
        /*
        |：无论左边为true或false，右边都会进行运行
        ||：左边为true时，右边不再进行运算，是|的智能版
        推荐使用||

        * */
        c = true;
        int i67 = 10;
        if (c | (i67++) > 0) {
            System.out.println("情况1：。。。");
        } else {
            System.out.println("情况2：。。。");
        }
        System.out.println("i67: " + i67); // 11

        i67 = 10;
        if (c || (i67++) > 0) {
            System.out.println("情况1：。。。");
        } else {
            System.out.println("情况2：。。。");
        }
        System.out.println("i67: " + i67); // 10

        int x = 1;
        int y = 1;
        if (x++ == 2) { // 这里后加，先计算，这时候1 != 2
            System.out.println("case 1: "+ x);
        } else {
            System.out.println("case 2:" + x);
        }
    }
}