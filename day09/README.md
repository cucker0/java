day09
==

# toString() 方法
* toString()方法在Object类中定义，其返回值是String类型，返回类名和它的引用地址
* 在进行String与其他类型数据的连接操作时，自动调用toString()方法
```java
    Date now = new Date();
    System.out.println("now = " + now);
    System.out.println("now = " + now.toString()); 
```
* 可以根据需要在用户自定义的类中重写toString()方法
```java
// 如String类重写了toString()方法，返回字符串的值
s1 = "hello";
System.out.println(s1); // 相当于System.out.println(s1.toString());

```
* 基本数据类型转换为String类型时，调用了对应包装类的toString()方法
    >int a = 10;  
    System.out.println("a = " + a);
    

