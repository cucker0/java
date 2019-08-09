classpath和jar
==


# 到底什么是classpath

在Java中，我们经常听到classpath这个东西。网上有很多关于“如何设置classpath”的文章，但大部分设置都不靠谱。  
classpath是JVM用到的一个环境变量，它用来指示JVM如何搜索class。  

因为Java是编译型语言，源码文件是.java，而编译后的.class文件才是真正可以被JVM执行的字节码。  
因此，JVM需要知道，如果要加载一个abc.xyz.Hello的类，应该去哪搜索对应的Hello.class文件。    

** 所以，classpath就是一组目录的集合，它设置的搜索路径与操作系统相关。 **

## 在Windows系统上，用;分隔，带空格的目录用""括起来，可能长这样：

```text
C:\work\project1\bin;C:\shared;"D:\My Documents\project1\bin"
```
## 在Linux系统上，用:分隔，可能长这样：

```text
/usr/shared:/usr/local/bin:/home/liaoxuefeng/bin
```

## 举例
现在我们假设classpath是.;C:\work\project1\bin;C:\shared，当JVM在加载abc.xyz.Hello这个类时，会依次查找：

<当前目录>\abc\xyz\Hello.class

C:\work\project1\bin\abc\xyz\Hello.class

C:\shared\abc\xyz\Hello.class

注意到.代表当前目录。如果JVM在某个路径下找到了对应的class文件，就不再往后继续搜索。如果所有路径下都没有找到，就报错。


# classpath的设定方法有两种

* 在系统环境变量中设置classpath环境变量，不推荐

* 在启动JVM时设置classpath变量，推荐

>我们强烈不推荐在系统环境变量中设置classpath，那样会污染整个系统环境。  
在启动JVM时设置classpath才是推荐的做法。  
实际上就是给java命令传入-classpath或-cp参数

## 启动JVM时设置classpath变量示例
```text
java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello
```
或者使用-cp的简写：
```text
java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello
```

* 没有设置系统环境变量，也没有传入-cp参数，那么JVM默认的classpath为.，即当前目录：
```text
java abc.xyz.Hello
```
上述命令告诉JVM只在当前目录搜索Hello.class。

在IDE中运行Java程序，IDE自动传入的-cp参数是当前工程的bin目录和引入的jar包。  

通常，我们在自己编写的class中，会引用Java核心库的class，例如，String、ArrayList等。这些class应该上哪去找？  

有很多“如何设置classpath”的文章会告诉你把JVM自带的rt.jar放入classpath，
但事实上，根本不需要告诉JVM如何去Java核心库查找class，JVM怎么可能笨到连自己的核心库在哪都不知道？

```text
不要把任何Java核心库添加到classpath中！JVM根本不依赖classpath加载核心库！
```

更好的做法是，不要设置classpath！默认的当前目录.对于绝大多数情况都够用了。

# jar包
如果有很多.class文件，散落在各层目录中，肯定不便于管理。如果能把目录打一个包，变成一个文件，就方便多了。

jar包就是用来干这个事的，它可以把package组织的目录层级，以及各个目录下的所有文件（包括.class文件和其他文件）都打成一个jar文件，这样一来，无论是备份，还是发给客户，就简单多了。

jar包实际上就是一个zip格式的压缩文件，而jar包相当于目录。如果我们要执行一个jar包的class，就可以把jar包放到classpath中：
```text
java -cp ./hello.jar abc.xyz.Hello
```
这样JVM会自动在hello.jar文件里去搜索某个类。

那么问题来了：如何创建jar包？

因为jar包就是zip包，所以，直接在资源管理器中，找到正确的目录，点击右键，在弹出的快捷菜单中选择“发送到”，“压缩(zipped)文件夹”，就制作了一个zip文件。然后，把后缀从.zip改为.jar，一个jar包就创建成功。

假设编译输出的目录结构是这样：

package_sample
└─ bin
   ├─ hong
   │  └─ Person.class
   │  ming
   │  └─ Person.class
   └─ mr
      └─ jun
         └─ Arrays.class
这里需要特别注意的是，jar包里的第一层目录，不能是bin，而应该是hong、ming、mr。如果在Windows的资源管理器中看，
应该长这样：
![](./images/other/classapth和jar包.png)
如果长这样：
![](./images/other/classapth和jar包2.png)

说明打包打得有问题，JVM仍然无法从jar包中查找正确的class，原因是hong.Person必须按hong/Person.class存放，而不是bin/hong/Person.class。

jar包还可以包含一个特殊的/META-INF/MANIFEST.MF文件，MANIFEST.MF是纯文本，可以指定Main-Class和其它信息。JVM会自动读取这个MANIFEST.MF文件，如果存在Main-Class，我们就不必在命令行指定启动的类名，而是用更方便的命令：
```text
java -jar hello.jar
```
jar包还可以包含其它jar包，这个时候，就需要在MANIFEST.MF文件里配置classpath了。

在大型项目中，不可能手动编写MANIFEST.MF文件，再手动创建zip包。Java社区提供了大量的开源构建工具，例如Maven，可以非常方便地创建jar包。

小结
JVM通过环境变量classpath决定搜索class的路径和顺序；

不推荐设置系统环境变量classpath，始终建议通过-cp命令传入；

jar包相当于目录，可以包含很多.class文件，方便下载和使用；

MANIFEST.MF文件可以提供jar包的信息，如Main-Class，这样可以直接运行jar包。