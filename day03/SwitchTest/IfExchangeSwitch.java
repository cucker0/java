/*
特定情况下，if-else与switch-case互换

运行：javac -encoding utf8 IfExchangeSwitch.java && java IfExchangeSwitch
* */

class IfExchangeSwitch {
    public static void main(String[] args) {
        int a = 3;
        int x = 100;
        System.out.println("a, x初始值：" + a + ", " + x);
        if (a == 1) {
            x +=5;
        } else if (a == 2) {
            x += 10;
        } else if (a == 3) {
            x += 16;
        } else {
            x += 34;
        }

        System.out.println("a, x" + a + ", " + x);

        a = 3;
        x = 100;
        switch (a) {
            case 1:
                x += 5;
                break;
            case 2:
                x += 10;
                break;
            case 3:
                x += 16;
                break;
            default:
                x += 34;
        }
        System.out.println("a, x" + a + ", " + x);
    }
}