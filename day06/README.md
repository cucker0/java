day06
==

[TOC]

# 类的成员之三：构造器（构造方法）
目前已学的java成员：属性、方法、构造器

## 构造器的特征
* 构造器具有与类相同的名称
* 构造器不声明返回值类型。与声明为void不同
* 不能被static、final、synchronized、abstract、native修饰，不能有return语句返回值

## 构造器的作用
```text
* 创建对象
* 给对象进行初始化

如：Order o = new Order();
Person p = new Person(Peter, 15);

```

## 构造器语法格式
```text
    修饰符 类名(参数列表) {
        初始化语句;
    }
    
举例：
public class Animal {
    private int legs;
    
    // 构造器
    public Animal() {
        legs = 4;
    }
    
    // 方法
    public void setLegs(int i) {
        legs = i;
    }
    
    public int getLegs() {
        return legs;
    }

// 创建Animal类的实例：Animal a = new Animal();
// 调用构造器时，将legs初始化为4

}

```

## 构造器规则
* 根据参数不同，构造器可分为如下两类：
>隐式无参数构造器（系统默认提供，是一个空参的构造器，代码块也为空）  
显式定义一个或多个构造器(无参、在参均可)，多个构造器将构成重载

* 注意
>. java语言中，每个类至少有一个构造器  
. 默认构造器的修饰符与所属类的修饰符一样  
. 一旦显式定义了构造器，则系统不再提供默认的构造器  
. 一个类可以创建多个重载的构造器  
. 父类的构造器不可被子类继承
. 类对象属性赋值先后顺序：  
    属性的默认初始化 > 属性的显示初始化 > 通过构造器给属性初始化 > 通过 "对象.方法" 的方式给属性赋值

# 构造器重载
* 构造器重载一般用来创建对象的同时初始化对象

```java
class Person {
    String name;
    int age;
    
    public Person(Strin n, int a) {
        name = n;
        age = a;
    }
}

```

* 构造器重载使得对象的创建更加灵活，方便创建各种不同的对象
```java
public class Person {
    public Person(String name, int age, Data d) {
        this(name, age);
        ... ...
    }
    
    public Person(String name, int age) {
        ...
    }
    
    public Person(String name, Date d) {
        ...
    }
    
    public Person() {
        ...
    }
}

```
* 构造器重载，参数列表必须不同

```java
public class Person {
    private String name;
    private int age;
    private Date birthDate;
    
    // 构造器
    public Person(Stringt name, int age, Date d) {
        this.name = name;
        this.age = age;
        this.birthDate = d;
    }
    public Person(String name, int age) {
        this(name, age);
        // 等同于
        // this.name = name;
        // this.age = age;
    }
    public Person(String name, Date d) {
        this(name, 30, d);
        // 等同于
        // this.name = name;
        // this.age = 30;
        // this.birthDate = d;
    }
    public Person(String name) {        
        this(name, 30);
    }
}

```


