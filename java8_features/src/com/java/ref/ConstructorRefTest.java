package com.java.ref;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      与方法引用类似，函数式接口中抽象方法的参数列表 与 构造器的参数列表一致
 *      抽象方法的返回值为构造器所属类的类型
 *
 * 二、数组引用（只适用于一维数组）
 *      把数组看成时一个特殊的类，则写法与构造器引用一致
 */
public class ConstructorRefTest {
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
}
