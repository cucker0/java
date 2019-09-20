package com.java.udp;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO UDP 非阻塞网络编程
 *
 * 功能：客户端可以多次键盘输入，发送到对端
 *
 */
public class NioUdpNonBlockingTest {
    @Test
    public void server() {
        DatagramChannel datagramChannel = null;
        try {
            // 1. 创建通道
            datagramChannel = DatagramChannel.open();

            // 2. 配置通道为非阻塞模式
            datagramChannel.configureBlocking(false);

            // 3. 绑定连接
            datagramChannel.bind(new InetSocketAddress(6060));

            // 4. 创建Selector选择器
            Selector selector = Selector.open();

            // 5. 把通道上的 READ实践注册到 选择器上
            datagramChannel.register(selector, SelectionKey.OP_READ);

            // 遍历选择器上就绪的事件
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) { // READ已准备就绪的事件
                        ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);
                        datagramChannel.receive(buffer);
                        buffer.flip();
                        String data = new String(buffer.array());
                        System.out.println(data);
                        buffer.clear();
                    }
                }
                // selector选择器上取消此事件的注册，否则会在重复处理
                iterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭通道
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
        try {
            // 1. 创建通道
            datagramChannel = DatagramChannel.open();
            // 2. 配置通道为非阻塞模式
            datagramChannel.configureBlocking(false);

            // 3. 创建指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

            // 4.利用缓冲区来向通道发送数据
            Scanner sc = new Scanner(System.in);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6060);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            while (true) {
                String str = sc.next();
                String dateTime = LocalDateTime.now(ZoneId.of("+8")).format(formatter);
                String data = String.format("%s: %s", dateTime, str);
                // 向缓冲区写入要发送的数据
                buffer.put(data.getBytes());
                // 读取缓冲区数据到通道去发送
                buffer.flip();
                datagramChannel.send(buffer, inetSocketAddress);
                // 清空缓冲区数据
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭通道
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
