/*
十进制转十六进制并在控制台输出(十六进制格式)


* */


class DecToHexOutput {
    public static void main(String[] args) {
        int i = 60; // 3c
        System.out.println("i = " + i + "转成十六进制数并打印");
        // 方法1：调用Integer类现成的方法
        String binary = Integer.toBinaryString(i);
        String hex = Integer.toHexString(i);
        System.out.println(binary);
        System.out.println(hex);

        // 手动实现

/*
        char c = 'a';
        char c1 = (char)(c + 2);
        System.out.println(c1); // c
*/

        int x = i & 15; // 为什么是与15做与运算，因为4位二进制数每位数都为1的数转10进制值为15。这一步的主要目的是取出i的最后4位数2进制值
        String v1 = (x <= 9) ? x + "": (char)( x - 10 + 'a') + ""; // 判断是否小于=9

        i = i >> 4; // 把i右移的位，相当于，把上面这步的后面4位截掉了
        int y = i & 15;
        String v2 = (y <= 9) ? y + "" : (char)(y - 10 + 'a') + "";

        System.out.println(v2 + v1);

    }
}
