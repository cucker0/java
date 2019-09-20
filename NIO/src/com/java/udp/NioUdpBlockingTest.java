package com.java.udp;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 *
 * NIO UDP 阻塞socket网络编程
 * NIO UDP传输文件
 *
 */
public class NioUdpBlockingTest {
    @Test
    public void server() {
        DatagramChannel datagramChannel = null;
        FileChannel fileChannel = null;
        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.bind(new InetSocketAddress(7700));
            fileChannel = FileChannel.open(Path.of("./ph31.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

            SocketAddress socketAddress = null;
            for (int i = 0; ; ++i) {
                if (i == 0) {
                    socketAddress = datagramChannel.receive(buffer);
                } else {
                    datagramChannel.receive(buffer);
                }
                buffer.flip();
                fileChannel.write(buffer);
                System.out.println("接收次数：" + (i + 1));
                if (buffer.limit() < buffer.capacity()) { // 读取最后的一点文件，没把缓冲区塞满，客户端则发送文件完毕。当客户端走后一次发送的数据长度为缓冲区容量，则无法停止
                    break;
                }
                buffer.clear();
            }

            // 响应客户端
            buffer.clear();
            buffer.put("文件接收成功".getBytes());
            buffer.flip();
            datagramChannel.send(buffer, socketAddress);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭通道
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (datagramChannel != null) {
                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void client() {
        DatagramChannel datagramChannel = null;
        FileChannel fileChannel = null;
        try {
            datagramChannel = DatagramChannel.open();
            fileChannel = FileChannel.open(Path.of("./ph.png"));

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 7700);
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                datagramChannel.send(buffer, inetSocketAddress);
                buffer.clear();
                try {
                    Thread.sleep(10); // 防止发包过快丢包
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 接收服务端响应消息
//            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
//            datagramChannel.receive(buffer1);
//            buffer1.flip();
//            System.out.println(new String(buffer1.array()));

            // 或这种方式
            buffer.clear();
            datagramChannel.receive(buffer);
            buffer.flip();
            byte[] b = new byte[buffer.limit()];
            buffer.get(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭通道
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (datagramChannel != null) {
                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
