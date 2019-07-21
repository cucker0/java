/*
Math类
java.lang.Math

不能再继承，
不需要实例化，方法都为static静态的


## 常量
public static final double E = 2.7182818284590452354
public static final double PI = 3.14159265358979323846

## 方法
static T abs(T a) 求绝对值，T为double、float、int、long
static double	acos(double a) 返回反余弦值，值范围：[0, pi]
static int	addExact(int x, int y) 返回传入的两个数的和
static long	addExact(long x, long y) 返回传入的两个数的和
static double	asin(double a) 返回反正弦值，值范围：[-pi/2, pi/2]
static double	atan(double a) 返回反正切值，值范围：(-pi/2, pi/2)
static double	atan2(double y, double x) 返回从直角坐标(x，y)到极坐标(r，θ)的转换角度θ
static double	cbrt(double a) 求立方根
static double	ceil(double a) 天花整，上取整(返回double型的整数)，
static double	copySign(double magnitude, double sign)
static float	copySign(float magnitude, float sign)
static double	cos(double a) 求余弦值，即cos(a)
static double	cosh(double x) 求返回双曲余弦值，即cosh(x)
static int	decrementExact(int a) 减1
static long	decrementExact(long a) 减1
static double	exp(double a) 返回欧拉数e的幂，即e^a
static double	expm1(double x) 返回欧拉数 e^x - 1
static double	floor(double a) 地板整，下取整(返回double型的整数)
static int	floorDiv(int x, int y) 返回两数相除的商下去整
static long	floorDiv(long x, long y) 返回两数相除的商下去整
static int	floorMod(int x, int y) 取模
static long	floorMod(long x, long y)
static int	getExponent(double d) 求指定数的无偏质数
static int	getExponent(float f) 求指定数的无偏质数
static double	hypot(double x, double y) 求两数平方的和开平方，即 (x^2 + y^2)^(1/2)，类似已知直角三角形直角边长度，求斜边
static double	IEEEremainder(double f1, double f2) 按照IEEE754标准，计算两个数的余数
static int	incrementExact(int a) 返回此数加1的值
static long	incrementExact(long a) 返回此数加1的值
static double	log(double a) 求此值的自然对数，以e为底
static double	log10(double a) 求此值的以10为底的对数
static double	log1p(double x) 此值的以10为底的对数，返回此对数+1的和
static T	max(T a, T b) T为double、float、int、long 求两数的最大值
static T min(T a, T b) T为double、float、int、long 求两数的最小值
static int	multiplyExact(int x, int y) 返回两数的积
static long	multiplyExact(long x, long y) 返回两数的积
static int	negateExact(int a) 求此数的相反数
static long	negateExact(long a) 求此数的相反数
static double	nextAfter(double start, double direction) 返回与start相近的浮点数，精度为系统最大精度，方向与direction靠近。
static float	nextAfter(float start, double direction)
static double	nextDown(double d) 返回沿负无穷大方向与d相邻的浮点数
static float	nextDown(float f)
static double	nextUp(double d) 返回沿正无穷大方向与d相邻的浮点数
static float	nextUp(float f)
static double	pow(double a, double b) 返回a的b次幂，即a^b
static double	random() 返回[0.0, 1.0)范围内随机的一个双精度浮点数
static double	rint(double a) 返回最接近浮点数a的整数的双精度值，以四舍五入原则，精确到个位。如 Math.rint(3.5) -> 4.0
static long	round(double a) 取最接近小数a的长整型数，取值方向为正无穷大，以四舍五入原则处理
static int	round(float a) 取最接近小数a的整型数，取值方向为正无穷大，以四舍五入原则处理
static double	scalb(double d, int scaleFactor) 返回小数d 乘以 2的scaleFactor次幂的积，即 d * 2^scaleFactor
static float	scalb(float f, int scaleFactor)
static double	signum(double d) 返回数d的符号，
                                0.0：d = 0
                                1.0：d > 0
                                -1.0：d < 0
static float	signum(float f) 返回数d的符号,
                                0.0F：d = 0
                                1.0F：d > 0
                                -1.0F：d < 0
static double	sin(double a) 返回弧度a的正弦值，即sin(a)
static double	sinh(double x) 返回x的双曲正弦值
static double	sqrt(double a) 返回双精度数a的平方根，即a^(1/2)
static int	subtractExact(int x, int y) 返回x - y的差值，即 x - y
static long	subtractExact(long x, long y)
static double	tan(double a) 返回弧度a的正切值，即tan(a)
static double	tanh(double x) 返回x的双曲正切值，即tanh(x)
static double	toDegrees(double angrad) 弧度转换成角度(近似值)
static int	toIntExact(long value) 返回long型数转int的值，即(int) value
static double	toRadians(double angdeg) 角度转换成弧度(近似值)
static double	ulp(double d) 返回数d的精度值
static float	ulp(float f)


// 浮点 Math 方法的准确性根据 ulp（units in the last place，最后一位的进退位）来衡量
An ulp stands for unit of least precision 一个ulp表示最小精度单位, https://www.geeksforgeeks.org/java-math-ulp-method-examples/


* */

package com.java.www;

import org.junit.Test;

import java.util.Map;
import java.util.regex.Pattern;

public class MathTest {
    @Test
    public void test1() {

        // static double	ceil(double a) 天花整，上取整(返回double型的整数)，
        double d = 3.00000001;
        double r = Math.ceil(d);
        System.out.println(r); // 4.0

        double b93 = 3.1;
        double b94 = 9.99999;
        double r95 = Math.copySign(b94, b93);
        System.out.println(r95);


        System.out.println(Math.floorMod(-9, 5));

        System.out.println(Math.getExponent(1/3));

        System.out.println(Math.hypot(3, 4)); // 5

        System.out.println(Math.IEEEremainder(13.14, 9.9));

        System.out.println(Math.multiplyExact(2, 3));

        System.out.println(Math.negateExact(-1));

        System.out.println("Math.nextAfter(a, b): " + Math.nextAfter(2.1, 3)); // 2.1000000000000005
        System.out.println("Math.nextAfter(a, b): " + Math.nextAfter(2.1, -1)); // 2.0999999999999996

        System.out.println(Math.random());

        System.out.println(Math.rint(3.4999999)); // 3.0
        System.out.println(Math.rint(3.5)); // 4.0

        System.out.println(Math.round(-2.4599)); // -2

        System.out.println(Math.scalb(2.0, 3)); // 16.0, ==> 2 * 2^3

        System.out.println(Math.signum(2.2F));
        System.out.println(Math.signum(0));
        System.out.println(Math.signum(-2.2F));

    }

    @Test
    public void test2() {
        for (int i = 0; i < 10000; ++i) {
            System.out.println(Math.random());

        }
    }

    @Test
    public void test3() {
        // 弧度、角度

        System.out.println(Math.sin(Math.PI/2)); // 1.0

        // 双曲正弦
        System.out.println(Math.sinh(1)); // 1.1752011936438014

        System.out.println(Math.subtractExact(2, 5)); // -3
        System.out.println(Math.subtractExact(5, -1)); // -3

        // tan(a) 正切
        System.out.println(Math.tan(Math.PI/4)); // 0.9999999999999999

        System.out.println(Math.tanh(1)); // 0.7615941559557649


        // 弧度转角度
        System.out.println(Math.toDegrees(Math.PI)); // 180.0


    }

    @Test
    public void test4() {
        System.out.println(Math.ulp(Math.PI)); // 4.440892098500626E-16
        System.out.println(Math.ulp(3)); // 2.3841858E-7
        System.out.println(Math.ulp(1)); // 1.1920929E-7
        System.out.println(Math.ulp(1.0)); // 2.220446049250313E-16
        System.out.println(Math.ulp(1.229)); // 2.220446049250313E-16

        System.out.println(Math.ulp(-1.0F / 0)); // Infinity
    }

}
