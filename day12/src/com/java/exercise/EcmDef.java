/*
编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
	对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException、
  	除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。
提示：
	(1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。
	(2)在main()方法中使用异常处理语句进行异常处理。
	(3)在程序中，自定义对应输入负数的异常类(EcDef)。
	(4)运行时接受参数 java EcmDef 20 10
		//args[0]=“20” args[1]=“10”
	(5)Interger类的static方法parseInt(String s)将s转换成对应的int值。如int a=Interger.parseInt(“314”);	//a=314;


* */

package com.java.exercise;

public class EcmDef {
    public static void main(String[] args) {
        try {
            String a = args[0];
            String b = args[1];
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            System.out.println(ecm(x, y));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("对数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("除数不能为0");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }

    }

    public static double ecm(int a, int b) throws EcDef {
        if (a < 0 || b < 0) {
            throw new EcDef("输入的数不能为负数");
        }
        return a / b;
    }
}

//
class EcDef extends Exception {
    /*
    自定义异常类型
    * */
    static final long serialVersionUID = -3387516993124229999L;

    // 构造器
    public EcDef() {
        super();
    }

    public EcDef(String message) {
        super(message);
    }
}
