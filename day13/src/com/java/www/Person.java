package com.java.www;

public class Person implements Comparable {
    private String name;
    private int age;

    // 构造器
    public Person () {}

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
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

    public String toString() {
        return "Person{ " +
                " name='" + name + '\'' +
                ", age=" + age +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
//            int i = this.name.compareTo(p.name);
            int i = age - p.age;
            if (i == 0) {
                i = name.compareTo(p.name);
            }
            return i;
        }
        return 0;
    }
}
