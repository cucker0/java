day12 异常处理
==

# 第二种异常处理方式：声明抛出异常
在方法的声明处，显式的抛出该异常对象的类型

* 如果一个方法中(包括编译、运行时)肯能出现某种异常，  
但是并不能确定如何处理这种异常，则此方法应显式的声明抛出异常，  
表明该方法将不对这些异常进行处理，而由该方法的调用者负责处理

* 在方法中声明用throws语句可以声明抛出异常的列表，  
throws的异常列表可以是方法中产生的异常类型，也可以是它的父类

* 格式：public void readFile() throws FileNotFoundException, IOException { }
* 当在此方法内部出现异常时，会抛出一个异常类的对象，抛给方法的调用者
* 异常对象可以逐层向上抛，一直到main方法中。在向上抛的时候，可以用try-catch-finally进行处理
* main()方法中抛出异常时到JVM中

示例
[Throws Exception](./src/com/java/www/ThrowsException.java)



## 重写方法声明抛出异常的原则
* 重写方法不能抛出比被重写方法范围更大的异常类型。  
在多态的情况下，对method()方法的调用时异常的捕获按照父类声明的异常处理

示例
[Throws Override 原则](./src/com/java/www/ThrowsOverrideTest.java)


# 手动抛出异常
* Java异常类对象除在程序执行过程中出现异常时由系统自动生成并抛出，也可根据需要人工创建并抛出。
    * 首先要生成异常类的对象，让后通过throw语句抛出异常对象
    >IOException e = new IOException();
    throw e;
    
    * 抛出的异常对象必须是Throwable或其子类的实例
    
java异常处理模型：抓抛模型
* 抓
    * try-catch-finally
    * throws 异常的类型列表  （在方法声明处，{ }前）
* 抛
    * 自动抛出
    * 手动抛出：throw 异常类的实例

[手动抛出异常](./src/com/java/www/ThrowTest.java)    


# 创建用户自定义的异常类
* 一般的，用户定义的异常类都是RuntimeException的子类
* 通常要编写几个重载的构造器
* 同样可以通过throw抛出自定义异常类的对象
* 自定义异常最重要的是异常类的名字，当异常出现时，可以根据名字判断异常类型

```java
class MyException extends Exception {
   	static final long serialVersionUID = 1L;
	private int idnumber;
 	public MyException(String message, int id) {
		super(message);
		this.idnumber = id;
 	} 
	public int getId() {
		return idnumber;
 	}
}

```

[自定义的异常类](./src/com/java/exercise/EcmDef.java)

## 异常处理5个关键字
抓
* try - catch - finally
* throws 异常类型列表  （方法声明处声明异常）

抛
* 自动
* thow 异常实例  （异常处）
