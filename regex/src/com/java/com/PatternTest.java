package com.java.com;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {


    /**
     * Pattern flags测试
     *
     * 从多行字符串中匹配配以"java"，"Java"，"JAVA"...开头的字符串
     *
     * 运行结果：
     * java
     * Java
     * JAVA
     */
    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE); // 忽略大小写，开启多行模式， 这里的| 为位或运算
        Matcher matcher = pattern.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java"
        );

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }


    /**
     * Mather.find()
     * Mather.find(int start) 指定搜索的开始索引
     */
    @Test
    public void test2() {
        String input = "Evening is full of the linnet's wings";
        Matcher m = Pattern.compile("\\w+").matcher(input);
        while (m.find()) {
            System.out.println(m.group());
        }
        System.out.println("\n\n");

        int i = 0;
        while (m.find(i)) {
            System.out.println(m.group() + " ");
            ++i;
        }
    }

    /**
     * groups捕获组
     * 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     *
     * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式((A)(B(C)))，有四个这样的组
     * ((A)(B(C)))
     * (A)
     * (B(C))
     * (C)
     *
     * 可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。
     *
     * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中
     */
    @Test
    public void test3() {
        /*
        * 获取最后3个单词
        * */
        String input = "Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves,\n" +
                "And the mome raths outgrabe.\n\n" +
                "Beware the Jabberwock, my son,\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird, and shun\n" +
                "The frumious Bandersnatch.";
        /*
        * ('/S+'): 任意多个连续的非空字符
        * ('/s+')：任意多个连续的空格字符
        * */
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(input);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); ++i) {
                System.out.printf("[ %s ]", m.group(i));
            }
            System.out.println();
        }
        /*
// 运行效果：
[ the slithy toves ][ the ][ slithy toves ][ slithy ][ toves ]
[ in the wabe. ][ in ][ the wabe. ][ the ][ wabe. ]
[ were the borogoves, ][ were ][ the borogoves, ][ the ][ borogoves, ]
[ mome raths outgrabe. ][ mome ][ raths outgrabe. ][ raths ][ outgrabe. ]
[ Jabberwock, my son, ][ Jabberwock, ][ my son, ][ my ][ son, ]
[ claws that catch. ][ claws ][ that catch. ][ that ][ catch. ]
[ bird, and shun ][ bird, ][ and shun ][ and ][ shun ]
[ The frumious Bandersnatch. ][ The ][ frumious Bandersnatch. ][ frumious ][ Bandersnatch. ]

        * */

    }


    /**
     * Matcher.group()
     * 给定的字符串中找到数字串
     */
    @Test
    public void test4() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        // 正则表达式
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern p = Pattern.compile(pattern);

        // 创建Matcher对象
        Matcher m = p.matcher(line);
        if (m.find()) {
            System.out.println("m.group(): " + m.group() ); // group() 取的是group(0)
            System.out.println("m.group(0): " + m.group(0) );
            System.out.println("m.group(1): " + m.group(1) );
            System.out.println("m.group(2): " + m.group(2) );
            System.out.println("m.group(3): " + m.group(3) );
        } else {
            System.out.println("No match");
        }
/*
m.group(): This order was placed for QT3000! OK?
m.group(0): This order was placed for QT3000! OK?
m.group(1): This order was placed for QT
m.group(2): 3000
m.group(3): ! OK?
* */
    }


    /**
     * Matcher.start()、Matcher.end()
     * start(): 返回当前匹配子字符串第一个字符在被匹配字符串中的索引
     * end(): 返回当前匹配子字符串最后个字符在被匹配字符串中的索引 + 1
     */
    @Test
    public void test5() {
        /*
        * 查找 cat单词 出现在 "cat cat cat cattie cat" 中出现的次数，以及每个cat单词首末字母在这个字符串中索引位置
        * */

        String regex = "\\bcat\\b"; // 查找cat单词，\b表示匹配一个字边界。 "\bcat\b" 与 "cat"有区别，
        String input = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        int count = 0;
        while (m.find()) {
            ++count;
            System.out.println("match count: " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
            System.out.println();
        }
/*
match count: 1
start(): 0
end(): 3

match count: 2
start(): 4
end(): 7

match count: 3
start(): 8
end(): 11

match count: 4
start(): 19
end(): 22
* */
    }
}
