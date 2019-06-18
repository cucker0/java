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

        // 基本数据类型 -> 包装类，调用包装类的构造器
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

    @Test
    public void test2() {
        // 包装类 -> 基本数据类型，调用包装类对象.xxxValue()方法
        Integer i44 = new Integer(208);
        int i45 = i44.intValue();
        System.out.println(i45);
        Float f48 = new Float(2.3);
        float f49 = f48.floatValue();
        System.out.println(f49);
        System.out.println(f48.intValue()); // 2
        Boolean b52 = new Boolean(true);
        boolean b53 = b52.booleanValue();
        System.out.println(b53);

    }

    @Test
    public void test3() {
        // JDK 1.5后，自动装箱、拆箱
        int i61 = 18;
        Integer i62 = i61; // 自动装箱
        System.out.println(i62.toString());
        Boolean b63 = false;

        Integer i66 = new Integer(15);
        int i67 = i66; // 自动拆箱
        System.out.println(i66);

    }

    @Test
    public void test4() {
        //  基本数据、包装类 -> StringString类：调用String.valueOf(Xxx x)方法
        int i75 = 22;
        String s76 = i75 + ""; // "22"
        Float f77 = 24.0F; // 自动装箱
        String s78 = String.valueOf(f77);
        System.out.println(s78);
        String s80 = String.valueOf(true); // "true"
        System.out.println(s80);

    }

    @Test
    public void test5() {
        // String类 -> 基本数据类型、包装类：调用包装类的parseXxx(String str)方法
        int i88 = Integer.parseInt("33");
        System.out.println(i88);
        boolean b90 = Boolean.parseBoolean("1"); // 非"true"都解析为false
        System.out.println(b90);
        boolean b92 = Boolean.parseBoolean("true");
        System.out.println(b92);
    }

}

class Order {
    Boolean status;

}