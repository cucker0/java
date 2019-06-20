/*
信用卡

* */

package banking5_2.domain;

public class CheckingAccount extends Account {
    private double overdraftProtection;

    // 构造器
    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, double overdraftProtection) {
        super(init_balance);
        this.overdraftProtection = overdraftProtection;
    }

    // 方法
    public boolean withdraw(double amount) {
        // 取钱
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else if (amount <= balance + overdraftProtection) {
            overdraftProtection = balance + overdraftProtection - amount;
            balance = 0; // 余额先去完了
            return true;
        } else {
            System.out.println("已超过您的投资额度，取款失败!");
            return false;
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }
}
