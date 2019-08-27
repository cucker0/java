package com.java.exam.domain;


import java.io.Serializable;

/**
 * 帐号类
 * 实现Comparable接口，以实现TreeMap中自然排序
 */
public class Account implements Comparable, Serializable {
    /* 用户身份证号码 */
    private String id;

    /* 姓名 */
    private String name;

    /* 年龄 */
    private int age;

    // 构造器
    public Account(String id, String name, int age) {
        this.id =  id;
        this.name = name;
        this.age = age;
    }

    // 方法


    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id.strip();
        if (id.length() == 18) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.strip();
        if (name.length() > 1) {
            this.name = name;
        } else {
            System.out.println("名字长度必须大于1");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("年龄范围：(0, 150]");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (age != account.age) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        return name != null ? name.equals(account.name) : account.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Account) {
            Account acc = (Account) o;
            return id.compareTo(acc.id);
        }
        return 0;
    }
}
