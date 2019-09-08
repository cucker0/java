package com.java.www;

/**
 * String、StringBuffer、StringBuild 在java不同版本之间的异同
 *
 * 三者存储结构变化
 * java 8 及之前，底层使用char[]数组存储，
 * java 9 底层使用byte[]数组存储，并记录编码标识(encoding flag)
 *
 *
 * 三者之间的区别
 * String: 不可变得字符序列
 * StringBuffer: 可变的字符序列，线程安全，效率一般
 * StringBuild: 可变的字符序列，线程不安全，效率很高（java 5开始增加的）
 *
 */
public class StringTest {

}
