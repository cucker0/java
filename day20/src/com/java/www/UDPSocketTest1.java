/*
UDP socket 网络编程

功能：
客户端发信息到服务端，服务器端接收信息

* */

package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSocketTest1 {
    @Test
    public void server() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(20);
            System.out.println("服务端启动好了...");
            byte[] b = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(b, 0, b.length);
            datagramSocket.receive(datagramPacket); // 这里阻塞，直接有客户连接进来
            System.out.println("客户端IP信息：" + datagramPacket.getSocketAddress());

            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);
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
            // 创建DatagramSocket对象
            datagramSocket = new DatagramSocket();
            System.out.println("UDP 客户端启动好...");
            // 要发送的内容，转成字节数组
            byte[] b = "一去二三里，\n烟村四五家;\n亭台六七座，\n八九十枝花。\n".getBytes();
            // 创建数据报，每个数据报不能大于64K，每个数据报要记录数据信息、发送端的IP、发送端的端口、接收端的IP、接收端的端口
            DatagramPacket datagramPacket = new DatagramPacket(b, 0, b.length,
                    InetAddress.getByName("127.0.0.1"), 20);
            // 调用datagramSocket.send(数据报对象)，把数据报发出去
            datagramSocket.send(datagramPacket);
            System.out.println("信息发送完毕.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }

}
