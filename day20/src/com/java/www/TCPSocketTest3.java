/*
题目：
    从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接


* */

package com.java.www;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest3 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            fos = new FileOutputStream("我曾__鱼大仙儿2.mp3");
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("文件接收成功");

            // 响应客户端
            outputStream = socket.getOutputStream();
            outputStream.write("发送成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流、socket
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (fos != null) {
                    fos.close();
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
        FileInputStream fis = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
            outputStream = socket.getOutputStream();
            fis = new FileInputStream(new File("我曾__鱼大仙儿.mp3"));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            // 文件发送完毕
            socket.shutdownOutput(); // 关闭socket的OutputStream流

            // 接收服务器信息
            inputStream = socket.getInputStream();
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println("接收到服务器端的信息：" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fis != null) {
                    fis.close();
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
