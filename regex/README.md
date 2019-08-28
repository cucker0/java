java正则表达式
==

# 正则表达式定义
正则表达式定义了字符串的模式

* 作用
>正则表达式可以用来搜索、编辑、处理文本。

# 正则表达式例子
* 一个字符串其实就是一个简单的正则表达式，例如：Hello World 正则匹配"Hello World"字符串
* .(点号) 也是一个表达式，它匹配任何一个字符，如："a" 或 "1" 等

* 下表列出了一些正则表达式的实例及描述

正则表达式 | 描述 
:--- |:---
this is text | 匹配字符串 "this is text"
this\s+is\s+text | 注意字符串中的 \s+ <br> 匹配单词 "this" 后面的 \s+ 可以匹配多个空格，之后匹配 is 字符串，再之后 \s+ 匹配多个空格然后再跟上 text 字符串。<br> 可以匹配这个实例：this is text
^\d+(\\.\d+)? | ^ 定义了以什么开始 <br> \d+ 匹配一个或多个数字 <br> ? 设置括号内的选项是可选的 <br> \\. 匹配 "." <br> 可以匹配的实例："5", "1.5", "2.21", "336.8"等

# java regex正则
从JDK 1.4开始自带了支持正则的包：java.util.regex

## java.util.regex包结构
此包结构也比较简单，如下
* java.util.regex(包)
    * Interface(接口)
        * MatchResult
    * Class(类)
        * Matcher (对输入字符串进行解释和执行匹配操作的引擎，实现了MatchResult接口)
        * Pattern (正则表达式的编译表示)
    * Exception(异常)
        * PatternSyntaxException (一个非强制异常类，它表示一个为检测的正则表达式模式中的语法错误)

为什么会把Matcher、Pattern分开设计，这主要是为了同一个正则表达式使用多次时提高效率。

## Pattern类
```text
Pattern 类没有公共构造方法。
要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法compile，它返回一个 Pattern 对象。
该方法接受一个正则表达式作为它的第一个参数
```
```text
// 一个经典的调用顺序
Pattern p = Pattern.compile("a*b");
Matcher m = p.matcher("aaaaab");
boolean b = m.matches();
```

* [Pattern类结构](./Pattern类.md)  

## Matcher类
没有公共构造方法。
创建Matcher对象，需要通过Pattern对象matcher方法，即Pattern对象.matcher(要进行匹配的字符串);

* [Matcher类结构](./Matcher.md)  


