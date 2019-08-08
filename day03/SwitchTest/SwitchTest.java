/*
switch-case分支语句

运行：javac -encoding utf8 SwitchTest.java &&java  SwitchTest
* */

class SwitchTest {
    public static void main(String[] args) {
        int i = 0;
        switch (i) {

            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}