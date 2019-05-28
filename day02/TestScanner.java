/*
从键盘输入
这里用到Scanner包
jdk api 在线文档 https://docs.oracle.com/javase/8/docs/api/index.html

执行：javac -encoding utf8 TestScanner.java && java TestScanner
* */

// 导入包
import java.util.Scanner;

class TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
//        int i = sc.nextInt(); // int
        String i = sc.next(); // String
        System.out.println(i);
    }
}