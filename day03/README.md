day03_基本语法
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
* do-while

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

示例  
[ForTest](./ForTest.java)


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

示例  
[WhileTest](./WhileTest.java)

## do-while
* 语法格式
```text
[初始化语句;]
do {
    语句或语句块;
    [更改语句;]
} while (布尔测试表达式);

```
示例  
[DoWhileTest](./DoWhileTest.java)

## 特殊流程控制break
### break语句用于终止某个语句块的执行
```text
{
    ... ...
    break;
}
```


### break语句出现在多层，嵌套的语句块中时，可以通过标签指明要终止的是哪一层语句块
```text
        lable1:
        for (int i = 0; i < 4; ++i) {
            System.out.println("i layer: " + i);
            lable2:
            for (int j = 0; j < 4; ++j) {
                System.out.println("j layer: " + j);
                lable3:
                for (int k = 0; k < 4; ++k) {
                    if (k == 2) {
                        break lable2;
                    }
                    System.out.println("k layer: " + k);
                }
            }
        }
        
        
```
示例  
[BreakTest](./BreakTest.java)


## continue特殊控制
```text
        // 跳过指定层的本次循环
        lable1:
        for (int i = 0; i < 4; ++i) {
            System.out.println("i layer: " + i);
            lable2:
            for (int j = 0; j < 4; ++j) {
                System.out.println("j layer: " + j);
                lable3:
                for (int k = 0; k < 4; ++k) {
                    if (k == 2) {
                        continue lable1;
                    }
                    System.out.println("k layer: " + k);
                }
            }
        }

```
示例  
[ContinueTest](./ContinueTest.java)

## return
```text
* return并非专门用于结束循环的，它的功能是结束当前整个方法。执行return语句时，这个方法将被结束
* 与break、continue不同的是，return直接结束整个方法，不管这个return处于多少层循环之内

```

## break, continue, return特殊流程控制说明
* return 返回值，结束当前整个方法
* break 终止本层循环，只能用于 switch-case语句和for、while、do-while循环语句中
* continue 终止本次循环，只能用于循环语句（for、while、do-while）
* break、continue之后不能有其他的语句，因为程序永远不会执行其后的语句，编译也会报错
* 标号语句必须紧接在循环的头部。标号语句不能用在非循环语句的前面。
