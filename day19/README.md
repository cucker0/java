day19 java反射机制
==

# 本章内容
* 理解Class类、实例化Class类对象、运行时类
* 创建运行时类的对象，获取该类的完整结构
* 通过反射调用类的指定方法、属性
* 动态代理、AOP


# java reflection
reflection(反射)被视为动态语言的关键，反射机制允许程序员在执行期间借助于reflection API
取得任何类的内部信息，并能直接操作任意对象的内部属性、方法

## 反射机制提供的功能
* 在运行时判断任意一个对象所属的类
* 在运行时构造任意一个类的对象
* 在运行时判断任意一个类所具有的成员变量和方法
* 在运行时调用任意一个对象的成员变量和方法
* 生成动态代理


## 反射相关的主要API
* java.lang.Class 一个类
* java.lang.reflect.Method 类的方法
* java.lang.reflect.Field 类的成员变量
* java.lang.reflect.Constructor 类的构造器

## Class类
* Object 类是所有类的根类，Object定义了下面这个方法
    >public final Class getClass()
* Class类是java反射的源头

* 正常方式
    >引入需要的"包类"名称 -> 通过 new实例化 -> 取得实例化的对象
* 反射方式
    >实例化对象 -> 对象.getClass() -> 得到完整的"包类"名称
* Class也是一个类
* Class对象只能有系统创建对象
* 一个类在JVM中有且只有一个Class实例
* 一个Class对象对应的是一个加载到JVM中的一个.class文件
* 每个类的实例都会记录自己是有哪个Class实例生成的
* 通过Class可以完整的得到一个类的完整结构

## Class类重用方法
* static Class forName(String name) 返回指定类名name的Class对象
* Object newInstance() 调用空参(或缺省)的构造器，返回Class对象的一个实例
* String getName() 返回此Class对象所表示的实体名称(类、接口、数组、基本类型或void)
* Class getSuperClass() 返回此Class对象的父类的Class对象
* ClassLoader getClassLoader() 返回此类的加载器
* Class getSuperclass() 返回此Class所表示的实体超类的Class
* Constructor[] getConstructors() 返回此对象对应类的所有构造器，以数组形式返回
* Field[] getDeclaredFields() 返回此对象对应类的声明的属性，Field[]
* Method getMethod(String name, Class... paramTypes) 返回此对象对象类形参为paramTypes 的方法

示例  
[Reflection2Test](./src/com/java/www/Reflection2Test.java)


## 获取类的Class实例
* 通过运行时类的对象，调用 对象.getClass()
```text
        Person p1 = new Person();
        // 获取对象的运行时类
        Class clazz = p1.getClass();
```
* 通过运行时类，调用 类.class
>Class<String> clazz2 = String.class;
* 通过Class的静态方法，调用 public Class Class.forName(String className),className必须是完整路径的
```text
        String className = "com.java.www.Person";
        Class clazz3 = null;
        try {
            clazz3 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz3.getName());
```
* 类加载器
```text
        ClassLoader loader = this.getClass().getClassLoader();
        try {
            Class clazz5 = loader.loadClass("java.lang.Math");
            System.out.println(clazz5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
```
示例  
[ReflectionTest test3](./src/com/java/www/ReflectionTest.java)


# JAVA类加载过程
当程序主动使用某个类时，如果该类还未被加载到内存中，则系统会通过如下三个步骤来对该类进行初始化。

![](./images/类的加载过程.png)  
![](./images/类的加载过程2.png)  

## ClassLoader
类加载器是用来把类(class)装载进内存的。JVM规范定义了两种类型的类加载器：启动类加载器(bootstrap)和
用户自定义加载器(user-define class loader)。JVM在运行时回产生3个类加载器组成的初始化加载器层次结构，如下：

Bootstrap ClassLoader 引导类加载器：用C++编写，是JVM自带的类加载器，负责java平台核心库，用来加载核心类库。访加载器无法直接获取  
Extension ClassLoader 扩展类加载器：负责jre/lib/ext 目录下的jar包或-D java.ext.dirs指定目录下的jar包载入工作库  
System ClassLoader 系统类加载器：负责java -classpath 或 -D java.class.path所指定的目录下的类与jar包载入工作，是最常用的加载器  

![](./images/ClassLoader.png)  

示例  
[ReflectionTest test4](./src/com/java/www/ReflectionTest.java)

### 类加载器一个主要方法
利用类加载器访问包内的文件，非根路径下的

[ReflectionTest test5](./src/com/java/www/ReflectionTest.java)


# 创建类对象并获取类的完整结构
Field、Method、Constructor、Supperclass、Interface、Annotation
* 实现的接口
    ```text
    public Class<?>[] getInterfaces()
    获取此对象所表示的类或接口实现的接口
  
    ```
* 所继承的父类
    ```text
    public Class<? Super T> getSuperclass()
    返回此Class所表示的实体(类、接口、基本数据类型)的父类的Class
    ```

* 全部的构造器
    * public Constructor<T>[] getConstructors()
    >返回此Class对象所表示的类的所有public构造器
    * public Constructor<T>[] getDeclaredConstructors()
    >返回此Class对象表示的类中声明的所有构造器，包括私有的
    
    ```text
    Constructor类中：
    取得修饰符：public int getModifiers()
    取得方法名称：public String getName()
    取得参数的类型：public Class<?>[] getParameterTypes()
    ```
    
* 全部的方法
    * 

## 通过反射调用类的完整结构







