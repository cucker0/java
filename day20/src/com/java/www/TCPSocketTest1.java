/*
题目：
    客户端发送内容给服务端，服务端将内容打印到控制台上。

TCP socket编程


# ServerSocket类
## 构造器
ServerSocket() 创建未绑定IP、端口等的ServerSocket对象
ServerSocket(int port) 创建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，端口范围：[0, 65535]，0：自动分配端口，下同; 请求连接队列的最大长度为50
ServerSocket(int port, int backlog) 建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，指定请求连接队列的最大长度
ServerSocket(int port, int backlog, InetAddress bindAddr) 建服务器端的ServerSocket对象，指定要绑定的监听端口，指定请求连接队列的最大长度，指定绑定的IP(InetAddress对象)

## 方法
Socket accept() 创建并返回一个socket对象，开始侦听该socket并接收请求连接
void bind(SocketAddress endpoint)  绑定SocketAddress，即绑定IP和端口，如 ServerSocket对象.bind(new InetSocketAddress(InetAddress.getByName("hostName")), 端口)
void bind(SocketAddress endpoint, int backlog)  绑定SocketAddress，并指定请求连接队列的最大长度
void close() 关闭此socket
ServerSocketChannel getChannel() 返回此ServerSocket对象相关的唯一的ServerSocketChannel 对象
InetAddress	getInetAddress() 获取此socket的IP信息
int	getLocalPort() 获取侦听的端口
SocketAddress getLocalSocketAddress() 获取绑定的IP信息
int	getReceiveBufferSize()
boolean	getReuseAddress() 或是否允许多个socket侦听相同的IP、端口
int	getSoTimeout() 获取socket 超时设置值
protected void implAccept(Socket s) 重写accept()方法
boolean isBound() 返回ServerSocket是否已经绑定
oolean isClosed() 返回ServerSocket是否已关闭
void setPerformancePreferences(int connectionTime, int latency, int bandwidth) 设置ServerSocket性能偏好：
                connectionTime：连接保持时间，对于短链接来说相对重要
                latency：延迟时间，对于要求低延迟的相对重要
                bandwidth：带宽，如要求带宽比较高的，此参数比较重要
void setReceiveBufferSize(int size)  重置socket接收缓存的大小，默认的大小将被修改
void setReuseAddress(boolean on) 开启/关闭 SO_REUSEADDR socket 选项
static void	setSocketFactory(SocketImplFactory fac)
void setSoTimeout(int timeout) 设置socket的超时时间，单位ms，0：表示不超时
String toString()


# Socket类

* */

package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest1 {
    @Test
    public void server() {
        /*
        服务器端
        * */
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            // 1. 创建ServerSocket对象，并指定监听的商品
            serverSocket = new ServerSocket(9090);
            // System.out.println(serverSocket.toString()); // ServerSocket[addr=0.0.0.0/0.0.0.0,localport=9090]
            // 2. 调用 ServerSocket对象.accept()方法获得socket
            socket = serverSocket.accept();
            // 3. 通过Socket对象.getInputStream()获取InputStream对象
            inputStream = socket.getInputStream();
            // 4. 通过InputStream对象 读取内容
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                String s = new String(b);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭InputStream流、Socket、ServerSocket连接
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void client() {
        /*
        客户端
        * */
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            // 1. 创建 Socket对象，并指定要连接的服务器的IP、端口
//            socket = new Socket("localhost", 9090);
            socket = new Socket(InetAddress.getByName("localhost"), 9090);
            // 2. 通过Socket对象获得OutputStream流
            outputStream = socket.getOutputStream();
            // 3. 通过OutputStream流输出内容
            outputStream.write("哈哈，你看到你还在线呢...".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭OutputStream流、Socket连接
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
