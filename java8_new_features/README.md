Java 8新特性
==


# 本章内容
* Lambda表达式
* 函数式接口
* 方法引用/构造器引用
* Stream API
    * 并行流
    * 串行流
* 接口的增强
    * 接口的静态方法
    * 接口的莫仍方法
* Optional类
* 新的时间和日期API
* 其他新特性
    * 重复注解
    * 类型注解
    * 通用目标类型推断
    * JDK的更新
        * 集合的流式操作
        * 并发
        * Arrays
        * Number和Math
        * IO/NIO的改进
        * Reflection获取形参名
        * String: join()
        * Files
    * 新编译工具：jjs、jdeps
    * JVM中Metaspace取代PermGen空间


# 新的时间和日期API
* LocalDate
* LocalTime
* LocalDateTime
* Instant
* DateTimeFormatter
* 其他类


# Java 8新特性简介
* 速度更快
* 代码更少(增加了新的语法:Lambda表达式)
* 强大的|Stream API
* 便于并行
* 最大化减少空指针异常:Optional类
* Nashorn引擎，允许在JVM上运行JavaScript应用

## Stream的并行流与串行流
    并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
    相比串行流，并行流可以很大程度上提高程序的执行效率。
    
    Java 8中，Stream API可以通过 parallel()声明为并行流，sequential()声明为串行流。


# Lambda表达式
## 为什么使用Lambda表达式
```text
Lambda 是一个匿名函数，
我们可以把 Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。
使用它可以写出更简洁、更灵活的代码。
作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。
```




