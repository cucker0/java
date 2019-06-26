/*
自定义异常类型

* */

package banking.domain;

public class OverdraftException extends Exception{
    // 类变量
    static final long serialVersionUID = -3387516993124220148L;

    // 实例变量
    private double deficit;

    // 构造器
    public OverdraftException() {
        super();
    }

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    // 方法
    public double getDeficit() {
        String defi = String.format("%.2f", deficit);
        return Double.parseDouble(defi);
    }

}
