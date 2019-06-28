day12 异常处理
==

# 第二种异常处理方式：声明抛出异常
在方法的声明处，显式的抛出该异常对象的类型

* 如果一个方法中(包括编译、运行时)肯能出现某种异常，  
但是并不能确定如何处理这种异常，则此方法应显式的声明抛出异常，  
表明该方法将不对这些异常进行处理，而由该方法的调用者负责处理

* 在方法中声明用throws语句可以声明抛出异常的列表，  
throws的异常列表可以是方法中产生的异常类型，也可以是它的父类

* 格式：public void readFile() throws FileNotFoundException, IOException { }
* 当在此方法内部出现异常时，会抛出一个异常类的对象，抛给方法的调用者
* 异常对象可以逐层向上抛，一直到main方法中。在向上抛的时候，可以用try-catch-finally进行处理
* main()方法中抛出异常时到JVM中

示例
[Throws Exception](./src/com/java/www/ThrowsException.java)



## 重写方法声明抛出异常的原则
* 重写方法不能抛出比被重写方法范围更大的异常类型。  
在多态的情况下，对method()方法的调用时异常的捕获按照父类声明的异常处理

示例
[Throws Override 原则](./src/com/java/www/ThrowsOverrideTest.java)


# 手动抛出异常
* Java异常类对象除在程序执行过程中出现异常时由系统自动生成并抛出，也可根据需要人工创建并抛出。
    * 首先要生成异常类的对象，让后通过throw语句抛出异常对象
    >IOException e = new IOException();
    throw e;
    
    * 抛出的异常对象必须是Throwable或其子类的实例
    
java异常处理模型：抓抛模型
* 抓
    * try-catch-finally
    * throws 异常的类型列表  （在方法声明处，{ }前）
* 抛
    * 自动抛出
    * 手动抛出：throw 异常类的实例

[手动抛出异常](./src/com/java/www/ThrowTest.java)    


# 创建用户自定义的异常类
* 一般的，用户定义的异常类都是RuntimeException的子类
* 通常要编写几个重载的构造器
* 同样可以通过throw抛出自定义异常类的对象
* 自定义异常最重要的是异常类的名字，当异常出现时，可以根据名字判断异常类型

```java
class MyException extends Exception {
   	static final long serialVersionUID = 1L;
	private int idnumber;
 	public MyException(String message, int id) {
		super(message);
		this.idnumber = id;
 	} 
	public int getId() {
		return idnumber;
 	}
}

```

[自定义的异常类](./src/com/java/exercise/EcmDef.java)

## 异常处理5个关键字
抓
* try - catch - finally
* throws 异常类型列表  （方法声明处声明异常）

抛
* 自动
* thow 异常实例  （异常处）


# java集合
本章内容
* java集合框架
* Collection接口API
* Iterator接口API
* Collection子接口之一：Set接口
    * HashSet
    * LinkedList
    * Vector
    
* Collection子接口之二：List接口
* Map接口
    * HashMap
    * TreeMap
    * Hashtable

* Collection工具类

## java集合概述
* 一方面，面向对象语言对事物的体现都是以对象的形式，为了方便对多个对象的操作，就要对对象进行存储。  
另一方面，使用Array数组存储对方具有一些弊端，二java集合就像一种容器，可以动态的把多个对象的引用放入容器中。

* java集合类可以用于数量不等的多个对象，还可以用于保存具有映射关系的关联数组。
* java集合分为Collection和Map两种体系
    * Collection接口
        - Set：元素无序、不可重复的集合
        - List：元素有序，可以重复 -- 动态数组
    * Map接口：具有映射关系"key-value"对的集合
    

## Collection几口继承树
+ Collection
    - 方法iterator()
        返回对象类型为Iterator
            ListIterator
    
    - 实现接口子类
        * List
            * ArrayList
            * LinkedList
            * Vector
        * Set
            * HashSet
                * LinkedHashSet
            * SortedSet
                * TreeSet

* 集合API都位于java.util包内
  
* 对象排序接口
    * Comparable
    * Comparator
    
## Map接口继承树
+ Map
    - HashMap
        * LinkedHaspMap
    - Hashtable
        * Properties
    - SortedMap
        * TreeMap

## Collection接口
* Collection是List、Set、Queue接口的父类，该接口定义的方法可以操作List、Set、Queue集合
* 该接口不提供任何实现，有具体的子接口实现
* java 5之前，java集合会丢失所有对象的数据类型，把所有对象当成Object类型处理；  
从java 5增加了泛型，java集合可以记住集合中对象的数据类型

## Collection接口方法
* int size() 返回集合中元素的个数
* boolean add(E e) 向集合中添加一个元素
* boolean addAll(Collection coll) 将一个集合所有元素添加到当前集合中
* 查看所有元素 System.out.println(Collection实例);
* boolean isEmpty() 判断集合是否为空，是返回true，否则false
* void clear() 清空合集所有元素
* boolean contains(Object obj) 判断集合中是否包含指定的元素obj，如果包含返回true，否则false。
>判断方法：用到了类中的equals(Object o)方法。若使用了自定义类要重写equals()方法
* boolean containsAll(Collection coll) 判断当前集合是否包含coll集合中所有的元素。即判断一个集合是否为当前集合的子集
* boolean retainAll(Collectoin coll) 当前集合中仅保留一个集合coll与当前集合的交集给当前集合，会覆盖当前集合
* boolean remove(Object obj) 删除集合中的obj元素。若删除成功返回true,否则返回false
* booeanl removeAll(Collection coll) 从当前集合中删除与另外一个集合coll的交集所有元素。即 当前集合 - coll集合的差集。
* boolean equals(Object obj) 判断一个集合obj与当前集合两者所有的元素是否都相等。
* int hashCode() 获取当前集合的hash值
* Object[] toArray() 将集合转化成数组
* Iterator<E> iterator() 返回一个Iterator接口实现类对象，可用于遍历集合。该方法返回的对象类型为Iterator，有boolean hasNext()、Object next()方法


实例  
[Collection Test](./src/com/java/collection/CollectionTest.java)

