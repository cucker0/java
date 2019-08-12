/*
家庭记账增强版
==

# 目标
* 模拟实现一个基于文本界面的《家庭记账软件》
* 对输入的数据保存起来，下次启动程序还能读取历史记录
* 掌握初步的编程技巧和调试技巧
* 主要涉及以下知识点
    * 变量的定义
    * 基本数据类型的使用
    * 循环语句
    * 分支语句
    * 方法声明、调用和返回值的接收
    * 简单的屏幕输出格式控制

# 需求说明
* 模拟实现基于文本界面的《家庭记账软件》。
* 该软件能够记录家庭的收入、支出，并能够打印收支明细表。
* 项目采用分级菜单方式。主菜单如下：
```text
-----------------家庭收支记账软件-----------------
1 收支明细
2 登记收入
3 登记支出
4 显示余额
5 退 出
请选择(1-5)：


运行：javac -encoding utf-8 AccountingSystem.java &&  java AccountingSystem
* */

package com.java.www;

public class AccountingSystem {
    // 程序入口
    public static void main(String[] args) {
        Accounting accounting = new Accounting();
        accounting.selectMenu();

    }
}



