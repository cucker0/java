package banking5_3;

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

    public boolean withdraw(double amount) {
        // 取钱
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("您的账户余额不足!");
        }
        return false;
    }
}
