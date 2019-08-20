/**
 * 第一个测试程序
 *
 * @author cucker
 * @version v0.1
 */


/*
* 1.源文件后缀.java
* 2.源文件中可以有多个class声明的类
* 3.类中可以有主方法（即main()方法），其格式是固定的：public static void main(String[] args) {}
* 4.main是()方法是程序的入口，方法内是程序的执行部分
* 5.一个源文件中只能有一个声明为public的类，同时要求此类的类名与源文件名一致
* 6.每个语句都要以;结尾
* 7.执行过程 1>编译:javac {-encoding utf8} 源文件名，生效多个.class字节码文件，
*           2>运行:java 类名
* 8.生成文档说明：javadoc -encoding utf8 -d mydoc -author -version HelloJava.java ,java文档说明，以/** 开头的多文本注释
**/
public class HelloJava {

    public static void main(String[] args) {
        System.out.print("Hello Java");
    }

}

class Person {

}

class Car {

}