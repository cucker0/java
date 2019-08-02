/*
题目：
    客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端

* */

package com.java.exercise;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class TCPSocketExercise2 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();
            System.out.println("等待客户端连接...");
            inputStream = socket.getInputStream();
            byte[] b = inputStream.readAllBytes();
            String str = new String(b);
            System.out.println("接受到客户端的信息：" + str);
            String str2 = str.toUpperCase();

            // 响应客户端
            outputStream = socket.getOutputStream();
            outputStream.write(str2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流、socket、ServerSocket
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
        Scanner sc = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8000);
            outputStream = socket.getOutputStream();
            sc = new Scanner(System.in);
            System.out.println("请输入多个字符：\n");
            String str = sc.nextLine();
            outputStream.write(str.getBytes());
//            socket.shutdownOutput();
            outputStream.flush();

            // 接受服务端信心
            inputStream = socket.getInputStream();
            byte[] b = inputStream.readAllBytes();
            String str2 = new String(b);
            System.out.println("服务端响应信息，服务端将响应装换成大写的内容：" + str2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流、socket
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
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
