Matcher类
==

位于：位于java.util.regex包下
实现了java.util.regex.MatchResult接口

# 构造器
```text
Matcher()
默认修饰的构造器，只能在其所在的java.util.regex包下使用

Matcher(Pattern parent, CharSequence text)
默认修饰的构造器

```

# 方法
```text
Matcher appendReplacement​(StringBuffer sb, String replacement) 
Implements a non-terminal append-and-replace step.
把给定人字符串追加到指定的字符缓冲sb，并返回此Matcher对象
This method performs the following actions:

1. It reads characters from the input sequence, starting at the append position, and appends them to the given string buffer. 
It stops after reading the last character preceding the previous match, that is, the character at index start() - 1.
2. It appends the given replacement string to the string buffer.
3. It sets the append position of this matcher to the index of the last character matched, plus one, that is, to end().

Matcher appendReplacement​(StringBuilder sb, String replacement) 
Implements a non-terminal append-and-replace step.
把给定人字符串追加到指定的StringBuilder sb，并返回此Matcher对象

StringBuffer appendTail​(StringBuffer sb) 
Implements a terminal append-and-replace step.
从 input 字符序列的append偏移位置开始读取字符追加到指定的StringBuffer sb

StringBuilder appendTail​(StringBuilder sb) 
Implements a terminal append-and-replace step.
从 input 字符序列的append偏移位置开始读取字符追加到指定的StringBuilder sb

int end() 
Returns the offset after the last character matched.
返回匹配了最后一个字符后的偏移量

int end​(int group) 
Returns the offset after the last character of the subsequence captured by the given group during the previous match operation.
返回在上一个匹配操作中由给定的组{group}捕获组捕获的子序列，在匹配最后一个字符后的偏移量

int end​(String name) 
Returns the offset after the last character of the subsequence captured by the given named-capturing group during the previous match operation.
返回在上一个匹配操作中由给定的捕获组名为{name}捕获的子序列，在匹配最后一个字符后的偏移量

boolean find() 
Attempts to find the next subsequence of the input sequence that matches the pattern.
试图在输入序列找到与Pattern里的正则匹配的的下一个子序列，如果找到，返回true,否则返回false。
如果匹配成功，则调用start、end和group能获取更多信息

boolean find​(int start) 
Resets this matcher and then attempts to find the next subsequence of the input sequence that matches the pattern, starting at the specified index.
重置此匹配器，然后尝试从指定的索引start开始查找与模式匹配的输入序列的下一个子序列，返回是否匹配

String group() 
Returns the input subsequence matched by the previous match.
返回与上一匹配项匹配的输入子序列

String group​(int group) 
Returns the input subsequence captured by the given group during the previous match operation.
返回在上一个匹配操作期间由给定组捕获的输入子序列

String group​(String name) 
Returns the input subsequence captured by the given named-capturing group during the previous match operation.
返回在上一个匹配操作中由给定的名字捕获组(name)捕获的输入子序列。

int groupCount() 
Returns the number of capturing groups in this matcher's pattern.
返回此Matcher中捕获组的组数目

boolean hasAnchoringBounds() 
Queries the anchoring of region bounds for this matcher.
返回此matcher是否使用锚定边界(Anchoring Bounds)

boolean hasTransparentBounds() 
Queries the transparency of region bounds for this matcher.
返回此matcher对象是否使用透明边界(transparent bounds)

boolean hitEnd() 
Returns true if the end of input was hit by the search engine in the last match operation performed by this matcher.
此matcher上次执行的匹配操作中是否命中了输入的结尾

boolean lookingAt() 
Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
返回输入字符串是否已pattern的正则开头，如字符串：aabcde123, 是否与aa开头，grep "^aa" 效果类似 
使用此Matcher的pattern从头开始匹配已输入的字符串

boolean matches() 
Attempts to match the entire region against the pattern.
返回输入的字符串是否与pattern中的正则表达式完全匹配。

Pattern pattern() 
Returns the pattern that is interpreted by this matcher.
返回此matcher对象的pattern

static String quoteReplacement​(String s) 
Returns a literal replacement String for the specified String.
把指定字符串中的"$"替换换为"\"，s不修改，会产生一个新的字符串返回。在替换过程中'\'当普通字符，而不是转义字符

Matcher region​(int start, int end) 
Sets the limits of this matcher's region.
重置此Matcher，并指定搜索的开始和结束索引

int regionEnd() 
Reports the end index (exclusive) of this matcher's region.
返回此mather的结束索引

int regionStart() 
Reports the start index of this matcher's region.
返回此mather的开始索引

String replaceAll​(String replacement) 
Replaces every subsequence of the input sequence that matches the pattern with the given replacement string.
将输入字符串里所有与模式相匹配的子串全部替换成replacement

String replaceAll​(Function<MatchResult,​String> replacer) 
Replaces every subsequence of the input sequence that matches the pattern with the result of applying the given replacer function to the match result of this matcher corresponding to that subsequence.
将输入字符串里所有与模式相匹配的子串全部替换成 replacer.apply(this)

String replaceFirst​(String replacement) 
Replaces the first subsequence of the input sequence that matches the pattern with the given replacement string.
将输入字符串里第一与模式相匹配的子串替换成replacement

String replaceFirst​(Function<MatchResult,​String> replacer) 
Replaces the first subsequence of the input sequence that matches the pattern with the result of applying the given replacer function to the match result of this matcher corresponding to that subsequence.
将输入字符串里第一与模式相匹配的子串替换成 replacer.apply(this)

boolean requireEnd() 
Returns true if more input could change a positive match into a negative one.
返回requireEnd

Matcher reset() 
Resets this matcher.
重置此matcher，并返回此matcher.
append position to zero, 
The matcher's region is set to the default region

Matcher reset​(CharSequence input) 
Resets this matcher with a new input sequence.
用新的输入序列input重置此matcher，并返回此matcher。相比reset(), 前面多了步text = input; text即为要进行匹配的字符串
如果还要用当前的正则表达式继续匹配下一个字符串，则执行 Matcher m2 = 当前的mathcer.reset​("要匹配的字符串");

Stream<MatchResult> results() 
Returns a stream of match results for each subsequence of the input sequence that matches the pattern.
返回与pattern匹配的输入序列的多个子序列的匹配结果流数组成的数组

int start() 
Returns the start index of the previous match.
返回上一个匹配项的开始索引

int start​(int group) 
Returns the start index of the subsequence captured by the given group during the previous match operation.
返回给定组group在上一个匹配操作期间捕获的子序列的起始索引。


int start​(String name) 
Returns the start index of the subsequence captured by the given named-capturing group during the previous match operation.
返回给定组名为name在上一个匹配操作期间捕获的子序列的起始索引。

MatchResult toMatchResult() 
Returns the match state of this matcher as a MatchResult.
将此matcher的匹配状态作为匹配结果返回

String toString() 
Returns the string representation of this matcher.


Matcher useAnchoringBounds​(boolean b) 
Sets the anchoring of region bounds for this matcher.
设置此matcher的anchoringBounds值(锚定界限)，并返回此matcher

Matcher usePattern​(Pattern newPattern) 
Changes the Pattern that this Matcher uses to find matches with.
修改此matcher的Pattern匹配模式，并返回此mathcer

Matcher useTransparentBounds​(boolean b) 
Sets the transparency of region bounds for this matcher.
设置此matcher的transparentBounds值(透明边界)，并返回此matcher

```