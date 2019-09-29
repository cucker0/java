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
    * 接口的默认方法
* Optional类
* 新的时间API
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

# Java8新特性简介
Java 8 (又称为 jdk 1.8) 是 Java 语言开发的一个主要版本，  
Java 8 是oracle公司于2014年3月发布

* 速度更快
* 代码更少(增加了新的语法:Lambda表达式)
* 强大的|Stream API
* 便于并行
* 最大化减少空指针异常:Optional类
* Nashorn引擎，允许在JVM上运行JavaScript应用

# Stream的并行流与串行流
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
创建一个实现函数式接口的匿名内部类的实例，函数式接口就是有且仅有一个抽象方法的接口  
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

[Stream接口详情](./Stream接口.md)  

## Stream与Collection集合区别
* Stream关注的是对数据的运算，与CPU打交道
* Collection集合关注的是数据的存储，与内存打交道。Collection集合是静态的内存数据

## Stream特点
* Stream 自己不会存储元素
* Stream不会改变源对象。相反的，它们会返回一个包含结果的新Stream
* Stream 操作是延迟的。即它们会等到需要结果的时候才会执行

## Stream执行流程
1. Stream的实例化
>通过一个数据源对象(集合、数组等)，获取一个流，以及其他方式
2. 中间操作
>一个中间操作链，一系列操作(过滤、映射 ...)，对数据源的数据进行处理
3. 终止操作
>一旦执行终止操作，就执行中间操作链，并产生结果。之后，这个Stream对象不能再被使用

## Stream实例化的几种方式
* 方式1：通过集合的默认方法
```text
    Stream<Employee> stream = employeeList.stream();
```

* 方式2：通过数组Arrays类的默认方法(只适用于顺序流)
```text
    int[] arr = new int[]{3, 1, 4, 7};

    // 调用Arrays类的public static <T> Stream<T> stream(T[] array): 返回一个流
    IntStream intStream = Arrays.stream(arr);
    
    // default Stream<E> parallelStream(): 返回一个并行流
    Stream<Employee> parallelStream = employeeList.parallelStream();
```

* 方式3：通过Stream接口的of()方法
```text
/**
 * 创建Stream对象方式3：通过Stream接口的of()方法
 *
 * public static<T> Stream<T> of(T t)
 */
@Test
public void test3() {
    Stream<Integer> stream = Stream.of(13, 13, 1, 3, 5);

}
```

* 方式4：创建无限流
```text
/**
 * 创建Stream对象方式4：创建无限流
 *
 * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
 * public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
 * public static<T> Stream<T> generate(Supplier<? extends T> s)
 */
@Test
public void test4() {
    // 迭代
    Stream<Integer> stream = Stream.iterate(0, t -> t + 2);
//        iterate.forEach(System.out::println); // 无限打印下去

    // 遍历前10个元素
    stream.limit(10).forEach(System.out::println);
    System.out.println();


    // 生成
    Stream<Double> stream1 = Stream.generate(Math::random);
//        stream1.forEach(System.out::println); // 不停遍历下去
    stream1.limit(5).forEach(System.out::println);

}
```

## 顺序流与并行流的互转
* parallel()
```
把此Stream流转成并行流
```

* sequential()
```text
把此Stream流转成顺序流
```

### Stream实例化示例
[StreamApiTest](./src/com/java/streamAPI/StreamApiTest.java)  


## Stream接口的中间操作
* 筛选与切片
```text
Stream<T> filter(Predicate<? super T> predicate);
     接收一个判定型的lambda表达式，从流中筛选出符合条件的元素。
     
Stream<T> limit(long maxSize);
     截断流，截断流后的长度不超过maxSize（包含等于），相当于返回取流中的前maxSize个元素组成的流，元素不够不报错

Stream<T> skip(long n);
     跳过流前面的n个元素，返回由剩下的元素组成的流。如果元素个数<=n，则返回一个空元素Stream对象
     与Stream<T> limit(long maxSize)互为把相反操作

Stream<T> distinct();
     去重，返回去除了重复元素之后组成的流
```

* 映射
```text
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
    接收一个函数作为参数，将元素转换成其他形式或提取信息。map方法会自动遍历所有的元素，该函数会被应用到每个元素上，并将其映射成一个新的元素，一一对应
    类似于test3()中的list1.add(list2);

<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
    接收一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有流连接成一个流
    类似于下面 test4()中的list1.addAll(list2);
     
IntStream mapToInt(ToIntFunction<? super T> mapper)
    接收一个函数作为参数，函数mapper应用到每个元素上，产生一个新的IntStream流
    
LongStream mapToLong(ToLongFunction<? super T> mapper)
    接收一个函数作为参数，函数mapper应用到每个元素上，产生一个新的LongStream流
    
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
    接收一个函数作为参数，函数mapper应用到每个元素上，产生一个新的DoubleStream流

```

* 排序
```text
Stream<T> sorted();
     自然排序。
     只对顺序流有效，对于parallelStream并行流无效

Stream<T> sorted(Comparator<? super T> comparator);
     定制排序
     只对顺序流有效，对于parallelStream并行流无效
```

### Stream接口的中间操作示例
[StreamApiTest2](./src/com/java/streamAPI/StreamApiTest2.java)

## Stream接口的终止操作
* 匹配与查找
```text
boolean allMatch(Predicate<? super T> predicate);
    检查是否匹配所有的元素

boolean anyMatch(Predicate<? super T> predicate);
    检查是否至少匹配一个元素

boolean noneMatch(Predicate<? super T> predicate);
    检查是否没有匹配所有的元素

Optional<T> findFirst();
    返回第一个元素，若没有元素则返回一个空的Optional对象

Optional<T> findAny();
    返回当前流中的任意元素，若没有元素则返回一个空的Optional对象
    顺序流中查找的为第一个元素，
    并行流中查找的则不一定为第一个元素。对于同一个集合，基本上每次查找的都是同一个

long count();
    返回流中元素的个数

Optional<T> max(Comparator<? super T> comparator);
    返回流中排序后的最大值元素

Optional<T> min(Comparator<? super T> comparator);
    返回流中排序后的最小值元素

void forEach(Consumer<? super T> action);
    内部迭代。(使用Collection接口的forEach，需要用户去做迭代，称为外部迭代)    
```

* 归约
```text
T reduce(T identity, BinaryOperator<T> accumulator);
     可以将流中的元素反复结合起来，得到一个值。返回T
     identity: 初始值
     sum、min、max、average和string连接都是归约的特殊情况

Optional<T> reduce(BinaryOperator<T> accumulator);
     可以将流中的元素反复结合起来，得到一个值。返回Optinal<T>

<U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
```

* 收集
```text
<R, A> R collect(Collector<? super T, A, R> collector);
    将流转换为其他形式。接收一个Collector接口的实现实例，用于给Stream中元素做收集的方法
    Collector接口实现实例的方法决定了如何对流执行收集操作（如收集到List、Set、Map）
    另外，Collectors实现类提供了很多静态方法，可以方便地创建常见收集器实例

    例如：把list中的员工信息转换成以id为key，Employee对象为值的Map中
    Function<Employee, Integer> keyMapper = Employee::getId;
    Function<Employee, Employee> valueMapper = e -> e;
    Map<Integer, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(keyMapper, valueMapper));
    employeeMap.forEach((k, v) -> System.out.println(String.format("key:%s, value:%s", k, v)));


<R> R collect(Supplier<R> supplier,
                 BiConsumer<R, ? super T> accumulator,
                 BiConsumer<R, R> combiner);
```

### Stream接口的终止操作示例
* 匹配与查找  
[StreamApiTest3 test1()](./src/com/java/streamAPI/StreamApiTest3.java)

* 归约  
[StreamApiTest3 test2()](./src/com/java/streamAPI/StreamApiTest3.java)

* 收集  
[StreamApiTest3 test3()](./src/com/java/streamAPI/StreamApiTest3.java)


## Collectors类
Collectors实用类提供了很多静态方法，可以方便地创建常见收集器实例


[Collectors类详情](./Collectors类.md)  

### Collectors常用方法
* static <T> Collector<T,​?,​List<T>> toList() 
>把流中的元素收集到List中，返回一个Collector

* static <T> Collector<T,​?,​Set<T>> toSet() 
>把流中的元素收集到Set中，返回一个Collector

* static <T,​K,​U> Collector<T,​?,​Map<K,​U>> toMap​(  
                                                Function<? super T,​? extends K> keyMapper,   
                                                Function<? super T,​? extends U> valueMapper  
                                                ) 
>把流中的元素收集到Map中，返回一个Collector


# Optional类
只能存放一个元素的容器

使用场景：在程序中避免空指针异常

## Optional方法
```text

* 创建Optional类对象
public static<T> Optional<T> empty()
    创建一个空value值的Optional对象

public static <T> Optional<T> of(T value)
    创建指定值为value的Optional类对象
    value不能为null，为空时报空指针异常java.lang.NullPointerException

public static <T> Optional<T> ofNullable(T value)
创建指定值为value的Optional类对象
    value可以为null，此时Optional对象为空的Optional，不能使用get()取里面的值


* 获取Optional容器中的对象
public T orElse(T other)
    获取此Optional容器获取value值。如果此Optional容器的value属性(元素)不为null，则直接返回value，否则返回指定的对象other
    与ofNullable(T value)配合使用

public T get()
    获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException
    与of(T value)方法配合使用。
    必须确保value属性值不为空才能取到值。可以调用isPresent()或isEmpty()来判断value属性值是否为空

public T orElseGet(Supplier<? extends T> supplier)
    获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则执行已实现Supplier接口实例supplier的supplier.get()

public T orElseThrow()
    获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException
    与 get()等价


* 判断Optional容器中是否包含对象
public boolean isPresent()
    判断此Optional容器的value值是否存在，存在返回true，否则false。即判断value是否为null

public void ifPresent(Consumer<? super T> action)
    此Optional容器的value值存在，则执行实现Consumer接口实例action的action.accept(value)方法，否则不做任何处理

public boolean isEmpty()
    判断此Optional容器的value值是否为null。是返回true，否则false。
    与isPresent()方法取相反的值

```

## Optional示例
[OptionalTest](./src/com/java/optional/OptionalTest.java)

** 防止空指针的应用 **
```text
    /**
     * Optional防止空指针的应用
     * @param employee
     * @return
     */
    public String getEmployeeName3(Employee employee) {
        Optional<Employee> optional = Optional.ofNullable(employee);
        Employee e = optional.orElse(new Employee("刘一含"));
        return e.getName();
    }
```

# java8注解新特性
* 可重复的注解
* 可用于类型的注解
* 元注解@Target的参数类型ElementType枚举值多了两个：TYPE_PARAMETER,TYPE_USE
    * ElementType.TYPE_PARAMETER
        >表示该注解能写在类型变量的声明语句中（如：泛型声明）
    * ElementType.TYPE_USE
        >表示该注解能写在使用类型的任何语句中
* 在java 8之前，注解只能是在声明的地方使用，java 8 开始，@Target为ElementType.TYPE_USE注解可以用在任何地方

** 可重复的注解 **
```text
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotations {
    MyAnnotation[] value();
}

/**
 * 可重复的注解
 */
@Repeatable(Annotations.class) // 修饰class可重复
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
//    String[] value();

    // 也可以定义带默认值的
    String[] value() default {"hehe"};
}


// 重复的注解
@MyAnnotation("Hello")
@MyAnnotation("World")
class AnnotationTest {
    // 数据类型的注解
    public void show(@MyAnnotation("abc") String string) {
        System.out.println("show 方法...");
    }
}
```

** 可以用于注解类型 **
```text
@Target(ElementType.TYPE_PARAMETER)
public @interface MyAnnotation2 {

}


// 注解类型
class TypeDefine<@MyAnnotation2() U> {
    // 字段属性
    private U u;

    // 方法
    public <@MyAnnotation2() T> void test(T t) {
        System.out.println("test method..." + u);
        System.out.println(t);
    }
}
```

**  **
```text
@Target(ElementType.TYPE_USE)
public @interface MyAnnotation3 {

}


// 注解放任何地方
@MyAnnotation3
class TypeDefine2<U> {
    @MyAnnotation3 private String name;

    // 构造器
    public @MyAnnotation3 TypeDefine2() {
        super();
    }

    @MyAnnotation3 public TypeDefine2(String name) {
        this.name = name;
    }

    // 方法
    public static void getDesc() {
        TypeDefine2<@MyAnnotation3 String> t = null;
        int a = (@MyAnnotation3 int) 2L;
        int b = 10;
    }

    public static <@MyAnnotation3 T> void run(T t) {
        System.out.println(t);
    }

    public void speak(@MyAnnotation3 String str) throws @MyAnnotation3 Exception{
        System.out.printf("%s: %s", name, str);
    }
```

## java8注解新特性示例
[可重复的注解](./src/com/java/annotation/MyAnnotation.java)  
[可用于类型的注解](./src/com/java/annotation/MyAnnotation2.java)  
[解能写在使用类型的任何语句中](./src/com/java/annotation/MyAnnotation3.java)  
[AnnotationJava8Test](./src/com/java/annotation/AnnotationJava8Test.java)   


# java8接口的改进
从java8开始，接口可以添加默认方法、静态方法
* 默认方法
```text
默认方法使用default关键字修饰。可以通过实现类对象来调用。
不管写不写public修饰，都是public，修饰的
我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。
比如java 8 API中对Collection、List、Comparator等接口提供了丰富的默认方法
```

* 静态方法
```text
使用static关键字修饰。可以通过接口直接调用静态方法。
不管写不写public修饰，都是public，修饰的
我们经常在相互一起使用的类中使用静态方法。
你可以在标准库中找到像Collection、Collections、Path、Paths这样成对的接口和类
```
* 注意
```text
@interface 修饰的接口，不是声明了一个interface，它是注解，继承了java.lang.annotation.Annotation 接口

interface 修改的接口才是声明了一个interface

```

**接口默认方法与静态方法示例**

[MyInterface](./src/com/java/interfaceFeatures/MyInterface.java)
[MyInterfaceTest](./src/com/java/interfaceFeatures/MyInterfaceTest.java)

## 接口中默认方法的"类优先"原则
若一个接口中定义了一个默认方法，而另外一个父类或接口中又定义了一个同名的方法时

1. 选择父类中的方法
```text
果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略
```
2. 接口冲突
```text
如果一个父接口提供一个默认方法，
而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），
那么必须覆盖该方法来解决冲突
```

** 示例 **
[接口冲突示例](./src/com/java/interfaceFeatures/MyClass.java)


# 新的时间API
java 8 吸收了Joda-Time的精华，引入了java.time接口。java 8之前可以用第三方的Joda-Time。

java 8之前的日期时间API存在的问题：
* 可变性：像日期和时间这样的类应该是不可变的。即已经示例化的时间日期对象还能被更改
* 偏移性：Date中的年份是从1900开始的，而月份都从0开始
* 格式化：格式化只对Date有用，Calendar则不行
* 它们也不是线程安全的；不能处理闰秒等

## 新的时间类包结构
* java.time
>包含值对象的基础包
* java.time.chrono
>提供对不同的日历系统的访问
* java.time.format
>格式化和解析时间、日期
* java.time.temporal
>包括底层框架和扩展特性
* java.time.zone
>包含时区支持的类

* LocalDate
* LocalTime
* LocalDateTime
* Instant
* DateTimeFormatter
* 其他类

## LocalDate、LocalTime、LocalDateTime
* 这几个类是其中较重要的几个类，它们的实例是不可变的对象，  
它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区相关的信息
    * LocalDate：使用ISO-8601日历系统的日期
        >代表IOS格式（yyyy-MM-dd）的日期,可以存储生日、纪念日等日期
    * LocalTime：公历的时间
        >表示一个时间，而不是日期
    * LocalDateTime：公历的日期和时间
        >是用来表示日期和时间的，这是一个最常用的类之一
* 注：ISO-8601日历系统是国际标准化组织制定的现代公民的日期和时间的表示法，也就是公历。

## LocalDateTime类

[LocalDateTime类详细介绍](./LocalDateTime类.md)  

### LocalDateTime方法使用示例
[LocalDateTimeTest、时间格式化与解析](./src/com/java/time/LocalDateTimeTest.java)

## DateTimeFormatter格式化或解析日期、日间
[DateTimeFormatterTest](./src/com/java/time/DateTimeFormatterTest.java)

## Instant瞬时
时间线上的一个瞬时点。  
这可被用来记录应用程序中的事件时间戳

* 时间戳 
```text
在处理时间和日期的时候，我们通常会想到年,月,日,时,分,秒。
然而，这只是时间的一个模型，是面向人类的。

第二种通用模型是面向机器的，或者说是连 续的。
在此模型中，时间线中的一个点表示为一个很大的数，这有利于计算机处理。

在UNIX中，这个数从1970年开始，以秒为的单位；
同样的，在Java中，也是从1970年开始，但以毫秒为单位。
```

```text
java.time包通过值类型Instant提供机器视图，不提供处理人类意义上的时间单位。
Instant表示时间线上的一点，而不需要任何上下文信息，例如，时区。
概念上讲，它只是简单的表示自1970年1月1日0时0分0秒（UTC）开始的秒数。
因为java.time包是基于纳秒计算的，所以Instant的精度可以达到纳秒级
```
  
* 1ns = 10<sup>-9</sup>s
* 1秒 = 1000毫秒 = 10^6微秒 = 10^9纳秒
>1s = 1000ms = 10^6μs = 10^9ns

### Instant方法
* now(): 获取0时区的瞬时点(时间戳)
* atOffset(ZoneOffset offset)：添加时间偏移量
* toEpochMilli(long epochMilli)：获取纪元秒，即自1970-1-1 00:00:00 UTC开始的毫秒
* ofEpochSecond(long epochSecond)：根据指定纪元秒创建Instant实例
**Instant方法使用示例**  
[InstantTest](./src/com/java/time/InstantTest.java)

### Instant 与 LocalDateTime互转
```text
    public void test2() {
        // Instant 转 LocalDateTime
        Instant instant = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC+8"));

        System.out.println(instant);
        System.out.println(localDateTime);
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // LocalDateTime 转 Instant
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Instant instant1 = localDateTime1.toInstant(ZoneOffset.ofHours(+8));
        System.out.println("localDateTime1: " + localDateTime1);
        System.out.println("instant1: " + instant1);
    }
```


# ArrayList在java7和java8上的异同
* java 7中，ArrayList像饿汉式，直接创建一个初始容量为10的数组，存满了时再扩容，扩容为原来的1.5倍
* java 8中，ArrayList像懒汉式，一开始创建一个长度为0的数组，当添加第一元素时创建一个容量为10的数组,存满了再扩容，扩容为原来的1.5倍


# HashMap在java7和java8的实现原理
* HashMap在java7的实现原理
```text
HashMap map = new HashMap();
* 在实例化后，底层创建了一个长度为16的一维数组Entry[] table.
* map.put(key1, value1)
    * 首先调用key1所在类的hash(hashCode())计算key1哈希值，此哈希值通过某种算法(&(数组长度-1)运算)，得到Entry在数组中的存放位置。
    情况1：如果此位置上的数据为空，此时的key1-value1对添加成功
            如果此益上的数据不为空(即此位置上存在一个或多个数据[以链表形式存储])，
            此时key1和已经存在的一个或多个数据的哈希值进行比较：
    情况2：如果key1的哈希值与已经存在数据所哈希值都不相同，此时key1-value1添加成功
            如果key1的哈希值与已经存在数据(如key2-value2)的哈希值相同，继续比较：
            调用 key1.equals(key2)方法，
    情况3：如果比较结果为false，此时key1-value1添加成功
            如果比较结果为true，使用value1替换value2。即更新
    * 关于情况2、情况3，此时key1-value1和原来的数据以链表的方式存储
* 在不断添加元素的过程中，当超过临界值(且存放位置不为空，临界值为数组长度的0.75)，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原来的元素一个一个重新计算添加进来

```

* HashMap在java8的实现原理
```text
HashMap map = new HashMap();

* 执行new HashMap(), 底层没有创建一个长度为16的数组
* 首次调用public V put(K key, V value)方法时，底层以创建一个长度为16的Node[]数组，而非Entry[]数组
* 底层结构
    * java 7底层结构只有：数组 + 链表
    * java 8底层结构有：数组 + 链表 + 红黑树。
    * java 8在数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8，且当前数组的长度 > 64时，
    此时此索引位置上的所有数据改为使用红黑树存储
* 在不断添加元素的过程中，当超过临界值(且存放位置不为空，临界值为数组长度的0.75)，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原来的元素一个一个重新计算添加进来   

HashMap源码中的重要常量
DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
DEFAULT_LOAD_FACTOR：HashMap的默认加载因子
TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树：8
UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（当桶中Node的
数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行
resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍，即64）
table：存储元素的数组，总是2的n次幂
entrySet：存储具体元素的集
size：HashMap中存储的键值对的数量
modCount：HashMap扩容和结构改变的次数。
threshold：扩容的临界值，=容量*填充因子
loadFactor：填充因子
```

HashMap中的内部类：Node
```text
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next; 
}
```

LinkedHashMap中的内部类：Entry
```text
static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after; // 记录了前一个和后一个Entry
    Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
    } 
}
```

# Set结构
HashSet底层使用 HashMap 来保存所有元素，元素为key，值为HashSet类常量PRESENT,是一个Object常量

