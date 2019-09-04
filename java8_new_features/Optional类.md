Optional类
==

# 构造器
构造器为私有的，无法直接调用

```text
    private Optional() {
        this.value = null;
    }
```

# 方法
大部分方法为static静态方法

```text
static <T> Optional<T> empty() 
Returns an empty Optional instance.
创建一个value值为null的Optional对象

static <T> Optional<T> of​(T value) 
Returns an Optional describing the given non-null value.
创建一个指定value属性值为给定值value的Optional对象，给定值value不能为null，否则报NullPointerException异常

static <T> Optional<T> ofNullable​(T value) 
Returns an Optional describing the given value, if non-null, otherwise returns an empty Optional.
创建一个指定value属性值为给定值value的Optional对象，给定值value可以为null

T get() 
If a value is present, returns the value, otherwise throws NoSuchElementException.
获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException

T orElse​(T other) 
If a value is present, returns the value, otherwise returns other.
获取此Optional容器获取value值。如果此Optional容器的value属性(元素)不为null，则直接返回value，否则返回指定的对象other
与ofNullable(T value)配合使用

T orElseGet​(Supplier<? extends T> supplier) 
If a value is present, returns the value, otherwise returns the result produced by the supplying function.
获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则执行已实现Supplier接口实例supplier的supplier.get()

T orElseThrow() 
If a value is present, returns the value, otherwise throws NoSuchElementException.
<X extends Throwable>
获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException
与 get()等价

T orElseThrow​(Supplier<? extends X> exceptionSupplier) 
If a value is present, returns the value, otherwise throws an exception produced by the exception supplying function.
获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则执行已实现Supplier接口实例supplier的supplier.get()

boolean isEmpty() 
If a value is not present, returns true, otherwise false.
判断此Optional容器的value值是否为null。是返回true，否则false。
与isPresent()方法取相反的值

boolean isPresent() 
If a value is present, returns true, otherwise false.

void ifPresent​(Consumer<? super T> action) 
If a value is present, performs the given action with the value, otherwise does nothing.
此Optional容器的value值存在，则执行实现Consumer接口实例action的action.accept(value)方法，否则不做任何处理

void ifPresentOrElse​(Consumer<? super T> action, Runnable emptyAction) 
If a value is present, performs the given action with the value, otherwise performs the given empty-based action.
此Optional容器的value值存在，则执行实现Consumer接口实例action的action.accept(value)方法，否则执行实现了Runnable接口实例emptyAction的emptyAction.run()方法

Optional<T> or​(Supplier<? extends Optional<? extends T>> supplier) 
If a value is present, returns an Optional describing the value, otherwise returns an Optional produced by the supplying function.
获取此Optional容器获取value值。如果此Optional容器的value属性(元素)不为null，则直接返回value，否则执行实现Supplier接口实例supplier的supplier.get()方法

<U> Optional<U> map​(Function<? super T,​? extends U> ) 
If a value is present, returns an Optional describing (as if by ofNullable(T)) the result of applying the given mapping function to the value, otherwise returns an empty Optional.
此Optional容器的value值存在，则返回 实现了Function接口实例mapper的mapper.apply(value)方法，否则放回一个空的Optional

Optional<T> filter​(Predicate<? super T> predicate) 
If a value is present, and the value matches the given predicate, returns an Optional describing the value, otherwise returns an empty Optional.

<U> Optional<U> flatMap​(Function<? super T,​? extends Optional<? extends U>> mapper) 
If a value is present, returns the result of applying the given Optional-bearing mapping function to the value, otherwise returns an empty Optional.

Stream<T> stream() 
If a value is present, returns a sequential Stream containing only that value, otherwise returns an empty Stream.

boolean equals​(Object obj) 
Indicates whether some other object is "equal to" this Optional.

int hashCode() 
Returns the hash code of the value, if present, otherwise 0 (zero) if no value is present.

String toString() 
Returns a non-empty string representation of this Optional suitable for debugging.
```