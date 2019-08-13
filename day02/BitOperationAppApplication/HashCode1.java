/*
StringLatin1 HashCode method
String HashCode计算方法之一

& 0xff: 只取得低八位

* */


final class StringLatin1 {

    public static int hashCode(byte[] value) {
        int h = 0;
        for (byte v : value) {
            h = 31 * h + (v & 0xff);
        }
        return h;
    }
}