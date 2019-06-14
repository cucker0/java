/*
Bank class

* */

package banking5_3;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers; // numberOfCustomers初始默认值为0

    // 构造器
    public Bank() {
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
}
