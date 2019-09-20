package com.java.tcp;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO TCP 非阻塞socket网络编程
 *
 * serverSocketChannel的register方法
 * SelectionKey register(Selector sel, int ops)
 * sel: 选择器，
 * ops: 事件，这里是用int类型来表示，多个事件之间用|位或运算，electionKey.OP_ACCEPT|SelectionKey.OP_CONNECT。SelectionKey该类已定义好常用事件
 *
 * SelectionKey事件类型：
 * OP_READ
 * OP_WRITE
 * OP_CONNECT
 * OP_ACCEPT
 */
public class NioTcpNonblockingTest {
    @Test
    public void server() {
        ServerSocketChannel serverSocketChannel = null;
        try {
            // 1. 获取服务端通道
            serverSocketChannel = ServerSocketChannel.open();

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
                while (iterator.hasNext()) {
                    // 8. 获取已准备就绪的事件
                    SelectionKey key = iterator.next();
                    // 9. 判断事件类型
                    if (key.isAcceptable()) {
                        // 10. 接收事件就绪了，获取与客户端的通道
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 11. 把与客户端连接的通道配置为非阻塞的
                        socketChannel.configureBlocking(false);
                        // 12. 将此通道的下一个事件read注册到选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        // 13. 获取 读就绪 的通道
                        SocketChannel readChannel = (SocketChannel) key.channel();

                        // 14. 读取数据
                        ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);
                        int len;
                        while ((len = readChannel.read(buffer)) > 0) { // 如果用(len = readChannel.read(buffer)) != -1 会无限打印第一条数据
                            buffer.flip();
                            System.out.println(new String(buffer.array()));
                            buffer.clear();
                        }
                    }

                    // 15. 取消选择键SelectionKey，每个SelectionKey只能执行一次
                    iterator.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

            while (true) {
                String str = sc.next();
//                buffer.put((LocalDateTime.now().toString()).getBytes());
                String dateTime = LocalDateTime.now(ZoneId.of("+8")).format(formatter);
                String msg = String.format("%s: %s", dateTime, str);
                buffer.put(msg.getBytes());
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
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
