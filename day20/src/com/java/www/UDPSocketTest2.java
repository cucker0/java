/*
UDP socket

功能：
    客户端信息到服务端，服务端接收信息并打印到控制台，然后回复客户端信息：你发送过来的信息接收到了

* */

package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSocketTest2 {
    @Test
    public void server() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(6060);
            System.out.println("UDP socket 服务端已启动好...");

            // 接收信息
            byte[] b = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(b, 0, b.length);
            datagramSocket.receive(datagramPacket);
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("接收到客户端的信息：" + str);

            // 响应客户端
            String data = "你发送过来的信息接收到了";
            byte[] b1 = data.getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(b1, 0, b1.length,
                    datagramPacket.getSocketAddress());
            datagramSocket.send(datagramPacket1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

    }

    @Test
    public void client() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            System.out.println("UDP socket 客户端启动好了...");

            // 发送信息
            String info = "春天到了，小猫开始种鱼了";
            byte[] b = info.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(b, b.length,
                    new InetSocketAddress("127.0.0.1", 6060));
            datagramSocket.send(datagramPacket);

            // 接收信息
            byte[] b1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(b1, 0, b.length);
            datagramSocket.receive(datagramPacket1);
            String receive = new String(datagramPacket1.getData());
            System.out.println("服务器响应信息：" + receive);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }

}
