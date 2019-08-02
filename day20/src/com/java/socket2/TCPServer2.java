/*
服务端、客户端互发信息，即一对一通信

* */

package com.java.socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) {
        Server server = new Server(8080);
        server.start();
    }
}

class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    // 构造器
    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器启动好，等待客户请求连接(输入q退出)...");
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方法
    public void start() {
        SendPoint sendPoint = new SendPoint(socket);
        ReceivePoint receivePoint = new ReceivePoint(socket);

        Thread th1 = new Thread(receivePoint);
        Thread th2 = new Thread(sendPoint);
        th1.start();
        th2.start();
    }
}
