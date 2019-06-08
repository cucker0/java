package banking;

public class Account {
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

    public void deposit(double amt) {
        // 存钱
        balance += amt;
    }

    public void withdraw(double amt) {
        // 取钱
        if (amt <= balance) {
            balance -= amt;
        } else {
            System.out.println("您的账户余额不足!");
        }
    }
}
