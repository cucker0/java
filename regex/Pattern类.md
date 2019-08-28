pattern类
==

位于java.util.regex包下

# 字段
```text
static int CANON_EQ 
Enables canonical equivalence.
启用规范等效，该常量值为：0x80
当且仅当两个字符的"正规分解(canonical decomposition)"都完全相同的情况下，才认定匹配。比如用了这个标志之后，表达式"a/u030A"会匹配"?"。默认情况下，不考虑"规范相等性(canonical equivalence)"。

static int CASE_INSENSITIVE 
Enables case-insensitive matching.
开启不区分大小写模式，该常量值为：0x02
默认情况下，大小写不明感的匹配只适用于US-ASCII字符集。这个标志能让表达式忽略大小写进行匹配。要想对Unicode字符进行大小不明感的匹配，只要将UNICODE_CASE与这个标志合起来就行了。

static int COMMENTS 
Permits whitespace and comments in pattern.
允许pattern中存在空白和注释，该常量值为：0x04
在这种模式下，匹配时会忽略(正则表达式里的)空格字符(注：不是指表达式里的"//s"，而是指表达式里的空格，tab，回车之类)。注释从#开始，一直到这行结束。可以通过嵌入式的标志来启用Unix行模式。
在这种模式下，表达式'.'可以匹配任意字符，包括表示一行的结束符。默认情况下，表达式'.'不匹配行的结束符。

static int DOTALL 
Enables dotall mode.
开启dotall模式，即 . 可以匹配任何字符。这里的dotall即dot all
在这种模式下，'^'和'$'分别匹配一行的开始和结束。此外，'^'仍然匹配字符串的开始，'$'也匹配字符串的结束。默认情况下，这两个表达式仅仅匹配字符串的开始和结束。

static int LITERAL 
Enables literal parsing of the pattern.
开启pattern模式中的文字分析。即Matcher在处理时，元字符或转义字符当文字处理，无特殊意义。但我们使用Pattern时就可以使用转义字符了
该常量值为：0x10
在这个模式下，如果你还启用了CASE_INSENSITIVE标志，那么它会对Unicode字符进行大小写不明感的匹配。默认情况下，大小写不明感的匹配只适用于US-ASCII字符集。

static int MULTILINE 
Enables multiline mode.
开启多行模式，该常量值为：0x08

static int UNICODE_CASE 
Enables Unicode-aware case folding.
开启Unicode字符不区分大小写模式，该常量值为：0x40

static int UNICODE_CHARACTER_CLASS 
Enables the Unicode version of Predefined character classes and POSIX character classes.
启用预定义字符类和POSIX字符类的Unicode版本，该常量值为：0x100

static int UNIX_LINES 
Enables Unix lines mode.
启用Unix行模式，即只有"\n"才识别为终止符，该常量值为：0x01
在这个模式下，只有'/n'才被认作一行的中止，并且与'.'，'^'，以及'$'进行匹配。

```

# 构造器
```text
私有的构造器
private Pattern(String p, int f)
p: 正则表达式字符串，
f: flag标识

```

# 方法
```text
Predicate<String> asMatchPredicate() 
Creates a predicate that tests if this pattern matches a given input string.

Predicate<String> asPredicate() 
Creates a predicate that tests if this pattern is found in a given input string.

static Pattern compile​(String regex) 
Compiles the given regular expression into a pattern.
把给定的正则表达式regex编译成pattern并返回，return new Pattern(regex, 0);

static Pattern compile​(String regex, int flags) 
Compiles the given regular expression into a pattern with the given flags.
把给定的正则表达式regex和匹配flags编译成pattern并返回，return new Pattern(regex, flags);
举例：Pattern p = Pattern.compile​("\w+", Pattern.UNICODE_CASE);

int flags() 
Returns this pattern's match flags.
获取pattern的匹配flags

Matcher matcher​(CharSequence input) 
Creates a matcher that will match the given input against this pattern.
创建一个matcher，该matcher可根据此pattern匹配给定的字符串input。
这步很重要，即指定要进行匹配的字符串

static boolean matches​(String regex, CharSequence input) 
Compiles the given regular expression and attempts to match the given input against it.
判断给定的正则表达式regex与指定的字符串input是否匹配。
    public static boolean matches(String regex, CharSequence input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

String pattern() 
Returns the regular expression from which this pattern was compiled.
返回该此编译过的pattern对象的正则表达式

static String quote​(String s) 
Returns a literal pattern String for the specified String.
返回指定字符串的文本模式字符串

String[] split​(CharSequence input) 
Splits the given input sequence around matches of this pattern.
以正则表达式为界，将指定字符串input分割成String数组,该pattern需要编译过

String[] split​(CharSequence input, int limit) 
Splits the given input sequence around matches of this pattern.
以正则表达式为界，将指定字符串input分割成String数组,该pattern需要编译过。
* limit 控制pattern匹配的次数，limit为正数、0、负数是效果不一样。
    * If the limit is positive then the pattern will be applied at most limit - 1 times, the array's length will be no greater than limit, and the array's last entry will contain all input beyond the last matched delimiter.
    * If the limit is zero then the pattern will be applied as many times as possible, the array can have any length, and trailing empty strings will be discarded.
    *If the limit is negative then the pattern will be applied as many times as possible and the array can have any length.


Stream<String> splitAsStream​(CharSequence input) 
Creates a stream from the given input sequence around matches of this pattern.
以正则表达式为界，将指定字符串input分割成Stream数组，该pattern需要编译过

String toString() 
Returns the string representation of this pattern.
返回正则表达式的字符串

```

