package com.java.pug;

public class TestStudentTeacher {
    public static void main(String[] args) {
        Student s1 =  new Student();
        Teacher t1 = new Teacher();

        s1.setName("熊二");
        s1.setAge(3);
        s1.walk();

        t1.setName("熊爸");
        t1.setAge(10);
        t1.walk();

        System.out.println("使用类的继承：");
        Student2 s2 = new Student2();
        Teacher2 t2 = new Teacher2();

        s2.setName("熊二");
        s2.setAge(3);
        s2.walk();

        t2.setName("熊爸");
        t2.setAge(10);
        t2.walk();

    }
}
