安装JDK
==

# Windows 安装JDK
* 下载相应的JDK包
* 解压JDK包到自定义目录
>例如：D:\java 专门存放JDK，jdk-12.0.1的解压到D:\java\jdk-12.0.1
* 设置系统环境变量


到www.oracle.com下载相应版本的JDK包
https://www.oracle.com/technetwork/java/javase/downloads/index.html
选择版本  
![选择版本](./images/jdk/selectJDKedit.png)

下载指定版本，这里下载zip版  
![下载指定版本](./images/jdk/downJDK.png)


JDK解压路径  
![](./images/jdk/jdkInstallPath.png)


设置系统环境变量  
![](./images/jdk/settingSystemPath.png)

变量名：JAVA_HOME  
变量值：D:\java\jdk-12.0.1  
![](./images/jdk/JAVA_HOME.png)

变量名：CLASSPATH  
变量值：.;%Java_Home%\bin;%Java_Home%\lib\dt.jar;%Java_Home%\lib\tools.jar  
![](./images/jdk/CLASSPATH.png)

修改Path，添加%JAVA_HOME%\bin; 并移至最前面  
![](./images/jdk/modifyPath.png)

