/*
TCP Client端

* 服务端未启动时，报异常 java.net.ConnectException: Connection refused: connect

* */

package com.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 创建Socket对象，指定要连接的主机IP、端口
            socket = new Socket("127.0.0.1", 8080);
            outputStream = socket.getOutputStream();
            outputStream.write("给我吐10000块钱出来...".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
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
        }
    }
}
