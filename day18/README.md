day18_java常用类
==

# 本章内容
* String类
* StringBuffer类
* StringBuilder类
* System类
* Date类
* SimpleDateFormat类
* Calendar类
* Math类
* BigIntege类
* BigDecimal类


# String类

作用：构造字符对象
* 常量对象
>字符串常量对象是双引号括起来的字符序列
* 字符串的字符使用unicode字符编码，一个字符占两个字节(即1 char 占用 2 byte)

## 字符串的特性
* String是一个final类，字符串是不可变的字符序列
* 字符串是不可变的。一个字符串对象一旦被创建，其内容是不可变的

## String类的构造器
```text
String()
String(String original)
String(byte[] bytes) 使用运行JVM平台的默认字符集编码字节数组bytes，可用于byte[]字节数组转字符串
String(byte[] bytes, Charset charset) 使用指定的字符集charset来解码字节数组bytes
String(byte[] bytes, int offset, int length)
String(byte[] bytes, int offset, int length, Charset charset)
String(char[] value) 字符数组转字符串
String(char[] value, int offset, int count)
String(byte[] ascii, int hibyte)    Deprecated
String(byte[] ascii, int hibyte, int offset, int count) //Deprecated
String(byte[] bytes, int offset, int length, String charsetName)
String(int[] codePoints, int offset, int count)
String(StringBuffer buffer)
String(StringBuilder builder)
```


String对象内存结构  
![String对象内存结构](./images/String在内存中的结构.png)  
![String对象内存结构2](./images/String内存结构2.png)  
![string多次赋值操作内存结构变化](./images/string多次赋值操作.png)  


## String方法
```text
* 常用方法
字符串是不可变的，所以操作字符串时，返回字符串时都是一个新的对象，原来的字符串对象不变

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
```

示例  
[String Test](./src/com/java/www/StringTest.java)

## 字符串与基本数据类型、包装类之间转换
* 字符串 -> 基本数据类型、包装类：调用 相应包装类.parseXxx(String str)   其中Xxx为相应的基本数据类型
* 基本数据类型、包装类 -> 字符串：调用String.valueOf(T obj)  // T 为int、boolean、byte等基本数据类型

## 字符串与字节数组的相互转换
* 字符串 -> 字节数组：字符串对象.getBytes()
    >public byte[] getBytes(String charsetName) 使用参数指定字符编码，将当前字符串转化为一个字节数组
* 字节数组 -> 字符串：new String(byte[] b)
    >String(byte[]，int offset，int length)
## 字符串与字符数据的转换
* 字符串 -> 字符数组：
    * 字符串对象.toCharArray()
    * String.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    ```
    char[] ch = new char[s.length()];
    s.getChars(0, s.length(), ch, 0);
    ```
* 字符数组 -> 字符串：
    * new String(char[] ch)
    >String(char[]，int offset，int length)

示例  
[String、字节数组、字符数组之间的转化](./src/com/java/www/String_CharArray_ByteArray_Transformation.java)  


# StringBuffer类
位于java.lang.StringBuffer  

##  特点
* StringBuffer对象是 可变的字符序列，可以对字符串内容进行增删改
* 很多方法与String相同，StringBuffer对象长度可变
* StringBuffer是一个容器

## 构造器
```text
StringBuffer() 新建一个空的字符串缓冲区，容量大小为16
StringBuffer(CharSequence seq) 构造一个字符串缓冲区，该缓冲区包含与指定字符序列相同的字符
StringBuffer(int capacity) 构建一个空字符串缓冲区，初始容量为指定的capacity
StringBuffer(String str) 新建一个字符串缓冲区，内容为指定字符串str

CharSequence类是java.lang包下的一个接口，此接口对多种不同的对char访问的统一接口，像String、StringBuffer、StringBuilder类都是CharSequence的子接口；
```

StringBuffer对象内存结构  
![](./images/StringBuffer内存结构.png)  


## StringBuffer方法
```text
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
```

示例  
[StringBufferTest](./src/com/java/www/StringBufferTest.java)  


# StringBuilder类
JDK 1.5开始有的特性  
StringBuilder和StringBuffer非常类似，两者的对象都是可变的字符序列，方法也类似  

## String、StringBuffer、StringBuilder特点比较
* String：不可变字符序列
* StringBuffer：可变字符序列、效率中等、线程安全
* StringBuilder：可变字符序列、效率高、线程不安全
* String使用缺陷
```text
string s="a"; // 创建了一个字符串 
s=s+"b"; // 实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串s+"b"（也就是"ab")。
         // 如果多次执行这些改变串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。
         // 如果这样的操作放到循环中，会极大影响程序的性能。

```
* 三者的效率：StringBuilder > StringBuffer > String

[String, StringBuffer, StringBuilder 执行效率比较](./src/com/java/www/String_StringBuffer_StringBuilder_efficiency.java)  


# 与时间相关的类
* System.currentTimeMillis();
* Date：java.util.Date、java.sql.Date
* SimpleDateFormat
* Calendar

# System类
位于java.lang.System  

System类提供的public static long currentTimeMillis() 用来返回当前时间与1970-01-01 00:00:00 之间以毫秒为单位的时间差  
1000ms = 1s  
System.currentTimeMillis() 方法适用于计算时间差

## 主要时间标准
* UTC(Universal Time Coordinated)
* GMT(Greenwich Mean Time)
* CST(Central Standard Time)


# Date类
表示特定的瞬间，精确到毫秒  

另外还有一个java.sql.Date，这个主要用于数据库相关的

## 构造器
```text
Date() 获取本地当前时间构建一个Date
Date(int year, int month, int date) // Deprecated
Date(int year, int month, int date, int hrs, int min) // Deprecated
Date(int year, int month, int date, int hrs, int min, int sec) // Deprecated
以上三个构造器以1900-01-01 00:00:00 GMT为基准时间

Date(long date) 以1970-01-01 00:00:00 GMT为基准的，毫秒差值
Date(String s) // Deprecated
```

## 方法
```text
boolean after(Date when)
boolean before(Date when)
Object clone()
int compareTo(Date anotherDate)
boolean equals(Object obj)
static Date from(Instant instant)
int getDate() // Deprecated
int getDay() // Deprecated
int getHours() // Deprecated
int getMinutes() // Deprecated
int getMonth() // Deprecated
int getSeconds() // Deprecated
int getTime() 返回自 1970-1-1 00:00:00 GMT 以来此Date对象表示的毫秒数
int getTimezoneOffset()
int getYear() // Deprecated
int hashCode() // Deprecated
static long parse(String s)
void setDate(int date)  // Deprecated
void setHours(int hours) // Deprecated
void setMinutes(int minutes) // Deprecated
void setMonth(int month) // Deprecated
void setSecondes(int secondes) // Deprecated
void setTime(long time)
void setYear(int year) // Deprecated
String toGMTString() // Deprecated
Instant toInstant()
String toLocaleString() // Deprecated
String toString() 把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)，zzz是时间标准
static long UTC(int year, int month, int date, int hrs, int min, int sec) // Deprecated

## java.sql.Date构造器
Date(int year, int month, int day)  //Deprecated
Date(long date)

## java.sql.Date方法
int getHours() // Deprecated
int getMinutes() // Deprecated
int getSeconds() // Deprecated
void setHours(int i) // Deprecated
void setMinutes(int i) // Deprecated
void setSeconds(int i)  // Deprecated
void setTime(long date) 重置此时间
Instant toInstant()
LocalDate toLocalDate() 把此Date转成本地时间格式
String toString() // Formats a date in the date escape format yyyy-mm-dd.
static Date valueOf(LocalDate date)  从本地时间格式的LocalDate获取Date实例
static Date valueOf(String s) 从字符串中获取Date实例

过时的方法到SimpleDateFormat中找
```

示例  
[Date Test](./src/com/java/www/DateTest.java)  


# SimpleDateFormat类
位于java.text.SimpleDateFormat

Date类的API不易于国际化，大部分被废弃了，java.text.SimpleDateFormat类
是一个不与语言环境有关的方式来格式化和解析日期的具体类

## 主要作用
* 格式化：Date对象 -> 指定格式文本
* 解析：一定格式的文本 -> Date对象

## SimpleDateFormat构造器
SimpleDateFormat() 使用默认的本地时间格式构建一个SimpleDateFormat对象
SimpleDateFormat(String pattern) 使用指定的时间格式pattern构建一个SimpleDateFormat对象
SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols)
SimpleDateFormat(String pattern, Locale locale)

## 方法
```text
String format(Date date)  把Date对象转成时间字符串，其父类DateFormat类中的方法
StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition fieldPosition)
Date parse(String source) 把字符串解析成Date，日期的格式要对应上，以1970, 00:00:00 GMT基准时间
Date parse(String text, ParsePosition pos)

void applyLocalizedPattern(String pattern)
void applyPattern(String pattern)
Object clone()
boolean equals(Object obj)
AttributedCharacterIterator	formatToCharacterIterator(Object obj)
Date get2DigitYearStart()
DateFormatSymbols getDateFormatSymbols()
int hashCode()
void set2DigitYearStart(Date startDate)
void setDateFormatSymbols(DateFormatSymbols newFormatSymbols)
String toLocalizedPattern()
String toPattern()

```

示例  
[SimpleDateFormat Test](./src/com/java/www/SimpleDateFormatTest.java)  


# Calendar类
位于java.util.Calendar  
Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能



 
