day01-04 Java语言特性
==

# java语言特点
* 面向对象
```
基本概念：类型、对象
三大特性：封闭、继续、多态
```
* 健壮性
* 跨平台性

# java两种核心机制
* java虚拟机(Java Virtal Machine)
* 垃圾收集机制(Garbage Collection)

# .java源文件要求
* 源文件后缀.java
* 源文件中可以有多个class声明的类
* 类中可以有主方法（即main()方法），其格式是固定的：public static void main(String[] args) {}
* main是()方法是程序的入口，方法内是程序的执行部分
* 一个源文件中只能有一个声明为public的类，同时要求此类的类名与源文件名一致
* 每个语句都要以;结尾
* 执行过程 
> 1>编译:javac {-encoding utf8} 源文件名，生效多个.class字节码文件，
> 2>运行:java 类名
* 单行注释：//
* 多行注释不能嵌套， /* 注释文本 */
* 生成文档说明：javadoc -encoding utf8 -d mydoc -author -version HelloJava.java ,java文档说明，以/** 开头的多文本注释
* java源文件的字符集与环境的字符集不一样时（尤其是windows cmd为GBK），这里javac 可指定字符集，如：javac encoding utf8 .java源文件


day01-08 基本语法
==

# 关键字
> 定义：被Java语言赋予了特殊含义，用做专门用途的字符串（单词）
> 特点：关键字中所有字母都为小写

## 定义数据类型的关键字
* class
* interface
* enum
* byte
* short
* int
* long
* float
* bouble
* char
* boolean
* void

## 定义数据类型值的关键字
* true
* false
* null

## 定义流程控制的关键字
* if
* else
* switch
* case
* default
* while
* do
* for
* break
* continue
* return

## 定义权限修饰符的关键字
* private
* protected
* public

## 定义类、函数、变量修饰符的关键字
* abstract
* final
* static
* synchronized

## 定义类与类之间关系的关键字
* extends
* implements

## 定义建立实例及引用实例，判断实例的关键字
* new
* this
* super
* instanceof

## 异常处理的关键字
* try
* catch
* finally
* throu
* throws

## 用于包的关键字
* package
* import

## 其他修饰符关键字
* native
* strictfp
* transient
* volatile
* assert

## 保留字
* byValue
* cast
* future
* generic
* inner
* operator
* outer
* rest
* var
* goto
* const

# 标识符
> java对各种变量、方法和类等要素命名时使用的字符序列称为标识符
>（凡是可以自己起名字的地方都叫做标识符）

## 合法标识符规则
* 由26个英文字母大不写、0-9数字、_、$组成
* 数字不可以开头
* 不可以使用关键字和保留字，但能包含关键字和保留字
* java中严格区分大小写，长度无限制
* 标识符不能包含空格
> 注意：在起名字时，为了提高阅读性，要尽量有意义，“见名知意”

# Java中名称命名规范
>建议遵守，如果不遵守编译也不会报错
* 包名
>多单词组成时所有字母都小写：xxyyzz
* 类名、接口名
>多单词组成时，第一个单词首字母小写，第二单词开始每个单词首字母大写：xxYyZz
* 常量名
>所有字母都大写。多个单词时每个单词用下划线连接：XX_YY_ZZ



day01-09 java中变量的声明与使用
==

# 变量
* 变量概念
```text
* 内存中的一个存储区域
* 该区域有自己的名称(变量名)和类型(数据类型)
* java中每个变量必须先声明，后使用
* 该区域的数据可以在同一个类型范围内不断变化
```

* 使用变量注意
>变量的作用域：一对{ }之间有效

> 初始化值

* 定义变量的格式
>数据类型 变量名 = 初始化值

* 变量是通过使用变量名来访问这块区域的

## 程序的执行过程
![程序执行过程](./images/程序的执行过程.png)

## 变量的分类
```text
基本数据类型
    数值型
        整数类型
            byte, short, int, long
        浮点类型
            float, double
    字符型
        char
    布尔型
        boolean
引用数据类型
    类(class) -- 字符串在这里，String[] 
    接口(interface)
    数组([])

```
### 整数类型
* java各整数类型有固定的表数范围和字段长度，不受具体OS的影响，以保证java程序的可移植性。
* <font color=red>java的整形常量默认是int型，声明long型常量须后加"l" 或"L" </font>
* 正负符号占用了第一个位置

|类型 |占用存储空间 |表数范围| 默认类型 |末尾加标识 |示例 |
|:---|:---|:---|:---|:---|:---|
|byte |1字节(byte)=8bit |-2<sup>7</sup> ~ 2<sup>7</sup>-1 | | |
|short |2字节 |-2<sup>15</sup> ~ 2<sup>15</sup>-1| | |
|int |4字节 |-2<sup>31</sup> ~ 2<sup>31</sup>-1 |默认 | |
|long |8字节|-2<sup>63</sup> ~ 2<sup>63</sup>-1 | |L 或 l |long lonng1 = 9999999999L

### 浮点型
* 与整型类似，java浮点型也有固定的表数范围和字段长度，不受具体OS的影响。
* java的浮点型常量默认为double型，声明float型常量，须后加"f" 或 "F"
* 浮点型常量有两种表示形式：
>十进制数形式，如5.12,  512.0f,  .512 (必须有小数点)

>科学计数法形式，如 5.12e2, 512E2, 100E-2

|类型 |占用存储空间 |表数范围| 默认类型 |末尾加标识 |示例 |
|:---|:---|:---|:---|:---|:---|
|单精度float |4字节 |-3.403E38 ~ 3.403E38 | |F 或 f | 5.03F|
|双精度double |8字节 |-1.798E308 ~ 1.798E308 |默认 | | 5.99|
