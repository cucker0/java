package com.java.tcp;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * NIO TCP 非阻塞socket网络编程
 *
 * serverSocketChannel的register方法
 * SelectionKey register(Selector sel, int ops)
 * sel: 选择器，
 * ops: 事件，这里是用int类型来表示，多个事件之间用|位或运算，electionKey.OP_ACCEPT|SelectionKey.OP_CONNECT。SelectionKey该类已定义好常用事件
 *
 *
 */
public class NioTcpNonblockingTest {
    @Test
    public void server() {
        // 1. 获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2. 配置服务端通道为非阻塞模式
        serverSocketChannel.configureBlocking(false); // 默认是阻塞模式

        // 3. 绑定InetSocketAddress
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // 4. 创建一个选择器
        Selector selector = Selector.open();

        // 5. 把serverSocketChannel注册到选择器，并指定监听ACCEPT的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6. 轮询获取选择器上 已经准备就绪的事件
        while (selector.select() > 0) { // selector.select(): 表示就绪的事件数量
            // 7. 获取当前选择器中所有注册的 就绪监听事件(选择键)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();


        }


    }

    @Test
    public void client() {
        SocketChannel socketChannel = null;
        try {
            // 1. 获取通道
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));

            // 2. 配置为非阻塞模式
            socketChannel.configureBlocking(false);

            // 3. 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

            // 4. 发送数据到服务端
            buffer.put(LocalDateTime.now().toString().getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭通道
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
