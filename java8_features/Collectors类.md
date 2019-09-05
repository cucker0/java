Collectors类
==

# 基本情况
位于java.util.stream包下

# 构造器
只有一个私有的构造器，无法直接调用

```text
private Collectors() { }
```


# 方法
大部分方法为static方法

```text
static <T> Collector<T,​?,​List<T>> toList() 
Returns a Collector that accumulates the input elements into a new List.
把流中的元素收集到List中，返回一个Collector

static <T> Collector<T,​?,​Set<T>> toSet() 
Returns a Collector that accumulates the input elements into a new Set.
把流中的元素收集到Set中，返回一个Collector

static <T,​K,​U>
Collector<T,​?,​Map<K,​U>> toMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper) 
Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.
把流中的元素收集到Map中，返回一个Collector

static <T> Collector<T,​?,​Double> averagingDouble​(ToDoubleFunction<? super T> mapper) 
Returns a Collector that produces the arithmetic mean of a double-valued function applied to the input elements.
计算流中元素的Integer属性的平均值

static <T> Collector<T,​?,​Double> averagingInt​(ToIntFunction<? super T> mapper) 
Returns a Collector that produces the arithmetic mean of an integer-valued function applied to the input elements.
计算流中元素的Double​属性的平均值

static <T> Collector<T,​?,​Double> averagingLong​(ToLongFunction<? super T> mapper) 
Returns a Collector that produces the arithmetic mean of a long-valued function applied to the input elements.
计算流中元素的Long属性的平均值

static <T,​A,​R,​RR>
Collector<T,​A,​RR> collectingAndThen​(Collector<T,​A,​R> downstream, Function<R,​RR> finisher) 
Adapts a Collector to perform an additional finishing transformation.
包裹林外一个收集器，对其结果转换函数

static <T> Collector<T,​?,​Long> counting() 
Returns a Collector accepting elements of type T that counts the number of input elements.
计算流中元素的个数

static <T,​A,​R>
Collector<T,​?,​R> filtering​(Predicate<? super T> predicate, Collector<? super T,​A,​R> downstream) 
Adapts a Collector to one accepting elements of the same type T by applying the predicate to each input element and only accumulating if the predicate returns true.

static <T,​U,​A,​R>
Collector<T,​?,​R> flatMapping​(Function<? super T,​? extends Stream<? extends U>> mapper, Collector<? super U,​A,​R> downstream) 
Adapts a Collector accepting elements of type U to one accepting elements of type T by applying a flat mapping function to each input element before accumulation.

static <T,​K>
Collector<T,​?,​Map<K,​List<T>>> groupingBy​(Function<? super T,​? extends K> classifier) 
Returns a Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function, and returning the results in a Map.
根据某属性值对流分组，属性为K,结果为T

static <T,​K,​D,​A,​M extends Map<K,​D>>
Collector<T,​?,​M> groupingBy​(Function<? super T,​? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,​A,​D> downstream) 
Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

static <T,​K,​A,​D>
Collector<T,​?,​Map<K,​D>> groupingBy​(Function<? super T,​? extends K> classifier, Collector<? super T,​A,​D> downstream) 
Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

static <T,​K>
Collector<T,​?,​ConcurrentMap<K,​List<T>>> groupingByConcurrent​(Function<? super T,​? extends K> classifier) 
Returns a concurrent Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function.

static <T,​K,​A,​D,​M extends ConcurrentMap<K,​D>>
Collector<T,​?,​M> groupingByConcurrent​(Function<? super T,​? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,​A,​D> downstream) 
Returns a concurrent Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

static <T,​K,​A,​D>
Collector<T,​?,​ConcurrentMap<K,​D>> groupingByConcurrent​(Function<? super T,​? extends K> classifier, Collector<? super T,​A,​D> downstream) 
Returns a concurrent Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.

static Collector<CharSequence,​?,​String> joining() 
Returns a Collector that concatenates the input elements into a String, in encounter order.
连接流中每个字符串

static Collector<CharSequence,​?,​String> joining​(CharSequence delimiter) 
Returns a Collector that concatenates the input elements, separated by the specified delimiter, in encounter order.

static Collector<CharSequence,​?,​String> joining​(CharSequence delimiter, CharSequence prefix, CharSequence suffix) 
Returns a Collector that concatenates the input elements, separated by the specified delimiter, with the specified prefix and suffix, in encounter order.

static <T,​U,​A,​R>
Collector<T,​?,​R> mapping​(Function<? super T,​? extends U> mapper, Collector<? super U,​A,​R> downstream) 
Adapts a Collector accepting elements of type U to one accepting elements of type T by applying a mapping function to each input element before accumulation.

static <T> Collector<T,​?,​Optional<T>> maxBy​(Comparator<? super T> comparator) 
Returns a Collector that produces the maximal element according to a given Comparator, described as an Optional<T>.
根据比较器选择最大值

static <T> Collector<T,​?,​Optional<T>> minBy​(Comparator<? super T> comparator) 
Returns a Collector that produces the minimal element according to a given Comparator, described as an Optional<T>.
根据比较器选择最小值

static <T> Collector<T,​?,​Map<Boolean,​List<T>>> partitioningBy​(Predicate<? super T> predicate) 
Returns a Collector which partitions the input elements according to a Predicate, and organizes them into a Map<Boolean, List<T>>.
根据true或false进行区分

static <T,​D,​A>
Collector<T,​?,​Map<Boolean,​D>> partitioningBy​(Predicate<? super T> predicate, Collector<? super T,​A,​D> downstream) 
Returns a Collector which partitions the input elements according to a Predicate, reduces the values in each partition according to another Collector, and organizes them into a Map<Boolean, D> whose values are the result of the downstream reduction.

static <T> Collector<T,​?,​Optional<T>> reducing​(BinaryOperator<T> op) 
Returns a Collector which performs a reduction of its input elements under a specified BinaryOperator.
利用BinaryOperator与流中元素逐个结合，从而归约成一个值

static <T> Collector<T,​?,​T> reducing​(T identity, BinaryOperator<T> op) 
Returns a Collector which performs a reduction of its input elements under a specified BinaryOperator using the provided identity.
从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成一个值

static <T,​U>
Collector<T,​?,​U> reducing​(U identity, Function<? super T,​? extends U> mapper, BinaryOperator<U> op) 
Returns a Collector which performs a reduction of its input elements under a specified mapping function and BinaryOperator.

static <T> Collector<T,​?,​DoubleSummaryStatistics> summarizingDouble​(ToDoubleFunction<? super T> mapper) 
Returns a Collector which applies an double-producing mapping function to each input element, and returns summary statistics for the resulting values.
收集流中Double属性的统计值

static <T> Collector<T,​?,​IntSummaryStatistics> summarizingInt​(ToIntFunction<? super T> mapper) 
Returns a Collector which applies an int-producing mapping function to each input element, and returns summary statistics for the resulting values.
收集流中Integer属性的统计值。如：平均值

static <T> Collector<T,​?,​LongSummaryStatistics> summarizingLong​(ToLongFunction<? super T> mapper) 
Returns a Collector which applies an long-producing mapping function to each input element, and returns summary statistics for the resulting values.
收集流中Long属性的统计值

static <T> Collector<T,​?,​Double> summingDouble​(ToDoubleFunction<? super T> mapper) 
Returns a Collector that produces the sum of a double-valued function applied to the input elements.
返回流中元素的Double属性求和

static <T> Collector<T,​?,​Integer> summingInt​(ToIntFunction<? super T> mapper) 
Returns a Collector that produces the sum of a integer-valued function applied to the input elements.
返回流中元素的整数属性求和

static <T> Collector<T,​?,​Long> summingLong​(ToLongFunction<? super T> mapper) 
Returns a Collector that produces the sum of a long-valued function applied to the input elements.

static <T,​R1,​R2,​R>
Collector<T,​?,​R> teeing​(Collector<? super T,​?,​R1> downstream1, Collector<? super T,​?,​R2> downstream2, BiFunction<? super R1,​? super R2,​R> merger) 
Returns a Collector that is a composite of two downstream collectors.

static <T,​C extends Collection<T>>
Collector<T,​?,​C> toCollection​(Supplier<C> collectionFactory) 
Returns a Collector that accumulates the input elements into a new Collection, in encounter order.

static <T,​K,​U>
Collector<T,​?,​ConcurrentMap<K,​U>> toConcurrentMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper) 
Returns a concurrent Collector that accumulates elements into a ConcurrentMap whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T,​K,​U>
Collector<T,​?,​ConcurrentMap<K,​U>> toConcurrentMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction) 
Returns a concurrent Collector that accumulates elements into a ConcurrentMap whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T,​K,​U,​M extends ConcurrentMap<K,​U>>
Collector<T,​?,​M> toConcurrentMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) 
Returns a concurrent Collector that accumulates elements into a ConcurrentMap whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T,​K,​U>
Collector<T,​?,​Map<K,​U>> toMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction) 
Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T,​K,​U,​M extends Map<K,​U>>
Collector<T,​?,​M> toMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) 
Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T> Collector<T,​?,​List<T>> toUnmodifiableList() 
Returns a Collector that accumulates the input elements into an unmodifiable List in encounter order.

static <T,​K,​U>
Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper) 
Returns a Collector that accumulates the input elements into an unmodifiable Map, whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T,​K,​U>
Collector<T,​?,​Map<K,​U>> toUnmodifiableMap​(Function<? super T,​? extends K> keyMapper, Function<? super T,​? extends U> valueMapper, BinaryOperator<U> mergeFunction) 
Returns a Collector that accumulates the input elements into an unmodifiable Map, whose keys and values are the result of applying the provided mapping functions to the input elements.

static <T> Collector<T,​?,​Set<T>> toUnmodifiableSet() 
Returns a Collector that accumulates the input elements into an unmodifiable Set.

```