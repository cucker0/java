/*
储蓄卡

* */

package banking5_2.domain;

public class SavingAccount extends Account {
    private double interestRate; // 利率

    // 构造器
    public SavingAccount(double init_balance, double interestRate) {
        super(init_balance);
        this.interestRate = interestRate;
    }

    // 方法
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
