day06面向对象编程
==

# Table of Contents
* [类的成员之三：构造器（构造方法）](#类的成员之三构造器构造方法)
* [构造器重载](#构造器重载)

# 类的成员之三：构造器(构造方法)
目前已学的java成员：属性、方法、构造器
声明构造器格式：权限修饰符 类名(形参) {  }        // 注意跟方法不同的是没有返回值类型

## 构造器的特征
* 构造器具有与类相同的名称
* 构造器不声明返回值类型。与声明为void不同
* 不能被static、final、synchronized、abstract、native修饰，不能有return语句返回值
* 一旦显式的定义了类的构造器，默认的构造器就不再提供

## 构造器的作用
构造器是在创建创建对象的时候调用。
```text
* 创建对象
* 给对象进行初始化

如：Order o = new Order();
Person p = new Person(Peter, 15);

```
与python类中的__init__(self):   作用一样，python还有析构器(也叫析构函数，销毁该实例)
```python
# python class
class Student(Object):
	__init__(self):  # 构造器（构造函数）
		name = self.name
		age = self.age
		
	__del__(self):  # 析构器（析构函数，在销毁该实例时执行，可用del 实例对象来手动销毁）
		print("del this instance")
	

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
显式定义一个或多个构造器(无参、带参均可)，多个构造器将构成重载

* 注意
>. java语言中，每个类至少有一个构造器  
. 默认构造器的修饰符与所属类的修饰符一样  
. 一旦显式定义了构造器，则系统不再提供默认的构造器  
. 一个类可以创建多个重载的构造器  
. 父类的构造器不可被子类继承
. 类对象属性赋值先后顺序：  
    属性的默认初始化 > 属性的显示初始化 > 通过构造器给属性初始化 > 通过 "对象.方法" 的方式给属性赋值

### 构造器练习
[TestPerson](./src/com/java/www/TestPerson.java)  
[TestPoint](./src/com/java/exercise/TestPoint.java)  
[TestTriAngle](./src/com/java/exercise/TestTriAngle.java)  
[Person1](./src/com/java/exercise/Person1.java)  
[Person2](./src/com/java/exercise/Person2.java)  
[Person3](./src/com/java/exercise/Person3.java)  

# 构造器重载
* 类的多个构造器之间构成重载(Over Load)
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
    public Person(Stringt name, int age, Date d) { // 构造器1
        this.name = name;
        this.age = age;
        this.birthDate = d;
    }
    public Person(String name, int age) {
        this(name, age); // 这里调用了构成重载的 构造器1
    }
    public Person(String name, Date d) {
        this(name, 30, d); // 调用构造器1
    }
    public Person(String name) {        
        this(name, 30);
    }
}

```


