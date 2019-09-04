package com.java.optional;

import com.java.ref.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional类
 * 只能存放一个元素的容器
 * 使用场景：在程序中避免空指针异常
 *
 *      public static<T> Optional<T> empty()
 *          创建一个空value值的Optional对象
 *
 *      public static <T> Optional<T> of(T value)
 *          创建指定值为value的Optional类对象
 *          value不能为null，为空时报空指针异常java.lang.NullPointerException
 *
 *      public static <T> Optional<T> ofNullable(T value)
 *      创建指定值为value的Optional类对象
 *          value可以为null，此时Optional对象为空的Optional，不能使用get()取里面的值
 *
 *      public T orElse(T other)
 *          获取此Optional容器获取value值。如果此Optional容器的value属性(元素)不为null，则直接返回value，否则返回指定的对象other
 *          与ofNullable(T value)配合使用
 *
 *      public T get()
 *          获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException
 *          与of(T value)方法配合使用。
 *          必须确保value属性值不为空才能取到值。可以调用isPresent()或isEmpty()来判断value属性值是否为空
 *
 *      public T orElseGet(Supplier<? extends T> supplier)
 *          获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则执行已实现Supplier接口实例supplier的supplier.get()
 *
 *      public T orElseThrow()
 *          获取此Optional容器获取value值。如果此Optional容器的value属性值不为null，则直接返回value，否则抛出异常NoSuchElementException
 *          与 get()等价
 *
 *      public boolean isPresent()
 *          判断此Optional容器的value值是否存在，存在返回true，否则false。即判断value是否为null
 *
 *      public void ifPresent(Consumer<? super T> action)
 *          此Optional容器的value值存在，则执行实现Consumer接口实例action的action.accept(value)方法，否则不做任何处理
 *
 *      public boolean isEmpty()
 *          判断此Optional容器的value值是否为null。是返回true，否则false。
 *          与isPresent()方法取相反的值
 *
 */
public class OptionalTest {

    @Test
    public void test0() {
        Optional<String> optional = Optional.empty();

        System.out.println(optional);
    }

    /**
     * public static <T> Optional<T> of(T value)
     */
    @Test
    public void test1() {
        Employee e = new Employee();
        Optional<Employee> optional = Optional.of(e);
        System.out.println(optional);
        System.out.println();

        Employee e2 = null;
        Optional<Employee> optional2 = Optional.of(e2); // 报异常：java.lang.NullPointerException
        System.out.println(optional2);
    }

    @Test
    public void test2() {
        Employee e = new Employee();
        Optional<Employee> optional = Optional.ofNullable(e);
        System.out.println(optional);
        System.out.println();

        Employee e2 = null;
        Optional<Employee> optional2 = Optional.ofNullable(e2);
        System.out.println(optional2); // Optional.empty
    }

    /**
     * 获取指定员工的姓名
     *
     * @param employee
     *          指定的Employee对象
     * @return 返回指定员工的姓名
     */
    public String getEmployeeName(Employee employee) {
        return employee.getName(); // employee有可能为null
    }

    /**
     * 获取指定员工的姓名 优化版
     *
     * @param employee
     * @return
     */
    public String getEmployeeName2(Employee employee) {
        if (employee != null) {
            return employee.getName();
        }
        return null;
    }

    @Test
    public void test4() {
        Employee e = new Employee();
        System.out.println(getEmployeeName(e));

        e = null;
        System.out.println(getEmployeeName(e));
    }

    @Test
    public void test5() {
        Employee e = null;
        System.out.println(getEmployeeName2(e));
        System.out.println();

        //
        System.out.println(getEmployeeName3(null));

    }

    /**
     * public T orElse(T other)
     */
    @Test
    public void test6() {
        Employee e = null;
        Optional<Employee> optional = Optional.ofNullable(e);
        Employee e2 = optional.orElse(new Employee("刘一含"));
        System.out.println(e2);
        System.out.println();

        //
        e = new Employee("关婷娜");
        Optional<Employee> optional2 = Optional.ofNullable(e);
        // 此时的e3一定为非空
        Employee e3 = optional2.orElse(new Employee("刘一含"));
        System.out.println(e3);
    }

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
}
