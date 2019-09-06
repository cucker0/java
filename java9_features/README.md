java 9新特性
==

# 新特性概览
```text
java 9 提供了超过150项新功能特性，
包括备受期待的模块化系统、
可交互的 REPL 工具：jshell，
JDK 编译工具，
Java 公共 API 和私有代码，
以及安全增强、扩展提升、性能管理改善等。
可以说 Java 9 是一个庞大的系统工程，完全做了一个整体改变
```

## 本章内容
* 模块华系统
* jShell命令
* 多版本兼容jar包
* 接口的私有化方法
* 钻石操作符(<>箭头操作符)的使用升级
* 语法改进:try语句
* 下划线使用限制
* String存储结构变更
* 便利的集合特性:of()
* 增强的Stream API
* 多分辨率图API
* 全新的HTTP客户端API
* Deparated的相关API
* 智能java编译工具
* 统一的JVM日志系统
* javadoc的HTML5支持
* javascript引擎升级:Nashorn
* java的动态编译器


# jdk9目录结构
[JDK9目录结构](images/JDK9目录结构.png)

```text
没有jre子目录了
bin: 包含所有命令。在windows平台上，它继续包含了系统的运行时动态链接库
conf: 包含用户可编辑的配置文件，例如以前位于jre/lib目录中的.properties和.policy文件
include: 包含编译本地代码使用的C/C+=头文件。它只存在于JDK中
jmods: 包含JMOD格式的平台模块。创建自定义运行时映像时需要它。它只存在于JDK中
legal: 包含法律声明
lib: 包含非windows平台上的动态链接本地库。其子目录和文件不应由开发员直接编辑或使用

```

# 模块化系统
Jigsaw项目后改名为Modularity，目的让java模块独立、化繁为简

* 模块(module)，本质就是在package外在包一层




