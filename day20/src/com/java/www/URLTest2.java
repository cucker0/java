/*
URL 编程

功能：
    本地上传信息到服务器

* */

package com.java.www;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLTest2 {
    @Test
    public void server() {
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

    @Test
    public void client() {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            URL url = new URL("http://127.0.0.1/");
            URLConnection urlConnection = url.openConnection();

            // upload
          /*  outputStream = urlConnection.getOutputStream();
            outputStream.write("hello server...".getBytes());*/

            // get
            inputStream = urlConnection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
