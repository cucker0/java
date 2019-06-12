day08
==

# 四种访问权限修饰符
java权限修饰符private、缺省(不写)、protected、public置于类成员前面，用来限定对象对该
类对象成员的访问权限。

修饰符 |类内部 |同一个包 |子类 |任何地方 | 可修饰的成员
:---|--- |--- |--- |--- |--- 
private |yes | | | |属性、方法、构造器
default(缺省,不写)|yes |yes | | |属性、方法、构造器、<br><br>类
protected|yes |yes |yes | |属性、方法、构造器
public |yes |yes |yes |yes |属性、方法、构造器、<br><br>类

* 可以修饰class(类)的只有public、default
* public类可以在任何地方被访问
* default类只能被同一个包内部的类访问

