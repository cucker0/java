package banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    /*
    客户
    * */

    private String firstName;
    private String lastName;
    private List<Account> accounts = new ArrayList<>();


    // 构造器
    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 方法
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getNumOfAccounts() {
        return accounts.size();
    }

    public void addAccount(Account account) {
        accounts.add(account);

    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public Iterator<Account> getAccounts() {
        return accounts.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        return lastName != null ? lastName.equals(customer.lastName) : customer.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer: " +
                firstName + "," +
                lastName;
    }
}
