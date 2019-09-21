package com.java.www;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Buffer缓冲区
 * 在java NIO中负责数据的存取。缓冲区本质是数组，用于存取不同类型的数据
 *
 * 不同数据类型的缓冲区(队boolean类型外)
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * Buffuer重要属性
 * capacity: 缓冲区的容量，final修改，声明后不可更改
 * limit: 界限，表示缓冲区中可以操作数据(读或写)的大小。
 * position: 偏移位置，表示缓冲区中正在操作数据的偏移位置
 * mark: 用于标记当前偏移位置的变量，-1表示还未标记过
 *
 * 不变式: mark <= position <= limit <= capacity
 *
 *
 * mark(): 记录当前的position位置，即mark = position
 * reset(): position恢复到mark记录的位置，可用于再重读等需求。当 mark >= 0，则position = mark
 * boolean hasRemaining(): 从目前的position到limit是否有元素
 * int remaining(): 从目前的position到limit的元素个数
 *
 * 非直接缓冲区 与 直接缓冲区
 * 非直接缓冲区：通过allocate(int capacity)创建，将缓冲区建立在JVM的堆内存中。HeapByteBufferd对象
 * 直接缓冲区：通过allocateDirect(int capacity)创建，将缓冲区建立在物理内存中，可提高效率。但无法被JVM的GC管理了。DirectByteBufferd对象
 */
public class BufferTest {
    @Test
    public void test1() {
        // 创建一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // HeapByteBufferd对象，一般这种类型的
        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(1024); // DirectByteBufferd对象，内存分配在操作系统中，非JVM中，需要跟外设IO设备交互时使用这种。

        System.out.println(byteBuffer.mark()); // mark = position; 并返回此Buffer对象，如：java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]
        System.out.println("position: " + byteBuffer.position()); // 0
        System.out.println("limit: " + byteBuffer.limit()); // 1024
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
//        System.out.println(byteBuffer.reset());
        System.out.println();

        // put(T[] src)，向缓冲区写入数据
        String str = "abcdefg";
        byteBuffer.put(str.getBytes());
        System.out.println("========== put(T[] src) ==========");
        System.out.println("position: " + byteBuffer.position()); // 7
        System.out.println("limit: " + byteBuffer.limit()); // 1024
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
        System.out.println();

        // flip() 切换读取数据模式，
        // mark = position; position = 0
        byteBuffer.flip();
        System.out.println("========== flip() ==========");
        System.out.println("position: " + byteBuffer.position()); // 0
        System.out.println("limit: " + byteBuffer.limit()); // 7
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
        System.out.println();

        // get(T[] dst) 从此缓冲区读取数据，读取一个 ++position
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b);
//        System.out.println(Arrays.toString(b));
        System.out.println(new String(b));
        System.out.println("========== get(T[] dst) ==========");
        System.out.println("position: " + byteBuffer.position()); // 7
        System.out.println("limit: " + byteBuffer.limit()); // 7
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
        System.out.println();

//        byte[] bb = new byte[byteBuffer.limit()];
//        byteBuffer.get(bb); // 当Buffer已经get过后，不能连续再get
//        System.out.println(new String(bb));

        // rewind() 倒回起点，可重复读。
        // position = 0, mark = -1;
        byteBuffer.rewind();
        System.out.println("========== rewind() ==========");
        System.out.println("position: " + byteBuffer.position()); // 0
        System.out.println("limit: " + byteBuffer.limit()); // 7
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
        System.out.println();

        byte[] bb = new byte[byteBuffer.limit()];
        byteBuffer.get(bb);
        System.out.println(new String(bb));

        // clear() 清空缓存区。缓冲区用于存放数据数组中的数据没有被清空，但已经标记为可覆盖状态，只执行如下几个操作
        // position = 0; limit = capacity; mark = -1;
        byteBuffer.clear();
        System.out.println("========== clear() ==========");
        System.out.println("position: " + byteBuffer.position()); // 0
        System.out.println("limit: " + byteBuffer.limit()); // 1024
        System.out.println("capacity: " + byteBuffer.capacity()); // 1024
        System.out.println((char) byteBuffer.get()); // a
        System.out.println();
    }

    @Test
    public void test2() {
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        String s = "to make a tape in a cassette player";
        charBuffer.put(s);
        System.out.printf("position:%s, limit:%s, capacity:%s\n", charBuffer.position(), charBuffer.limit(), charBuffer.capacity()); // position:35, limit:1024, capacity:1024

        char[] c = new char[2];
        charBuffer.flip();
        charBuffer.get(c);
        System.out.println(new String(c)); // to
        System.out.printf("position:%s, limit:%s, capacity:%s\n", charBuffer.position(), charBuffer.limit(), charBuffer.capacity()); // position:2, limit:35, capacity:1024
        charBuffer.mark(); // mark = position;
        System.out.printf("position:%s, limit:%s, capacity:%s\n", charBuffer.position(), charBuffer.limit(), charBuffer.capacity()); // position:2, limit:35, capacity:1024
        charBuffer.get(c);
        System.out.println(new String(c)); // " m"
        System.out.printf("position:%s, limit:%s, capacity:%s\n", charBuffer.position(), charBuffer.limit(), charBuffer.capacity()); // position:4, limit:35, capacity:1024
        charBuffer.reset(); //  当mark >= 0，position = mark。可用于再重读
        System.out.printf("position:%s, limit:%s, capacity:%s\n", charBuffer.position(), charBuffer.limit(), charBuffer.capacity()); // position:2, limit:35, capacity:1024
        charBuffer.get(c);
        System.out.println(new String(c)); // " m"

        if (charBuffer.hasRemaining()) { // 从目前的position到limit是否有元素
            System.out.println(charBuffer.remaining()); // 从目前的position到limit的元素个数
        }
    }

    /**
     * 用一个较小的数组来读取缓冲区中较多的数据
     *
     */
    @Test
    public void test3() {
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        String s = "to make a tape in a cassette player";
        charBuffer.put(s);

        char[] c = new char[2];
        charBuffer.flip();
        int i;
        while ((i = charBuffer.limit() - charBuffer.position()) >= c.length) {
            charBuffer.get(c);
            System.out.println(new String(c));
        }
        if (i > 0) {
            charBuffer.get(c, 0, i);
            System.out.println(new String(c, 0, i));
        }
    }

}
