package com.java.exercise;

import java.util.Comparator;

public class GenComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int i = o1.getBirthday().getYear() - o2.getBirthday().getYear();
        if (i != 0) {
            return i;
        }
        i = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
        if (i != 0) {
            return i;
        }
        i = o1.getBirthday().getDay() - o2.getBirthday().getDay();
        return i;
    }
}
