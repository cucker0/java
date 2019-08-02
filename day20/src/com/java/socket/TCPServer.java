/*
TCP Server端

题目：
    客户端持续发送内容给服务端，输入q或exit是退出，服务端将内容打印到控制台上。

先启动server端，再启动client端
* */

package com.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 创建ServerSocket对象，指定监听的端口
            serverSocket = new ServerSocket(8080);
            System.out.println("服务端已初始化好，等待请求连接...");
            // 开始监听并接受请求
            socket = serverSocket.accept();
            // 获取socket输入流
            inputStream = socket.getInputStream();
            // 读取内容
            byte[] b = new byte[1024];
            int len;
            int i = 0;
            while ((len = inputStream.read(b)) != -1) { //  inputStream.read(b)) 此处一直阻塞
                String str = new String(b, 0, len);
                System.out.println(str);
                System.out.println("No.:" + ++i);
            }
            /*
            // 此方法行不通
            byte[] b = inputStream.readAllBytes(); 一直阻塞，读不出内容
            String str = new String(b);
            System.out.println(str);
            */
            System.out.println("我是后面打印的");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
