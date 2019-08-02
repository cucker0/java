/*
TCP Client端

* 服务端未启动时，报异常 java.net.ConnectException: Connection refused: connect

* */

package com.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        Scanner sc = null;
        try {
            // 创建Socket对象，指定要连接的主机IP、端口
            socket = new Socket("127.0.0.1", 8080);
            System.out.println("客户端初始化好并与服务器连接成功.");
            outputStream = socket.getOutputStream();
            sc = new Scanner(System.in);
            String input = "";
            int i = 0;
            do {
                input = sc.nextLine();
//                System.out.println(input);
                outputStream.write(input.getBytes());
                outputStream.flush();
                System.out.println("No.: " + ++i);
            } while (!(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("exit")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
