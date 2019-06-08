package banking;

public class Customer {
    // 客户
    private String firstName;
    private String lastName;
    Account account;

    // 构造器
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    // 方法
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account acct) {
        account = acct;
    }
}
