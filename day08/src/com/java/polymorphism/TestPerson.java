/*
类的特征三：多态
* 多态，可以理解为一个事物的多种表形形态
    * 方法的重载与重写
    * 子类对象的多态性
* 子类对象的多态性使用的前提条件：
    * 要有类的继承
    * 要有子类对父类方法的重写
* 程序运行分为编译状态和运行状态
    对于多态性来方法有如下规则
    * 编译时，"看左边的类型"，将此引用变量理解为父类的类型
    * 运行时，"看右边的类型"，关注于真实对象的实体：子类的对象实体。执行的方法就是子类的重写的方法
    * 此规则不适用于类的属性，属性还是都看左边

* instanceof
格式：对象a instanceof 类A
    判断对象a是否为类A的实例，是则返回true;否则返回false


* */

package com.java.polymorphism;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.walk();
        p1.watchtTv();

        System.out.println();
        Man m1 = new Man("古天乐", 49, "络腮胡");
        m1.walk();
        m1.watchtTv();
        m1.showMoustache();

        // 子类对象的多态性，父类的引用指向子类对象
        System.out.println();
        Person p3 = new Man("金庸", 94, "山羊胡"); // 向上转型
        // 虚拟方法的调用，通过父类的引用指向子类的对象实体，当调用方法时，实际执行的是子类重写父类的方法
        p3.walk();
        p3.watchtTv();
//        p3.showMoustache(); // 不能调用，编译时就不通过
        Person p4 = new Woman("杨采诗", 23, "空气刘海");
        p4.walk();
        p4.watchtTv();
//        p4.showHairStyle(); // 不能调用
        System.out.println("p4 id: " + p4.id); // 101 (Person类的)

        // 向下转型，这里使用强制类型转换
        Woman w1  = (Woman)p4;
        w1.showHairStyle();
        System.out.println("w1 id: " + w1.id); // 102 (Woman类的)

//        Woman w2 = (Woman)p3; // 运行时出错，Man类型实体强转 Woman
//        w2.showHairStyle();
//        Woman w3 = (Woman) new Man(); // 编译时直接出错

        // 可以使用映射判断
        if (p3 instanceof Woman) {
            System.out.println("p3 exchange to Woman");
            Woman w = (Woman)p3;
            w.showHairStyle();
        } else if (p3 instanceof Man) {
            Man m = (Man)p3;
            m.showMoustache();
        }

        if (p3 instanceof Person) {
            System.out.println(p3 + "为Person类的实例");
        }


    }
}
