/*
String类

特点
* String 不可变的字符序，底层使用char[]存放
* String时final修饰的，不能增删改


* 构造器
String()
String(byte[] bytes) 使用运行JVM平台的默认字符集几码自己数组bytes
String(byte[] bytes, Charset charset) 使用指定的字符集charset来解码字节数组bytes
String(byte[] ascii, int hibyte)    Deprecated
String(byte[] bytes, int offset, int length)
String(byte[] bytes, int offset, int length, Charset charset)
String(byte[] ascii, int hibyte, int offset, int count) //Deprecated
String(byte[] bytes, int offset, int length, String charsetName)
String(char[] value)
String(char[] value, int offset, int count)
String(int[] codePoints, int offset, int count)
String(String original)
String(StringBuffer buffer)
String(StringBuilder builder)


## 字符串与基本数据类型、包装类之间转换
* 字符串 -> 基本数据类型、包装类：调用 相应包装类.parseXxx(String str)   其中Xxx为相应的基本数据类型
* 基本数据类型、包装类 -> 字符串：调用String.valueOf(T obj)

## 字符串与字节数组的相互转换
* 字符串 -> 字节数组：字符串对象.getBytes()
* 字节数据 -> 字符串：new String(byte[] b)

## 字符串与字符数据的转换
* 字符串 -> 字符数组：
    * 字符串对象.toCharArray()
    * String.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    ```
    char[] ch = new char[s.length()];
    s.getChars(0, s.length(), ch, 0);
    ```
* 字符数组 -> 字符串：* new String(char[] ch)



* 常用方法
char charAt(int index) 返回索引为index的字符
boolean endsWith(String suffix) 当前字符串是否以字符串suffix结尾
byte[] getBytes() 把当前字符串使用平台默认字符集编码成一个新的字节数组并返回
byte[] getBytes(Charset charset) 使用指定的charset字符集把当前字符串编码成一个新的字节数组并返回
byte[] getBytes(String charsetName) 把当前字符串使用指定的字符集编码成一个新的字节数组并返回
boolean equals(Object anObject)
boolean equalsIgnoreCase(String anotherString) 忽略大小写的方式比价两个字符串是否相等
int indexOf(int ch) 回该字符串中指定字符ch第一次出现的索引
int indexOf(int ch, int fromIndex) 返回指定字符第一次出现的字符串中的索引，从指定索引fromIndex开始搜索。
int indexOf(String str) 返回子字符串str在当前字符串中首次出现的索引值
int indexOf(String str, int fromIndex) 返回子字符串str在当前字符串中首次出现的索引值，从指定索引fromIndex开始搜索。
String intern() 返回字符串对象的规范表示形式。
boolean isEmpty() 这个字符串长度是否为0
int length() 返回当前字符串的长度
int lastIndexOf(int ch) 返回指定编码值为ch的字符在当前字符串中最后一次出现的索索引值，不存在则返回-1
int lastIndexOf(int ch, int fromIndex) 返回指定编码值为ch的字符在当前字符串中最后一次出现的索索引值，从指定的索引位置fromIndex开始搜索
int lastIndexOf(String str) 返回指定子字符串最后一次出现的字符串中的索引
int lastIndexOf(String str, int fromIndex) 返回指定子字符串最后一次出现的字符串中的索引，从指定的索引位置fromIndex开始搜索
String trim() 返回当前字符串去掉收尾两端的所有的空格后的新字符串，当前字符串不改变
String strip() 去除首尾的空格
String stripLeading() 去除首部的空位
String stripTrailing() 去除尾部的空格
String substring(int beginIndex) 返回从beginIndex到末尾的字串
String substring(int beginIndex, int endIndex) 返回索引为[beginIndex, endIndex)的子串
char[] toCharArray() 把当前字符串转换成一个字符数组并返回
String toLowerCase()  使用默认规则吧所有字符都转换成小写字符
String replace(char oldChar, char newChar) 使用字符newChar替换字符oldChar
String replace(CharSequence target, CharSequence replacement) 使用字符串replacement替换替换目标字符序列target
String replaceAll(String regex, String replacement) 使用字符串replacement替换正则表达式regex匹配的所有结果。
String replaceFirst(String regex, String replacement) 使用字符串replacement替换正则表达式regex匹配的第一个子串。
String[] split(String regex) 使用正则表达式regex分割当前字符串，分割结果以String[]返回
String[] split(String regex, int limit) 使用正则表达式regex分割当前字符串，最多分割limit次，分割结果以String[]返回
boolean startsWith(String prefix) 当前字符串是否已子字符串prefix开始
boolean startsWith(String prefix, int toffset) 从索引为toffset位置开始是否以子字符串prefix开始
int compareTo(String anotherString) 从词法上比较两个字符串
int compareToIgnoreCase(String str) 忽略大小写，从词法上比较两个字符串
static String join(CharSequence delimiter, CharSequence... elements) 使用指定的分隔符delimiter连接多个元素elements组成的新字符串，并返回
static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) 使用指定的分隔符delimiter连接可迭代的集合元素，并返回


int codePointAt(int index) 返回指定索引位置为index处的int型字符Unicode编码值，
int codePointCount(int beginIndex, int endIndex)
String concat(String str) 将指定的字符串连接到此字符串的结尾
boolean contains(CharSequence s) 当前字符是否包含子字符串s
boolean contentEquals(CharSequence cs) 比较当前字符串与指定的cs字符串是否相等
boolean contentEquals(StringBuffer sb) 比较当前字符串与指定的sb字符缓冲串是否相等
static String copyValueOf(char[] data) 相当于 String.valueOf(char[])
static String copyValueOf(char[] data, int offset, int count)  相当于String.valueOf(char[], int offset, int count)
static String format(Local l, String format, Object... args)
static String format(String format, Object... args)
void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin)
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 将此字符串中[srcBegin, srcEnd)的字符复制到目标字符数组dst中，且开始位置为dstBegin
int hashCode()
boolean matches(String regex) 测试当前字符串与给定的正则表达式regex是否匹配
int offsetByCodePoints(int index, int codePointOffset) 返回指定的字节编码为codePointOffset在当前字符串中的索引与给定的索引index的差值
boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
boolean regionMatches(int toffset, String other, int ooffset, int len)
CharSequence subSequence(int beginIndex, int endIndex) 返回索引为[beginIndex, endIndex)的子字符序列
String toLowerCase(Locale locale)
String toString()
String toUpperCase() 所有字符都转换成大写
String toUpperCase(Locale locale) 使用给定区域设置的规则locale将此字符串中的所有字符转换为大写
static String valueOf(boolean b) boolean型转成字符串
static String valueOf(char c)
static String valueOf(char[] data)
static String valueOf(char[] data, int offset, int count)
static String valueOf(double d)
static String valueOf(float f)
static String valueOf(int i)
static String valueOf(long l)
static String valueOf(Object obj)


* */

package com.java.www;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.stream.IntStream;

public class StringTest {
    @Test
    public void test1() {
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        String s3 = new String("JavaEE");
        String s4 = "JavaEE" + "Android";
        String s5 = "Android";
        String s6 = s1 + s5;
        String s7 = s6.intern(); // 返回字符串对象的规范表示形式
        String s8 = "JavaEEAndroid";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true

        System.out.println(s4 == s6); // false
        System.out.println(s4.equals(s6)); // true
        System.out.println(s7 == s4);
        System.out.println(s4 == s8); // true

    }

    @Test
    public void test2() throws Exception{
        // char charAt(int index) 返回索引为index的字符
        String s = "aabdddffdp";
        char c = s.charAt(3);
        System.out.println("charAt : " + c);

        // boolean endsWith(String suffix) 当前字符串是否以字符串suffix结尾
        boolean is = s.endsWith("dp");
        System.out.println("endsWith : " + is);

        // byte[] getBytes() 把当前字符串使用平台默认字符集编码成一个新的字节数组并返回
        String s139 = new String("china");
        byte[] b140 = s139.getBytes();
        for (byte b : b140) {
            System.out.printf("%s(%s) ", b, (char)b);
        }
        System.out.println();

        // byte[] getBytes(Charset charset) 使用指定的charset字符集把当前字符串编码成一个新的字节数组并返回
        Charset charset =  Charset.forName("UTF-8");
        byte[] b146 = s139.getBytes(charset);
        for (byte b : b146) {
            System.out.printf("%s(%s) ", b, (char)b);
        }
        System.out.println();

        // byte[] getBytes(String charsetName) 把当前字符串使用指定的字符集编码成一个新的字节数组并返回
        byte[] b156 = s139.getBytes("UTF-8");
        for (byte b : b156) {
            System.out.printf("%s(%s) ", b, (char)b);
        }
        System.out.println();

        // boolean equals(Object anObject)
        String s163 = "qq43123腾讯";
        String s164 = "qq43123腾讯";
        String s165 = new String("qq43123腾讯");
        System.out.println(s163.equals(s164));
        System.out.println(s163.equals(s165));


        // boolean equalsIgnoreCase(String anotherString) 忽略大小写的方式比价两个字符串是否相等
        String s172 = "I like All, 大大的";
        String s173 = "i like all, 大大的";
        System.out.println(s172.equalsIgnoreCase(s173));

        // int indexOf(int ch) 回该字符串中指定字符ch第一次出现的索引
        String s177 = "ggyyxxkkggxx";
        System.out.println(s177.indexOf('x'));

        // int indexOf(int ch, int fromIndex) 返回指定字符第一次出现的字符串中的索引，从指定索引fromIndex开始搜索。
        System.out.println(s177.indexOf('g', 3));

        // int indexOf(String str) 返回子字符串str在当前字符串中首次出现的索引值
        System.out.println(s177.indexOf("xx"));

        // int indexOf(String str, int fromIndex) 返回子字符串str在当前字符串中首次出现的索引值，从指定索引fromIndex开始搜索。
        System.out.println(s177.indexOf("xx", 5));

        // String intern() 返回字符串对象的规范表示形式。


        // boolean isEmpty() 这个字符串长度是否为0
        String s193 = "";
        String s194 = "park";
        System.out.println(s193.isEmpty());
        System.out.println(s194.isEmpty());


        // int length() 返回当前字符串的长度
        System.out.println(s194.length());

        // int lastIndexOf(int ch) 返回指定编码值为ch的字符在当前字符串中最后一次出现的索索引值
        String s203 = "aggyyxxkkggxxa";
        System.out.println(s203.lastIndexOf(97));

        // int lastIndexOf(int ch, int fromIndex) 返回指定编码值为ch的字符在当前字符串中最后一次出现的索索引值，从指定的索引位置fromIndex开始搜索
        System.out.println(s203.lastIndexOf('x', 12));

        // int lastIndexOf(String str) 返回指定子字符串最后一次出现的字符串中的索引
        System.out.println(s203.lastIndexOf("xx"));

        // int lastIndexOf(String str, int fromIndex) 返回指定子字符串最后一次出现的字符串中的索引，从指定的索引位置fromIndex开始搜索


        // String trim() 返回当前字符串去掉收尾两端的所有的空格后的新字符串，当前字符串不改变
        String s216 = "   天上宫阙   很是悠哉   ";
        String s217 = s216.trim();
        System.out.println(s217 + "----");
        System.out.println(s216);

        String s220 = s216.strip();
        System.out.println(s220 + "----");
        System.out.println(s216);

        System.out.println(s216.stripLeading() + "----");

        // String substring(int beginIndex) 返回从beginIndex到末尾的字串
        String s231 = "abcdefghijkl你来了吗";
        System.out.println(s231.substring(2));

        // String substring(int beginIndex, int endIndex) 返回索引为[beginIndex, endIndex)的子串
        System.out.println(s231.substring(10, 14));

        // char[] toCharArray() 把当前字符串转换成一个字符数组并返回
        String s238 = "我要吃香的喝辣的";
        char[] c239 = s238.toCharArray();
        for (int i = 0; i < c239.length; ++i) {
            System.out.print(c239[i] + ".");
        }
        System.out.println();

        // String toLowerCase()  使用默认规则吧所有字符都转换成小写字符
        String s245 = "AbcdKKii";
        System.out.println(s245.toLowerCase());

        // String replace(char oldChar, char newChar) 使用字符newChar替换字符oldChar
        System.out.println(s245.replace('i', '旺'));

        // String replace(CharSequence target, CharSequence replacement) 使用字符串replacement替换替换目标字符序列target
        System.out.println(s245.replace("KK", "我就是不一样"));

        // String replaceAll(String regex, String replacement) 使用字符串replacement替换正则表达式regex匹配的所有结果。
        String s256 = "AA123BB66sa996";
        System.out.println(s256.replaceAll("\\d+", "数字"));

        // String replaceFirst(String regex, String replacement) 使用字符串replacement替换正则表达式regex匹配的第一个子串。
        System.out.println(s256.replaceFirst("\\d+", "数字"));

        // String[] split(String regex) 使用正则表达式regex分割当前字符串，分割结果以String[]返回
        String[] ss = s256.split("\\d+");
        System.out.println("===");
        for (String h : ss) {
            System.out.println(h);
        }
        System.out.println("===");

        String s271 = "aaxx-bb-99-a37";
        String[] sarr = s271.split("-");
        System.out.println("===>");
        for (String obj : sarr) {
            System.out.println(obj);
        }
        System.out.println("===>");


        // String[] split(String regex, int limit) 使用正则表达式regex分割当前字符串，最多分割limit次，分割结果以String[]返回
        String[] ss2 = s256.split("\\d+", 2);
        System.out.println("===");
        for (String h : ss2) {
            System.out.println(h);
        }
        System.out.println("===");

        // boolean startsWith(String prefix) 当前字符串是否已子字符串prefix开始
        System.out.println(s256.startsWith("AA"));

        // boolean startsWith(String prefix, int toffset) 从索引为toffset位置开始是否以子字符串prefix开始
        System.out.println(s256.startsWith("66", 10));

        // int compareTo(String anotherString) 从词法上比较两个字符串
        String s286 = "ShengZhen";
        String s287 = "ShengZhen1";
        String s289 = "shengzhen";
        int i288 = s286.compareTo(s287);
        System.out.println(i288);

        // int compareToIgnoreCase(String str) 忽略大小写，从词法上比较两个字符串
        int i293 = s286.compareToIgnoreCase(s289);
        System.out.println(i293);
    }

}
