/*
BigDecimal类

一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。BigDecimal类支持任何精度的定点数


// 构造器
BigDecimal(BigInteger val)
BigDecimal(BigInteger unscaledVal, int scale)
BigDecimal(BigInteger unscaledVal, int scale, MathContext mc)
BigDecimal(BigInteger val, MathContext mc)
BigDecimal(char[] in)
BigDecimal(char[] in, int offset, int len)
BigDecimal(char[] in, int offset, int len, MathContext mc)
BigDecimal(char[] in, MathContext mc)
BigDecimal(double val)
BigDecimal(double val, MathContext mc)
BigDecimal(int val)
BigDecimal(int val, MathContext mc)
BigDecimal(long val)
BigDecimal(long val, MathContext mc)
BigDecimal(String val)
BigDecimal(String val, MathContext mc)


// 常量
static BigDecimal ONE
static BigDecimal TEN
static BigDecimal ZERO
static int ROUND_CEILING
static int ROUND_DOWN
static int ROUND_FLOOR
static int ROUND_HALF_DOWN
static int ROUND_HALF_EVEN
static int ROUND_HALF_UP
static int ROUND_UNNECESSARY
static int ROUND_UP



// 方法
BigDecimal abs()
BigDecimal abs(MathContext mc)
BigDecimal add(BigDecimal augend)
BigDecimal add(BigDecimal augend, MathContext m
byte byteValueExact()
int compareTo(BigDecimal val)
BigDecimal divide(BigDecimal divisor)
BigDecimal divide(BigDecimal divisor, int roundingMode)
BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
BigDecimal divide(BigDecimal divisor, MathContext mc)
BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)
BigDecimal divideAndRemainder(BigDecimal divisor)
BigDecimal divideAndRemainder(BigDecimal divisor, MathContext mc)
BigDecimal divideToIntegralValue(BigDecimal divisor)
BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc)
double doubleValue()
boolean equals(Object x)
float floatValue()
int hashCode()
int intValue()
int intValueExact()
long longValue()
BigDecimal max(BigDecimal val)
BigDecimal min(BigDecimal val)
BigDecimal movePointLeft(int n)
BigDecimal movePointRight(int n)
BigDecimal multiply(BigDecimal multiplicand)
BigDecimal multiply(BigDecimal multiplicand, MathContext mc)
BigDecimal negate()
BigDecimal negate(MathContext mc)
BigDecimal plus()
BigDecimal plus(MathContext mc)
BigDecimal pow(int n)
BigDecimal pow(int n, MathContext mc)
int precision()
BigDecimal remainder(BigDecimal divisor)
BigDecimal remainder(BigDecimal divisor, MathContext mc)
BigDecimal round(MathContext mc)
int scale()
BigDecimal scaleByPowerOfTen(int n)
BigDecimal setScale(int newScale)
BigDecimal setScale(int newScale, int roundingMode)
BigDecimal setScale(int newScale, RoundingMode roundingMode)
short shortValueExact()
int signum()
BigDecimal stripTrailingZeros()
BigDecimal subtract(BigDecimal subtrahend)
BigDecimal subtract(BigDecimal subtrahend, MathContext mc)
BigInteger toBigInteger()
BigInteger toBigIntegerExact()
String toEngineeringString()
String toPlainString()
String toString()
BigDecimal 	ulp()
BigInteger unscaledValue()
static BigDecimal valueOf(double val)
static BigDecimal valueOf(long val)
static BigDecimal valueOf(long unscaledVal, int scale)



* */

package com.java.www;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    public void test1() {
        BigDecimal bd1 = new BigDecimal(695436655.945231564656);
        BigDecimal bd2 = new BigDecimal("3.14159265358979323846264338327950288419716939937510");
        System.out.println("bd1: " + bd1);
        System.out.println("bd2: " + bd2);

        BigDecimal bd120 = bd1.divide(bd2, 15, BigDecimal.ROUND_HALF_UP);
        BigDecimal bd121 = bd1.divide(bd2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bd120);
        System.out.println(bd121);

    }

}
