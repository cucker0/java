/*
赋值运算符:
=
扩展赋值运算符：+=, -+, *=, /+, %=

* */

class GetValue {
    public static void main(String[] args) {
        int i10 = 99;
        i10 += 1; // 100，相当于i10 = i10 + 1

        System.out.println("i10: " + i10);

        short s15 = 20;
        // s15 = s15 + 1; // 编译报错,不兼容的类型: 从int转换到short可能会有损失。主要的是原因是后面的1类型为int,而 s15是short类型的
        s15 += 1; // 既可以实现运算，以不会改变s15的数据类型。
        System.out.println("s15: " + s15);

        // 举例
        int i21 = 1;
        i21 *= 0.1; // 这种情况下i21数据类型还是int型，把小数部分舍去，所有i21是0
        System.out.println("i21: " + i21); // 0，

        /*
        Java连续赋值操作的细节
        对于一个连等型的表达式，其在不同位置相同的变量，
        会因为变量赋值顺序的不同，影响变量的值是否赋值成功
        对于同一个变量，左边变量变化对右边
        变量产生影响，而右边变量的变化对左边变量不产生影响
        * */

        int a=0,b=0;
        b+=a*=b+=(a=1)/(b=1);
        System.out.println("b: " + b); // 0

        a=0;b=0;
        b+=++a+(++a+b);
        System.out.println("b: " + b); // 3

    }

}