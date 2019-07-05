/*
自定义泛型类

* 构造器中不能使用泛型

* */

package com.java.www;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer<T> {
    private long id;
    private String name;
    private T t;
    private List<T> list = new ArrayList<>();

    // 构造器
    public Customer() {
        super();
    }

    /*
    构造器不能使用泛型，错误写法
    public Customer<T>(long id) {
        this.id = id;
    }
    */

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 方法
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getList() {
        return list;
    }

    public void add(T t) {
        list.add(t);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
/*
        泛型错误用法

        try {
            System.out.println("test");
        } catch (T e) { // 泛型不能用在catch中

        }
*/

        this.name = name;
    }
   /*
   静态方法中不能使用泛型
    public static void show(T t) {

    }
*/
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", t=" + t +
                ", list=" + list +
                '}';
    }

    // 声明泛型方法
    public <E> List<E> arrayToList(@NotNull E[] e) { // e不能为null
        /*
        数组转换成List并返回
        * */
        List<E> list = Arrays.asList(e);
        return list;
    }

    // 泛型方法
    public <F> void showSelf(F f) {
        System.out.println(f.toString());
    }
}

class SubCustomer extends Customer<Integer> { // 这里SubCustomer就不为泛型了，已经指定确定的类型

}

class SubCustomer2<T> extends Customer<T> { // SubCustomer2仍为泛型
    //构造器
    public SubCustomer2() {
        super();
    }

    public SubCustomer2(long id, String name) {
        super(id, name);
    }
    // 方法
    public String toString() {
        return "SubCustomer2{ " +
                super.toString() +
                " }";
    }
}