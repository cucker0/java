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

public class WebServer4 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 80;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端已经启动，绑定端口：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true) {

            try {
                Socket socket = serverSocket.accept();
                // 新建socket线程，匿名Thread、Runnable对象
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader br = null;
                        BufferedWriter bw = null;

                        try {
                            // 接受客户端信息
                            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String data = "客户信息：" + socket.getRemoteSocketAddress() + "\n",
                                    s = "";
                            while ((s = br.readLine()) != null) {
                                data = data + s + "\n";
                                if (s.equals("")) {
                                    break;
                                }
                            }
                            System.out.println(data);

                            // 响应客户端
                            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            String responseData = "HTTP/1.0 200 OK\r\n" +
                                    "Server: Java/12.0.1\r\n" +
                                    "Content-Type: text/html; charset=UTF-8\r\n" +
                                    "\r\n" +
                                    "<title>java web server</title>" +
                                    "<h1>Java Web Server</h1>" +
                                    "<h3>datetime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()) + "</h3>";

                            bw.write(responseData);
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                // 关闭bw、br、socket
                                if (bw != null) {
                                    bw.close();
                                }
                                if (br != null) {
                                    br.close();
                                }
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
