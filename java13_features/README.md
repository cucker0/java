java 13 新特性
==

# 新特性官方说明
https://openjdk.java.net/projects/jdk/13/

```text
Features
350:	Dynamic CDS Archives
351:	ZGC: Uncommit Unused Memory
353:	Reimplement the Legacy Socket API
354:	Switch Expressions (Preview)
355:	Text Blocks (Preview)
```

# 动态CDS归档
```text
扩展应用程序类数据共享，以允许在Java应用程序执行结束时动态归档类。
存档的类将包括所有加载的应用程序类和库类，这些类在默认的基础层cds存档中不存在
```

# 增强ZGC垃圾回收器，不提交未使用的内存
```text
增强zgc以将未使用的堆内存返回到操作系统
```

# 重新实现Socket API
```text
将java.net.socket和java.net.serversocket api使用的底层实现替换为更简单、更现代、易于维护和调试的实现。
新的实现将很容易适应用户轻量级模式线程，即纤线程(Fibers)。缘于目前正在探索的项目Fibers(https://openjdk.java.net/jeps/353)

```

# 增强switch表达式(预览功能)
```text
同java 12的需求功能，还未实现，仅为预览功能
```

# 文本块(预览功能)
```text
类似python的文本块功能。

文本块是一个多行字符串文本，它避免了大多数转义序列的需要，自动以可预测的方式格式化字符串，并在需要时让开发人员控制格式。

符号：
"""文本块
... ...
"""


示例：
// 目前多行字符串写法
String html = "<html>\n" +
              "    <body>\n" +
              "        <p>Hello, world</p>\n" +
              "    </body>\n" +
              "</html>\n";

// 文本块写法
String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
              
String query = """
               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
               WHERE `CITY` = 'INDIANAPOLIS'
               ORDER BY `EMP_ID`, `LAST_NAME`;
               """;
               
ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
Object obj = engine.eval("""
                         function hello() {
                             print('"Hello, world"');
                         }
                         
                         hello();
                         """);

```
