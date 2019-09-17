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

## HeapByteBuffer与DirectByteBuffer
* HeapByteBuffer
```text
是写在jvm堆上面的一个buffer，底层的本质是一个数组，用类封装维护了很多的索引（make/limit/position/capacity等） 
优点：由于内容维护在jvm里，所以把内容写进buffer里速度会快些；并且，可以更容易回收

创建方式：XxxBuffer.allocate(int capacity)
```

* DirectByteBuffer
```text
底层的数据其实是维护在操作系统的内存中，而不是jvm里，DirectByteBuffer里维护了一个引用address指向了数据，从而操作数据
优点：跟外设（IO设备）打交道时会快很多，因为外设读取jvm堆里的数据时，不是直接读取的，而是把jvm里的数据读到一个内存块里，再在这个块里读取的，如果使用DirectByteBuffer，则可以省去这一步，实现zero copy（零拷贝）

创建方式：XxxBuffer.allocateDirect(int capacity)
```

* DirectByteBuffer的必要性
```text
外设之所以要把jvm堆里的数据copy出来再操作，不是因为操作系统不能直接操作jvm内存，
而是因为jvm在进行gc（垃圾回收）时，会对数据进行移动，一旦出现这种问题，外设就会出现数据错乱的情况
```

