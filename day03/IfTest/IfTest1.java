/*
if-else分支语句

执行：javac -encoding utf8 IfTest1.java && java IfTest1
* */

class IfTest1 {
    public static void main(String[] args) {
        int age = 20;
        System.out.println("你的年龄：" + age + "岁");
        if (age > 18) {
            System.out.println("你已经成年");
        } else {
            System.out.println("小屁孩一个... 该干吗干吗去");
        }

        if (age > 120 || age < 0) {
            System.out.println("成仙了");
        } else if (age < 30) {
            System.out.println("还没到儿立之年");
        } else {
            System.out.println("已过不惑之年");
        }


    }
}