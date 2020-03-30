IntelliJ IDE
==


## 字符集设置
建议选择UTF-8  
![](images/Intellij_IDE/字符集设置.png)

## 换行符设置
建议选择LF，即Unix and maxOS(\n)
![](images/Intellij_IDE/换行符设置.png)

## 显示行号
![](images/Intellij_IDE/显示行号.png)

## 字体、字体大小、行距设置
![](images/Intellij_IDE/字体、字体大小、行距设置.png)


## Tab键缩进大小设置
![](./images/Intellij_IDE/Tab键缩进大小设置.png)

## 文件模板设置
![](./images/Intellij_IDE/文件模板设置.png)

## 打开常见视图
![](./images/Intellij_IDE/常规视图.png)

## TortoiseGit设置不自动转换换行符
建议安装的git也不自动转换换行符，主要目的是换行符使用LF(\n)
```text
[core]
  autocrlf = false
```
![](./images/Intellij_IDE/TortoiseGit设置不自动转换换行符.png)

## IDEA设置JavaDOC注释的快捷键
* 方法1:Alt + Enter
```text
这时默认的

把光标停在类名或者方法名上(光标点一下，或选中它)，然后Alt + Enter，出现几个选项，选择Add Javadoc就OK了
```
 ![](./images/Intellij_IDE/addJavaDoc01.png)  
 
 * 设置自定义快捷键
 ```text
    我这里把他设置成Alt + M，你可以设置成其他的
 
Settings ->Keymap ->Other ->Fix doc comment ->右键 ->选择 Add Keyboard Shortcut， 然后输入自定义的快捷键Alt + M、
默认Fix doc comment是没有设置快捷键的

把光标停在类名或者方法名上这行上，然后Alt + Enter，出现几个选项，选择Add Javadoc就OK了
```

![](./images/Intellij_IDE/addJavaDoc02.png)  

## 查看类、接口的关系图，或查看modules模块关系图
```text
Ctrl + Alt + U
```

## 快速搜索
```text
双击 shift
```

## 常见异常与错误
### Error:java: 错误: 不支持发行版本 12
```text
多半是Project与Modules的jdk版本不一致导致的，如下的示例就会导致这种错误

值需要把Project与Modules的jdk版本设置为一致就可以
```
![](./images/Intellij_IDE/异常1.png)  

![](./images/Intellij_IDE/异常2.png)  


## 编程建议字体
```
优点：L1l0oO"'等字符的辨识度高
Droid Sans Mono Slashed, 
Droid Sans Mono Dotted,
Source Code Pro,
```

* Droid Sans Mono Slashed

    ![](./images/Intellij_IDE/font_DroidSansMonoSlashed.png)

* Droid Sans Mono Dotted

    ![](./images/Intellij_IDE/font_DroidSansMonoDotted.png)
    
* Source Code Pro

    ![](./images/Intellij_IDE/font_SourceCodePro.png)
