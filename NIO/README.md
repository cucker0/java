NIO流
==

# 本章主要内容
* java NIO简介
* java NIO与IO的区别
* 缓冲区(Buffer)和通道(Channel)
* 文件通道(FileChannle)
* NIO的非阻塞式网络通信
    * 选择器Selector
    * SocketChannel,ServerSocketChannel,DatagramChannel
* 管道Pipe
* java NIO2(Path, Paths, Files)


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

# java NIO与IO的区别
内容 |IO |NIO 
:--- |:--- |:---
面向的对象 |面向流 Stream Oriented |面向缓冲区 Buffer Oriented
IO是否阻塞 |阻塞IO(Blocking IO) |非阻塞IO(Non Blocking IO)
是否有选择器 |无 |选择器 Selector

# Channel通道与Buffer缓冲区
java NIO系统的核心在于:Channel通道与Buffer缓冲区。
通道表示打开到IO设备的连接(如文件、socket)。
使用NIO系统，需要分配用于读写数据的缓冲区。
Channel：负责连接传输
Buffer：负责存储

# Buffer缓冲区
* 缓冲区（Buffer）概念
```text
一个用于特定基本数据类型的容器。
由 java.nio 包定义的，所有缓冲区都是 Buffer 抽象类的子类
```

* Buffuer用途
```text
Java NIO 中的 Buffer 主要用于与NIO通道进行交互，
1. 从in通道读取数据是写入缓冲区，
2. 从缓冲区读取数据到out通道中
```

* Buffer存储数据的是一个数组，
* Buffer子类
    ```text
    根据数据类型不同(boolean 除外) ，有以下 Buffer 常用子类
    static XxxBuffer allocate(int capacity) : 创建一个容量为 capacity 的 XxxBuffer 对象
    ```
    * ByteBuffer
    * CharBuffer
    * ShortBuffer
    * IntBuffer
    * LongBuffer
    * FloatBuffer
    * DoubleBuffer

## 缓冲区的基本属性
* capacity容量
```text
表示Buffer能存放的数据个数，即存放数据的数组长度，
不能为负数，并且创建后不能更改
```
* limit限制
```text
第一个不应该读取或写入的数据的索引，即位于 limit 后的数据
不可读写。缓冲区的限制不能为负，并且不能大于其容量
```
* position位置
```text
下一个要读取或写入的数据的索引。缓冲区的位置不能为
负，并且不能大于其限制
```
* mark标记
```text
用于标记当前偏移位置的变量，-1表示还未标记过
```

* 以上几个属性存在的关系
```text
不变式: mark <= position <= limit <= capacity
```

## Buffer常用方法
* Buffer clean()
```text
清空此缓冲区并返回此缓冲区.
public Buffer clear() {
    position = 0;
    limit = capacity;
    mark = -1;
    return this;
}
```

* Buffer flip()
```text
将缓冲区设置数据读取模式，执行flip()后，就可以通过get读取数据
将缓冲区的limit设置为当前位置position，并将当前位置position充值为0
public Buffer flip() {
    limit = position;
    position = 0;
    mark = -1;
    return this;
}
```

* int capacity()
>返回capacity容量值

* int limit()
>返回此缓冲区当前的limit值

* int position()
>返回此缓冲区当前的position值

* Buffer limit(int newLimit)
>将缓冲区limit值设置为newLimit, 并返回一个此缓冲区

* Buffer position(int newPosition)
>将缓冲区position值设置为newPosition, 并返回一个此缓冲区

* boolean hasRemaining()
>从目前的position到limit是否有元素, true:有， false:无

* int remaining()
>从目前的position到limit的元素个数

* Buffer mark()
>记录当前的position位置，即mark = position

* Buffer reset()
>position恢复到mark记录的位置，可用于再重读等需求。当 mark >= 0，则position = mark

* Buffer rewind()
```text
倒回起点，取消标记，可重复读。
public Buffer rewind() {
    position = 0;
    mark = -1;
    return this;
}
```

## Buffer数据操作方法
* 获取 Buffer 中的数据
    * get()
        >读取单个字节
    * get(byte[] dst)
        >批量读取多个(dst长度)字节到 dst 数组中
    * get(int index)
        >读取指定索引位置的字节(不会移动 position)

* 放入数据到 Buffer 中
    * put(byte b)
        >将给定单个字节写入缓冲区的当前位置
    * put(byte[] src)
        >将 src 中的字节写入缓冲区的当前位置
    * put(int index, byte b)
        >将指定字节写入缓冲区的索引位置(不会移动 position)


## 直接缓冲区与非直接缓冲区
```text
字节缓冲区要么是直接的，要么是非直接的。如果为直接字节缓冲区，
则 Java 虚拟机会尽最大努力直接在此缓冲区上执行本机 I/O 操作。
也就是说，在每次调用基础操作系统的一个本机 I/O 操作之前（或之后），
虚拟机都会尽量避免将缓冲区的内容复制到中间缓冲区中（或从中间缓冲区中复制内容）。
```

```text
直接字节缓冲区可以通过调用此类的 allocateDirect() 工厂方法来创建。
此方法返回的缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区。

直接缓冲区的内容可以驻留在常规的垃圾回收堆之外，
因此，它们对应用程序的内存需求量造成的影响可能并不明显。
所以，建议将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。
一般情况下，最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
```
```text
直接字节缓冲区还可以通过 FileChannel 的 map() 方法 将文件区域直接映射到内存中来创建。
该方法返回MappedByteBuffer。Java 平台的实现有助于通过 JNI 从本机代码创建直接字节缓冲区。
如果以上这些缓冲区中的某个缓冲区实例指的是不可访问的内存区域，
则试图访问该区域不会更改该缓冲区的内容，
并且将会在访问期间或稍后的某个时间导致抛出不确定的异常。
```

```text
字节缓冲区是直接缓冲区还是非直接缓冲区可通过调用其 isDirect() 方法来确定。
提供此方法是为了能够在性能关键型代码中执行显式缓冲区管理。
```

## HeapByteBuffer与DirectByteBuffer
* HeapByteBuffer非直接缓冲(堆缓冲区)
```text
是写在jvm堆上面的一个buffer，底层的本质是一个数组，用类封装维护了很多的索引（make/limit/position/capacity等） 
优点：由于内容维护在jvm里，所以把内容写进buffer里速度会快些；并且，可以更容易回收

创建方式：XxxBuffer.allocate(int capacity)
```

* DirectByteBuffer直接缓冲区
```text
底层的数据其实是维护在操作系统的内存中，而不是jvm里，DirectByteBuffer里维护了一个引用address指向了数据，从而操作数据
优点：跟外设（IO设备）打交道时会快很多，因为外设读取jvm堆里的数据时，不是直接读取的，而是把jvm里的数据读到一个内存块里，再在这个块里读取的，如果使用DirectByteBuffer，则可以省去这一步，实现zero copy（零拷贝）

创建方式：ByteBuffer.allocateDirect(int capacity)
只有ByteBuffer能创建直接缓冲区

```

* DirectByteBuffer的必要性
```text
外设之所以要把jvm堆里的数据copy出来再操作，不是因为操作系统不能直接操作jvm内存，
而是因为jvm在进行gc（垃圾回收）时，会对数据进行移动，一旦出现这种问题，外设就会出现数据错乱的情况
```

# Channel通道


