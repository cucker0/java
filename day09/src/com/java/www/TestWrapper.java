/*

* 包装类：8种基本数据类型分别对应着一个类，此类为 包装类
* 基本数据类型、包装类、String三者之间的相互转换

* */

package com.java.www;

import org.junit.Test;

public class TestWrapper {
    @Test
    public void test1() {
        int i = 10;
        System.out.println(i);
//        System.out.println(i.toString()); // 基本数据类型没有toString()方法
        boolean b18 = false;

        // 基本数据类型 -> 对应的包装类，调用包装类的构造器
        Integer i21 = new Integer(i);
        System.out.println(i21.toString());

        Float f = new Float("12.6F");
        System.out.println(f);

//        int i27 = new Integer("11ab"); // 编译报java.lang.NumberFormatException: For input string: "11ab"
//        System.out.println(i27);

        Boolean b1 = new Boolean("true"); // true
        System.out.println(b1);
        Boolean b2 = new Boolean(false);
        System.out.println(b2);
        Boolean b3 = new Boolean("true100"); // false，只要写的不是true，则都是false,能正常编译和运行
        System.out.println(b3);

        Order o1 = new Order();
        System.out.println(o1.status); // null，因为这是一个类了


    }
}

class Order {
    Boolean status;

}