/*
Bank class
单例模式
* */

package banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bank {
    // 实例变量
    private List<Customer> customers = Collections.synchronizedList(new ArrayList<>()); // 同步控制，使得线程安全

    // 类变量
    private static Bank bank = new Bank();

    // 构造器
    private Bank() {
    }

    // 方法
    public void addCustomer(String firstName, String lastName) {
        // 添加客户
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public static Bank getBank() {
        return bank;
    }

    public Iterator<Customer> getCustomers() {
        return customers.iterator();
    }
}
