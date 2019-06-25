/*
匿名类、匿名内部类的应用

* */


package com.java.www;

import javax.swing.text.Caret;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        AnonymousInnerClassTest t1 = new AnonymousInnerClassTest();
        // 方式1：创建一个Product接口类的对象
        NoteBook n1 = new NoteBook("HUAWEI MateBook 14", 5699);
        t1.showProduct(n1);
        System.out.println();

        // 方式2：创建一个实现Product接口的匿名类的对象
        Product p18 = new Product() {
            // 方法
            @Override
            public String getName() {
                return "Dell XPS 15";
            }

            @Override
            public double getPrice() {
                return 14999;
            }
        };

        t1.showProduct(p18);
        System.out.println();

        // 方式3：创建一个实现Product接口的匿名类的匿名对象
        t1.showProduct(new Product() {

            // 方法
            @Override
            public String getName() {
                return "HUAWEI MateBook X Pro 2019款";
            }

            @Override
            public double getPrice() {
                return 8999;
            }
        });

        // 局部内部类的应用测试
        System.out.println(t1.getProduct());
        System.out.println(t1.getProduct2());

    }

    public void showProduct(Product p) {
        System.out.println(p.getName());
        System.out.println(p.getPrice());
    }

    // 局部内部类的应用
    public Product getProduct() {
        // 方式1：非匿名局部类
        class Camera implements Product {
            private String name;
            private double price;

            // 构造器
            public Camera(String name, double price) {
                this.name = name;
                this.price = price;
            }

            // 方法
            public String getName() {
                return name;
            }

            public double getPrice() {
                return price;
            }

            public String toString() {
                return "Camera{ " +
                        "name='" + name + '\'' +
                        ", price=￥" + price +
                        " }";
            }
        };

        return new Camera("佳能（Canon）EOS 80D 单反", 8299);
    }

    public Product getProduct2() {
        return new Product() {
            public String getName() {
                return "微软（Microsoft）Xbox One X 1TB";
            }

            public double getPrice() {
                return 3799;
            }

            public String toString() {
                return "{ " +
                        "name='" + getName() + '\'' +
                        ", price=￥" + getPrice() +
                        " }";
            }
        };
    }
}

interface Product {

    String getName();
    double getPrice();
}

class NoteBook  implements Product {
    private String name;
    private double price;

    // 构造器
    public NoteBook() {
        super();
    }

    public NoteBook(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // 方法
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

