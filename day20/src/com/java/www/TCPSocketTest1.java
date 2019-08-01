/*
题目：
    客户端发送内容给服务端，服务端将内容打印到控制台上。

TCP socket编程


# ServerSocket类
## 构造器(没有特殊说明时，都是public构造器)
ServerSocket() 创建未绑定IP、端口等的ServerSocket对象
ServerSocket(int port) 创建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，端口范围：[0, 65535]，0：自动分配端口，下同; 请求连接队列的最大长度为50
ServerSocket(int port, int backlog) 建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，指定请求连接队列的最大长度
ServerSocket(int port, int backlog, InetAddress bindAddr) 建服务器端的ServerSocket对象，指定要绑定的监听端口，指定请求连接队列的最大长度，指定绑定的IP(InetAddress对象)

## 方法(没有特殊说明，都是public方法)
Socket accept() 创建并返回一个Socket对象，开始侦听该socket并接收请求连接
void bind(SocketAddress endpoint)  绑定SocketAddress，即绑定IP和端口，如 ServerSocket对象.bind(new InetSocketAddress(InetAddress.getByName("hostName")), 端口)
void bind(SocketAddress endpoint, int backlog)  绑定SocketAddress，并指定请求连接队列的最大长度
void close() 关闭此socket
ServerSocketChannel getChannel() 返回此ServerSocket对象相关的唯一的ServerSocketChannel 对象
InetAddress	getInetAddress() 获取此socket的IP信息
int	getLocalPort() 获取侦听的端口
SocketAddress getLocalSocketAddress() 获取绑定的IP信息
int	getReceiveBufferSize()
boolean	getReuseAddress() 获取请求客户端的address信息
int	getSoTimeout() 获取socket 超时设置值
protected void implAccept(Socket s) 重写accept()方法
boolean isBound() 返回ServerSocket是否已经绑定
oolean isClosed() 返回ServerSocket是否已关闭
void setPerformancePreferences(int connectionTime, int latency, int bandwidth) 设置此ServerSocket性能偏好：
                connectionTime：连接保持时间，对于短链接来说此参数相对重要
                latency：延迟时间，对于要求低延迟的连接，此参数相对重要
                bandwidth：带宽，如要求带宽比较高的，此参数比较重要
void setReceiveBufferSize(int size)  重置socket接收缓存的大小，默认的大小将被修改
void setReuseAddress(boolean on) 开启/关闭 SO_REUSEADDR socket 选项，当需要使用多进程时，需要开启address重用
static void	setSocketFactory(SocketImplFactory fac)
void setSoTimeout(int timeout) 设置socket的超时时间，单位ms，0：表示不超时
String toString()


# Socket类
## 构造器
public Socket() 创建一个未绑定IP、端口等的Socket对象
public Socket(InetAddress address, int port) throws IOException 创建一个流Socket对象(即TCP socket)，并绑定IP、端口
public Socket(String host, int port) throws UnknownHostException, IOException 创建一个流Socket对象(即TCP socket)，并绑定IP、端口
public Socket(InetAddress address, int port, InetAddress localAddr, int localPort) throws IOException 创建一个Socket对象，指定连接远端的IP和端口，同时绑定本地的IP和端口
public Socket(String host, int port, InetAddress localAddr, int localPort) throws IOException 创建一个Socket对象，指定连接远端的IP和端口，同时绑定本地的IP和端口

public Socket(InetAddress host, int port, boolean stream) throws IOException // Deprecated. 创建一个绑定了IP和端口的流Socket对象(TCP)或数据报Socket对象(UDP)，stream为true时创建流Socket对象，stream为false时创建数据报Socket
public Socket(String host, int port, boolean stream) throws IOException // Deprecated. 创建一个绑定了IP和端口的流Socket对象(TCP)或数据报Socket对象(UDP)，stream为true时创建流Socket对象，stream为false时创建数据报Socket

public Socket(Proxy proxy) 创建一个未连接的代理Socket，使用代理的设置，如调用代理的IP、端口，
    示例：
    Socket s = new Socket(Proxy.NO_PROXY);  will create a plain socket ignoring any other proxy configuration.
    Socket s = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("socks.mydom.com", 1080))); will create a socket connecting through the specified SOCKS proxy server.

protected Socket(SocketImpl impl) throws SocketException 创建一个由用户实现的SocketImpl且未连接的Socket对象。


## 方法
void bind(SocketAddress bindpoint) 绑定SocketAddress，即IP和端口
void close() 关闭此socket
void connect(SocketAddress endpoint) 连接此socket到服务器
void connect(SocketAddress endpoint, int timeout) 连接此socket到服务器，并指定连接超时时间
SocketChannel getChannel() 返回唯一的SocketChannel 对象，如果存在的话
InetAddress	getInetAddress() 返回此socket连接到远端的IP
InputStream	getInputStream() 获取此socket的InputStream输入流
boolean	getKeepAlive() 测试SO_KEEPALIVE 是否开启，返回此socket是否开启回话保持
InetAddress	getLocalAddress() 获取此socket绑定的本地IP
int	getLocalPort() 获取此socket绑定的本地端口
SocketAddress getLocalSocketAddress() 获取此socket绑定的本地SocketAddress信息，即绑定的本地IP、本地端口
boolean	getOOBInline() 获取此socket的SO_OOBINLINE是否开启
OutputStream getOutputStream() 获取此socket的OutputStream输出流
int	getPort() 返回此socket连接的远端端口
int	getReceiveBufferSize() 获取此socket的SO_RCVBUF值
SocketAddress getRemoteSocketAddress() 返回此socket连接着远端的SocketAddress信息(IP、port)
boolean	getReuseAddress() 获取SO_REUSEADDR是否可重用
int	getSendBufferSize() 获取此socket的SO_SNDBUF返送缓冲大小
int	getSoLinger() 获取 SO_LINGER值
int	getSoTimeout() 获取此socket的SO_TIMEOUT设置的值
boolean	getTcpNoDelay() 获取此socket的TCP_NODELAY是否开启，关闭Nagle算法，即要发送到网络的数据不缓冲
int	getTrafficClass() 从发送的IP头包里获取traffic跟踪类或服务类型
boolean	isBound() 返回此socket是绑定状态
boolean	isClosed() 返回此socket是关闭状态
boolean	isConnected() 返回此socket是连接状态
boolean	isInputShutdown()  在此socket输入流读取过程中，返回此socket连接是否为是关闭状态，是关闭则返回true
boolean	isOutputShutdown()  在此socket输出流读取过程中，返回此socket连接是否为是关闭状态，是关闭则返回true
void sendUrgentData(int data) 发送一个字节的紧急数据到此socket
void setKeepAlive(boolean on) 设置此suocket的SO_KEEPALIVE值，即socket TCP的超时时间
void setOOBInline(boolean on)
void setPerformancePreferences(int connectionTime, int latency, int bandwidth) 设置此Socket性能偏好：
                connectionTime：连接保持时间，对于短链接来说此参数相对重要
                latency：延迟时间，对于要求低延迟的连接，此参数相对重要
                bandwidth：带宽，如要求带宽比较高的，此参数比较重要
void setReceiveBufferSize(int size) 设置此socket的SO_RCVBUF值
void setReuseAddress(boolean on) 设置address是否可重用
void setSendBufferSize(int size) 设置SO_SNDBUF值
static void	setSocketImplFactory(SocketImplFactory fac)
void setSoLinger(boolean on, int linger) 开启/关闭 SO_LINGER，指定linger时间为linger，单位s
void setSoTimeout(int timeout) 设置此socket超时时间(单位ms)，以timeout为0时无限超时，read()将一直阻塞，如果timeout > 0,在read()时做多阻塞timeout 毫秒，超时后抛出java.net.SocketTimeoutException异常
void setTcpNoDelay(boolean on) 设置此socket的TCP_NODELAY 值
void setTrafficClass(int tc)
void shutdownInput() 关闭此socket的InputStream流，在read socket InputStream时，调用此方法后，InputStream的read()方法返回-1，其他可用方法都将返回0，
void shutdownOutput() 关闭此socket的OutputStream流。对于TCP，调用此方法前需要发送的数据还未完成发送的将继续正常的连接终止顺序发送，
String toString() //"Socket[addr=" + getImpl().getInetAddress() +
                    ",port=" + getImpl().getPort() +
                    ",localport=" + getImpl().getLocalPort() + "]";

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
            System.out.println("此连接的客户IP：" + socket.getInetAddress());
            System.out.println("ServerSocket超时时间(s):" + serverSocket.getSoTimeout());
            System.out.println("ServerSocket本地IP信息:" + serverSocket.getLocalSocketAddress());
            System.out.println(socket.getLocalSocketAddress());
            System.out.println("此连接的远端客户IP、端口信息" +  socket.getRemoteSocketAddress()); // 如 /127.0.0.1:57870
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
