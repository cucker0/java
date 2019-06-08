尚硅谷 Java 基础实战—Bank 项目 
==

# 实验题目 3
修改 withdraw 方法以返回一个布尔值，指示交易是否成功。

# 实验目的
使用有返回值的方法。

# 提示
```text
1． 修改 Account 类
a. 修改 deposit 方法返回 true（意味所有存款是成功的）。
b. 修改 withdraw 方法来检查提款数目是否大于余额。如果amt小于
balance, 则从余额中扣除提款数目并返回 true，否则余额不变返回
false。
2． 在 exercise3 主目录编译并运行 TestBanking 程序，将看到下列输出;
Creating the customer Jane Smith.
Creating her account with a 500.00 balance. 
Withdraw 150.00: true
Deposit 22.50: true 
Withdraw 47.62: true 
Withdraw 400.00: false
Customer [Smith, Jane] has a balance of 324.88
```

类UML图

![类UML图](./images/UML.jpg "类UML图")