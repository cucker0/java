/*
StringUTF16 HashCode method
String HashCode计算方法之一

* */

final class StringUTF16 {

    public static int hashCode(byte[] value) {
        int h = 0;
        int length = value.length >> 1; // 计算字符长度，除以2，因为UTF16是两个字节表示一个字符
        for (int i = 0; i < length; i++) {
            h = 31 * h + getChar(value, i);
        }
        return h;
    }


}