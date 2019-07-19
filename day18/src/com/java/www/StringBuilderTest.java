/*
StringBuilder类
位于java.lang包下
JDK 1.5开始添加此特性

## 特点
* 可变字符序列
* 执行效率高
* 线程不安全


## 构造器
StringBuilder() 构建一个无字符的字符串生成器，初始容量为16
StringBuilder(CharSequence seq)  构建一个字符串生成器，内容为指定的字符序列seq
StringBuilder(int capacity) 构建一个字符串生成器，容量为指定的capacity
StringBuilder(String str) 构建一个字符串生成器，内容为str

## 常用方法(用法与StringBuffer类似)

增
StringBuilder append(T obj) 添加任意类型的对象到当前StringBuilder序列中，T为任意类型
StringBuilder insert(int offset, T objc) 在索引offset处插入任意类型的对象

删
StringBuilder delete(int start, int end)
StringBuilder deleteCharAt(int index)


改
StringBuilder replace(int start, int end, String str)
void setCharAt(int index, char ch)
void setLength(int newLength)

查
char charAt(int index)
int lastIndexOf(String str)
int lastIndexOf(String str, int fromIndex)
int indexOf(String str)
int indexOf(String str, int fromIndex)

其他
int capacity()
int length()
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
StringBuilder reverse()
CharSequence subSequence(int start, int end)
String substring(int start)
String substring(int start, int end)
void trimToSize()  试图去除为使用的容量，从而节省存储空间



StringBuilder appendCodePoint(int codePoint)
int codePointAt(int index)
int codePointBefore(int index)
int codePointCount(int beginIndex, int endIndex)
void ensureCapacity(int minimumCapacity)
int offSetByCodePoints(int index, int codePointOffset)
String toString()



* */

package com.java.www;

public class StringBuilderTest {


}
