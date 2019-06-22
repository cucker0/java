day10高级类特性2
==

# 单例设计模式(Singleton)
概念：采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象
实例的方法。

解决的问题：使得一个类只能够创建一个对象

## 实现
* 饿汉式单例模式
```java
/*
饿汉式单例
建议使用饿汉式单例模式

# 单例的设计模式
* 解决的问题：使得一个类只能够创建一个对象
* 实现
    * 在类的内部创建一个私有静态的该类的对象
    * 定义一个private 空参构造器
    * 定义一个public静态方法回返上面定义的实例


* */

package com.java.www;

public class Singleton {
    // 类变量
    private static Singleton instance = new Singleton();

    // 构造器
    private Singleton() {
        super();
    }

    // 方法
    public static Singleton getInstance() {
        return instance;
    }
}

```

* 懒汉式单例模式
```java
/*
懒汉式单例
可能在线程安全问题。学了多线程时可修复此问题

* */

package com.java.www;

public class SingletonLazybones {
    // 类变量
    // 定义私有静态的该类的对象实例为null
    private static SingletonLazybones instance = null;

    // 构造器
    // 定义私有的空参构造器
    private SingletonLazybones() {}

    // 方法
    // 定义公共静态的方法返回实例，并判断实例是否为null，为null时新建该实例
    public static SingletonLazybones getInstance() {
        if (instance == null) {
            instance = new SingletonLazybones();
        }
        System.out.println(instance);
        return instance;
    }
}
```

# main方法
格式：public static void main(String[] args) { }

举例
```java
public class MainTest {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            System.out.printf("args[%d]: %s\n", i, args[i]);
        }
    }
}
```

# 类的成员之四：初始化块
* 初始化块(代码块)作用
    > 对java对象进行初始化
    
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

* 关于属性赋值操作先后顺序  
    1.默认的初始化  
    2.显示初始化、代码块初始化（这两个机构之间按照顺序执行）  
    3.构造器中赋值  
    4.通过方法对对象的属性进行修改  

```java
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
```


# final 关键字
final  （最终的）   
可以修饰类、属性、方法。不能修饰构造器  
目的：禁止被修改  

* final修饰的类
    这个类不能被继承。如String、StringBuffer、System类
* final修饰的方法。
    不能被重写
    功能确定不变的，就定义为final方法，如Object类中的getClass
    final于访问权限修饰符顺序可先可后，建议先权限修饰符，再final。如：public static void walk() { }
* final修饰的属性
    此属性就是常量。建议常量名字母全大写
    常量一旦初始化，就不能修改
    怎么赋值：可以显示的赋值、代码块、构造器，没有默认值。且必须先赋值再能使用
* static final修饰的变量：全局常量
    Math.PI
* final于finally、finalize()没有联系

```java

public class finalTest {
}

final class Nvwa {
    private String color;
    private double height;
    private boolean sex;
    private String nation;
}

class Animal {
    private String name;
    private final boolean status = true;
    private int age;
    protected final int legs;

    // 构造器
    public Animal() {
        super();
//        status = false; // 不能*/
        legs = 4;
    }

    // 方法
    public void shout() {
        System.out.println("叫");
    }

    public static void walk() {
        System.out.println("走");
    }
}

/*
class Yello extends Nvwa {

}
// 不能继承final修饰的类
*/

/*
class myString extends String {

}
// 不能继承final修饰的类
*/

class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪叫");
    }

    /* // final修饰的方法不能被重写
    public void walk() {

    }
    */
}


/*
public class Something {
    public int addOne(final int x) {
        return ++x; // 报错，不能再修改了
    }
}
*/

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }

    public void addOne(final Other o) { // final修饰的时对象的引用地址，只要引用地址值不变就可以
        o.i++;
    }
}

class Other {
    public int i;
}

```

