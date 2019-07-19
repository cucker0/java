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
static double	cos(double a) 求余弦值
static double	cosh(double x) 求返回双曲余弦值
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
static long	negateExact(long a)
static double	nextAfter(double start, double direction) 
static float	nextAfter(float start, double direction)
static double	nextDown(double d)
static float	nextDown(float f)
static double	nextUp(double d)
static float	nextUp(float f)
static double	pow(double a, double b)
static double	random()
static double	rint(double a)
static long	round(double a)
static int	round(float a)
static double	scalb(double d, int scaleFactor)
static float	scalb(float f, int scaleFactor)
static double	signum(double d)
static float	signum(float f)
static double	sin(double a)
static double	sinh(double x)
static double	sqrt(double a)
static int	subtractExact(int x, int y)
static long	subtractExact(long x, long y)
static double	tan(double a)
static double	tanh(double x)
static double	toDegrees(double angrad)
static int	toIntExact(long value)
static double	toRadians(double angdeg)
static double	ulp(double d)
static float	ulp(float f)


* */

package com.java.www;

import org.junit.Test;

import java.util.Map;

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
    }
}
