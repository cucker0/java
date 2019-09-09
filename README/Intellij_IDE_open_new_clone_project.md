clone或一个新的Interlij IDE项目到本地如何正常运行
==

# 步骤
* 设置src目录为Source Root
* 添加SDK
* 指定SDK和设置项目编译输出目录
* 导入其他的模块
* 这时候就可以选择.java文件点击 运行(Ctrl + Shift + F10)


## 具体操作
* 设置src目录为Source Root，设置后src目录会变浅蓝色  
* 如果没有src文件夹，手动创建即可。package只能在设置为Source Root的目录下创建  
![设置src目录为Source Root](images/Intellij_IDE/markDirectoryAs_SoucesRoot.png)

* 添加SDK，需要先安装好JDK，打开 Project Structure  
![add SDK](images/Intellij_IDE/addSDK.png)  

* 指定SDK和设置项目编译输出目录  
![copy path](images/Intellij_IDE/copyPath.png)  

![Project Structure](images/Intellij_IDE/setttingProjectStructure.png)  

![指定SDK和设置项目编译输出目录](images/Intellij_IDE/settingOutputAndPorjectSDK.png)  

* 如果项目中还建了其他模块(Module)的，则要导入
```text
如何判断有没有其他模块

看项目中第一层文件夹中有没有 .iml文件，若有则存在其他模块

```

** 导入module模块操作 **
![](./images/Intellij_IDE/import_Module01.png)  

![](./images/Intellij_IDE/import_Module02.png)  

![](./images/Intellij_IDE/import_Module03.png)  
