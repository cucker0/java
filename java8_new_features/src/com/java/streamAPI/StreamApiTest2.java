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
     *      与Stream<T> limit(long maxSize)互为把相反操作
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

    /**
     * 映射
     *
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     *      接收一个函数作为参数，将元素转换成其他形式或提取信息。map方法会自动遍历所有的元素，该函数会被应用到每个元素上，并将其映射成一个新的元素，一一对应
     *      类似于test3()中的list1.add(list2);
     *
     * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
     *      接收一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有流连接成一个流
     *      类似于下面 test4()中的list1.addAll(list2);
     */
    @Test
    public void test2() {
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        // 把列表中的每个元素转成大写
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map( str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();

        // 练习：获取员工姓名长度大于3的员工姓名
        Stream<String> namesSteam = employeeList.stream().map(e -> e.getName());
//        Stream<String> namesSteam = employeeList.stream().map(Employee::getName); // 也可以这样写，使用方法引用
        namesSteam.filter(e -> e.length() > 3).forEach(System.out::println);
        System.out.println();

        // 练习：map(Function mapper) 与 flatMap(Function mapper) 对比
        System.out.println("map(Function mapper): ");
        Stream<Stream<Character>> streamStream = list.stream().map(s -> stringToStream(s));
//        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiTest2::stringToStream); 也可以这样写
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println();

        // Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        System.out.println("flatMap(Function mapper): ");
        Stream<Character> characterStream = list.stream().flatMap(s -> stringToStream(s));
        characterStream.forEach(System.out::println);
    }

    /**
     * 将字符串的多个字符构成的集合List转换成对应的Stream实例
     * @param str
     *          字符串
     * @return 返回指定的字符串组成的List集合的Stream实例
     */
    public static Stream<Character> stringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList list2 = new ArrayList();
        list2.add(5);
        list2.add(6);
        list2.add(7);

        list1.add(list2);
        System.out.println(list1); // [1, 2, 3, [5, 6, 7]]
    }

    @Test
    public void test4() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList list2 = new ArrayList();
        list2.add(5);
        list2.add(6);
        list2.add(7);

        list1.addAll(list2);
        System.out.println(list1); // [1, 2, 3, 5, 6, 7]
    }


    /**
     * 排序
     *
     * Stream<T> sorted();
     *      自然排序。
     *      只对顺序流有效，对于parallelStream并行流无效
     *
     * Stream<T> sorted(Comparator<? super T> comparator);
     *      定制排序
     *      只对顺序流有效，对于parallelStream并行流无效
     *
     */
    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(22, 11, 33, 78, 99, 60, -1);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        list.parallelStream().sorted().forEach(System.out::println); // sorted()方法对并行流无效。
        System.out.println();

        // 将员工按年龄从小到大排序，如果年龄相等，则按工资从小到大排序
        employeeList.stream().sorted((e1, e2) -> {
            int i = e1.getAge() - e2.getAge();
            if (i == 0) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
            return i;
        }).forEach(System.out::println);
    }
}
