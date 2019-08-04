package com.java.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        Client c1 = new Client("127.0.0.1", 8080);
        c1.start();
    }
}

class Client {
    private Socket socket;

    // 构造器
    public Client(String host, int port) {
        super();
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方法
    public void start() {
        SendPoint sendPoint = new SendPoint(socket);
        ReceivePoint receivePoint = new ReceivePoint(socket);
        System.out.println("客户端启动好(输入q退出)...");

        Thread th1 = new Thread(receivePoint); // 接收信息线程
        Thread th2 = new Thread(sendPoint); // 发送信息线程
        th1.start();
        th2.start();
    }
}
