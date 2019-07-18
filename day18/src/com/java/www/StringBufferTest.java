/*
StringBuffer类

## 特点
可变的字符序列，可以对字符串内容进行增删改
很多方法与String类相同，但StringBuffer是可变长度的
StringBuffer是一个窗口

## 4个构造器
StringBuffer() 新建一个空的字符串缓冲区，容量大小为16
StringBuffer(CharSequence seq) 构造一个字符串缓冲区，该缓冲区包含与指定字符序列相同的字符
StringBuffer(int capacity) 构建一个空字符串缓冲区，初始容量为指定的capacity
StringBuffer(String str) 新建一个字符串缓冲区，内容为指定字符串str

CharSequence类是java.lang包下的一个接口，此接口对多种不同的对char访问的统一接口，像String、StringBuffer、StringBuilder类都是CharSequence的子接口；


## StringBuffer类常用方法
增
StringBuffer append(T obj)  T为基本数据类型、字符串、字符数据等所有的Object
StringBuffer insert(int offset, T obj) 在当前序列指定索引offset插入obj对象，obj为任意类型的对象

删
StringBuffer delete(int start, int end) 删除此序列中索引为[start, end)的字符
StringBuffer deleteCharAt(int index) 删除此序列中索引为index的字符

改
void setCharAt(int index, char ch) 把索引为index处的字符重置为字符ch
StringBuffer replace(int start, int end, String str) 把此序列中索引为[start, end)替换为字符串str

查
char charAt(int index) 返回索引为index的字符
CharSequence subSequence(int start, int end) 获取索引为[start, end)的字符序列
String substring(int start) 获取此序列中索引从start开始到结束的子序列
String substring(int start, int end) 获取此序列中索引[start, end)的子序列
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 把此序列中索引为[srcBegin, srcEnd)的字符复制到到目标字符数组dst，从索引为dstBegin开始存

其他
int capacity() 返回当前的容量大小
int length() 返回序列内容长度
StringBuffer reverse() 反转当前序列内容，并返回当前序列
void trimToSize() 试图减少用于字符序列的存储空间，删除未使用容量
int indexOf(String str) 返回字符串str在此字符中首次出现的索引值
int indexOf(String str, int fromIndex) 返回字符串str在此字符中首次出现的索引值，从索引fromIndex开始查找
int lastIndexOf(String str) 返回字符串str在此字符中首最后一次出现的索引值
int lastIndexOf(String str, int fromIndex) 返回字符串str在此字符中首最后一次出现的索引值，从索引fromIndex开始查找



int codePointAt(int index) 返回索引为index的字符的Unicode code指针值
int codePointCount(int beginIndex, int endIndex) 返回此序列指定文本范围内的Unicode代码点数
void ensureCapacity(int minimumCapacity) 确保容量最小为指定的minimumCapacity
int offsetByCodePoints(int index, int codePointOffset) 返回此序列中的索引，该索引与给定索引之间的偏移量由codepointoffset代码点组成。
void setLength(int newLength) 设置字符序列的长度
String toString()



* */

package com.java.www;

import org.junit.Test;

import java.util.Date;

public class StringBufferTest {
    @Test
    public void test1() {
        // 增
        //StringBuffer append(T obj)  T为基本数据类型、字符串、字符数据等所有的Object
        //StringBuffer insert(int offset, T obj) 在当前序列指定索引offset插入obj对象，obj为任意类型的对象

        StringBuffer sb1 = new StringBuffer();
        System.out.println("capacity初始容量：" + sb1.capacity());
        sb1.append(true);
        sb1.append(3.14F);
        sb1.append(new Date());
        System.out.println(sb1);

    }

    @Test
    public void test2() {
        // 删
        //StringBuffer delete(int start, int end) 删除此序列中索引为[start, end)的字符
        //StringBuffer deleteCharAt(int index) 删除此序列中索引为index的字符
        StringBuffer sb = new StringBuffer("java progrom world ...");
        sb.deleteCharAt(3);
        System.out.println(sb);
        sb.delete(4, 6);
        System.out.println(sb);

    }

    @Test
    public void test3() {
        // 改
        //void setCharAt(int index, char ch) 把索引为index处的字符重置为字符ch
        //StringBuffer replace(int start, int end, String str) 把此序列中索引为[start, end)替换为字符串str
        StringBuffer sb = new StringBuffer("java progrom world ...");
        sb.setCharAt(3, 'A');
        System.out.println(sb);

        sb.replace(5, 8, "新内容");
        System.out.println(sb);
    }

}
