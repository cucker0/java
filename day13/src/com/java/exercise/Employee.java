package com.java.exercise;

public class Employee implements Comparable{
    /*
    员工
    * */

    // 实例变量
    private String name;
    private int age;
    private MyDate birthday;

    // 构造器
    public Employee() {
        super();
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    // 方法
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "Employee{ " +
                " name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return birthday != null ? birthday.equals(employee.birthday) : employee.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            int i = name.compareTo(employee.name);
            if (i == 0) {
                i = age - employee.age;
            }
            return i;
        }
        return 0;
    }

}
