package com.java.streamAPI;

import com.java.ref.Employee;
import com.java.ref.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream接口的终止操作
 *
 *
 */
public class StreamApiTest3 {
    private List<Employee> employeeList = EmployeeData.getEmployees();

    /**
     *  匹配与查找
     *
     *  boolean allMatch(Predicate<? super T> predicate);
     *      检查是否匹配所有的元素
     *
     *  boolean anyMatch(Predicate<? super T> predicate);
     *      检查是否至少匹配一个元素
     *
     *  boolean noneMatch(Predicate<? super T> predicate);
     *      检查是否没有匹配所有的元素
     *
     *  Optional<T> findFirst();
     *      返回第一个元素，若没有元素则返回一个空的Optional对象
     *
     *  Optional<T> findAny();
     *      返回当前流中的任意元素，若没有元素则返回一个空的Optional对象
     *      顺序流中查找的为第一个元素，
     *      并行流中查找的则不一定为第一个元素。对于同一个集合，基本上每次查找的都是同一个
     *  long count();
     *      返回流中元素的个数
     *
     *  Optional<T> max(Comparator<? super T> comparator);
     *      返回流中排序后的最大值元素
     *
     *  Optional<T> min(Comparator<? super T> comparator);
     *      返回流中排序后的最小值元素
     *
     *  void forEach(Consumer<? super T> action);
     *      内部迭代。
     *
     */
    @Test
    public void test1() {
        // boolean allMatch(Predicate<? super T> predicate)
        // 是否所有的员工年龄都大于18
        boolean b = employeeList.stream().allMatch(e -> e.getAge()>18);
        System.out.println("allMatch: ");
        System.out.println(b);
        System.out.println();

        // boolean anyMatch(Predicate<? super T> predicate);
        // 是否存有员工的工资大于6000
        boolean anyMatch = employeeList.parallelStream().anyMatch(e -> e.getSalary() > 6000);
        System.out.println("anyMatch: ");
        System.out.println(anyMatch);
        System.out.println();

        // boolean noneMatch(Predicate<? super T> predicate);
        // 是否不存在姓"雷"的员工
        boolean noneMatch = employeeList.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println("noneMatch: ");
        System.out.println(noneMatch);
        System.out.println();

        // Optional<T> findFirst();
        // 查找第一个员工姓名
        Optional<Employee> employee = employeeList.stream().findFirst();
        System.out.println("Optional<T> findFirst(), 查找第一个员工姓名");
        System.out.println(employee);
        System.out.println();

        // Optional<T> findAny();
        // 查找任意一个员工
        Optional<Employee> employee1 = employeeList.parallelStream().findAny();
        System.out.println("findAny(), 查找任意一个员工: ");
        System.out.println(employee1);
        System.out.println();

        // long count();
        System.out.println("count(): ");
        System.out.println(employeeList.parallelStream().count());
        System.out.println();

        // Optional<T> max(Comparator<? super T> comparator);
        // 练习：返回最高的工资
        System.out.println("max(Comparator<? super T> comparator), 返回最高的工资: ");

        Optional<Double> maxSalary = employeeList.stream().map(Employee::getSalary).max((d1, d2) -> Double.compare(d1, d2));
        System.out.println(maxSalary.get());
        System.out.println();

        // Optional<T> min(Comparator<? super T> comparator);
        // 练习：返回工资最低的员工
        Optional<Employee> minSalaryEmployee = employeeList.parallelStream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("min(Comparator<? super T> comparator), 工资最低的员工: ");
        System.out.println(minSalaryEmployee);
        System.out.println();


        // void forEach(Consumer<? super T> action);
        employeeList.stream().forEach(System.out::println);
        System.out.println();

        // 使用集合的迭代器，这个与Stream接口的forEach方法不一样
        employeeList.forEach(System.out::println);
    }

    /**
     * 归约
     *
     * T reduce(T identity, BinaryOperator<T> accumulator);
     *      可以将流中的元素反复结合起来，得到一个值。返回T
     *      identity: 初始值
     *      sum、min、max、average和string连接都是归约的特殊情况
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     *      可以将流中的元素反复结合起来，得到一个值。返回Optinal<T>
     *
     * <U> U reduce(U identity,
     *                  BiFunction<U, ? super T, U> accumulator,
     *                  BinaryOperator<U> combiner);
     *
     */
    @Test
    public void test2() {
        // T reduce(T identity, BinaryOperator<T> accumulator);
        // 练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer i = list.stream().reduce(0, (i1, i2) -> i1 + i2);
        System.out.println("T reduce(T identity, BinaryOperator<T> accumulator), 计算1-10的自然数的和: ");
        System.out.println(i);
        System.out.println();

        // Optional<T> reduce(BinaryOperator<T> accumulator);
        // 练习：计算公司所有员工工资的总和
        Stream<Double> salaryStream = employeeList.parallelStream().map(Employee::getSalary);
        Optional<Double> salarySum = salaryStream.reduce((d1, d2) -> d1 + d2);
//        Optional<Double> salarySum = salaryStream.reduce(Double::sum); // 也可以
        System.out.println("Optional<T> reduce(BinaryOperator<T> accumulator), 计算公司所有员工工资的总和: ");
        System.out.println(salarySum.get());

    }

    /**
     * 收集
     *
     *  <R, A> R collect(Collector<? super T, A, R> collector);
     *      将流转换为其他形式。接收一个Collector接口的实现实例，用于给Stream中元素做收集的方法
     *      Collector接口实现实例的方法决定了如何对流执行收集操作（如收集到List、Set、Map）
     *      另外，Collectors实现类提供了很多静态方法，可以方便地创建常见收集器实例
     *
     *  <R> R collect(Supplier<R> supplier,
     *                   BiConsumer<R, ? super T> accumulator,
     *                   BiConsumer<R, R> combiner);
     */
    @Test
    public void test3() {
        // <R, A> R collect(Collector<? super T, A, R> collector);
        // 练习：查找公司内工资大于6000的员工，结果返回为一个List或Set
        List<Employee> collectList = employeeList.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        System.out.println(collectList);
        System.out.println();

        Set<Employee> collectSet = employeeList.parallelStream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        System.out.println(collectSet);
    }
}
