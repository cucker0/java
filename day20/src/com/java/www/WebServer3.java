/*
Web Server, TCP socket

先启动一个线程来等待用户的请求连接，当有一个客户请求连接进来时，新开启一个线程等待下一个客户端请求连接。
线程响应完客户请求后，关闭当前socket及相关的IO流，当前线程就退出了。

* */

package com.java.www;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebServer3 implements Runnable{
    private ServerSocket serverSocket;
    private static WebServer3 instance = new WebServer3(80);

    // 构造器
    public WebServer3(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端已经启动，绑定端口：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方法
    @Override
    public void run() {
        start();
    }

    public void receive (Socket socket) {
        /*
        接收客户端数据
        * */
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = "",
                s = "";
        try {
            while ((s = bufferedReader.readLine()) != null) {
                data += s + "\n";
//                if (s.equals("")) { // 不读取post的数据
//                    break;
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }

    public void response(Socket socket) {
        /*
        响应客户端
        * */
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String data = "HTTP/1.0 200 OK\r\n" +
                    "Server: Java/12.0.1\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "\r\n" +
                    "<title>java web server</title>" +
                    "<h1>Java Web Server</h1>" +
                    "<h3>datetime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()) + "</h3>";
            bufferedWriter.write(data);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(Socket socket) {
        /*
        关闭当前socket、输入流、输入流
        * */
        try {
            if (socket != null) {
                socket.shutdownOutput();
                socket.shutdownInput();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        Socket socket = null;
        try {
            // 等待客户端请求连接，阻塞到客户请求连接进来
            socket = serverSocket.accept();
            Thread th = new Thread(instance);
            th.start();
            if (socket != null) {
                receive(socket);
                response(socket);
                close(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 程序执行入口
    public static void main(String[] args) {
        Thread th1 = new Thread(instance);
        th1.start();
    }
}
