/*
java socket TCP 模拟 WEB Server

* */

package com.java.www;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) throws Exception {

        int port = 80;
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("启动服务，绑定端口： " + port);

        while (true) {

            Socket socket = serverSocket.accept();
            System.err.println("有客户端连接进来了: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            // PrintWriter流也可以
//            PrintWriter out = new PrintWriter(
//                    new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),
//                    true
//            );
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 获取客户端httpd请求头信息
            String data = "";
            String s = "";
            while ((s = in.readLine()) != null) { // 这里获取到的数据，没有换行符
                data = data + s + "\n";
                if (s.equals("")){
                    break;
                }
            }
            System.out.println("客户请求http header信息：");
            System.out.println(data);

            System.err.println("响应");
            out.write("HTTP/1.0 200 OK\r\n");
            out.write("Server: Java/12.0.1\r\n");
            out.write("Content-Type: text/html\r\n");
            out.write("\r\n");
            out.write("<title>Exemple</title>");
            out.write("<h1>Java Web Server</h1>");
            out.write("<p>timeStamp: " + System.currentTimeMillis() + "</p>");
            out.flush();

            System.err.println("结束");

            out.close();
            in.close();
            socket.close();
//            socket.shutdownOutput();
//            socket.shutdownInput();
        }
    }
}
