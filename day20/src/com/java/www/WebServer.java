/*
java socket TCP 模拟 WEB Server

* */

package com.java.www;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    final static String CRLF = "\r\n";

    public static void main(String[] args) throws Exception {

        int port = 80;
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("启动服务，绑定端口： " + port);

        while (true) {

            Socket socket = serverSocket.accept();
            System.err.println("有客户端连接进来了");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                    new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),
                    true
            );

            String data = "";
            String s;
            // 判断客户的请求发送是否完毕
            while ((s = in.readLine()) != null) {
                s += CRLF;  // 很重要，默认情况下\r\n被去掉了
                data = data + s;
                if (s.equals(CRLF)){
                    break;
                }
            }
            System.out.println("UserAgent信息：");
            System.out.println(data);

            System.err.println("响应");
            out.write("HTTP/1.0 200 OK\r\n");
            out.write("Server: Apache/0.8.4\r\n");
            out.write("Content-Type: text/html\r\n");
            out.write("\r\n");
            out.write("<TITLE>Exemple</TITLE>");
            out.write("<h1>Java Web Server</h1>");
            out.flush();

            System.err.println("结束");

            out.close();
            in.close();
            socket.close();
        }
    }
}
