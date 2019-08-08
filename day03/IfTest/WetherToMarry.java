/*
题目：
大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出一定的条件：高：180cm以上；富：财富1千万以上；帅：是。
如果这三个条件同时满足，则：“我一定要嫁给他!!!”
如果三个条件有为真的情况，则：“嫁吧，比上不足，比下有余。”
如果三个条件都不满足，则：“不嫁！”

运行：javac -encoding utf8 WetherToMarry.java && java WetherToMarry
* */

import java.util.Scanner;

class WetherToMarry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("身高(cm)：");
        int high = sc.nextInt();
        System.out.println("财富(万)：");
        float wealth = sc.nextFloat();
        System.out.println("帅否(是/否)：");
        String is_handsome = sc.next();

        boolean h = high >= 180;
        boolean w = (wealth >= 1000);
        boolean y = is_handsome.equals("是");
        if (h && w && y) {
            System.out.println("我一定要嫁给他!!!");
        } else if (h || w || y) {
            System.out.println("嫁吧，比上不足，比下有余。");
        } else {
            System.out.println("不嫁");
        }
    }
}