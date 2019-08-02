/*
发送器
* */

package com.java.socket2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendPoint implements Runnable{
    private Socket socket;
    private OutputStream outputStream;
    private Scanner scanner;

    // 构造器
    public SendPoint(Socket socket) {
        this.socket = socket;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in);
    }

    // 方法
    @Override
    public void run() {
        String str = "";
        do {
            str = scanner.next();
            send(str);
        } while (!str.equalsIgnoreCase("q"));
        close();
    }

    public void send(byte[] b) {
        try {
            outputStream.write(b);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String str) {
        send(str.getBytes());
    }

    public void close() {
        try {
            outputStream.close();
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
