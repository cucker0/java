package com.java.www;

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.showInfo();
        s1.status();

        Student s2 = new Student("王小川", 31, "清华大学");
        s2.showInfo();
    }

}
