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
 * 阻塞式NIO TCP编程
 *
 * 使用NIO中的Channel + Buffer实现客户端给服务端发送文件
 */
public class BlockingNioTCPTest {
    @Test
    public void server() {
        Path path = Paths.get("./ph3.png");
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
            serverSocketChannel.bind(inetSocketAddress); // 绑定inetSocketAddress
            SocketChannel socketChannel = serverSocketChannel.accept();// 获取socketChannel，开始侦听

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (socketChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client() {
        Path path = Paths.get("./ph.png");
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);

        try (SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
             FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip(); // 翻转缓冲区，位置设为零
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
