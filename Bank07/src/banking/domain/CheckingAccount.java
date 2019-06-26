/*
信用卡

* */

package banking.domain;

public class CheckingAccount extends Account {
    private Double overdraftProtection; // double对应的包装类，默认初始化值为null。

    // 构造器
    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, double overdraftProtection) {
        super(init_balance);
        this.overdraftProtection = overdraftProtection;
    }

    // 方法
    public void withdraw(double amount) throws OverdraftException {
        // 取钱
        if (amount <= balance) {
            balance -= amount;
        } else if (overdraftProtection == null) {
            // 在没有透支保护的赤字
            throw new OverdraftException("no overdraft protection", amount);
        } else if (amount <= balance + overdraftProtection) {
            overdraftProtection = balance + overdraftProtection - amount;
            balance = 0; // 余额先去用完了
        } else {
            // overdraftProtection 数额不足以弥补赤字
            throw new OverdraftException("Insufficient funds for overdraft protection", amount - balance - overdraftProtection);
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }
}
