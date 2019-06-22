/*
类的第四个成员：初始化块（代码块）
* 代码块修饰符只能是空或static
## 分类
* 静态代码块 static { }
    * { }内可以有输出语句
    * 随着类的加载而加载，且只能被加载一次，内存中同样只有一份
    * 一个类中可以有多个静态代码块，多个代码块之间按照顺序结构执行
    * 静态代码块要早于构造器执行
    * 静态代码块中只能执行静态的结构（静态的属性、静态的方法）
    * 静态的要早于非静态执行

* 非静态代码块 { }
    * 可以对类的属性(静态的、非静态的)进行初始化操作，同时也可以田勇本类中的方法(静态、非静态的)
    * 里面可以右输出语句
    * 一个类可以右多个非静态的代码块，多个代码块之间按照顺序结构执行
    * 每创建一个类的对象，非静态代码块就加载一次
    * 非静态代码块的执行要早于构造器

* 关于属性赋值操作顺序
    1.默认的初始化 2.显示初始化、代码块初始化（这两个机构之间按照顺序执行） 3.构造器中赋值 4.通过方法对对象的属性进行修改

* */

package com.java.www;

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println(o1);
        Order o2 = new Order();
        System.out.println(o2);
    }
}

class Order {
    // 实例变量
    private int orderId = 100;
    private String orderName;

    // 类变量（静态属性）
    private static double price = 0.0;

    // 非静态代码块（初始化块）
    {
        orderId = 200;
        orderName = "mai mai";
        System.out.println("我是非静态初始化块1");
    }

    // 非静态代码块
    {
        System.out.println("我是非静态初始化块2");
    }

    // 构造器
    public Order() {
        super();
        orderId = 600;
        System.out.println("我是空参构造器");
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    // 非静态代码块
    {
        System.out.println("我是非静态初始化块0");
    }

    // 静态代码块
    static {
        Order.price = 99.9;
//        orderId = 301; // 静态代码块中不能调用非静态的属性
        showInfo();
        System.out.println("我是静态代码块1");
    }

    static {
        System.out.println("我是静态代码块2");
    }

    // 方法
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String toString() {
        return "Order{ orderId=" + orderId +
                ", orderName='" + orderName + "'" +
                ", price=" + Order.price +
                " }";
    }

    public static void showInfo() {
        System.out.println("静态方法");
    }
}
