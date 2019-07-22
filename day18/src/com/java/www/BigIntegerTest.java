/*
BigInteger类

Integer类是int的包装类，能存储的最大整型值为2^31 - 1
BitInteger类的数字范围比Integer类的数字范围要大的多，可以支持任意精度的整数


## 使用场景
整数范围超过2^31 - 1，科学研究计算

## 构造器
BigInteger(String val)
BigInteger(byte[] val)
BigInteger(int signum, byte[] magnitude)
BigInteger(int bitLength, int certainty, Random rnd)
BigInteger(int numBits, Random rnd)
BigInteger(String val, int radix)

## 常量
static BigInteger ONE
static BigInteger TEN
static BigInteger ZERO


## 方法
BigInteger abs() 返回绝对值
BigInteger add(BigInteger val) 返回 this + val
BigInteger subtract(BigInteger val) 返回 this - val
BigInteger multiply(BigInteger val) 返回 this * val
BigInteger divide(BigInteger val) 返回 this / val

BigInteger and(BigInteger val) 返回 this & val
BigInteger or(BigInteger val) 或运算，返回 (this | val)
BigInteger not() 取反，返回~this
BigInteger xor(BigInteger val) 异或运算，返回 this ^ val
BigInteger andNot(BigInteger val) 返回 this & ~val
BigInteger shiftLeft(int n) this << n
BigInteger shiftRight(int n) this >> n

BigInteger max(BigInteger val) 返回 this 与 val中较大的值
BigInteger min(BigInteger val) 返回 this 与 val中较小的值
BigInteger mod(BigInteger m) 返回 this % m
BigInteger modInverse(BigInteger m) 返回 this^(-1) % m
BigInteger modPow(BigInteger exponent, BigInteger m) 返回 this^exponent % m
BigInteger pow(int exponent) 返回 this^exponent
BigInteger remainder(BigInteger val) 返回 this % val

int bitCount() 返回这个大整数的二进制补码表示中与其符号位不同的位数
int bitLength() 返回这个大整数的最小二进制补码表示中的位数，不包括符号位
byte byteValueExact() 将这个大整数转换为byte，检查丢失的信息
BigInteger clearBit(int n)
int compareTo(BigInteger val)
BigInteger[] divideAndRemainder(BigInteger val) 返回 BigInteger[]{ this / val, this % val }
double doubleValue() 把此BigInteger转化成 double
boolean equals(Object x)
BigInteger flipBit(int n)
float floatValue()
BigInteger gcd(BigInteger val)
int getLowestSetBit()
int hashCode()
int intValue()
int intValueExact()
boolean isProbablePrime(int certainty)
long longValue()
long longValueExact()
BigInteger negate()
BigInteger nextProbablePrime()
static BigInteger probablePrime(int bitLength, Random rnd)

BigInteger setBit(int n)
short shortValueExact()
int signum()
boolean testBit(int n)
byte[] toByteArray()
String toString()
String toString(int radix)
static BigInteger valueOf(long val)


* */

package com.java.www;

import org.junit.Test;

import java.math.BigInteger;

public class BigIntegerTest {
    @Test
    public void test1() {
        BigInteger bi1 = new BigInteger("-99123456789455665445585564");
        BigInteger bi2 = new BigInteger("123545688855644652245");
        BigInteger bi3 = new BigInteger("796578123554652245");
        System.out.println(bi1);
        System.out.println(bi2);

        // BigInteger abs() 返回绝对值
        System.out.println("||: " +  bi1.abs());

        //BigInteger add(BigInteger val) 返回 this + val
        BigInteger bi98 = bi1.add(bi2);
        System.out.println("+: " + bi98);

        //BigInteger subtract(BigInteger val) 返回 this - val
        System.out.println("-: " + bi1.subtract(bi2));

        //BigInteger multiply(BigInteger val) 返回 this * val
        System.out.println("*: " + bi1.multiply(bi2));

        //BigInteger divide(BigInteger val) 返回 this / val
        System.out.println("/: " + bi1.divide(bi2));


        //BigInteger and(BigInteger val) 返回 this & val
        System.out.println("&: " + bi2.and(bi3));

        //BigInteger or(BigInteger val) 或运算，返回 (this | val)
        System.out.println(bi2.or(bi3));

        //BigInteger not() 取反，返回~this
        System.out.println(bi3.not());

        //BigInteger xor(BigInteger val) 异或运算，返回 this ^ val
        System.out.println(bi2.xor(bi2));

        //BigInteger andNot(BigInteger val) 返回 this & ~val
        System.out.println(bi3.andNot(bi2));

        //BigInteger shiftLeft(int n) this << n
        System.out.println("<<: " + bi2.shiftLeft(3));

        //BigInteger shiftRight(int n) this >> n
        System.out.println(new BigInteger("4").shiftRight(2));


        //BigInteger max(BigInteger val) 返回 this 与 val中较大的值
        System.out.println(bi1.max(bi2));

        //BigInteger min(BigInteger val) 返回 this 与 val中较小的值
        System.out.println(bi2.min(bi3));

        //BigInteger mod(BigInteger m) 返回 this % m
        System.out.println(bi2.mod(bi3));

        //BigInteger modInverse(BigInteger m) 返回 this^(-1) % m

        //BigInteger modPow(BigInteger exponent, BigInteger m) 返回 this^exponent % m
        //BigInteger pow(int exponent) 返回 this^exponent
        System.out.println(bi2.pow(3));


        // BigInteger remainder(BigInteger val) 返回 this % val
        System.out.println(bi1.remainder(bi2));

        // BigInteger[] divideAndRemainder(BigInteger val) 返回 BigInteger[]{ this / val, this % val }
        BigInteger[] biArr = bi1.divideAndRemainder(bi3);
        for (BigInteger bb : biArr) {
            System.out.println(bb);
        }

    }

    @Test
    public void test2() {
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.TEN);

    }

}
