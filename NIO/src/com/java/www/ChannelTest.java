package com.java.www;

import org.junit.Test;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
 * NIO中通道主要实现类
 * open(Path path, OpenOption... options) 方法
 *  java.nio.channels.Channel接口，以下是其实现类
 *      |--FileChannel
 *      |--SocketChannel
 *      |--ServerSocketChannel
 *      |--DatagramChannel
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

}
