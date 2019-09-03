package com.java.ref;

/**
 * @author shkstart 邮箱：shkstart@126.com
 */
public class Employee {
	// Field字段
	private int id;
	private String name;
	private int age;
	private double salary;

	// 构造器
	public Employee() {
		System.out.println("Employee() ...");
	}

	public Employee(int id) {
		this.id = id;
		System.out.println("Employee(int id) ...");
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Employee(int id, String name) ...");
	}

	public Employee(int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
//		System.out.println("Employee(int id, String name, int age, double salary) ...");
	}

	// 方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (age != employee.age) return false;
		return name != null ? name.equals(employee.name) : employee.name == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + age;
		return result;
	}
}
