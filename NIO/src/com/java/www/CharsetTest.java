package com.java.www;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Charset 字符集
 * 编码：字符数组 -> 字节数组
 * 解码：字节数组 -> 字符数组
 *
 *
 *
 */
public class CharsetTest {
    /**
     * 字符集
     */
    @Test
    public  void test() {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();
        System.out.println("数量: " + entries.size());
        entries.forEach(System.out::println);
    }

    @Test
    public void test8() {
        // 返回指定字符集名的字符集
        Charset charset = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder encoder = charset.newEncoder();

        // 获取解码器
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("我信你个鬼，你个槽老头，坏得很！！！");
        buffer.flip();
        System.out.println(buffer.getClass());

        // 编码
        ByteBuffer encodeBuffer = null;
        try {
            encodeBuffer = encoder.encode(buffer);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        while (encodeBuffer.hasRemaining()) {
            System.out.print(encodeBuffer.get() + " ");
        }
        System.out.println();

        // 解码
        encodeBuffer.flip();
        try {
            CharBuffer decodeBuffer = decoder.decode(encodeBuffer);
            System.out.println(decodeBuffer.toString());
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 当编码字符集与解码字符集不是同一种是，出现乱码
        Charset utf8 = Charset.forName("utf-8");
        encodeBuffer.flip();
        CharBuffer decode = utf8.decode(encodeBuffer);
        System.out.println(decode);
    }
}
