/*
位运算
<<
>>
>>>
&
|
^
~
运行：

* */

class BitOperation {
    public static void main(String[] args) {
        // 为什么要定义一个字符型数据的参数，这是用于在执行这个方法时接收参数
        int i1 = 31;

        System.out.println(i1 + " << 2: " + (i1 << 2)); // 124
        System.out.println(i1 + " << 28: " + (i1 << 28)); // -268435456

        System.out.println(i1 + " >> 2: " + (i1 >> 2)); // 7
        System.out.println(i1 + " >>> 2: " + (i1 >>> 2)); // 7

        int i2 = -31;
        System.out.println(i2 + " >> 2: " + (i2 >> 2)); // -8
        System.out.println(i2 + " >>> 2: " + (i2 >>> 2)); // 1073741816

        int m = 12;
        int n = 5;
        System.out.println(m + " & " + n + ": " + (m & n)); // 4
        System.out.println(m + " | " + n + ": " + (m | n)); // 13
        System.out.println(m + " ^ " + n + ": " + (m ^ n)); // 9
        System.out.println("~" + m + ": " + (~m)); // -13

    }

}