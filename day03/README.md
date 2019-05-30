day03
==

# 循环结构
* 循环语句功能
>在某些条件满足的情况下，反复执行特定代码的功能

* 循环语句的4个组成部分
>初始化部分(init_statment)

>循环条件部分(text_exp)

>循环休部分(body_statement)

>迭代部分(alter_statement)

* 循环语句分类
 ```text
* for
* while
* do/while

```

## for循环
* 语法格式
```text
for (初始表达式; 布尔值测试表达式; 更改表达式) {
    语句或语句块;
}


格式：
①初始化条件
②循环条件
③迭代条件
④循环休

for (①; ②; ③) {
    ④;
}
```

* 无限循环
```text
for (; ; ) {
    
}
```

## while
* 语法格式
```text
[初始化语句;]
while (布尔测试表达式) {
    语句或语句块;
    [更改语句;]
}

格式 ：
①
while (②) {
    ④
    ③
}


```
* 无限循环
```text
while (true) {
    
}
```

* for循环与while循环可以互相转换

## do-while
* 语法格式
```text
[初始化语句;]
do {
    语句或语句块;
    [更改语句;]
} while (布尔测试表达式);

```