package com.java.streamAPI;

import com.java.ref.Employee;
import com.java.ref.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream接口的中间操作
 *
 *
 */
public class StreamApiTest2 {
    private List<Employee> employeeList = EmployeeData.getEmployees();

    /**
     * 筛选与切片
     *
     * Stream<T> filter(Predicate<? super T> predicate);
     *      接收一个判定型的lambda表达式，从流中筛选出符合条件的元素。
     *
     * Stream<T> limit(long maxSize);
     *      截断流，截断流后的长度不超过maxSize（包含等于），相当于返回取流中的前maxSize个元素组成的流，元素不够不报错
     *
     * Stream<T> skip(long n);
     *      跳过流前面的n个元素，返回由剩下的元素组成的流。如果元素个数<=n，则返回一个空元素Stream对象
     *
     * Stream<T> distinct();
     *      去重，返回去除了重复元素之后组成的流
     */
    @Test
    public void test1() {
        Stream<Employee> stream = employeeList.stream();

        // Stream<T> filter(Predicate<? super T> predicate)
        // 查询员工表中薪资大于7000的员工信息
        System.out.println("Stream<T> filter(Predicate<? super T> predicate): ");
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        // Stream<T> limit(long maxSize)
        // 取员工列表中的前3个员工
        System.out.println("\nStream<T> limit(long maxSize): ");
        employeeList.stream().limit(3).forEach(System.out::println);
        System.out.println();

        // Stream<T> skip(long n)
        // 取员工列表中第三名员工之后的所有员工信息
        System.out.println("\nStream<T> skip(long n): ");
        employeeList.stream().skip(3).forEach(System.out::println);


        //
        System.out.println("\nStream<T> distinct(): ");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 9876.12));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1004, "马化腾", 34, 6000.38));
        list.add(new Employee(1005, "马云", 12, 9876.12));

        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
    }
}
