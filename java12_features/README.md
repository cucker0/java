java 12新特性
==

# 新特性官方介绍
https://openjdk.java.net/projects/jdk/12/


```text
189:	Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)
Shenandoah：新添加一个低暂停时间垃圾收集器算法(实验)

230:	Microbenchmark Suite
添加一个基本的microbenchmark套件

325:	Switch Expressions (Preview)
增强switch表达式(预览功能)

334:	JVM Constants API
JVM常量API

340:	One AArch64 Port, Not Two
只保留一个64位AARCH64端口

341:	Default CDS Archives


344:	Abortable Mixed Collections for G1


346:	Promptly Return Unused Committed Memory from G1

```


# 新增Shenandoah低暂停时间垃圾回收器算法(实验性功能)
```text
添加一个新的垃圾收集（GC）算法名为Shenandoah，通过与运行的Java线程同时进行疏散工作，减少GC暂停时间。
shenandoah的暂停时间与堆大小无关，这意味着无论堆大小是200mb还是200gb，暂停时间都是相同的。
```

# 添加一个基本的microbenchmark套件

# 增强switch表达式(预览功能)
```text
java 12还未实现
```

```text
使swith(变量) 的变量处可以是一个表达式

// 之前的swith语句需要break，如何缺少则跟我们预设的结果不一样
int day = 1;
switch (day) {
    case MONDAY:
    case FRIDAY:
    case SUNDAY:
        System.out.println(6);
        break;
    case TUESDAY:
        System.out.println(7);
        break;
    case THURSDAY:
    case SATURDAY:
        System.out.println(8);
        break;
    case WEDNESDAY:
        System.out.println(9);
        break;
}


// 建议的形式：
建议引入一种新形式的开关标签，写着“case l->”，以表示只有标签右边的代码在标签匹配的情况下才能执行
int day = 1;
switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> {
        System.out.println(6);
    }
    case TUESDAY                -> System.out.println(7);
    case THURSDAY, SATURDAY     -> System.out.println(8);
    case WEDNESDAY              -> System.out.println(9);
}

// 更简化形式
int numLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case THURSDAY, SATURDAY     -> 8;
    case WEDNESDAY              -> 9;
};

```

# 引入JVM常量API
```text
引入API来对键类文件和运行时工件（特别是可从常量池加载的常量）的名义描述建模
```

# 只保留一个64位AARCH64端口
```text
移除与ARM64端口相关的所有源，同时保留32位ARM端口和64位AARCH64端口
```

# 64位平台上使用默认CDS存档
```text
增强JDK构建过程，在64位平台上使用默认类列表生成类数据共享（CDS）存档
```

# 增强G1垃圾回收器，可中止混合集合
```text
如果G1混合集合可能超过暂停目标，则使其可中止。
```

# 增强G1垃圾回收器，使其能自动返回未用堆内存给操作系统
```text
当空闲时，增强G1垃圾收集器自动返回Java堆内存到操作系统
```