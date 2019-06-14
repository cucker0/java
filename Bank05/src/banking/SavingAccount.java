package banking;

public class SavingAccount extends Account {
    private double interestRate; // 利率

    // 构造器
    public SavingAccount(double init_balance, double interestRate) {
        super(init_balance);
        this.interestRate = interestRate;
    }

    // 方法


}
