package banking.domain;

public class Account {
    // 账号
    protected double balance;

    // 构造器
    public Account(double init_balance) {
        balance = init_balance;
    }

    // 方法
    public double getBalance() {
        // 获取余额
        return balance;
    }

    public boolean deposit(double amount) {
        // 存钱
        balance += amount;
        return true;
    }

    public void withdraw(double amount) throws OverdraftException {
        // 取钱
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("您的账户余额不足!");
            throw new OverdraftException("您的账户资金不足", amount - balance);
        }
    }
}
