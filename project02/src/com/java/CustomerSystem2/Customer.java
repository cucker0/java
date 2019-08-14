/*
客户类


* void表示无返回值
```
public void setName(String name) {
        this.name = name.strip();
}

```

实现Serializable接口为了把此该类的对象写入文件

* */

package com.java.CustomerSystem2;

import java.io.Serializable;

public class Customer implements Serializable {
    // 类属性
    private static int init = 10000; // id计数器初始值
    private static final long serialVersionUID = 8683452581122892333L; // 序列化版本号

    // 实例属性
    private int id;
    private String name;
    private boolean sex; // 性别 true: 女性， false: 男性
    private int age;
    private String phone;
    private String email;

    // 构造器
    public Customer() {
        super();
        idAdd();
    }

    public Customer(String name, boolean sex) { // 构造器2
        super();
        setName(name);
        this.sex = sex;
        idAdd();
    }

    public Customer(String name, boolean sex, int age, String phone, String email) {
        this(name, sex); // 调用 构造器2
//        setName(name);
//        this.sex = sex;
        setAge(age);
        this.phone = phone;
        setEmail(email);
        idAdd();
    }

    // 方法
    private void idAdd() {
        // ID自增
        id = init;
        ++id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0 && name.length() < 37) {
            this.name = name.strip();
        }
    }

    public boolean getSex() {
        return sex;
    }

    public String getSexString() {
        return sex ? "女" : "男";
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 151) {
            this.age = age;
        } else {
            // 年龄不符合要求
            System.out.println("age must be greater than 0 and less than 151");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws RuntimeException{
//        if (email.contains("@")) {
        if (email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            this.email = email;
        } else {
            // 邮件格式不正确时抛出异常
//            throw new RuntimeException("the email format is incorrect ");
            this.email = "";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        // 姓名、性别、年龄相同则判断为相等
        if (sex != customer.sex) return false;
        if (age != customer.age) return false;
        return name != null ? name.equals(customer.name) : customer.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sex ? 1 : 0);
        result = 31 * result + age;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\t\tCustomer{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                "}";
    }
}
