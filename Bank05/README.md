尚硅谷 Java 基础实战—Bank 项目 
==

# 实验题目 5
在银行项目中创建 Account 的两个子类：SavingAccount 和 CheckingAccount
实验目的：
继承、多态、方法的重写。

# 提示
```text
创建 Account 类的两个子类：SavingAccount 和 CheckingAccount 子类
a. 修改 Account 类；将 balance 属性的访问方式改为 protected
b. 创建 SavingAccount 类，该类继承 Account 类
c. 该类必须包含一个类型为 double 的 interestRate 属性
d. 该类必须包括带有两个参数（balance 和 interest_rate）的公有构造器。该
构 造器必须通过调用 super(balance)将 balance 参数传递给父类构造
器。

实现 CheckingAccount 类
1． CheckingAccount 类必须扩展 Account 类
2． 该类必须包含一个类型为 double 的 overdraftProtection 属性。
3． 该类必须包含一个带有参数（balance）的共有构造器。该构造器必须通过调
用 super(balance)将 balance 参数传递给父类构造器。
4． 给类必须包括另一个带有两个参数（balance 和 protect）的公有构造器。该
构造器必须通过调用 super(balance)并设置 overdragtProtection 属性，
将 balance 参数传递给父类构造器。
5． CheckingAccount 类必须覆盖 withdraw 方法。此方法必须执行下列检
查。如 果当前余额足够弥补取款 amount,则正常进行。如果不够弥补但是
存在透支 保护，则尝试用 overdraftProtection 得值来弥补该差值
（balance-amount）. 如果弥补该透支所需要的金额大于当前的保护级别。
则整个交易失败，但余 额未受影响。
6． 在主 exercise1 目录中，编译并执行 TestBanking 程序。输出应为：

Creating the customer Jane Smith.
Creating her Savings Account with a 500.00 balance and 3% interest.
 尚硅谷 Java 基础实战—Bank 项目 
Creating the customer Owen Bryant.
Creating his Checking Account with a 500.00 balance and no 
overdraft protection.
Creating the customer Tim Soley.
Creating his Checking Account with a 500.00 balance and 500.00 in 
overdraft protection.
Creating the customer Maria Soley.
Maria shares her Checking Account with her husband Tim.
Retrieving the customer Jane Smith with her savings account.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: false
Customer [Simms, Jane] has a balance of 324.88
Retrieving the customer Owen Bryant with his checking account with 
no overdraft protection.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: false
Customer [Bryant, Owen] has a balance of 324.88
Retrieving the customer Tim Soley with his checking account that 
has overdraft protection.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: true
Customer [Soley, Tim] has a balance of 0.0
Retrieving the customer Maria Soley with her joint checking account 
with husband Tim.
Deposit 150.00: true
Withdraw 750.00: false
Customer [Soley, Maria] has a balance of 150.0
```

# URM图
![图1](./images/UML.gif)
![图2](./images/关系图.JPG)
