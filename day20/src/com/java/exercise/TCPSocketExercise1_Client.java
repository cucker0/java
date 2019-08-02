package com.java.exercise;

import java.io.*;
import java.net.Socket;

public class TCPSocketExercise1_Client {
    // client
    public static void main(String[] args) {
        Socket s = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            s = new Socket("127.0.0.1", 8000);
            is = s.getInputStream();
            fos = new FileOutputStream(new File("img_receive.png"));

            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("文件接收完毕");

            // 响应对端服务器
            os = s.getOutputStream();
            os.write("文件接收成功。".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
