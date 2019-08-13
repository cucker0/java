/*
客户类


* void表示无返回值
```
public void setName(String name) {
        this.name = name.strip();
}

```

* */

package com.java.com;

public class Customer {
    // 实例属性
    private String name;
    private boolean sex; // 性别 true: 女性， false: 男性
    private int age;
    private String phone;
    private String email;

    // 构造器
    public Customer() {
        super();
    }

    public Customer(String name, boolean sex) {
        super();
        this.name = name;
        this.sex = sex;
    }

    public Customer(String name, boolean sex, int age, String phone, String email) {
        this.name = name;
        this.sex = sex;
        setAge(age);
        this.phone = phone;
        setEmail(email);
    }

    // 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.strip();
    }

    public boolean getSex() {
        return sex;
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
        if (email.contains("@")) {
            this.email = email;
        } else {
            // 邮件格式不正确时抛出异常
            throw new RuntimeException("the email format is incorrect ");
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
