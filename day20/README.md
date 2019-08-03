day20_网络编程
==

# java lambda表达式
符号：() -> {}
即一个匿名类的匿名方法

```text
// 如： 
Runnable runnable = () -> {
    // 方法内容
    ...
}
```

# InputStream判断数据已经读取结束的解决方法
* 让发送端发送完数据后，关闭连接。 这个在Http的操作时很常见。
* 约定发送的数据长度，比如 http的 keepAlive 就是必须依赖这个的 Content-Length 
* 设置超时的时间，根据我的经验，只有在Socket级别设置才有效. 
Socket socket = new Socket(host,port); 
socket.setSoTimeout(100); // 如果超过100毫秒还没有数据，则抛出 SocketTimeoutException



