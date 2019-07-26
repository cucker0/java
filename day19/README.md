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



