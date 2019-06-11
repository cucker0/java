package com.java.exercise;

public class Kids extends Mankind {
    public static void main(String[] args) {
        Kids someKid = new Kids();
        System.out.println(someKid.getSex());
        System.out.println(someKid.getSalary());
        System.out.println(someKid.getClass());
        someKid.printAge();
        someKid.manOrWoman();
        someKid.employeed();

        System.out.println();
        someKid.setSex(1);
        someKid.setSalary(4800);
        someKid.setYearsOld(23);
        System.out.println(someKid.getSex());
        System.out.println(someKid.getSalary());
        someKid.manOrWoman();
        someKid.employeed();
        someKid.printAge();
    }

    private int yearsOld;

    // 构造器
    public Kids() {

    }

    public Kids(int sex, int salary, int yearsOld) {
        this.yearsOld = yearsOld;
        this.setSex(sex);
        this.setSalary(salary);
    }

    // 方法
    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge() {
        System.out.println(yearsOld);
    }

    void employeed() {
        System.out.println("Kids should study and no job.");
    }
}
