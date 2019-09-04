Java 8新特性
==


# 本章内容
* Lambda表达式
* 函数式接口
* 方法引用/构造器引用
* Stream API
    * 并行流
    * 串行流
* 接口的增强
    * 接口的静态方法
    * 接口的莫仍方法
* Optional类
* 新的时间和日期API
* 其他新特性
    * 重复注解
    * 类型注解
    * 通用目标类型推断
    * JDK的更新
        * 集合的流式操作
        * 并发
        * Arrays
        * Number和Math
        * IO/NIO的改进
        * Reflection获取形参名
        * String: join()
        * Files
    * 新编译工具：jjs、jdeps
    * JVM中Metaspace取代PermGen空间


# 新的时间和日期API
* LocalDate
* LocalTime
* LocalDateTime
* Instant
* DateTimeFormatter
* 其他类


# Java 8新特性简介
Java 8 (又称为 jdk 1.8) 是 Java 语言开发的一个主要版本，  
Java 8 是oracle公司于2014年3月发布

* 速度更快
* 代码更少(增加了新的语法:Lambda表达式)
* 强大的|Stream API
* 便于并行
* 最大化减少空指针异常:Optional类
* Nashorn引擎，允许在JVM上运行JavaScript应用

## Stream的并行流与串行流
    并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
    相比串行流，并行流可以很大程度上提高程序的执行效率。
    
    Java 8中，Stream API可以通过 parallel()把此流转为并行流，sequential()把此流转为为顺序流。


# Lambda表达式
## 为什么使用Lambda表达式
```text
Lambda 可理解为一个匿名内部类的方法，
我们可以把 Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。
使用它可以写出更简洁、更灵活的代码。
作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。
```

举例：
```text
    /**
     * 实现接口的匿名内部类实例，之前的方式
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实例");
            }
        };

        Thread t = new Thread(runnable);
        t.start();

    }
```

```text
/**
     * Lambda表达式
     */
    @Test
    public void test2() {
//        Runnable runnable = () -> System.out.println("Hello Lambda");
        Runnable runnable = () -> System.out.println(String.format("%s: Hello Lambda", Thread.currentThread().getName()));

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();

    }
```

* 示例  
[LambdaTest](./src/com/java/www/LambdaTest.java)  

* Lambda表达式的使用示例
`(o1, o2) -> Integer.compare(o1, o2);`

## Lambda表达式格式
```text
->: lambda操作符(或叫箭头操作符)
->左边: lambda形参列表 (其实就是接口中的抽象方法的形参列表)
->右边: lambda体 (其实就是接口抽象方法的重写后的方法体)
```

## Lambda表达式的本质
创建一个实现函数式接口的匿名内部类的实例，  
所以Lambda表达式是对象

写lambda表达式时，要清楚要实现的函数式接口那个抽象方法的结构，方法名，形参列表，返回值

* 函数式接口的定义
只包含一个抽象方法的接口，称为函数式接口

## Lambda表达式的6种语法格式
* 语法格式1：无参, 无返回值
```text
        Runnable r2 = () -> System.out.println("菩提本无树,明镜亦非台;本来无一物,何处惹尘埃。");
        r2.run();
```

* 语法格式2：有一个参数，无返回值
```text
        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("一个是听的人信了，一个是说的人信了");
```

* 语法格式3：数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
```text
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("一个是听的人信了，一个是说的人信了");
        System.out.println("\n// --------------------\n");

        // Lambda 简化写法
        Consumer<String> consumer2 = (s) -> System.out.println(s);
```

* 语法格式4：Lambda 值需要一个参数时，参数的小括号可以省略
```text
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("千里冰封，万里雪飘。");
```

* 语法格式5：Lambda 需要两个或两个以上的参数，有多条执行语句，并且可以有返回值
```text
        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println("比较结果：" + comparator1.compare(10, 18));
```

* 语法格式6：当Lambda体只有一条语句时，若有return与大括号，可以一起省略，且这两者要么一起省略，要么一起保留
```text
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(33, 44));
        System.out.println("\n// --------------------\n");

        // Lambda 简略写法
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(33, 44));
```

** 语法格式总结 **
```text

->左边: Lambda 形参列表的参数类型可以省略(类型推断)
     如果lambda形参列表只有一个参数时，包裹形参列表的小括号()可以省略
     
->右边: Lambda体使用一对{ }包裹，
     如果lambda体只有一条语句时(包括只有一条return语句)，可以一起省略一对{ }和return关键字,
     这种情况下的{}与return要么一起省略，要么一起保留
```

示例  
[LambdaTest2](./src/com/java/www/LambdaTest2.java)


# 函数式(Functional)接口
* 只包含一个抽象方法的接口，称为函数式接口
* 你可以通过Lambda表达式来创建该接口的对象
（若Lambda表达式抛出一个受检异常(即：非运行时异常)，那么该异常需要在被实现的目标接口的抽象方法上进行声明）
* 我们可以在一个接口上使用@FunctionalInterface注解，
这样做可以检查它是否是一个函数式接口。
同时javadoc也会包含一条声明，说明这个接口是一个函数式接口
* 在java.util.function包下定义了Java8的丰富的函数式接口

## java内置的函数式接口

函数接口 |抽象方法 |备注
:---|:---|:---
消费型接口:Consumer\<T>       |void accept(T t) |
供给型接口:Supplier\<T>       |T get()
函数型接口:Function\<T, R>    |R apply(T t) | R为返回的类型
断定型接口:Predicate\<T>      |boolean test(T t) |
BiFunction\<T, U, R>          | R apply(T t, U u)               |Function的子接口，R为返回类型 |
UnaryOperate\<T>              | T apply(T t)                    |BiFunction的子接口 |
BinaryOperate\<T, T>          | T apply(T t1, T t2) |
BiConsumer\(T, U)             | void accept(T t, U u) |
BiPredicate\<T, U>            | boolean test(T t, U u) |
ToIntFunction\<T>             | int applyAsInt(T value) |
ToLongFunction\<T>            | long applyAsLong(T value); |
ToDoubleFunction\<T>          | double applyAsDouble(T value); |
IntFunction\<R>               | R apply(int value); |
LongFunction\<R>              | R apply(long value); |
DoubleFunction\<R>            | R apply(long value); |


举例  
```text
    /**
     * 根据给定的规则，过滤指定集合中字符串，并返符合条件的元素组成的新的集合。具体规则有Predicate的test方法决定
     * @param list
     *          指定的集合
     * @param predicate
     *          判断规则
     * @return 返符合条件的元素组成的新的集合
     */
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    /**
     * 过滤list中含"京"的元素
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "天津", "西京", "南京", "东京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        System.out.println("\n// --------------------\n");

        // lambda写法
        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);
    }
```

* 示例  
[LambdaTest3](./src/com/java/www/LambdaTest3.java)


# 方法引用
method references

* 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
* 格式：使用操作符"::" 将类(或对象) 与方法隔开。类::方法名，对象::方法名

## 方法引用的本质
方法引用可以看作是Lambda表达式深层次的表达
```text
方法引用本质就是lambada表达式，
lambda表达式作为实现函数式接口的匿名内部的实例，
所以方法引用也是实现函数式接口的匿名类的实例
```

## 方法引用三中使用情况
```text
情况1：	对象::非静态方法名
情况2：	类::静态方法名
情况3：	类::非静态方法名
```
* 方法引用的要求（正对情况1、情况2）
>要求函数式接口中抽象方法的形参列表、返回值类型 与 引用方法的形参列表、返回值类型要相同

例如：
```text
Consumer<String> con = (x) -> System.out.println(x);
// 等同于
Consumer<String> con1 = System.out::println;

// 因为：
Consumer中的void accept(T t)
PrintStream中的void println(T t) 把此方法当作实现了Consumer接口的方法

```

```text
/**
	 *  情况二：类::静态方法名
	 *
	 * Comparator中的int compare(T t1,T t2)
	 * Integer中的int compare(T t1,T t2)
	 */
	@Test
	public void test3() {
		Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(comparator.compare(90, 120));

		System.out.println("\n// --------------------\n");

		// 方法引用
		Comparator<Integer> comparator1 = Integer::compare;
		System.out.println(comparator1.compare(90, 120));
	}
```

```text
	/**
	 * 情况三：类::实例方法名
	 *
	 * Comparator中的int comapre(T t1,T t2)
	 * String中的int t1.compareTo(t2)
	 */
	@Test
	public void test5() {
		Comparator<String> comparator = (t1, t2) -> t1.compareTo(t2);
		System.out.println(comparator.compare("abc", "abd"));

		System.out.println("\n// --------------------\n");

		// 方法引用
		Comparator<String> comparator1 =  String::compareTo;
		System.out.println(comparator1.compare("abc", "abd"));
	}
```

## 方法引用示例
[MethodRefTest](./src/com/java/ref/MethodRefTest.java)


# 构造器引用
与方法引用类似，函数式接口中抽象方法的参数列表 与 构造器的参数列表一致  
Fcuntion的返回值为构造器所属类的类型

* 举例
```text
/**
     * 构造器引用
     * 空参构造器
     *
     * Supplier中的T get()
     * Employee 空参构造器: Employee(),  调用其空参构造器创建对象，Employee e = new Employee();
     */
    @Test
    public void test1(){
        // 创建一个 匿名内部类实现接口的对象
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier.get());

        System.out.println("\n// --------------------\n");

        // lambda写法
        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());
        System.out.println("\n// --------------------\n");

        // 构造器引用
        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());
    }
```

```text
/**
     * 构造器引用
     * 一个参数构造器
     *
     * Function中的R apply(T t)
     */
    @Test
    public void test2(){
        // lambda写法
        Function<Integer, Employee> func = id -> new Employee(id);

        System.out.println(func.apply(1001));
        System.out.println("\n// --------------------\n");

        // 方法引用写法
        Function<Integer, Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002));
	}
```

```text
/**
     * 构造器引用
     * 两个参数构造器
     *
     * BiFunction中的R apply(T t,U u)
     */
    @Test
    public void test3(){
        // lambda写法
        BiFunction<Integer, String, Employee> biFunction = (id, name) -> new Employee(id, name); // ->左边的(id, name)编译器使用类型推断，自动把类型补上
        Employee e = biFunction.apply(1003, "赵八");
        System.out.println(e);
        System.out.println("\n// --------------------\n");

        // 方法引用写法
        BiFunction<Integer, String, Employee> biFunction1 = Employee::new;
        Employee e1 = biFunction.apply(1003, "赵八");
        System.out.println(e1);
	}
```


## 数组引用
只适用于一维数组  
把数组看成时一个特殊的类，则写法与构造器引用一致

```text
/**
     * 数组引用
     *
     * Function中的R apply(T t)
     */
    @Test
    public void test4(){
        int[] iArr = new int[4];
        System.out.println(iArr.toString());
        System.out.println("\n// --------------------\n");

        // lambda写法
        Function<Integer, int[]> func2 = length -> new int[length];
        int[] i2= func2.apply(4);
        System.out.println(Arrays.toString(i2));
        System.out.println("\n// --------------------\n");

        // 数组引用写法，使用于一维数组
        Function<Integer, int[]> func3 = int[]::new;
        int[] i3 = func3.apply(4);
        System.out.println(Arrays.toString(i3));

        // String[][]
        String[][] ss = new String[2][3];
        BiFunction<Integer, Integer, String[][]> biFunction = (length1, length2) -> new String[length1][length2];
        String[][] ss1 = biFunction.apply(2, 3);
        System.out.print("[ ");
        for (String[] sArr : ss1) {
            System.out.print(Arrays.toString(sArr) + ", ");
        }
        System.out.print(" ]");

        // 二维数组的引用不适用了
//        BiFunction<Integer, Integer, String[][]> biFunction2 = String[][]::new;
    }
```

## 构造器引用示例
[ConstructorRefTest](./src/com/java/ref/ConstructorRefTest.java)  


# Stream API
用于操作数据源(集合、数组等)所生成的元素序列，提供了一种高效易用的处理数据方式  

* 作用：主要是对集合的计算操作，如查找、过滤、映射、归约等

## Stream与Collection集合区别
* Stream关注的是对数据的运算，与CPU打交道
* Collection集合关注的是数据的存储，与内存打交道。Collection集合是静态的内存数据

## Stream特点
* Stream 自己不会存储元素
* Stream不会改变源对象。相反的，它们会返回一个包含结果的新Stream
* Stream 操作是延迟的。即它们会等到需要结果的时候才会执行

## Stream 执行流程
1. Stream的实例化
>通过一个数据源对象(集合、数组等)，获取一个流，以及其他方式
2. 中间操作
>一个中间操作链，一系列操作(过滤、映射 ...)，对数据源的数据进行处理
3. 终止操作
>一旦执行终止操作，就执行中间操作链，并产生结果。之后，这个Stream对象不能再被使用


### 绘制流程图 Flowchart

```flow
st=>start: 用户登陆
op=>operation: 登陆操作
cond=>condition: 登陆成功 Yes or No?
e=>end: 进入后台

st->op->cond
cond(yes)->e
cond(no)->op
```
[========]

### 绘制序列图 Sequence Diagram

```seq
Andrew->China: Says Hello
Note right of China: China thinks\nabout it
China-->Andrew: How are you?
Andrew->>China: I am good thanks!
```