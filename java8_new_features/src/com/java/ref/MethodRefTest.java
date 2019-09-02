package com.java.ref;

import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;

/**
 * 方法引用的使用（Method References）
 *
 *
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 * 方法引用的本质：
 * 		方法引用本质就是lambada表达式，
 * 		lambda表达式作为实现函数式接口的匿名内部的实例，所以方法引用也是实现函数式接口的匿名类的实例
 *
 * 三中使用情况
 * 		情况1：	对象::非静态方法名
 * 		情况2：	类::静态方法名
 * 		情况3：	类::非静态方法名
 *
 * 方法引用的要求（正对情况1、情况2）
 * 		要求函数式接口中抽象方法的形参列表、返回值类型 与 引用方法的形参列表、返回值类型要相同
 *
 *
 */
public class MethodRefTest {


	/**
	 * 	情况一：对象::实例方法名
	 * 	Consumer中的void accept(T t)
	 * 	PrintStream中的void println(T t)
	 */
	@Test
	public void test1() {
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("枪杆子中出政权，不能让枪杆子指挥政权");

		System.out.println("\n// --------------------\n");

		// 方法引用
		PrintStream ps = System.out;
		Consumer<String> consumer1 = ps::println;
//		Consumer<String> consumer1 = System.out::println;

		consumer1.accept("只识弯弓射大雕");
	}

	/**
	 * 对象::实例方法名
	 *
	 * Supplier中的T get()
	 * Employee中的String getName()
	 */
	@Test
	public void test2() {
		Employee employee = new Employee(001, "mayun", 18, 8910);
		Supplier<String> supplier = () -> employee.getName();
		System.out.println(supplier.get());

		System.out.println("\n// --------------------\n");

		// 方法引用
		Supplier<String> supplier1 = employee::getName;
		System.out.println(supplier1.get());
	}

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

	/**
	 * 类::静态方法名
	 *
	 * Function中的R apply(T t)
	 * Math中的Long round(Double d)
	 */
	@Test
	public void test4() {
		Function<Double, Long> func = new Function<Double, Long>() { // Double: 参数类型，Long: 返回值类型
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble); // 左四舍五入
			}
		};

		System.out.println(func.apply(2.49));

		System.out.println("\n// --------------------\n");

		Function<Double, Long> func1 = d -> Math.round(d);
		System.out.println(func1.apply(2.49));

		System.out.println("\n// --------------------\n");

		// 方法引用
		Function<Double, Long> func2 = Math::round;
		System.out.println(func2.apply(2.49));
	}

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

	/**
	 * 类::实例方法名
	 *
	 * BiPredicate中的boolean test(T t1, T t2);
	 * String中的boolean t1.equals(t2)
	 */
	@Test
	public void test6() {
		String str1 = "abcd";
		String str2 = "abcd";
		BiPredicate<String, String> biPredicate = (t1, t2) -> t1.equals(t2);
		System.out.println(biPredicate.test(str1, str2));

		System.out.println("\n// --------------------\n");

		// 方法引用
		BiPredicate<String, String> biPredicate1 = String::equals;
		System.out.println(biPredicate1.test(str1, str2));
	}

	/**
	 * 类::实例方法名
	 *
	 * Function中的R apply(T t)
	 * Employee中的String getName(); // 相当于t为String
	 */
	@Test
	public void test7() {
		Employee ep = new Employee(201, "Tom", 33, 8000);
		Function<Employee, String> func = e -> e.getName();
		System.out.println(func.apply(ep));

		System.out.println("\n// --------------------\n");

		// 方法引用
		Function<Employee, String> func2 = Employee::getName;
		System.out.println(func2.apply(ep));
	}

}
