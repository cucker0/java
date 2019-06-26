/*
Bank class
单例模式
* */

package banking.domain;

public class Bank {
    // 实例变量
    private Customer[] customers;
    private int numberOfCustomers; // numberOfCustomers初始默认值为0
    // 类变量
    private static Bank bank = new Bank();

    // 构造器
    private Bank() {
        customers = new Customer[8];
    }

    // 方法
    public void addCustomer(String firstName, String lastName) {
        // 添加客户
        Customer customer = new Customer(firstName, lastName);
        customers[numberOfCustomers] = customer;
        numberOfCustomers += 1; // 每添加一个客户，计数器要加1
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }

    public static Bank getBank() {
        return bank;
    }
}
