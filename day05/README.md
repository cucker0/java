day05
==

# 学习面向对象内容的三条主线
* java类及类的成员
* 面向对象的三大特征（封装、继承、多态、抽象）
* 其他关键字

# 学习的内容
* 面向对象与面向过程
* java语言的基本元素：类和对象
* 类的成员之一：属性(Field)
* 类的成员之二：方法（Method）
* 对象的创建于使用
* 方法
* 面向对象特征之一：封装和隐藏
* 类的成员之三：构造器（构造方法）
* 几个关键字：this, package, import

## 面向对象与面向过程
>二者都是一种思想，面向对象是想对于面向过程而言的。  
面向过程，强调的是功能行为。面向对象，将功能封装进对象，强调具备了功能的对象。

>面向对象的三大特征  
. 封装(Encapsulation)  
. 继承(Inheritance)  
. 多态(Polymorphism)  

## 面向对象的思想概述
* 程序员从执行者转化成了指挥者
* 完成需求时：
>先去找具有所需功能的对象来用

>如果该对象不存在，那么创建一个具有所需功能的对象

>这样简化开发并提高服用

* 类(class)和对象(object)时面向对象的核心概念
>类是对一类事物的描述，是抽象的、概念上的定义

>对象是实际存在的该类事物的每个个体，因而也称实例(instance)

* “万事万物皆对象”

##  class类结构
* Field = 属性 = 成员变量,
* Method = [成员]方法 = 函数

### 类的成员构成 v1.0
```java
class Person {
    
    // 属性(成员变量) --start
    String name;
    int age;
    boolean isMale;
    // 属性(成员变量) --end
    
    //方法(函数) --start
    public void walk() {
        System.out.println("人两腿走路...");
    }
    
    public String showInfo() {
       String info = "名字是:" + name + " 年龄是:" + age + " sex:" + isMale;
       return info;
    }
    //方法(函数) --end
    
}

```

### 类的成员构成 v2.0
```java
class Person {
    // 属性(成员变量)
    String name;
    boolean isMale;
    
    //构造器
    public Person() {}
    public Person(String n, boolean ism) {
        name = n;
        isMale = ism;
    }
    
    // 方法(函数)
    public void walk() {
        System.out.println("人两腿走路...");
    }
    public String showInfo() {
       String info = "名字是:" + name + " 年龄是:" + age + " sex:" + isMale;
       return info;
    }
    
    // 代码块
    {
        name = "Lu meng";
        age = 17;
        isMale = true;
    }
    
    // 内部类
    class pet {
        String name;
        float weight;
    }
    
}

```

# 创建java自定义类
## 类的成员之一：属性
* 语法格式
    修饰符 类型 属性名 = 初始值;
>修饰符private: 该属性智能由该类的方法访问  
修饰符public: 该属性可以被该类以外的方法访问  
类型: 任何类型

* 举例
```java
public class Person {
    private int age;
    public String name = "Lilei";
}

```