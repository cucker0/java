package com.java.exercise;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class EmployeeTest {
    @Test
    public void test1() {
        TreeSet<Employee> tset1 = new TreeSet<>();
        tset1.add(new Employee("Lucy", 19, new MyDate(2000, 1, 3)));
        tset1.add(new Employee("Harry", 18, new MyDate(2001, 12, 3)));
        tset1.add(new Employee("Eric", 23, new MyDate(1996, 6, 1)));
        tset1.add(new Employee("Epson", 15, new MyDate(2004, 10, 1)));
        tset1.add(new Employee("Leida", 11, new MyDate(2008, 1, 3)));

        for (Employee e : tset1) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        Comparator<Employee> comparator = new GenComparator();
        TreeSet<Employee> tset1 = new TreeSet<>(comparator);
        tset1.add(new Employee("Lucy", 19, new MyDate(2000, 1, 3)));
        tset1.add(new Employee("Harry", 19, new MyDate(2000, 1, 4)));
        tset1.add(new Employee("Eric", 23, new MyDate(1996, 6, 1)));
        tset1.add(new Employee("Epson", 15, new MyDate(2004, 10, 1)));
        tset1.add(new Employee("Leida", 11, new MyDate(2008, 1, 3)));

        Iterator<Employee> iterator = tset1.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            System.out.println(e);
        }

    }

}


