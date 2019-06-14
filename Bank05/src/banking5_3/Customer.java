package banking5_3;

public class Customer {
    // 客户
    private String firstName;
    private String lastName;
//    private Account[] accounts; // 假定 accounts[0]: SavingAccount  accounts[1]: CheckignAccount
    private Account savingAccount;
    private Account checkingAccount;

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

    public void addAccount(Account account) {
        if (account instanceof SavingAccount) {
            savingAccount = account;
        } else if (account instanceof CheckingAccount) {
            checkingAccount = account;
        }
    }

    public Account getSaving() {
        return savingAccount;
    }

    public Account getChecking() {
        return checkingAccount;
    }

    public void setSaving(Account account) {
        savingAccount = account;
    }

    public void setChecking(Account account) {
        checkingAccount = account;
    }

}
