/*
TCP Server端

题目：
    客户端发送内容给服务端，服务端将内容打印到控制台上。

先启动server端，再启动client端
* */

package com.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            // 创建ServerSocket对象，指定监听的端口
            serverSocket = new ServerSocket(8080);
            // 开始监听并接受请求
            socket = serverSocket.accept();
            // 获取socket输入流
            inputStream = socket.getInputStream();
            // 读取内容
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭socket输入流、socket、ServerSocket
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
