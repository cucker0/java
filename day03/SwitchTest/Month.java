/*
switch通过月份判断季节

运行：javac -encoding utf8 Month.java && java Month.java
* */

class Month {
    public static void main(String[] args) {
        int m = 5;

        switch (m) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("冬季");

        }
    }
}