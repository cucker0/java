/*
信用卡
信用卡可以使用主卡的钱
信用卡属性：余额，透支额度，绑定的储蓄主卡
取钱规则：
    1 先用信用卡上的现金
    2 用完了信用卡现金再使用信用卡透支额度
    3 使用完信用卡透支额度后，再使用主卡现金

* */

package banking5_3;

public class CheckingAccount extends Account {
    private double overdraftProtection; // 可透支额度
    private SavingAccount protectedBy; // 绑定的主卡（储蓄卡）

    // 构造器
    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, SavingAccount protectedBy) {
        super(init_balance);
        this.protectedBy = protectedBy;
    }

    // 方法
    public boolean withdraw(double amount) {
        // 取钱
        /*
        1 先用信用卡上的现金
        2 用完了信用卡现金再使用信用卡透支额度
        3 使用完信用卡透支额度后，再使用主卡现金
        * */
        if (amount < 0) {
            System.out.println("取钱不能取负数！！！，你是黑客吧。");
            return false;
        } else if (amount <= balance) {
            balance -= amount;
            return true;
        } else if (amount <= balance + overdraftProtection) {
            overdraftProtection = overdraftProtection + balance - amount;
            balance = 0;
            return true;
        } else {
            if (protectedBy instanceof SavingAccount) { // 判断本信用卡是绑定了储蓄主卡
                double difference = 0;
                difference = amount - balance - overdraftProtection;
                boolean status = protectedBy.withdraw(difference);
                return status;
            }
            return false;
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    public SavingAccount getProtectedBy() {
        return protectedBy;
    }

    public void setProtectedBy(SavingAccount protectedBy) {
        this.protectedBy = protectedBy;
    }
}
