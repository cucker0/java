day03_基本语法
==

# 程序流程控制
## 结构类型
* 顺序结构
>程序从上到下逐行地执行（从上往下），中间没有任何判断和跳转

* 分支结构
>根据条件，选择性地执行某段代码

>有if ... else 和 switch ... case两种分支语句

* 循环结构
>根据循环条件，重复性地执行某段代码

>有while, do ... while, for 三种循环语句

>注：JDK1.5 提供了foreach循环，方便遍历集合、数组元素  
for (类型 o : obj被遍历的对象) {
    // o为obj中的元素
}


# 分支结构
## if-else
>从上往下找，匹配到一个条件后跳出判断。

* 格式1
```text
if (true) {
    执行的代码块;
}


```

* 格式2
```text
if (条件表达式) {
    执行代码块;
} else {
    执行代码块;
}

```

* 格式3
```text
if (表达式1) {
    执行代码块;
} else if {
    执行代码块;
} 
... ...
else {
    执行代码块;
}

```

>执行代码块只有一行语句时可省略这个代码块的{}  
建议任意时候都保留{}

### if示例
[IfTest1](./IfTest1.java)  
[ScoreIf](ScoreIf.java)  
[SortIf3](./SortIf3.java)  
[WetherToMarry](./WetherToMarry.java)

## switch-case
格式：
```text
switch (变量) {
    case 常量1:
        语句1;
        break;
    case 常量2;
        语句2;
        break;
    ... ...
    case 常量N:
        语句N;
        break;
    default:
        语句;
        break;
}

```

### switch-case规则
* 变量的值只有是下列数据类型：byte, short, char, 枚举, String(jdk1.7)
* case子句中的值必须是常量，不能取范围，且所有case子句中的值应是不同的
* default子句是可选选的，位置也是灵活的，不一定放到最后。但建议放到最后。  
当没有匹配的case时，执行default子句
* break语句用来执行完成一个case分支后使程序跳出switch语句块;  
如果没有break，则从匹配的case开始顺序执行到switch结尾，这一特性可以很好的用于计算日期为当年的第几天

### switch-case示例
[SwitchTest](./SwitchTest.java)  
[Score2](./Score2.java)  
[IfExchangeSwitch](./IfExchangeSwitch.java)  特定情况下if与switch可互换  
[DateEstimationDays](DateEstimationDays.java)  switch特殊应用：输入任意2019年一个年月日日期，算出这是当年的第几天  
[DateEstimationDays2 自动判断是否为闰年](./DateEstimationDays2.java)  switch特殊应用:输入任意一个年月日日期，算出这是当年的第几天

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
④循环体

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
* continue 终止本次循环，本次循环到此终止，继续下一次循环，只能用于循环语句（for、while、do-while）
* break、continue之后不能有其他的语句，因为程序永远不会执行其后的语句，编译也会报错
* 标号语句必须紧接在循环的头部。标号语句不能用在非循环语句的前面。
