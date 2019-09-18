package com.java.tcp;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用NIO完成网络通信的核心
 * Channel通道: 负责连接
 *      java.nio.channels.Channel
 *          |--SelectableChannel
 *              |--SocketChannel
 *              |--ServerSocketChannel
 *              |--DatagramChannel
 *
 *              |--Pipe.SinkChannel
 *              |--Pipe.SourceChannel
 * Buffer缓冲区: 存取数据的容器，负责数据的存取
 * Selector选择器: 是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 *
 *
 *
 * NIO TCP socket编程需求：客户端发送文件，服务端接受并保存文件
 */
public class NioTcpBlockingTest {
    @Test
    public void server() {
        ServerSocketChannel serverSocketChannel = null;
        FileChannel fileChannel = null;
        SocketChannel socketChannel = null;
        try {
            // 1. 获取通道
            serverSocketChannel = ServerSocketChannel.open();
            fileChannel = FileChannel.open(Path.of("./ph21.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            // 2. 绑定连接
            serverSocketChannel.bind(new InetSocketAddress(9000));

            // 3. 获取客户端连接的通道，并开始侦听，开始侦听是发生阻塞
            socketChannel = serverSocketChannel.accept();

            // 4. 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

            // 5. 读取客户端通道数据到缓冲区，读取缓冲区数据保存到本地文件通道
            while (socketChannel.read(buffer) != -1) {
                buffer.flip(); // 切换到数据读取模式
                fileChannel.write(buffer);
                buffer.clear(); // 清空缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭通道
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        FileChannel fileChannel = null;
        try {
            // 1. 获取通道
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9000));
            fileChannel = FileChannel.open(Paths.get("./ph.png"), StandardOpenOption.READ);

            // 2. 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

            // 3. 读取本地文件到缓冲区，再读取缓冲区的数据发送到服务端
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }

            // 4. 关闭资源通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
