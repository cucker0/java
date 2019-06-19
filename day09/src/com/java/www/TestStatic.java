/*
static，可以修饰 属性、方法、代码块、内部类
* static修饰的属性（类变量）
    * 有该类创建的所有对象，都共用这个变量
    * 当其中一个对象修改了此属性，其他属性访问到该属性的结果也会改变。
    * 类变量在类加载时加载到内存，且只有一份数据
    * 静态的变量（类变量）访问方法之一："类.类变量"  ，建议使用这种，当"类.实例变量" 访问时会报错的
    * 类变量访问方法二："对象.类变量"
    * 类变量的加载早于对象
    *

* 实例变量
    非static修饰的属性变量
* 类变量
    static修饰的属性变量

* static修饰的方法（类方法）
    * 类方法在类在加载时一起加载
    * 可以通过"类.类方法" 调用，也可以"对象.类方法"，建议使用第一种
    * 静态方法可以可以调用静态属性和静态方法，但不能调用非静态的属性和非静态的方法

* 注意
    静态的结构(static的属性、方法、代码块、内部类)的生命周期要早于非静态的结构，被回收的时间要晚于非静态的结构
    静态方法里不能有this、super关键字
* */


package com.java.www;

public class TestStatic {
    public static void main(String[] args) {
        System.out.println(SportMan.nationality);

        SportMan m1 = new SportMan("丁俊晖", 32);
        SportMan m2 = new SportMan("谌龙", 30);
        System.out.println(m1);
        System.out.println(m2);

        m1.setAge(31);
        System.out.println(m1);
        System.out.println(m2);

        System.out.println(SportMan.getNationality());
        System.out.println(m1.getNationality());
        System.out.println(m1.nationality);
        m1.nationality = "中国";
        System.out.println(m1);
        System.out.println(m2);

        m2.showAddress();
        m2.showInfo();
        SportMan.showInfo();
    }
}

class SportMan {
    // 实例变量
    private String name;
    private int age;

    // 类变量
    static String nationality; // 国籍

    // 构造器
    public SportMan() {
        super();
    }

    public SportMan(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // 方法
/*    @Override
    public String toString() {
        return "SportMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/

    @Override
    public String toString() {
        return "SportMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
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

    public static String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality) {
        SportMan.nationality = nationality;
    }

    public void showAddress() {
        System.out.println("家住石沟");
    }

    public static void showInfo() {
//        System.out.println("name: " + this.name); // 编译报错，这时由于name属性的生命周期决定的
//        showAddress(); //
        System.out.println(nationality);
        System.out.println("绝招技能");
        drive();
    }

    public static void drive() {
        System.out.println("drive car");
    }
}