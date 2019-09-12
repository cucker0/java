java 10新特性
==

# 局部变量类型推断
## 适用情况
* 局部变量的初始化
```text
public void test1() {
        var num = 10;

        var list = new ArrayList<>(); // list元素的类型为Object
        var list2 = new ArrayList<Integer>(); // list元素的类型为Integer
        list2.add(78);
        System.out.println(list2);

        var arr = new int[]{1, 5, 8};
        System.out.println();
    }
```

* forEach增添循环
```text
    public void test2() {
        List<Integer> list = Arrays.asList(11, 22, 1, 33);
        for (var e : list) {
            System.out.println(e);
            System.out.println(e.getClass());
            System.out.println();
        }
    }
```

* for遍历
```text
    public void test3() {
        for (var i = 0; i < 10; ++i) {
            System.out.println(i);
        }

    }
```

## 不适用情况
* 变量初始值为null
* lambda表达式
* 方法引用中
* 为数组静态初始化
* 没有初始化的局部变量声明
* 方法的返回类型
* 方法的参数类型
* 构造器的参数类型
* 字段属性
* catch块中的异常类型


# 局部变量类型推断原理
```text
编译器在处理var标识时，先看表达式右边部分，并根据右边变量值的类型进行推断，
作为左边变量的类型，然后将该类型写入字节码中
```
* var不是一个关键字
```text
你不需要担心变量名或方法名会与var发生冲突，因为var实际上并不是一个关键字，而是一个类型名，
只有在编译器需要知道类型的地方才需要用到它。除此之外，它就是一个普通合法的标识符。
也就是说，除了不能用它作为类名，其他的都可以，但极少人会用它作为类名
```

* var不是javaScript中的var,不会改变java静态类型语言特性
```text
var并不会改变Java是一门静态类型语言的事实。编译器负责推断出类型，
并把结果写入字节码文件，就好像是开发人员自己敲入类型一样
```

# 集合新增创建不可变集合的方法
* static Xxx<E> copyOf(Collection<E> coll)
```text
根据集合创建只读集合对象，Xxx为List、Set、Map等
如果coll为只读集合，则直接返回coll
如果coll可读写集合，则根据coll元素调用of(T t)方法创建一个新的只读集合，不改变原来的coll
```
