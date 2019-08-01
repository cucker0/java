/*
题目：
    客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端

* */

package com.java.exercise;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketExercise2 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8090);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            while (true) {
                byte[] b = inputStream.readAllBytes();
                String str = new String(b);
                if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("exit")) {
                    System.out.println("接收客户端退出指令，现在关闭socket");
                    break;
                }
                String str2 = str.toUpperCase();

                // 响应客户端，发送str2
                if (socket.isOutputShutdown()) {
                    outputStream = socket.getOutputStream();
                }
                outputStream.write(str2.getBytes());
                socket.shutdownOutput(); // 本次内容已经发送完毕
            }
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
        BufferedReader br = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8090);
            outputStream = socket.getOutputStream();
            InputStream is = System.in;
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            inputStream = socket.getInputStream();
            System.out.println("请输入任意字符，服务器响应大写内容(输入q或exit退出)");
            while (true) {
                String str = br.readLine();
                if (socket.isOutputShutdown()) { // 如果OutputStream关闭了，再重建
                    outputStream = socket.getOutputStream();
                }
                outputStream.write(str.getBytes()); // 发送本次内容
                socket.shutdownOutput(); // 发送完毕后，关闭本socket OutputStream流
                if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("exit")) {
                    break;
                }

                // 接收对端的响应信息
                byte[] b = inputStream.readAllBytes();
                String str2 = new String(b);
                System.out.println("服务器响应信息：" + str2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (br != null) {
                    br.close();
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
