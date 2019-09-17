package com.java.www;

import org.junit.Test;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * 获取通道方法
 * IO流对象获取通道，对象.getChannel()
 *      本地IO
 *          FileInputStream/FileOutputStream
 *          RandomAccessFile
 *
 *      网络IO
 *          Socket
 *          ServerSocket
 *          DatagramSocket
 *
 * NIO中通道主要实现类，java 1.7开始，NIO2 针对各个通道类提供了静态的open方法
 * open(Path path, OpenOption... options) 方法
 *  java.nio.channels.Channel接口，以下是其实现类
 *      |--FileChannel
 *      |--SocketChannel
 *      |--ServerSocketChannel
 *      |--DatagramChannel
 *
 * 另外java 1.7开始，NIO2的Files工具类提供了newByteChannel
 *
 * 通道之间的数据传输
 * long transferTo(long position, long count, WritableByteChannel target)
 * long transferFrom(ReadableByteChannel src, long position, long count)
 *
 *
 * 分散读取 与 聚集写入
 * 分散读取：把通道中的数据分段写到多个缓冲区，写满一个再换下一个
 * 聚集写入：把多缓冲区中的数据逐个缓冲区数据写到通道，读取一个缓冲区再读下一个
 */
public class ChannelTest {
    /**
     * 本地文件IO对象获取channel方法
     * FileChannel 流对象.getChannel()
     */
    @Test
    public void test1() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./jdbc.conf");
            FileChannel inputStreamChannel = fileInputStream.getChannel();

            FileOutputStream fileOutputStream = new FileOutputStream("./nginx.conf");
            FileChannel outputStreamChannel = fileOutputStream.getChannel();

            RandomAccessFile raFile = new RandomAccessFile("./nginx.conf", "wr");
            FileChannel fileChannel = raFile.getChannel();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 网络IO socket对象获取channel
     */
    @Test
    public void test2() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            SocketChannel socketChannel = socket.getChannel();

            ServerSocket serverSocket = new ServerSocket(8080);
            ServerSocketChannel serverSocketChannel = serverSocket.getChannel();
            Socket socket1 = serverSocket.accept();

            DatagramSocket datagramSocket = new DatagramSocket(9090);
            DatagramChannel datagramSocketChannel = datagramSocket.getChannel();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 实现Channel的open相关方法
     *
     */
    @Test
    public void test3() {
        try {
            FileChannel fileChannel = FileChannel.open(Paths.get("./nginx.conf"), StandardOpenOption.READ);

            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9000));

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9090));

            DatagramChannel datagramChannel = DatagramChannel.open();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 利用通道完成文件的复制
     *
     */
    @Test
    public void test4() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("./ph.png");
            fos = new FileOutputStream("./ph11.png");
            // 1. 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 2. 分配一个指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // 3. 将in通道中的数据写入缓冲区
            while ((inChannel.read(byteBuffer)) != -1) {
                // 4. 读取缓冲区中数据写入out通道
                // 需要先将缓冲区切换到 数据读取模式
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                // 每次读取完缓冲区数据后，做清空处理
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( outChannel != null ) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( inChannel != null ) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( fos != null ) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( fis != null ) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 使用直接缓冲区复制文件，利用内存映射文件
     *
     */
    @Test
    public void test5() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Path.of("./ph.png"));
            outChannel = FileChannel.open(Paths.get("./ph12.png"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            // 内存映射文件
            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作
            byte[] b = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(b); // 从inMappedByteBuffer缓冲区中读取数据到数组b中
            outMappedByteBuffer.put(b); // 把数组b中的数据写入到outMappedByteBuffer缓冲区中
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 通道之间的数据传输
     * long transferTo(long position, long count, WritableByteChannel target)
     * long transferFrom(ReadableByteChannel src, long position, long count)
     */
    @Test
    public void test6() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Path.of("./ph.png"));
            outChannel = FileChannel.open(Paths.get("./ph13.png"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            // 通道之间传输数据
//            inChannel.transferTo(0, inChannel.size(), outChannel);
            // 或
            outChannel.transferFrom(inChannel, 0, inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 闭关资源
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 分散读取、聚集写入
     *
     */
    @Test
    public void test7() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("./sige.txt", "rw");
            inChannel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(20);
            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            ByteBuffer[] buffers = new ByteBuffer[]{buffer, buffer1, buffer2};

            // 分散读取
            inChannel.read(buffers);

            for (ByteBuffer byteBuffer : buffers) {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array()));
                System.out.println("==========================");
                System.out.printf("position:%s, limit:%s\n", byteBuffer.position(), byteBuffer.limit());

            }

            // 聚集写入
            outChannel = FileChannel.open(Paths.get("./sige2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            outChannel.write(buffers);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
