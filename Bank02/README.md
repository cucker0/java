尚硅谷 Java 基础实战—Bank 项目
==

# 实验题目 2
扩展银行项目，添加一个 Customer 类。Customer 类将包含一个 Account对
象。

# 实验目的
使用引用类型的成员变量。

# 提示
```text
1. 在banking包下的创建Customer类。该类必须实现上面的UML图表中的模
型。
a. 声明三个私有对象属性：firstName、lastName 和 account。
b. 声明一个公有构造器，这个构造器带有两个代表对象属性的参数（f 和 l）
c. 声明两个公有存取器来访问该对象属性，方法 getFirstName 和 getLastName
返
回相应的属性。
d. 声明 setAccount 方法来对 account 属性赋值。
e. 声明 getAccount 方法以获取 account 属性。
2. 在 exercise2 主目录里，编译运行这个 TestBanking 程序。应该看到如下
输出结果:
Creating the customer Jane Smith.
Creating her account with a 500.00 balance.
Withdraw 150.00
Deposit 22.50
Withdraw 47.62
Customer [Smith, Jane] has a balance of 324.88
```

类的UML图

![类的UML图](./images/UML.jpg)