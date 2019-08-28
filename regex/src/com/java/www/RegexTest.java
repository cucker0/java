package com.java.www;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 */
public class RegexTest {


    /**
     * Pattern flags测试
     *
     * 从多行字符串中匹配配以"java"，"Java"，"JAVA"...开头的字符串
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
/*
// 运行结果：
java
Java
JAVA
* */
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
        * (?m) 表示匹配多行
        * */
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(input);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); ++i) {
                System.out.printf("[ %s ]", m.group(i));
            }
            System.out.println();
        }
        /*
// 运行效果
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
// 运行结果
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
        String input = "cat cat cattie cat";
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
// 运行结果
match count: 1
start(): 0
end(): 3

match count: 2
start(): 4
end(): 7

match count: 3
start(): 15
end(): 18
* */
    }


    /**
     * Matcher.lookingAt()、Matcher.matches()
     *
     * lookingAt()：输入的字符串是否以pattern开头
     * matches()：输入的字符串是否完全与pattern匹配
     */
    @Test
    public void test6() {
        String regex = "foo";
        String input1 = "fooooooooooooooooo";
        String input2 = "ooooofoooooooooooo";
        Pattern p;
        Matcher m1, m2;

        p = Pattern.compile(regex);
        m1 = p.matcher(input1);

        System.out.println("regex: " +  regex);
        System.out.println("input1: " +  input1);
        System.out.println("input2: " +  input2);

        System.out.println("input1 Matcher.lookingAt(): " + m1.lookingAt());
        System.out.println("input1 Matcher.matches(): " + m1.matches());
//        m2 = p.matcher(input2); // 这方法上面已经用过，是可以
        m2 = m1.reset(input2); // 可以通过重置m1，并指定要匹配字符串，返回此Matcher对象

        System.out.println("input2 Matcher.lookingAt(): " + m2.lookingAt());

/*
// 运行结果
regex: foo
input1: fooooooooooooooooo
input2: ooooofoooooooooooo
input1 Matcher.lookingAt(): true
input1 Matcher.matches(): false
input2 Matcher.lookingAt(): false

* */
    }


    /**
     * Matcher.replaceFirst(String replacement)、Matcher.replaceAll(String replacement)
     *
     * Matcher.replaceFirst(String replacement)：用指定的字符串replacement替换输入字符串中匹配到的第一个子字符串，返回被替换后的新字符串，不修改原输入字符串
     * Matcher.replaceAll(String replacement)：用指定的字符串replacement替换输入字符串中匹配到的所有子字符串，返回被替换后的新字符串，不修改原输入字符串
     */
    @Test
    public void test7() {
        String regex = "dog";
        String input = "The dog says meow. " +
                "All dogs say meow.";
        String replace = "cat";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        String str = m.replaceAll(replace);
        System.out.println("input：" + input); // 不改变
        System.out.println("Matcher.replaceAll(String replacement)  ：" + str);
        m = m.reset(input);
        String str2 = m.replaceFirst(replace);
        System.out.println("Matcher.replaceFirst(String replacement)：" + str2);
/*
// 运行结果
input：The dog says meow. All dogs say meow.
Matcher.replaceAll(String replacement)  ：The cat says meow. All cats say meow.
Matcher.replaceFirst(String replacement)：The cat says meow. All dogs say meow.

* */
    }

    /**
     * Matcher.appendReplacement(StringBuilder sb, String replacement)、Matcher.appendReplacement(StringBuilder sb)、
     * Matcher.appendReplacement(StringBuffer sb, String replacement)、Matcher.appendReplacement(StringBuffer sb)
     *
     * Matcher.appendReplacement(StringBuilder sb, String replacement)：
     *              用指定的字符串replacement替换输入字符串中匹配到的所有字符串，替换后的新字符串追加到指定的StringBuilder sb，并返回此Matcher对象。输入的字符串不修改
     * Matcher.appendReplacement(StringBuilder sb)：从 输入字符序列的append偏移位置开始读取字符追加到指定的StringBuilder sb，相当于把输入字符串中匹配的最后一个字符串的最后一个字符位置之后的字符都追加到StringBuilder sb
     * Matcher.appendReplacement(StringBuffer sb, String replacement)：
     *              用指定的字符串replacement替换输入字符串中匹配到的所有字符串，替换后的新字符串追加到指定的StringBuffer sb，并返回此Matcher对象。输入的字符串不修改
     *
     * Matcher.appendReplacement(StringBuffer sb)：从 输入字符序列的append偏移位置开始读取字符追加到指定的StringBuffer sb，相当于把输入字符串中匹配的最后一个字符串的最后一个字符位置之后的字符都追加到StringBuffer sb
     */
    @Test
    public void test8() {
        String regex = "a*b";
        String input = "aabfooaaabfooabfoobkkk";
        String replace = "-";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
//        StringBuffer sb = new StringBuffer(); // StringBuffer也可以
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            m.appendReplacement(sb, replace);
        }
        System.out.println("Matcher.appendReplacement(StringBuilder sb, String replacement)：" + sb.toString()); // 最后面的"kkk" 没有追加到StringBuilder sb中
        System.out.println("input: " + input);
        m.appendTail(sb);
        System.out.println("Matcher.appendReplacement(StringBuilder sb)：" + sb.toString()); // 把后面的"kkk" 追加到StringBuilder sb中
/*
// 运行结果
Matcher.appendReplacement(StringBuilder sb, String replacement)：-foo-foo-foo-
input: aabfooaaabfooabfoobkkk
Matcher.appendReplacement(StringBuilder sb)：-foo-foo-foo-kkk

* */
    }

    /**
     * Matcher usePattern​(Pattern newPattern)、Matcher Matcher.reset(CharSequence input)、Matcher Matcher.reset()
     *
     * reset(CharSequence input)：重置此Matcher，并重置输入的字符串，最后返回此Matcher。可用同一个Mathcer匹配多个输入的字符串，这样效率也高
     * reset()：重置此Matcher，不重置输入的字符串，最后返回此Matcher。
     * usePattern​(Pattern newPattern)：重置Matcher对象中的pattern为newPattern，及用另一个正则表达式来匹配输入的字符串
     */
    @Test
    public void test9() {
        String regex1 = "foo";
        String regex2 = "^name:";
        String input1 = "fooooooooooooooooo";
        String input2 = "name:oofoooooooooooo";

        Pattern p = Pattern.compile(regex1);
        Pattern p2 = Pattern.compile(regex2);
        Matcher m = p.matcher(input1);
        System.out.printf("find():%s, start():%s, end():%s\n" , m.find(), m.start(), m.end());

        // 重置Matcher对象中输入的字符串 Matcher.reset(CharSequence input)
        Matcher m2 = m.reset(input2); // 此时的 m2 == m，即为同一个对象
        System.out.println("Matcher.reset(CharSequence input)  重置Matcher对象中输入的字符串后：");
        System.out.printf("find():%s, start():%s, end():%s\n" , m2.find(), m2.start(), m2.end());
        System.out.println();

        //重置Matcher对象中的pattern，usePattern​(Pattern newPattern)
        m.usePattern(p2);
        System.out.println("usePattern\u200B(Pattern newPattern) 重置Matcher对象中的pattern后：");
        System.out.println(m.lookingAt());

/*
// 运行结果
find():true, start():0, end():3
Matcher.reset(CharSequence input)  重置Matcher对象中输入的字符串后：
find():true, start():7, end():10

usePattern​(Pattern newPattern) 重置Matcher对象中的pattern后：
true

* */
    }

    /**
     * PatternSyntaxException 异常
     * 非强制异常
     *
     * String getDescription()
     *      获取错误的描述
     * int e.getIndex())
     *      获取错误的索引
     * String getPattern())
     *      获取错误的正则表达式模式
     * String getMessage()
     *      返回多行字符串，包含语法错误及其索引的描述、错误的正则表达式模式和模式中错误索引的可视化指示
     */
    @Test
    public void test10() {
        String regex = "$dog";
        String input = "The dog says meow. " +
                "All dogs say meow.";
        String replace = "cat";
        Pattern p = null;
        try {
            p = Pattern.compile(regex); // 这有可能报 PatternSyntaxException 异常
            Matcher m = p.matcher(input);
            System.out.println(m.replaceAll(replace));
        } catch (PatternSyntaxException e) {
            System.out.println(e.getDescription());
            System.out.printf("indes: %d", e.getIndex());
            System.out.println(e.getPattern());
            System.out.println(e.getMessage());
        }

    }

}
