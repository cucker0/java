day15 IO流
==

# 主要内容
* java.io.File类的使用
* IO原理及流的分类
* 文件流
    * FileInputStream
    * FileOutputStream
    * FileReader
    * FileWriter
* 缓冲流
    * BufferedInputStream
    * BufferedOutputStream
    * BufferedReader
    * BufferedWriter
* 转换流
    * InputStreamReader
    * OutputStreamWriter
* 标准输入、输出流
* 打印流
    * PrintStream
    * PrintWriter
* 数据流
    * DataInputStream
    * DataOutputStream
* 对象流(序列化、反序列化)
    * ObjectInputStream
    * ObjectOutputStream
* 随机存取文件流(这里的随机是指在文件任意位置)
    * RandomAccessFile
    
# File类
* java.io.File类，文件和目录路径的抽象表示形式，与平台无关
* File能新建、删除、重命名文件和目录，但不能访问文件内容。操作文件内容需要使用IO流

* File对象可以作为参数给 new 流对象时的构造器参数

* File类常见的构造器
    * public File(String pathname)
    >以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储
    * public File(String parent, String child)
    >以parent为父路径，child为子路径创建的File对象
* File类的静态属性String separator存储了当前系统的路径分隔符。
    >在UNIX中，此字段为‘/’，在Windows中，为‘\\’，windows的路径分隔符也可以写成'/'  
            File file2 = new File("E:\\dev\\java_2019\\day15\\testLab\\lab1");  
            File file3 = new File("E:/dev/java_2019//day15/testLab/lab1/qq.exe");
    
## File类方法
### 访问文件名
* String getName() 获取文件名
* String getPath() 获取路径
* String getAbsoluteFile()  获取文件绝对路径
* String getAbsolutePath() 获取目录绝对路径
* String getParent() 获取父路径
* boolean renameTo(File newFile) 重命名文件或目录，当目标文件名、目录名存在时，则重名失败

### 文件检测
* boolean exists() 是否存在
* boolean canWrite() 是否能写
* boolean canRead() 是否可读
* boolean isFile() 是否为文件
* boolean isDirectory() 是否为目录
* boolean canExecute() 是否可执行

### 获取常规文件信息
* long lastModified() 返回文件、目录修改时间戳
* long length() 字节长度，The length, in bytes, of the file denoted by this abstract pathname

### 文件相关操作
* boolean createNewFile() 创建新文件，父目录不存在时，报IOException异常；若文件存在，创建失败
* boolean delete() 删除文件或空目录，非空目录删除失败

### 目录相关操作
* boolean mkDir() 创建目录，父目录不存在时创建失败
* boolean mkDirs() 创建多层目录，若父目录不存在时，父目录一同创建
* String[] list() 列出指定路径下的文件和目录，只显示当前层的，返回String数组
* File[] listFiles() 列出指定路径下的文件和目录，只显示当前层的，返回File数组

### 设置属性
* boolean setReadOnly()
* boolean setLastModified()
* boolean setWritable()
* boolean setExecutable()

File类的方法示例  
[File Test](./src/com/java/www/FileTest.java)


# JAVA IO原理
* IO流用来处理设备之间的数据传输
* java程序中，对于数据的输入/输出操作以流(stream)的方式进行
* java.io包下提供了各种流类和接口，用以获取不同各类的数据，并通过标准的方法输入和输出数据
* 输入(Input): 从外部读取数据(硬盘、U盘，网络存储的数据)到程序(内存)
* 输出(Output): 将程序数据输出到硬盘、U盘、网络、屏幕等

# 流的分类
* 按操作数据单位分类：
    * 字节流bytes stream (8 bit)
    * 字符流character stream (16 bit)
* 按数据流的方向分类
    * 输入流
    * 输出流
    
* 按流的角色分类
    * 节点流
    * 处理流

[流的分类结构](./images/IO流分类结构.png)


## 流的抽象基类
流方向 |字节流 |字符流
:--- |--- |---
输入流 |InputStream |Reader
输出流 |OutputStream |Writer

##　IO流体系
分类 |字节输入流(byte) |字节输出流(byte) |字符输入流(char) |字符输出流(char)
:--- |--- |--- |--- |---
抽象基类 |InputStream |OutputStream |Reader |Writer
访问文件 |FileInputStream <br>int read()是阻塞的 |FileOutputStream |FileReader |FileWriter
访问数组 |ByteArrayInputStream |ByteArrayOutputStream |CharArrayReader |CharArrayWriter
访问管道 |PipedInputStream |PipedOutputStream |PipedReader |PipedWriter
访问字符串 | | |StringReader |StringWriter
缓冲流 |BufferedInputStream <br>int read()非阻塞的 |BufferedOutputStream <br>flush() 每次写入后执行一次，保证最后的缓冲内容也被写入 |BufferedReader <br>String readLine() 读取的内容不包括行尾的换行符 |BufferedWriter <br> flush() 每次写入后执行一次，保证最后的缓冲内容也被写入
转换流 | | |InputStreamReader |OutputStreamWriter
对象流 |ObjectInputStream |ObjectOutputStream | |
打印流(输出) | |PrintStream | |PrintWriter
推回输入流 |PushbackInputStream | |PushbackReader |
数据流(特殊流) |DataInputStream |DataOutputStream | |

## 节点流和处理流
* 节点流可以从一个特定的数据源读写数据
    * 一般是一次一个字节或字符地操作
    * FileInputStream
    * FileOutputStream
    * FileReader
    * FileWriter
* 处理流是"连接"在已经存在的流(节点流或处理流)之上，通过对数据的处理为程序提供更强大的读写功能，对流的继续封装处理
    * 一般是一次多个字节或字符地操作
    * BufferedInputStream
    * BufferedOutputStream
    * BufferedReader
    * BuffereWriter


# InputStream、Reader
* InputStream、Reader是所有输入流的基类
* InputStream 方法(典型实现类：FileInputStream)
    * int read()
    * int read(byte[] b)
    * int read(byte[] b, int off, int len)
    * void close()
* Reader 方法(典型实现类：FileReader)
    * int read()
    * int read(char[])
    * int read(char[] c, int off, int len)
    * void close()
* 打开的IO流需要显式的关闭，IO资源不属于内存时的资源。JVM不会自动关闭


# OutputStream、Writer
* OutputStream、Writer是所有输出类的基类
* OutputStream 方法(典型实现类：FileOutputStream)
    * void write(int b)
    * void writer(byte[] b)
    * void write(byte[] b, int off, int len)
    * void flush()
    * void close() 需要先刷新，再关闭流对象
* Writer 方法(典型实现类：FileWriter)
    * void write(int c)
    * void writer(char[] cbuf)
    * void write(char[] cbuf, int off, int len)
    * void write(String str) // 因为字符流以字符为单位在操作，String就是char[]数组
    * void write(String str, int off, int len)
    * void flush()
    * void close()

[FileInputStream、FileOutStream Test](./src/com/java/www/FileInputStreamAndFileOutStreamTest.java)   
[FileReader、FileWriter Test](./src/com/java/www/FileReaderAndFileWriterTest.java)


# 处理流之一：缓冲流
* 为了提高数据读写的速度，JavaAPI提供了带缓冲功能的流类，在使用这些流类时，会创建一个内部缓冲区数组
* 根据数据操作单位可以把缓冲流分类
    * 字节缓冲流
        * BufferedInputStream
        * BufferedOutputStream
    * 字符缓冲流
        * BufferedReader
        * BufferedWriter
* 缓冲流要"套接"在相应有节点流上，对读写的数据提供了缓冲的功能，提高了读写的效率，同时增加了一些新的方法
* 对于输出的缓冲流，写出的数据会先在内存中缓存，使用flush()会使内存中的数据立刻写出

## 处理流之二：转换流
* 转换流提供了在字节流和字符流之间的转换
* Java API提供一两个转换流
    * InputStreamReader 字节流 转换成 字符流，解码过程
    * OutputStreamWriter 字符流 转换成 字节流，编码过程
* 字节流中的数据都是字符时，转换成字符流操作更高效

### InputStreamReader
* 用于将字节流中读取到的字节按指定字符集解码成字符。需要和InputStream“套接”
* 构造器
    * public InputStreamReader(InputStream in)
    * public InputStreamReader(InputStream, String chasetName)
    >InputStreamReader isr = new InputStreamReader(System.in, "UTF-8")
    

### OutputStreamWriter
* 用于将要写入到字节流中的字符按指定字符集编码成字节。需要和OutputStream“套接”
* 构造器
    * public OutputStreamWriter(OutputStream out)
    * public OutputStreamWriter(OutputStream out, String charsetName)
    

# 字符集编码
常见的编码表
* ASCII：美国标准信息交换码  
用一个字节的7位可以表示。
* ISO8859-1：拉丁码表。欧洲码表  
用一个字节的8位表示。
* GB2312：中国的中文编码表。  
* GBK：中国的中文编码表升级，融合了更多的中文文字符号。
* Unicode：国际标准码，融合了多种文字。  
所有文字都用两个字节来表示,Java语言使用的就是unicode
* UTF-8：最多用三个字节来表示一个字符。


