package banking;

public class Account {
    // 账号
    private double balance;

    // 构造器
    public Account(double init_balance) {
        balance = init_balance;
    }

    // 方法
    public double getBalance() {
        // 获取余额
        return balance;
    }

    public boolean deposit(double amt) {
        // 存钱
        balance += amt;
        return true;
    }

    public boolean withdraw(double amt) {
        // 取钱
        if (amt <= balance) {
            balance -= amt;
            return true;
        } else {
            System.out.println("您的账户余额不足!");
        }
        return false;
    }
}
