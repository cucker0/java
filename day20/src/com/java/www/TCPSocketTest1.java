/*
题目：
    客户端发送内容给服务端，服务端将内容打印到控制台上。

TCP socket编程

* */

package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest1 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
//            socket = new Socket("localhost", 9090);
            socket = new Socket(InetAddress.getByName("localhost"), 9090);
            outputStream = socket.getOutputStream();
            outputStream.write("哈哈，你看到你还在线呢...".getBytes());
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
