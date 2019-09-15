NIO流
==

# NIO概述
```
Java NIO(New IO, Non-blocking IO)是从java 1.4开始加入。可以替代原来的java IO接口。
IO是面向流，NIO是面向缓冲区，基于通道的IO操作。NIO效率更高。
```

```text
java.nio.channels.Channel
    |--FileChannel  处理本地文件
    |--SocketChannel  TCP网络编程中客户端的Channel
    |--ServerSocketChannel  TCP网络编程中服务器的Channel
    |--DatagramChannel  UDP网络编程中发送端和接受端的Channel

```


