/*
接收器
* */

package com.java.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceivePoint implements Runnable{
    private Socket socket;
    private InputStream inputStream;

    // 构造器
    public ReceivePoint(Socket socket) {
        super();
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方法
    @Override
    public void run() {
        receive();
    }

    public void receive() {
        byte[] b = new byte[1024 * 8];
        int len;
        try {
            while ((len = inputStream.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            inputStream.close();
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
