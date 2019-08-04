/*
UDP socket 网络编程

功能：
客户端发信息到服务端，服务器端接收信息


# DatagramSocket类
## 构造器
DatagramSocket() 创建一个数据报socket，不绑定IP、端口
protected DatagramSocket(DatagramSocketImpl impl) 创建一个未绑定IP、端口的 DatagramScoket对象，并指定DatagramSocketImpl
DatagramSocket(int port) 创建一个DatagramSocket对象，并绑定指定的port端口，IP默认为0.0.0.0
DatagramSocket(int port, InetAddress laddr) 创建一个DatagramSocket对象,绑定指定的IP(laddr)、端口(port)
DatagramSocket(SocketAddress bindaddr) 创建一个DatagramSocket对象，绑定指定的SocketAddress，如：new DatagramSocket(new InetSocketAddress("10.100.0.2", 3030))

## 方法
void bind(SocketAddress addr) 绑定Socket地址，即绑定IP和端口
void close() 关闭此数据报socket
void connect(InetAddress address, int port) 连接到指定IP、端口
void connect(SocketAddress addr) 连接到指定的Socket地址([ip, 端口])
void disconnect() 断开数据报socket连接，如果socket已经关闭或未连接，则没有任何影响
boolean	getBroadcast() 测试SO_BROADCAST 是否是开启
DatagramChannel	getChannel() 返回唯一DatagramChannel，如果DatagramChannel 存在的话
InetAddress	getLocalAddress() 获取socket本地的InetAddress
int	getLocalPort() 获取socket在本地绑定的端口
SocketAddress getLocalSocketAddress() 获取socket本地的SocketAddress(即[ip, 端口])
InetAddress	getInetAddress() 获取socket远端的InetAddress地址
int	getPort() 获取此socket远端的端口
SocketAddress getRemoteSocketAddress() 获取socket远端的SocketAddress
int	getReceiveBufferSize() 获取SO_RCVBUF的值，即平台用在此DatagramSocket上的输入的缓冲大小
boolean	getReuseAddress() 测试SO_REUSEADDR 是否是开启，即SocketAddress是否可复用。
int	getSendBufferSize() 获取SO_SNDBUF的值，即平台用在此DatagramSocket上的输出的缓冲大小
int	getSoTimeout() 获取SO_TIMEOUT值，即socket的超时时间，默认为0，单位为：毫秒，即无限超时
int	getTrafficClass() Gets traffic class or type-of-service in the IP datagram header for packets sent from this DatagramSocket.
boolean	isBound() 返回此socket是否是已经绑定好IP、端口
boolean	isClosed() 返回此socket是否是关闭
boolean	isConnected() 返回此socket是否是连接
void receive(DatagramPacket p) 从此socket上用一个指定数据报包来接收一个数据报包
void send(DatagramPacket p) 从此socket上发送一个指定的数据报包p
void setBroadcast(boolean on) 设置SO_BROADCAST开启/关闭
static void	setDatagramSocketImplFactory(DatagramSocketImplFactory fac) Sets the datagram socket implementation factory for the application.
void setReceiveBufferSize(int size) 设置SO_RCVBUF大小，设置socket接收缓冲区大小
void setReuseAddress(boolean on) 设置此socket SO_REUSEADDR值，开启/关闭此SocketAddress是否可复用
void setSendBufferSize(int size) 设置 SO_SNDBUF 大小，设置socket发送缓冲区大小
void setSoTimeout(int timeout) 设置此socket超时时间，单位milliseconds 毫秒
void setTrafficClass(int tc) Sets traffic class or type-of-service octet in the IP datagram header for datagrams sent from this DatagramSocket.


# DatagramPacket类
## 构造器
DatagramPacket(byte[] buf, int length) 创建一个DatagramPacket对象，用于接收数据报包，使用字节数组buf来存放，长度length，默认从0开始
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，默认从0开始，指定接收端的IP为address，端口为port
DatagramPacket(byte[] buf, int offset, int length) 创建一个DatagramPacket对象，用于接收数据报包，使用字节数组buf来存放，长度length，从offset开始
DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，从offset开始，指定接收端的IP为address，端口为port
DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，从offset开始，并指定SocketAddress为address
DatagramPacket(byte[] buf, int length, SocketAddress address) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，默认从0开始，并指定SocketAddress为address


## 方法
InetAddress	getAddress() 返回发送数据报中的接收端的IP 或 返回接收数据报中的发送端的IP
byte[] getData() 从接收到或要发送的数据报包中获取缓冲数据，从偏移量offset开始读取length个字节
int	getLength() 返回接收到或要发送的数据报包数据的大小
int	getOffset() 返回读取数据报包中数据的指定的偏移量，不指定默认为0
int	getPort() 返回发送或接收数据报中远端的端口
SocketAddress getSocketAddress() 返回发送或接收数据报中远端的SocketAddress，包含了IP、端口
void setAddress(InetAddress iaddr) 设置要发送数据报的接收端的IP
void setPort(int iport) 设置要发送数据报的接收端的端口
void setData(byte[] buf) 设置此数据报包的数据缓冲区
void setData(byte[] buf, int offset, int length) 设置此数据报包的数据缓冲区，指定从偏移量offset开启，length个长度
void setLength(int length) 设置数据报包的长度
void setSocketAddress(SocketAddress address)

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
            // 创建数据报，每个数据报不能大于64K，每个数据报都记录了数据信息、发送端的IP、发送端的端口、接收端的IP、接收端的端口
            // 发送的数据报，只需要显式指定数据信息、接收端的IP、接收端的端口，发送端的IP(本端)、发送端的端口(本端)会自动添加到包中
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
