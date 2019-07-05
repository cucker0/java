/*
泛型

作用：限制为指定的数据类型，但未使用之前(实例化之前)又不能确定是哪种数据类型，在实例化时指定数据类型。

* 格式：<类型列表>, 如<Boolean>, <String, Integer>，可以写多个数据类型


## 集合中使用泛型
* 限制集合中只能添加指定类型的对象，添加其他类型的数据将报错
* 获取元素时，类型仍为集合限制的数据类型，不需要强制类型转换
* 非泛型的Collection 集合中的元素类型都为Object
* 非泛型的Iterator里的对象类型都为Object
* 非泛型的Map中key、value均为Object类型

## 自定义泛型类、泛型接口、泛型方法
* 当实例化泛型类的对象时，指明泛型类的类型，指明后，对应的类中所有使用泛型类的位置，都变为实例中指定的泛型类型
* 如果定义了泛型类，在实例化时没有指定泛型，默认类型为Object
* 静态方法中不能使用类的泛型，因为静态方法在类加载时就确定了
* catch的异常类型不能为泛型

## 泛型与继承的关系
* 子类不为泛型类：继承时指定父类泛型中的类型，例如class SubCustomer extends Customer<Integer> {}
* 子类仍为泛型类：继承时继承使用泛型，例如class SubCustomer2<T> extends Customer<T> {}

## 通配符




* */

package com.java.www;

import org.junit.Test;

import java.util.*;

public class GenericTest {
    @Test
    public void test1() {
        // 集合没有使用泛型的情况

        List list1 = new ArrayList(); // 元素类型为 Object，可以添加任何类型的数据
        list1.add(11);
        list1.add(22);
        list1.add(22);
        list1.add(null);
        list1.add("AA");
        list1.add(true);
/*
        for (Object o : list1) {
            System.out.println(o);
        }
        */

        for (int i = 0; i < list1.size(); ++i) {
            Object obj = list1.get(i);
            // 需要进行类型强转
            Integer n = (Integer) obj; // 当有元素不为int数据时(null除外)，报ClassCastException异常            System.out.println(n);
            System.out.println(n);
        }
    }

    @Test
    public void test2() throws RuntimeException {
        // 在集合中使用泛型
        List<Integer> list = new ArrayList<>(); // 此时list只能添加 Integer 元素
        List<Integer> list2 = new ArrayList<Integer>(); // 也可以这样写
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
//        list.add("QQ"); // 添加其他类型的报错

        for (int i = 0; i < list.size(); ++i) {
            int n = list.get(i);
            System.out.println(n);
        }

        System.out.println();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            System.out.println(n);
        }

    }

    @Test
    public void test3() {
        // Map中使用泛型
        HashMap<String, Integer> hmap1 = new HashMap<>(); // 等价于 HashMap<String, Integer> hmap1 = new HashMap<String, Integer>();
        hmap1.put("李连杰", 1963);
        hmap1.put("赵文卓", 1972);
        hmap1.put("李小龙", 1940);

        Set<Map.Entry<String, Integer>> entrys = hmap1.entrySet();
        for (Map.Entry<String, Integer> entry : entrys) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.printf("姓名：%s \t出生年份：%d年\n", k, v);
        }
    }

    @Test
    public void test4() {
        // 自定义泛型类 测试
        Customer<Character> c1 = new Customer<>(10001, "三星");
        c1.setT('B');
        System.out.println(c1.getT());
        c1.add('C');
        c1.add('D');
        c1.add('A');
//        c1.add("GG"); // 与前面指定的类型不匹配，编译不通过
        System.out.println(c1.getList());
        System.out.println();

        // 泛型方法 测试
        c1.showSelf(new Date());
        Integer[] iarr = new Integer[]{11, 22, 33, 44, 55};
        List<Integer> li = c1.arrayToList(iarr);
        System.out.println(li);
    }

    @Test
    public void test5() {
        // 泛型继承关系 测试
        SubCustomer2<String> subc1 = new SubCustomer2<>(2001, "华为公司");
        subc1.setT("我把泛型指定为String了");
        subc1.add("Monday");
        subc1.add("Tusday");
        subc1.add("Wednesday");
        subc1.add("Thursday");
        subc1.add("Friday");
        subc1.add("Seturday");
        subc1.add("Sunday");
//        subc1.add(33);

        System.out.println(subc1);
    }

    @Test
    public void test6() {
        /*
        DAO模拟测试
        * */
        DAO<Student> dao = new DAO<>();
        Student s1 = new Student("Mary", "mary@gmail.com", new MyDate(1999, 2, 1));
        Student s2 = new Student("Rucy", "rucy@gmail.com", new MyDate(2008, 10, 1));
        Student s3 = new Student("Nacy", "nacy@gmail.com", new MyDate(2002, 12, 25));
        Student s4 = new Student("Farrency", "farrency@gmail.com", new MyDate(2014, 11, 3));
        dao.add(s1);
        dao.add(s2);
        dao.add(s3);
        dao.add(s4);

        List<Student> list = dao.getList();
        System.out.println(list);

        Student ss = list.get(2);
        System.out.println(ss);
    }
}
