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
目的：禁止被修改、被继承  

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

# 抽象类(abstract class)
随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计得非常抽象，以至于它没有具体的实例，这样的类叫做抽象类

只能修饰 类、方法  
目的：让继承的子类去实现(重写方法)

* abstract修饰类：抽象类
    * 不能被实例化
    * 抽象类有构造器（凡是类都有构造器）
    * 有抽象方法的类一定是抽象类
    * 抽象类可以没有抽象方法
    * abstract于访问权限修饰符顺序可先可后，建议先权限修饰符，再abstract。如：public abstract class aa { }

* abstract修饰方法：抽象方法
    * 格式：没有方法体，包括{ }也不能有，即没有{}块。如：public abstract void walk();
    * 抽象方法只保留方法的功能，具体的执行交给继承该抽象的子类去实现，实现方法：子类重写抽象方法
    * 有抽象方法的抽象类的子类，必须实现（重写）所有的抽象方法，才能实例化。未全部重写的类只能定义为抽象类
    * 抽象类的子类，可以为抽象类，可以只实现一部分抽象方法，还可以再添加新的抽象方法。那么子类必须实现多层父类的抽象方法

* 注意事项
    * abstract不能于private、final、static修饰符公用
    * 不能修饰属性、构造器
    
示例
```java
package com.java.www;

public class AbstractTest {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.eat();
//        System.out.println(p1);

        Person s1 = new Student("灵气", 30); // 多态
        System.out.println(s1);

        Worker w1 = new Worker();
        w1.walk();

    }
}

abstract class Person {
    private String name;
    protected int age;
//    protected abstract double height; // 不能修饰属性

    // 构造器
    public Person() {
        super();
    }

    /*
    // 不能修饰构造器
    public abstract Person(String name) {
        super();
        this.name = name;
    }
    */

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void eat() {
        System.out.println("eating");
    }

    public abstract void walk();

//    public static abstract void sleep(); // abstract不能与static一起

//    private abstract void see(); // abstract不能与 private一起

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person{" +
                " name='" + name + "'" +
                ", age=" + age +
                " }";
    }

}

class Worker extends Person {

    // 构造器
    public Worker() {
        super();
    }

    // 方法
    public void eat() {
        System.out.println("工人吃饭");
    }

    public void walk() {
        System.out.println("工人走路");
    }

}

class Student extends Person {
    // constructor
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    // methods
    public void eat() {
        System.out.println("student eating");
    }

    public void walk() {
        System.out.println("student walking");
    }

}

abstract class Man extends Person {
    public void walk() {
        System.out.println("男人走路");
    };

    public abstract void smoking();
}

class Driver extends Man {
    @Override
    public void smoking() {
        System.out.println("帅气地吸烟");
    }
}
```


# 模板方法设计模式(TemplateMethod)
抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

* 解决的问题
    - 当功能内部一部分实现是确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
    - 编写一个抽象父类，父类提供了多个子类的通用方法，并把一个或多个方法留给其子类实现，就是一种模板模式。

示例
```java
public class TemplateTest {
    public static void main(String[] args) {
        MySort s1 = new MySort(1000);
        s1.spendTime();
    }
}

abstract class Template {
    abstract void code();

    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.printf("spend time: %ds\n", end - start);
    }
}

class MySort extends Template {
    private int num;

    // 构造器
    public MySort() {
        super();
    }

    public MySort(int num) {
        this.num = num;
    }

    // 方法
    public void code() {
        /*
        求给定数的范围内所有的质数
        * */
        for (int i = 2; i <= num; ++i) {
            boolean flag = true;
            for (int j = 2; j < Math.pow(i, 1.0/2); ++j) {  // Math.pow(num, 1.0/2) 根号2
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

```

# interfacer接口
接口用途：被实现类去实现接口定义的功能（面向接口编程）
* interface是与类等级平级的一个概念
* 接口可以看做是一个特殊的抽象类。
* 接口是常量、抽象方法的集合，只能有常量和抽象方法，不能包含变量、一般的方法
* 没有构造器，也就不能实例化
* 接口定义的是一种功能。此功能可以被类实现（implements）
* 接口里所有的常量都是被  public static final 修饰。不写也会默认加上
* 所有的方法都是被 public abstract 修饰。不写默认也会加上
* 实现接口的类，必须重写所有的抽象方法，才能实例化。若没有重写所有的方法，则此类只能定义为抽象类
* 类可以同时实现多个接口。相当于多重继承。类的继承是单个多层继承的
* 接口可以被接口继承，接口允许多重多层继承，如：interface GG extends AA, DD { }
* 一个类可以同时承继父类、实现接口，必须先写extends，后写implements，如：class EE extends FF implements AA, DD { }
* 与继承关系类似，接口与实现类之间存在多态性

示例
```java
package com.java.www;

public class InterfaceTest {
    public static void main(String[] args) {
        Audi a1 = new Audi("奥迪R8 V10 Spyder", 229.98);
        System.out.println(a1);
        System.out.println(a1.run());
    }
}

interface AA {
    // 常量
    // 接口里所有的常量都是被  public static final 修饰。不写也会默认加上
    public static final int I = 99;
    boolean FLAG = false;
//    int age; // 不能有变量，此处会的报错

    // 方法
    // 抽象方法：所有的方法都是被 public abstract 修饰。不写默认也会加上
    abstract void eat();
    void walk();

}

interface DD {
    int lifeValue();
}


abstract class BB implements AA{

}

class CC implements AA{

    public void eat() {
        System.out.println("eating ...");
    }

    public void walk() {
        System.out.println("walking ...");
    }

}

class FF {
    public boolean status() {
        return true;
    }
}

class EE extends FF implements AA, DD {
    // 多重实现，还可以同时继承一个类
    public void eat() {

    }

    public void walk() {

    }

    public int lifeValue() {
        return 100;
    }
}

interface GG extends AA, DD {
    // 接口允许多重继承
}

//
interface Car {
    public static final int WHEEL = 4;

    // 是自动档
    boolean isAutoGear();
}

interface ChinaCar extends Car {
    /*
    接口继承
    * */
    String NATION = "China";

    String run ();
}


class Audi implements ChinaCar{
    private String model;
    private double price; // 单位：万


    // 构造器
    public Audi() {
        super();
    }

    public Audi(String model, double price) {
        this.model = model;
        this.price = price;
    }

    // 方法
    public boolean isAutoGear() {
        return true;
    }

    public String run() {
        return "120 KM/H在跑";
    }

    public String toString() {
        return "Audi{ " +
                "model='" + model + "'" +
                ", price=" + price + "万" +
                ", isAutoGear=" + isAutoGear() +
                " }";
    }
}
```