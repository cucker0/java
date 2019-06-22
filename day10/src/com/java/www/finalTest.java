/*
final  （最终的）
可以修饰类、属性、方法。不能修饰构造器
目的：禁止被修改

* final修饰的类
    这个类不能被继承。如String、StringBuffer、System类
* final修饰的方法。
    不能被重写
    功能确定不变的，就定义为final方法，如Object类中的getClass
    final于访问权限修饰符顺序可先可后，建议先权限修饰符，再final。如：public static void walk() { }
* final修饰的属性
    此属性就是常量。建议常量名字母全大写
    常量一旦初始化，就不能修改
    怎么赋值：可以显示的赋值、代码块、构造器，没有默认值。且必须先赋值再能使用
* static final修饰的变量：全局常量
    Math.PI
* final于finally、finalize()没有联系


* */

package com.java.www;

public class finalTest {
}

final class Nvwa {
    private String color;
    private double height;
    private boolean sex;
    private String nation;
}

class Animal {
    private String name;
    private final boolean status = true;
    private int age;
    protected final int legs;

    // 构造器
    public Animal() {
        super();
//        status = false; // 不能*/
        legs = 4;
    }

    // 方法
    public void shout() {
        System.out.println("叫");
    }

    public static void walk() {
        System.out.println("走");
    }
}

/*
class Yello extends Nvwa {

}
// 不能继承final修饰的类
*/

/*
class myString extends String {

}
// 不能继承final修饰的类
*/

class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪叫");
    }

    /* // final修饰的方法不能被重写
    public void walk() {

    }
    */
}


/*
public class Something {
    public int addOne(final int x) {
        return ++x; // 报错，不能再修改了
    }
}
*/

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }

    public void addOne(final Other o) { // final修饰的时对象的引用地址，只要引用地址值不变就可以
        o.i++;
    }
}

class Other {
    public int i;
}


