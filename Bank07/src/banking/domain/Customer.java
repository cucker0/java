package banking.domain;

public class Customer {
    // 客户
    private String firstName;
    private String lastName;
//    Account account;
    private Account[] accounts;
    private int numOfAccounts;

    // 构造器
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new Account[5];
    }

    public Customer(String firstName, String lastName, int numberOfAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numOfAccounts = numberOfAccounts;
    }

    // 方法
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account acct) {
//        account = acct;
//    }


    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public void setNumOfAccounts(int numberOfAccounts) {
        this.numOfAccounts = numberOfAccounts;
    }

    public void addAccount(Account account) {
        accounts[numOfAccounts] = account;
        numOfAccounts += 1;
    }

    public Account getAccount(int index) {
        return accounts[index];
    }
}
