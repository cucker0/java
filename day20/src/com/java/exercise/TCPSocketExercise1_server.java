/*
题目：
    服务端读取图片并发送给客户端，客户端保存图片到本地

* */

package com.java.exercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketExercise1_server {
    public static void main(String[] args) {
        // server
        ServerSocket ss = null;
        Socket s = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        try {
            ss = new ServerSocket(8000);
            s = ss.accept();
            os = s.getOutputStream();
            fis = new FileInputStream(new File("img.png"));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
            System.out.println("文件发送完毕");
            os.write("文件发送完毕".getBytes());
            s.shutdownOutput();
            // System.out.println("socket's OutputStream is shutdown" + s.isOutputShutdown());

            // 接收对端的响应信息
            is = s.getInputStream();
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (os != null) {
                    os.close();
                }
                if (s != null) {
                    s.close();
                }
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

}
