day14泛型
==

# 泛型概述
* 概念：泛型将接口的概念进一步延伸，"泛型"字面意思就是广泛的类型，类、接口和方法代码可以应用于非常广泛的类型，  
代码与它们能够操作的数据类型不再绑定在一起，同一套代码，可以用于多种数据类型，  
这样，不仅可以复用代码，降低耦合，同时，还可以提高代码的可读性和安全性。
* 泛型作用
    * 把集合中元素、类、接口的内容限制为指定的数据类型，但未使用之前(实例化之前)又不能确定是哪种数据类型，在实例化时指定数据类型
    * 解决元素存储的安全性问题
    * 解决获取数据元素时，需要类型强转的繁琐问题

示例  
[泛型测试](./src/com/java/www/GenericTest.java)

# 泛型的使用
* 泛型的声明
* 符号：<>
* 格式：<类型列表>, 如<Boolean>, <String, Integer>，可以写多个数据类型
```text
interface List<T> 和class TestGen<K, V>其中，T、K、V不代表值，而是表示类型。
这里使用任意字母都可以，通常大写。常用T表示，T是Type的缩写
```
* 泛型的实例化
```text
一定要在类名后面指定类型参数的值(类型)
如：
List<String> strList = new ArrayList<>();
Iterator<Customer> iterator = customer.iterator();

T只能是类，不能用基本数据类型填充

```


# 泛型的几个重要使用地方
* 在集合中使用泛型
* 自定义泛型类
* 泛型方法
* 泛型接口


# 泛型类规则
* 泛型类对象实例化时不指定泛型，默认类型为 Object
* 泛型不同的引用不能相互赋值
* 加入集合中的对象类型必须与指定的泛型类型一致
* 静态方法中不能使用类的泛型，因为静态方法在类加载时就确定了
* catch的异常类型不能为泛型
* 构造器中不能使用泛型

[自定义泛型类](./src/com/java/www/Customer.java)  
[泛型类、泛型继承关系、泛型通配符 测试](./src/com/java/www/GenericTest.java)


# 泛型接口
与泛型类相似
```java
// 示例
public interface USB<T> {
    public abstract void start(T t);
    void stop(T t);
}
```
示例  
[泛型接口](./src/com/java/www/USB.java)  
[泛型接口实现](./src/com/java/www/PhoneUSB.java)


# 泛型方法
* 普通类(非泛型类)、泛型类中都可以定义泛型方法。
* 在泛型方法中定义泛型参数，参数的类型就是传入数据的类型
* 泛型方法格式：
```text
    [访问权限] <泛型> 返回类型 方法名([泛型标识] 参数名称) [throws 异常类型类表] {
    
    }
    
示例
public class DAO {
    public <E> E get(int id, E e) {
        E result = null;
        return result;
    }
}    
```

示例  
[泛型方法](./src/com/java/www/Customer.java)


# 泛型与继承的关系
```text
* 若B是A的一个子类型（子类或者子接口），而G是具有泛型声明的类或接口，G<B>并不是G<A>的子类型！  
那么List<B>不是List<A>的子类，List<A>与List<B>类型不一样

* 子类不为泛型类：继承时指定父类泛型中的类型，例如class SubCustomer extends Customer<Integer> { }

* 子类仍为泛型类：继承时子类使用泛型，例如class SubCustomer2<T> extends Customer<T> { }
```

# 泛型通配符
作用：兼容多种泛型类型
```text
* 类型通配符符号：<?>  
如List<?>, Map<?, ?>

* List<A>、List<B> ... ... 都是List<?>的子类

* 读取 List<?> 对象list中的元素时，永远是安全的，因为不管list的元素真实类型是什么，list包含都是Object

* 写入、修改list中的元素时，不行，因为我们不知道list的元素类型，唯一例外的是null，null是所有类的成员

* <? extends A>  
只能存放A及其子类，元素可以增查改删

* <? super A>   
只能存放A及其父类

* <? extends Comparable> 只允许泛型为实现Comparable接口的实现类的引用调用

* 不能向声明为通配符的集合中添加、修改元素(当元素为null除外)，但可以获取、删除元素
```

# java8注解新特性
[java8注解新特性](../java8_new_features/README.md#java8注解新特性)  
