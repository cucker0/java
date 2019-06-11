package com.java.exercise;

public class Mankind {
    private  int sex; // 1:man, 0: woman
    private int salary; // 薪水

    // 方法
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    void manOrWoman() {
        if (sex == 1) {
            System.out.println("man");
        } else if (sex == 0) {
            System.out.println("woman");
        } else {
            System.out.println("ladyboy"); // 人妖
        }
    }

    void employeed() {
        /*
        雇员
        * */
        if (salary == 0) {
            System.out.println("no job");
        } else if (salary > 0) {
            System.out.println("job");
        } else {
            System.out.println("excetions");
        }
    }
}
