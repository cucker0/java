/*
题目：
    客户端发送内容给服务端，服务端给予反馈
* */

package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest2 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println(s);
            }

            // 响应远端客户
            outputStream = socket.getOutputStream();
            outputStream.write("占领月球？哈哈，小毛孩儿，撒泡尿照照镜子吧...".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            outputStream = socket.getOutputStream();
            outputStream.write("占领月球，别回复，别回复，别回复".getBytes());
            // 关闭OutputStream流，没有关闭的情况下，对端的服务器 InputStream对象.read()方法将一直阻塞。
            socket.shutdownOutput();

            // 接收服务端信息
            inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println("来自服务器信息：" + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
