/*
工厂方法设计模式(接口的应用)


* */

package com.java.www;

public class FactoryMethodTest {
    public static void main(String[] args) {
        iWorkFactory i1 = new StudentWorkFacory();
        iWorkFactory i2 = new TeacherWorkFactory();
        i1.getWork().doWork();
        i2.getWork().doWork();
    }
}

// factory 2
interface Work {
    void doWork();
}

class StudentWork implements Work{
    public void doWork() {
        System.out.println("学生做作业");
    }
}

class TeacherWork implements Work {
    public void doWork() {
        System.out.println("老师备课");
    }
}

// factory 1
interface iWorkFactory {
    Work getWork();
}

class TeacherWorkFactory implements iWorkFactory{
    public Work getWork() {
        return new TeacherWork();
    }
}

class StudentWorkFacory implements iWorkFactory {
    public Work getWork() {
        return new StudentWork();
    }
}




