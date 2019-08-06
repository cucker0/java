day20_网络编程
==

# 本章主要内容
* 网络编程概述
* 通讯要素
    * IP和端口
    * 网络通信协议
* InetAddress类
* TCP socket网络编程
* UDP socket网络编程
* URL socket网络编程


# 网络编程概述
* Java提供的网络类库，可以实现无痛的网络连接，联网的底层细节被隐藏在 Java 的本机安装系统里，由 JVM 进行控制。
并且 Java 实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境。

# 网络基础
* 计算机网络
```text
把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规模大、功能强的网络系统，
从而使众多的计算机可以方便地互相传递信息、共享硬件、软件、数据信息等资源。

```

* 网络编程的目的
>直接或间接地通过网络协议与其他计算机进行通讯

* 网络编程中主要的两个问题
    * 如何准确地定位网络上的一台或多台主机
    * 找到主机后如何可靠高效地进行数据传输

* 实现网络中主机互相通信的机制
    * 通信双方地址
    * 一定的规则(主要有两套参考模型)
        * OSI 7层参考模型：模型过于理想或，未能在互联网上进行广泛推广
        * TCP/IP 4层参考模型：事实上的国际标准

* 通信要素:网络通信协议
![](./images/通信协议参考模型OSI、TCP_IP.png)   
    
* 通信要素:IP和端口
* IP地址：InetAddress
    * 唯一的标识Internet上的计算机
    * 本地回环地址：127.0.0.1,主机名：localhost
    * 不易记忆
* 端口：标识正在计算机上运行的进程(程序)
    * 不同的进程有不同的端口
    * 被规定为一个16二进制整数，端口可使用范围：(0-65535]
* IP与端口的组合得出一个socket


# InetAddress类
位置：java.net.InetAddress
* 主机地址的两种表示形式
    * 域名(hostName)，如：www.baidu.com
    * IP地址(hostAddress)，如：223.5.5.5
* InetAddress类主表示IP地址  
两个子类
    * Inet4Address
    * Inet6Address
* InetAddress对象含有一个Internet主机的域名和IP地址
* 域名易于记忆，通信前需要把域名解析成IP地址

## 构造器
// 跨包后调用不了此构造器
protected InetAddress() {
        holder = new InetAddressHolder();
}

## 方法
<details>
<summary>展开方法</summary>

* 创建InetAddress对象
static InetAddress getByName(String host)
static InetAddress getByAddress(byte[] addr)
static InetAddress getByAddress(String host, byte[] addr)
static InetAddress[] getAllByName(String host) 获取到域名解析出来的多个IP

* 获取相关属性
String getHostName()
String getHostAddress()
byte[] getAddress()
String getCanonicalHostName()
static InetAddress getLocalHost()
static InetAddress getLoopbackAddress()
</details>

[InetAddress使用示例 ](./src/com/java/www/InetAddressTest.java)  


# 通信要素2：网络通讯协议
* 通信协议
```text
计算机网络中实现通信必须有一些约定，
即通信协议，对速率、传输代码、代码结构、传输控制步骤、出错控制等制定标准。

```

* 通信协议分层思想
```text
由于结点之间联系很复杂，在制定协议时，把复杂成份分解成一些简单的成份，再将它们复合起来。
最常用的复合方式是层次方式，
即同层间可以通信、上一层可以调用下一层，
而与再下一层不发生关系。
各层互不影响，利于系统的开发和扩展。
```

## TCP/IP协议簇
* 传输协议中两个重要的协议
    * TCP(Transmission Control Protocol) 传输控制协议
    * UDP(User Datagram Protocol) 用户数据报协议

* TCP/IP 以其两个主要协议
>传输控制协议(TCP)和网络互联协议(IP)而得名，  
实际上是一组协议，包括多个具有不同功能且互为关联的协议。  

* IP(Internet Protocol)协议是网络层的主要协议，支持网间互连的数据通信
* TCP/IP协议模型从更使用的角度出发，形成了高效地四层体系，  
即 物理链路层、IP层(网络层)、传输层、应用层

## TCP和UDP
* TCP协议
    * 使用TCP协议签，必须建立TCP连接，形成传输的通道
    * 传输前，采用"三次握手"方式，是可靠的
    * TCP协议进行通信的两个应用进程：服务端、客户端，先启动服务端
    * 在已经建立了连接的连接中可进行大数据的传输
    * 传输完毕，采用"四次挥手"方式释放已建立的连接，效率低
* UDP协议
    * 将数据、源地址、目的地址封装成数据报，不需要建立连接
    * 每个数据报的大小限制在64K内
    * 因无需连接，故是不可靠的
    * 发送数据结束时无需释放资源，速度快


# Socket
* 利用套接字(Socket)开发网络应用程序早已被广泛的采用，以至于成为事实上的标准
* 通信的两端都要有Socket，是两台机器间通信的端点
* 网络通信其实就是Socket间的通信
* Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输
* 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端
个人觉得Socket翻译成链流口更合适

基于TCP的socket通信  
![](./images/JavaTCPsocket服务器、客户端相互收发信息.png)  


# Socket类
位置：java.net.Socket
## 构造器
<details>
<summary>展开Socket类构造器</summary>

```text

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

```
</details>

## 方法
<details>
<summary>展开Socket类方法</summary>

```text
void bind(SocketAddress bindpoint) 绑定SocketAddress，即IP和端口
void close() 关闭此socket
void connect(SocketAddress endpoint) 连接此socket到服务器
void connect(SocketAddress endpoint, int timeout) 连接此socket到服务器，并指定连接超时时间
SocketChannel getChannel() 返回唯一的SocketChannel 对象，如果存在的话
InetAddress getInetAddress() 返回此socket连接到远端的IP
InputStream getInputStream() 获取此socket的InputStream输入流，此InputStream.read()、InputStream.read(byte[] b) 都是是阻塞的
boolean getKeepAlive() 测试SO_KEEPALIVE 是否开启，返回此socket是否开启回话保持
InetAddress getLocalAddress() 获取此socket绑定的本地IP
int getLocalPort() 获取此socket绑定的本地端口
SocketAddress getLocalSocketAddress() 获取此socket绑定的本地SocketAddress信息，即绑定的本地IP、本地端口
boolean getOOBInline() 获取此socket的SO_OOBINLINE是否开启
OutputStream getOutputStream() 获取此socket的OutputStream输出流，此OutputStream.write(byte[] b) 非阻塞的
int getPort() 返回此socket连接的远端端口
int getReceiveBufferSize() 获取此socket的SO_RCVBUF值
SocketAddress getRemoteSocketAddress() 返回此socket连接着远端的SocketAddress信息(IP、port)
boolean	getReuseAddress() 获取SO_REUSEADDR是否可重用
int getSendBufferSize() 获取此socket的SO_SNDBUF返送缓冲大小
int getSoLinger() 获取 SO_LINGER值
int getSoTimeout() 获取此socket的SO_TIMEOUT设置的值
boolean getTcpNoDelay() 获取此socket的TCP_NODELAY是否开启，关闭Nagle算法，即要发送到网络的数据不缓冲
int getTrafficClass() 从发送的IP头包里获取traffic跟踪类或服务类型
boolean isBound() 返回此socket是绑定状态
boolean isClosed() 返回此socket是关闭状态
boolean isConnected() 返回此socket是连接状态
boolean isInputShutdown()  在此socket输入流读取过程中，返回此socket连接是否为是关闭状态，是关闭则返回true
boolean isOutputShutdown()  在此socket输出流读取过程中，返回此socket连接是否为是关闭状态，是关闭则返回true
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
void shutdownInput() 关闭此socket的InputStream流，在read socket InputStream时，调用此方法后，InputStream的read()方法返回-1，其他可用方法都将返回0，不可恢复
void shutdownOutput() 关闭此socket的OutputStream流。对于TCP，调用此方法前需要发送的数据还未完成发送的将继续正常的连接终止顺序发送，不可恢复
String toString() //"Socket[addr=" + getImpl().getInetAddress() +
                    ",port=" + getImpl().getPort() +
                    ",localport=" + getImpl().getLocalPort() + "]";
                    
```
</details>

## 注意
* 调用socket.close() 或者socket.shutdownOutput()方法，都会结束客户端socket，且不可恢复。
* socket.close() 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
* socket.shutdownOutput() 是将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的
* inputStream.readAllBytes()，只有等对端的socket关闭了，才能读取完成，是阻塞的


# ServerSocket类
位置：java.net.ServerSocket
## 构造器(没有特殊说明时，都是public构造器)
```text
ServerSocket() 创建未绑定IP、端口等的ServerSocket对象
ServerSocket(int port) 创建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，端口范围：[0, 65535]，0：自动分配端口，下同; 请求连接队列的最大长度为50
ServerSocket(int port, int backlog) 建服务器端的ServerSocket对象，指定要绑定的监听端口，绑定所有IP(即0.0.0.0)，指定请求连接队列的最大长度
ServerSocket(int port, int backlog, InetAddress bindAddr) 建服务器端的ServerSocket对象，指定要绑定的监听端口，指定请求连接队列的最大长度，指定绑定的IP(InetAddress对象)
```

## 方法(没有特殊说明，都是public方法)
<details>
<summary>ServerSocket类方法</summary>

```text

Socket accept() 创建并返回一个Socket对象，开始侦听该socket并接收请求连接，阻塞的，直到有请求连接进来
void bind(SocketAddress endpoint)  绑定SocketAddress，即绑定IP和端口，如 ServerSocket对象.bind(new InetSocketAddress(InetAddress.getByName("hostName")), 端口)
void bind(SocketAddress endpoint, int backlog)  绑定SocketAddress，并指定请求连接队列的最大长度
void close() 关闭此socket
ServerSocketChannel getChannel() 返回此ServerSocket对象相关的唯一的ServerSocketChannel 对象
InetAddress getInetAddress() 获取此socket的IP信息
int getLocalPort() 获取侦听的端口
SocketAddress getLocalSocketAddress() 获取绑定的IP信息
int getReceiveBufferSize()
boolean getReuseAddress() 获取请求客户端的address信息
int getSoTimeout() 获取socket 超时设置值
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

```
</details>


# 基于Socket的TCP编程
* 客户端Socket的工作过程包含以下四个基本的步骤
    * 创建 Socket
    ```text
    根据指定服务端的 IP 地址或端口号构造 Socket 类对象。
    若服务器端响应，则建立客户端到服务器的通信线路。
    若连接失败，会出现异常
    ```
    * 打开连接到 Socket 的输入流/输出流
    ```text
    使用 getInputStream()方法获得输入流，其read()会阻塞
    使用 getOutputStream()方法获得输出流，进行数据传输
    ```
    * 按照一定的协议对 Socket 进行读/写操作
    ```text
    通过输入流读取服务器放入线路的信息（但不能读取自己放入线路的信息），
    通过输出流将信息写入线程
    ```
    * 关闭socket
    ```text
    断开客户端到服务器的连接，释放链路
    ```
    示例  
    [TCPSocketTest1 client](./src/com/java/www/TCPSocketTest1.java)
    
* 服务端TCP socket编程
    * 调用 ServerSocket(int port)
    ```text
    创建一个服务器端套接字，并绑定到指定端口上。用于监听客户端的请求
    ```
    * 调用 accept()
    ```text
    监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字对象。
    这里会发生阻塞，知道有请求连接进来
    ```
    * 调用 该Socket类对象的 getOutputStream() 和 getInputStream()
    InputStream.read(byte[] b)方法也会发生阻塞，等待读取内容，需要自行判断结束
    ```text
    获取输出流和输入流，开始网络数据的发送和接收
    ```
    * 关闭ServerSocket和Socket对象
    ```text
    客户端访问结束，关闭通信套接字
    ```
    示例  
    [TCPSocketTest1 server](./src/com/java/www/TCPSocketTest1.java)  


## TCP socket示例
<details>
<summary>展开示例</summary>

* 客户端发送内容给服务端，服务端将内容打印到控制台上  
[TCPSocketTest1](./src/com/java/www/TCPSocketTest1.java) 

* 客户端发送内容给服务端，服务端给予反馈  
[TCPSocketTest2](./src/com/java/www/TCPSocketTest2.java)  

* 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接  
[TCPSocketTest3](./src/com/java/www/TCPSocketTest3.java)  

* 客户端持续发送内容给服务端，输入q或exit是退出，服务端将内容打印到控制台上  
[TCPServer](./src/com/java/socket/TCPServer.java)  
[TCPClient](./src/com/java/socket/TCPClient.java)  

* 服务端、客户端互相收发信息，类似聊天，即一对一通信
[TCPServer](./src/com/java/socket2/TCPServer.java)  
[TCPClient](./src/com/java/socket2/TCPClient.java)  

* java socket TCP 模拟 简单的WEB Server  
[WebServer](./src/com/java/www/WebServer.java)  

* Web server:先启动一个线程来等待用户的请求连接，当有一个客户请求连接进来时，新开启一个线程等待下一个客户端请求连接。  
线程响应完客户请求后，关闭当前socket及相关的IO流，当前线程就退出了。  
[WebServer2](./src/com/java/www/WebServer2.java)  
[WebServer3](./src/com/java/www/WebServer3.java)  
[WebServer4](./src/com/java/www/WebServer4.java)  

* Web server:利用线程池，让服务端一直保持开启n个线程  
[WebServer5](./src/com/java/www/WebServer5.java)

</details>


# UDP网络通信
* DatagramSocket类和DatagramPacket类实现了基于UDP协议的网络程序
* UDP数据报通过数据报socket DatagramSocket发送和接收，系统不保证UDP数据报一定能够安全送到目的地，
也不能确定什么时候送达
* DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP、发送端的端口、接收端的IP、接收端的端口、
数据信息
* UDP协议中每个数据报都包含了完整的地址信息，因此无须建立发送方和接收方的连接

# DatagramSocket类
位置：java.net.DatagramSocket;
## 构造器
<details>
<summary>展开构造器</summary>

```text
DatagramSocket() 创建一个数据报socket，不绑定IP、端口
protected DatagramSocket(DatagramSocketImpl impl) 创建一个未绑定IP、端口的 DatagramScoket对象，并指定DatagramSocketImpl
DatagramSocket(int port) 创建一个DatagramSocket对象，并绑定指定的port端口，IP默认为0.0.0.0
DatagramSocket(int port, InetAddress laddr) 创建一个DatagramSocket对象,绑定指定的IP(laddr)、端口(port)
DatagramSocket(SocketAddress bindaddr) 创建一个DatagramSocket对象，绑定指定的SocketAddress，如：new DatagramSocket(new InetSocketAddress("10.100.0.2", 3030))


```

</details>

## 方法
<details>
<summary>展开方法</summary>

```text
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

```

</details>


# DatagramPacket类
位置：java.net.DatagramPacket
## 构造器
<details>
<summary>展开构造器</summary>

```text
DatagramPacket(byte[] buf, int length) 创建一个DatagramPacket对象，用于接收数据报包，使用字节数组buf来存放，长度length，默认从0开始
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，默认从0开始，指定接收端的IP为address，端口为port
DatagramPacket(byte[] buf, int offset, int length) 创建一个DatagramPacket对象，用于接收数据报包，使用字节数组buf来存放，长度length，从offset开始
DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，从offset开始，指定接收端的IP为address，端口为port
DatagramPacket(byte[] buf, int offset, int length, SocketAddress address) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，从offset开始，并指定SocketAddress为address
DatagramPacket(byte[] buf, int length, SocketAddress address) 创建一个DatagramPacket对象，用于发送数据报包，内容为buf，长度为length，默认从0开始，并指定SocketAddress为address

```

</details>

## 方法
<details>
<summary>展开方法</summary>

```text
InetAddress	getAddress() 返回发送数据报中的接收端的IP 或 返回接收数据报中的发送端的IP
byte[] getData() 从接收到或要发送的数据报包中获取缓冲数据，从偏移量offset开始读取length个字节
int	getLength() 返回接收到或要发送的数据报包数据的大小
int	getOffset() 返回读取数据报包中数据的指定的偏移量，不指定默认为0
int	getPort() 返回发送或接收数据报中远端的端口
SocketAddress getSocketAddress() 返回发送或接收数据报中远端的SocketAddress，包含了IP、端口，接收端要知道数据报包从哪发过来的，用此方法就可以知道发送端的IP和端口
void setAddress(InetAddress iaddr) 设置要发送数据报的接收端的IP
void setPort(int iport) 设置要发送数据报的接收端的端口
void setData(byte[] buf) 设置此数据报包的数据缓冲区
void setData(byte[] buf, int offset, int length) 设置此数据报包的数据缓冲区，指定从偏移量offset开启，length个长度
void setLength(int length) 设置数据报包的长度
void setSocketAddress(SocketAddress address)

```
</details>


# 基于socket的UDP编程
1. 创建DatagramSocket对象和DatagramPacket对象，数据放在数据报包，在数据报包中为数据报指定接收端IP、接收方端口、发送端(即本端)IP和端口不需要显式指定，由系统自动添加
2. 建立发送商、接收端
3. 建立数据包
4. 调用Socket的send、receive方法，DatagramSocket.receive()方法会阻塞，直接接收到数据
5. 关闭Socket 

* 发送端与接收端是两个独立的运行程序

示例  
客户端发信息到服务端，服务器端接收信息  
[UDPSocketTest1](./src/com/java/www/UDPSocketTest1.java)  

客户端信息到服务端，服务端接收信息并打印到控制台，然后回复客户端信息：你发送过来的信息接收到了  
[UDPSocketTest2](./src/com/java/www/UDPSocketTest2.java)  

客户端、服务端你一条、我一条依次发收数据。先从客户端开始发送信息，输入q退出  
[UDPSocketTest3](./src/com/java/www/UDPSocketTest3.java)  


# URL编程
* URL
```text
Uniform Resource Locator, 统一资源定位符，它表示 Internet 上某一资源的地址。
通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www，ftp 站点。
浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源

```
* URL的基本结构
    * <传输协议>://<主机名>:<端口号>/<文件名>
    * 如：http://192.168.1.100:8080/helloworld/index.jsp

* 类URL的构造方法都声明抛出非运行时异常，
必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获

* 一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性

# URL类
位置：java.net.URL

## 构造器
<details>
<summary>展开构造器</summary>

```text
URL(String spec)
Creates a URL object from the String representation.
从字符串形式的URL spec中创建一个URL对象

URL(String protocol, String host, int port, String file)
Creates a URL object from the specified protocol, host, port number, and file.
创建URL对象，指定协议为protocol、主机为host、端口为port、文件为字符串形式的file

URL(String protocol, String host, int port, String file, URLStreamHandler handler)
Creates a URL object from the specified protocol, host, port number, file, and handler.
创建URL对象，指定协议为protocol、主机为host、端口为port、文件为file、URL流处理器为Handler

URL(String protocol, String host, String file)
Creates a URL from the specified protocol name, host name, and file name.
创建URL对象，指定协议为protocol、主机为host、文件为file

URL(URL context, String spec)
Creates a URL by parsing the given spec within a specified context.
从指定的上下文context解析字符形式的spec，并创建该URL对象

URL(URL context, String spec, URLStreamHandler handler)
Creates a URL by parsing the given spec with the specified handler within a specified context.
创建URL对象，指定URL上下文解释器context、字符串形式URLspec，URL流处理器handler

```

</details>

## 方法
<details>
<summary>展开方法</summary>

```text
boolean	equals(Object obj) 判断此URL对象与URL对象obj是否相等
Compares this URL for equality with another object.

String getAuthority() 获取Authority
Gets the authority part of this URL.

Object getContent() 从此URL对象中获取内容，如：openConnection().getContent()
Gets the contents of this URL.

Object getContent(Class[] classes) 从此URL对象中获取内容，有classes数组中的第一个类型开始匹配
Gets the contents of this URL.

int	getDefaultPort() 获取此URL协议的默认端口
Gets the default port number of the protocol associated with this URL.

String getFile() 获取文件名
Gets the file name of this URL.

String getHost() 获取主机
Gets the host name of this URL, if applicable.

String getPath() 获取目录path
Gets the path part of this URL.

int	getPort() 获取端口
Gets the port number of this URL.

String getProtocol() 获取协议
Gets the protocol name of this URL.

String getQuery() 获取所有query参数
Gets the query part of this URL.

String getRef() 获取reference
Gets the anchor (also known as the "reference") of this URL.

String getUserInfo() 获取用户信息
Gets the userInfo part of this URL.

int	hashCode() 获取hash值
Creates an integer suitable for hash table indexing.

URLConnection openConnection() 返回一个URLConnection实例，该实例代表本地连接到URL远程的连接对象。
    注意：该方法不是建立一个真实的网络连接，只是返回一个URLConnection类的实例
Returns a URLConnection instance that represents a connection to the remote object referred to by the URL.

URLConnection openConnection(Proxy proxy) 与openConnection()相同，只是本地用的输入、输出流有指定的proxy处理
Same as openConnection(), except that the connection will be made through the specified proxy; Protocol handlers that do not support proxing will ignore the proxy parameter and make a normal connection.

InputStream	openStream() 打开本地到URL远端的连接，并返回一个InputStream输入流
Opens a connection to this URL and returns an InputStream for reading from that connection.

boolean	sameFile(URL other) 比较此URL与other URL是否相同，不包括fragment片段参数
Compares two URLs, excluding the fragment component.

static void	setURLStreamHandlerFactory(URLStreamHandlerFactory fac) 设置此URL的URL流处理器为fac
Sets an application's URLStreamHandlerFactory.

String toExternalForm() 获取此URL对象字符串形式的字符串
Constructs a string representation of this URL.

String toString()
Constructs a string representation of this URL.

URI	toURI() 获取去此URL等效的URI
Returns a URI equivalent to this URL.

```
</details>


# URLConnection类
针对HTTP协议  
位置：java.net.URLConnection

* URL的方法 openStream()：能从网络上读取数据
* 若希望输出数据，例如向服务器端的 CGI （公共网关接口-Common Gateway Interface-的简称，  
是用户浏览器和服务器端的应用程序进行连接的接口）程序发送一些数据，  
则必须先与URL建立连接，然后才能对其进行读写，此时需要使用 URLConnection
* 如果有输入和输入数据需求，使用URL对象.openConnection()，返回一个URLConnection
* URLConnection
```text
表示到URL所引用的远程对象的连接。当与一个URL建立连接时，
首先要在一个 URL 对象上通过方法 openConnection() 生成对应的 URLConnection 对象。
如果连接过程失败，将产生IOException

URLConnection对象可获取输入流、输出流

```
* 通过URLConnection对象获取的输入流和输出流，即可以与现有的CGI程序进行交互


## 属性
<details>
<summary>展开属性</summary>

```text
protected boolean allowUserInteraction
If true, this URL is being examined in a context in which it makes sense to allow user interactions such as popping up an authentication dialog.

protected boolean connected
If false, this connection object has not created a communications link to the specified URL.

protected boolean doInput
This variable is set by the setDoInput method.

protected boolean doOutput
This variable is set by the setDoOutput method.

protected long ifModifiedSince
Some protocols support skipping the fetching of the object unless the object has been modified more recently than a certain time.

protected URL url
The URL represents the remote object on the World Wide Web to which this connection is opened.

protected boolean useCaches
If true, the protocol is allowed to use caching whenever it can.
```
</details>


## 构造器
<details>
<summary>展开构造器</summary>

```text
protected URLConnection(URL url)
Constructs a URL connection to the specified URL.
```
</details>

## 方法
<details>
<summary>展开方法</summary>

```text
InputStream	getInputStream() 从此打开的连接中获取 InputStreams输入流
Returns an input stream that reads from this open connection.

OutputStream getOutputStream() 从此打开的连接中获取 OutputStreams输出流
Returns an output stream that writes to this connection.

void addRequestProperty(String key, String value)
Adds a general request property specified by a key-value pair.

abstract void connect()
Opens a communications link to the resource referenced by this URL, if such a connection has not already been established.

boolean	getAllowUserInteraction()
Returns the value of the allowUserInteraction field for this object.

int	getConnectTimeout() 获取连接超时时间，单位ms毫秒
Returns setting for connect timeout.

Object getContent()
Retrieves the contents of this URL connection.

Object getContent(Class[] classes)
Retrieves the contents of this URL connection.

String getContentEncoding() 从content-encoding头字段中获取内容的编码
Returns the value of the content-encoding header field.

int	getContentLength() 从content-encoding头字段中获取内容长度
Returns the value of the content-length header field.

long getContentLengthLong()
Returns the value of the content-length header field as a long.

String getContentType() 从content-encoding头字段中获取内容的类型
Returns the value of the content-type header field.

long getDate() 获取long型日期
Returns the value of the date header field.

static boolean getDefaultAllowUserInteraction()
Returns the default value of the allowUserInteraction field.

static String getDefaultRequestProperty(String key)
Deprecated.
The instance specific getRequestProperty method should be used after an appropriate instance of URLConnection is obtained.

boolean	getDefaultUseCaches()
Returns the default value of a URLConnection's useCaches flag.

boolean	getDoInput()
Returns the value of this URLConnection's doInput flag.

boolean	getDoOutput()
Returns the value of this URLConnection's doOutput flag.

long getExpiration()
Returns the value of the expires header field.

static FileNameMap	getFileNameMap()
Loads filename map (a mimetable) from a data file.

String getHeaderField(int n)
Returns the value for the nth header field.

String getHeaderField(String name)
Returns the value of the named header field.

long getHeaderFieldDate(String name, long Default)

Returns the value of the named field parsed as date.

int	getHeaderFieldInt(String name, int Default)
Returns the value of the named field parsed as a number.

String getHeaderFieldKey(int n)
Returns the key for the nth header field.

long getHeaderFieldLong(String name, long Default)
Returns the value of the named field parsed as a number.

Map<String,List<String>> getHeaderFields()
Returns an unmodifiable Map of the header fields.

long getIfModifiedSince()
Returns the value of this object's ifModifiedSince field.

long getLastModified()
Returns the value of the last-modified header field.

Permission	getPermission()
Returns a permission object representing the permission necessary to make the connection represented by this object.

int	getReadTimeout()
Returns setting for read timeout.

Map<String,List<String>> getRequestProperties()
Returns an unmodifiable Map of general request properties for this connection.

String getRequestProperty(String key)
Returns the value of the named general request property for this connection.

URL	getURL()
Returns the value of this URLConnection's URL field.

boolean	getUseCaches()
Returns the value of this URLConnection's useCaches field.

static String guessContentTypeFromName(String fname)
Tries to determine the content type of an object, based on the specified "file" component of a URL.

static String guessContentTypeFromStream(InputStream is)
Tries to determine the type of an input stream based on the characters at the beginning of the input stream.

void setAllowUserInteraction(boolean allowuserinteraction)
Set the value of the allowUserInteraction field of this URLConnection.

void setConnectTimeout(int timeout)
Sets a specified timeout value, in milliseconds, to be used when opening a communications link to the resource referenced by this URLConnection.

static void	setContentHandlerFactory(ContentHandlerFactory fac)
Sets the ContentHandlerFactory of an application.

static void	setDefaultAllowUserInteraction(boolean defaultallowuserinteraction)
Sets the default value of the allowUserInteraction field for all future URLConnection objects to the specified value.

static void	setDefaultRequestProperty(String key, String value)
Deprecated.
The instance specific setRequestProperty method should be used after an appropriate instance of URLConnection is obtained. Invoking this method will have no effect.

void setDefaultUseCaches(boolean defaultusecaches)
Sets the default value of the useCaches field to the specified value.

void setDoInput(boolean doinput) 设置doInput属性值，默认是true，即允许读取InputStream
Sets the value of the doInput field for this URLConnection to the specified value.

void setDoOutput(boolean dooutput) 设置doOutput属性值，默认是false，即默认不允许OutputStream写入数据。若要写入，把doOutput设置为true
Sets the value of the doOutput field for this URLConnection to the specified value.

static void	setFileNameMap(FileNameMap map)
Sets the FileNameMap.

void setIfModifiedSince(long ifmodifiedsince)
Sets the value of the ifModifiedSince field of this URLConnection to the specified value.

void setReadTimeout(int timeout)
Sets the read timeout to a specified timeout, in milliseconds.

void setRequestProperty(String key, String value)
Sets the general request property.

void setUseCaches(boolean usecaches)
Sets the value of the useCaches field of this URLConnection to the specified value.

String toString()
Returns a String representation of this URL connection.

```
</details>


# HttpURLConnection类
位置：java.net.HttpURLConnection

## 属性
<details>
<summary>展开属性</summary>

```text
protected int chunkLength
The chunk-length when using chunked encoding streaming mode for output.

protected int fixedContentLength0
The fixed content-length when using fixed-length streaming mode.

protected long fixedContentLengthLong
The fixed content-length when using fixed-length streaming mode.

static int HTTP_ACCEPTED
HTTP Status-Code 202: Accepted.

static int HTTP_BAD_GATEWAY
HTTP Status-Code 502: Bad Gateway.

static int HTTP_BAD_METHOD
HTTP Status-Code 405: Method Not Allowed.

static int HTTP_BAD_REQUEST
HTTP Status-Code 400: Bad Request.

static int HTTP_CLIENT_TIMEOUT
HTTP Status-Code 408: Request Time-Out.

static int HTTP_CONFLICT
HTTP Status-Code 409: Conflict.

static int HTTP_CREATED
HTTP Status-Code 201: Created.

static int HTTP_ENTITY_TOO_LARGE
HTTP Status-Code 413: Request Entity Too Large.

static int HTTP_FORBIDDEN
HTTP Status-Code 403: Forbidden.

static int HTTP_GATEWAY_TIMEOUT
HTTP Status-Code 504: Gateway Timeout.

static int HTTP_GONE
HTTP Status-Code 410: Gone.

static int HTTP_INTERNAL_ERROR
HTTP Status-Code 500: Internal Server Error.

static int HTTP_LENGTH_REQUIRED
HTTP Status-Code 411: Length Required.

static int HTTP_MOVED_PERM
HTTP Status-Code 301: Moved Permanently.

static int HTTP_MOVED_TEMP
HTTP Status-Code 302: Temporary Redirect.

static int HTTP_MULT_CHOICE
HTTP Status-Code 300: Multiple Choices.

static int HTTP_NO_CONTENT
HTTP Status-Code 204: No Content.

static int HTTP_NOT_ACCEPTABLE
HTTP Status-Code 406: Not Acceptable.

static int HTTP_NOT_AUTHORITATIVE
HTTP Status-Code 203: Non-Authoritative Information.

static int HTTP_NOT_FOUND
HTTP Status-Code 404: Not Found.

static int HTTP_NOT_IMPLEMENTED
HTTP Status-Code 501: Not Implemented.

static int HTTP_NOT_MODIFIED
HTTP Status-Code 304: Not Modified.

static int HTTP_OK
HTTP Status-Code 200: OK.

static int HTTP_PARTIAL
HTTP Status-Code 206: Partial Content.

static int HTTP_PAYMENT_REQUIRED
HTTP Status-Code 402: Payment Required.

static int HTTP_PRECON_FAILED
HTTP Status-Code 412: Precondition Failed.

static int HTTP_PROXY_AUTH
HTTP Status-Code 407: Proxy Authentication Required.

static int HTTP_REQ_TOO_LONG
HTTP Status-Code 414: Request-URI Too Large.

static int HTTP_RESET
HTTP Status-Code 205: Reset Content.

static int HTTP_SEE_OTHER
HTTP Status-Code 303: See Other.

static int HTTP_SERVER_ERROR
Deprecated.
it is misplaced and shouldn't have existed.

static int HTTP_UNAUTHORIZED
HTTP Status-Code 401: Unauthorized.

static int HTTP_UNAVAILABLE
HTTP Status-Code 503: Service Unavailable.

static int HTTP_UNSUPPORTED_TYPE
HTTP Status-Code 415: Unsupported Media Type.

static int HTTP_USE_PROXY
HTTP Status-Code 305: Use Proxy.

static int HTTP_VERSION
HTTP Status-Code 505: HTTP Version Not Supported.

protected boolean instanceFollowRedirects
If true, the protocol will automatically follow redirects.

protected String method
The HTTP method (GET,POST,PUT,etc.).

protected int responseCode
An int representing the three digit HTTP Status-Code.

protected String responseMessage
The HTTP response message.
```
</details>

## 构造器
<details>
<summary>展开构造器</summary>

```text
protected HttpURLConnection(URL u)
Constructor for the HttpURLConnection.
```
</details>

## 方法
<details>
<summary>展开方法</summary>

```text
abstract void disconnect()
Indicates that other requests to the server are unlikely in the near future.

InputStream	getErrorStream()
Returns the error stream if the connection failed but the server sent useful data nonetheless.

static boolean getFollowRedirects()
Returns a boolean indicating whether or not HTTP redirects (3xx) should be automatically followed.

String getHeaderField(int n)
Returns the value for the nth header field.

long getHeaderFieldDate(String name, long Default)
Returns the value of the named field parsed as date.

String getHeaderFieldKey(int n)
Returns the key for the nth header field.

boolean	getInstanceFollowRedirects()
Returns the value of this HttpURLConnection's instanceFollowRedirects field.

Permission getPermission()
Returns a SocketPermission object representing the permission necessary to connect to the destination host and port.

String getRequestMethod()
Get the request method.

int	getResponseCode()
Gets the status code from an HTTP response message.

String getResponseMessage()
Gets the HTTP response message, if any, returned along with the response code from a server.

void setChunkedStreamingMode(int chunklen)
This method is used to enable streaming of a HTTP request body without internal buffering, when the content length is not known in advance.

void setFixedLengthStreamingMode(int contentLength)
This method is used to enable streaming of a HTTP request body without internal buffering, when the content length is known in advance.

void setFixedLengthStreamingMode(long contentLength)
This method is used to enable streaming of a HTTP request body without internal buffering, when the content length is known in advance.

static void	setFollowRedirects(boolean set)
Sets whether HTTP redirects (requests with response code 3xx) should be automatically followed by this class.

void setInstanceFollowRedirects(boolean followRedirects)
Sets whether HTTP redirects (requests with response code 3xx) should be automatically followed by this HttpURLConnection instance.

void setRequestMethod(String method) 设置请求方法，GET、POST、HEAD、OPTIONS、PUT、DELETE、TRACE方法之一
Set the method for the URL request, one of: GET POST HEAD OPTIONS PUT DELETE TRACE are legal, subject to protocol restrictions.

abstract boolean usingProxy()
Indicates if the connection is going through a proxy.
```
</details>

## URL编程示例
```text
URL url = new URL("http://127.0.0.1/");

URLConnection urlConnection = url.openConnection();
urlConnection.setDoOutput(true); // 设置doOutput值为true，允许向OutputStream写入数据，默认是不允许的

InputStream inputStream = urlConnection.getInputStream()
OutputStream outputStream = urlConnection.getOutputStream()


如果URL的scheme为 http或https，则可以把URLConnection转为HttpURLConnection

HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
```

* 从网络上下载一个文件  
[URLTest](./src/com/java/www/URLTest.java)  
* 本地上传信息到服务器  
[URLTest2](./src/com/java/www/URLTest2.java)


# 小结
* 位于网络中的计算机具有唯一的IP地址，这样不同的主机可以互相区分
* 客户端--服务器模型
```text
是一种最常见的网络应用程序模型。
服务器是一个为其客户端提供某种特定服务的硬件或软件。
客户机是一个用户应用程序，用于访问某台服务器提供的服务。
端口号是对一个服务的访问场所，它用于区分同一物理计算机上的多个服务。
套接字用于连接客户端和服务器，客户端和服务器之间的每个通信会话使用一个不同的套接字。
TCP协议用于实现面向连接的会话
```
* Java 中有关网络方面的功能都定义在 java.net 程序包中。  
Java 用 InetAddress 对象表示 IP 地址，  
该对象里有两个字段：主机名(String) 和 IP 地址(int)
* 类 Socket 和 ServerSocket 实现了基于TCP协议的客户端－服务器程序
```text
Socket是客户端和服务器之间的一个连接，连接创建的细节被隐藏了。
这个连接提供了一个安全的数据传输通道，
这是因为 TCP 协议可以解决数据在传送过程中的丢失、损坏、重复、乱序以及网络拥挤等问题，
它保证数据可靠的传送
```
* 类 URL 和 URLConnection 提供了最高级网络应用
```text
URL 的网络资源的位置来同一表示 Internet 上各种网络资源。
通过URL对象可以创建当前应用程序和 URL 表示的网络资源之间的连接，
这样当前程序就可以读取网络资源数据，或者把自己的数据传送到网络上去
```


# 其他
## java lambda表达式
符号：() -> { }
即一个匿名类的匿名方法

```text
// 如： 
Runnable runnable = () -> {
    // 方法内容
    ...
}
```

## InputStream判断数据已经读取结束的解决方法
* 让发送端发送完数据后，关闭连接。 这个在Http的操作时很常见。
* 约定发送的数据长度，比如 http的 keepAlive 就是必须依赖这个的 Content-Length 
* 设置超时的时间，根据我的经验，只有在Socket级别设置才有效. 
Socket socket = new Socket(host,port); 
socket.setSoTimeout(100); // 如果超过100毫秒还没有数据，则抛出 SocketTimeoutException
