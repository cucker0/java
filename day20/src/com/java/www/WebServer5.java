/*
Web Server, TCP socket

利用线程池，让服务端一直保持开启n个线程

* */

package com.java.www;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer5 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 80;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            // 创建ServerSocket对象，绑定端口
            serverSocket = new ServerSocket(port);
            System.out.println("服务端已经启动，绑定端口：" + port);
            // 创建一个线程池
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true) {

            try {
                Socket socket = serverSocket.accept();
                // 新建socket线程，匿名Thread、Runnable对象
                Runnable runnable = new Runnable() {
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
                };
                executorService.submit(runnable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
