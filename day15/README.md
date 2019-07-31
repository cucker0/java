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

![流的分类结构](./images/IO流分类结构.png)


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

** 使用 字节流 读取含中文的文本文件 **
[byteStreamAndCharStream 2.1 字节流 读取文件到控制台](./src/com/java/exercise/byteStreamAndCharStream.java)  



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

示例  
[BufferedInputStream、BufferedOutput Test](./src/com/java/www/BufferedInputStreamAndBufferedOutputTest.java)  
[BufferedReader、BufferedWriter Test](./src/com/java/www/BufferedReaderAndBufferedWriterTest.java)  


# 处理流之二：转换流
* 转换流提供了在字节流和字符流之间的转换
* Java API提供一两个转换流
    * InputStreamReader 字节流 转换成 字符流，解码过程
    * OutputStreamWriter 字符流 转换成 字节流，编码过程
* 字节流中的数据都是字符时，转换成字符流操作更高效

示例  
[InputStreamReader、OutputStreamWriter Test](./src/com/java/www/InputStreamReaderAndOutputStreamWriterTest.java)

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
    

# 字符集
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


## 字符编码
* 解码：字节数组 -> 字符串
* 编码：字符串 -> 字节数组
* 转换流的编码应用 
    * 可以将字符按指定编码格式存储
    * 可以对文本数据按指定编码格式来解读
    * 指定编码表的动作由构造器完成


# 处理之三：标准输入输出流
* System.in和System.out分别代表了系统标准的输入和输出设备
* 默认输入设备是键盘，输出设备是显示器
* System.in的类型是InputStream
* System.out的是类型是PrintStream，它是OutputStream子类FileOutputStream子类
* 通过System类的setIn，setOut方法对默认设备进行改变。
    * public static void setIn(InputStream in)
    * public static void setOut(PrintStream out)
    

示例  
[StandardInput、StandardOutput Test](./src/com/java/www/StandardInputAndStandardOutputTest.java)

# 处理流之四：打印流
* 在整个IO包中，打印流是输出信息最方便的类
* PrintStream（字节打印流）和PrintWriter（字符打印流）
    * 提供了一系列重载的print和println方法，用于多种数据类型的输出
    * PrintStream和PrintWriter的输出不会抛出异常
    * PrintStream和PrintWriter有自动flush功能
    * System.out返回的是PrintStream的实例
    
示例  
[PrintStream、PrintWriter Test](./src/com/java/www/PrintStreamAndPrintWriterTest.java)    


# 处理流之五：数据流
* 为了方便操作java语言的基本数据类型的数据，可以使用数据流
* 数据流有两个类
    * DataInputStream 数据输入流，套接在InputStream 节点流上
    * DataOutputStream 数据输出流，套接在OutputStream 节点流上
* DataInputStream 方法
    * boolean readBoolean()
    * char readChar()
    * double readDouble()
    * long readLong()
    * String readUTF()
    * byte readByte()
    * float readFloat()
    * short readShort()
    * int readInt()
    * void readFully(byte[] b)
* DataOutputStream方法
    * void writeBoolean(boolean v)
    * void writeChar(int v)
    * void writeDouble(double v)
    * void writeLong(long v)
    * void writeUTF(String str)
    * int writeUTF(String str, DataOutput out)
    * void writeByte(int v)
    * void writeFloat(float v)
    * void wirteInt(int v)
    * void writeBytes(String s)
    * void writeChars(String s)
    * void write(byte b[], int off, int len)
    * void write(int b)
    * void flush()
示例  
[DataInputStream、DataOutputStream Test](./src/com/java/www/DataInputStreamAndDataOutputStreamTest.java)    
    
# 处理流之六：对象流
* ObjectInputStream、ObjectOutputStream
    >用于存储和读取对象的处理流，它的强大之处是可以把对象写入到存储设备中，也能把对象从
    外部设备中读取出来
* 序列化(Serialize):用ObjectOutputStream类将对象写入IO流中
* 反序列化(Deserialize):用ObjectInputStream类从IO流中恢复对象
    >ObjectOutputStream、ObjectInputStream不能序列化static和transient修饰的成员变量  
    读出来是null

示例  
[ObjectInputStream、ObjectOutputSteam Test](./src/com/java/www/ObjectInputStreamAndObjectOutputSteamTest.java)

## 对象的序列化
* 对象序列化机制
    >允许把内存中的java对象换成与平台无关的二进制流，从而允许把这种二进制流持久地保存到
    硬盘上，或通过网络将这种二进制流传输到另一个网络节点
* 当其他程序获取了这种二进制流，就可以恢复成原来的java对象
* 序列化的好处在于可将任何实现了Serializable接口的对象转化为字节数据，使其在保存和传输时可被还原
* 序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI 是 JavaEE 的基础。因此序列化机制是 JavaEE 平台的基础
* 如果需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一：
    * Serializable
    * Externalizable
* 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量
    * private static final long serialVersionUID;
    * serialVersionUID用来表明类的不同版本间的兼容性
    * 如果类没有显示定义这个静态变量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的源代码作了修改，serialVersionUID 可能发生变化。故建议，显示声明
* 显示定义serialVersionUID的用途
    * 希望类的不同版本对序列化兼容，因此需确保类的不同版本具有相同的serialVersionUID
    * 不希望类的不同版本对序列化兼容，因此需确保类的不同版本具有不同的serialVersionUID

## 使用对象流序列化对象
* 若某个类实现了Serializable就扣，该类的实例对象就是可以序列化的
    * 创建一个ObjectOutputStream对象
    * 调用ObjectOutputStream对象的wirteObject(T 对象)方法输出可序列化对象。没写一次，执行以下flush()
* 反序列化
    * 创建一个ObjectInputStream对象
    * 调用readObject()方法读取流中的对象
* 注意，如果某个类的变量不是基本数据类型或String类型，而是另一个引用类型，这个引用类型必须是可序列化的，
否者使用了该类的Field的类也不能序列化


# RandomAccessFile类
这里的随机指：可任意位置读写文件

* 即可以充当输入流，又可以充当输出流，也可以同时充当输入流、输出流
* 属于字节流
* 若输出的文件不存在，则创建；若存在，则覆盖内容
* RandomAccessFile类支持"随机访问"的方式，程序可以直接跳到文件的任意位置读、写文件
    * 支持值访问部分文件内容
    * 可以向已存在的文件后追加内容
* RandomAccessFile对象包含一个文件指针，用以标示当前读写出的位置，
RandomAccessFile类对象可以移动文件指针
    * long getFilePointer() 获取文件指针的位置
    * void seek(long pos) 将文件指针定位到pos位置
* RandomAccessFile类的构造器
    * public RandomAccessFile(File file, String mode)    
    * public RandomAccessFile(String fileName, String mode)
* 创建RandomAccessFile类实例需要制定mode访问模式，mode有以下4种
    * r 以只读模式打开
    * rw 以读写模式打开文件
    * rwd 以读写模式打开文件,同步文件内容的更新
    * rws 以读写模式打开文件,同步文件内容和元数据的更新

示例  
[RandomAccessFile Test](./src/com/java/www/RandomAccessFileTest.java)

# 流的基本应用小总结
* 流是用来处理数据的
* 处理数据时，一定要先明确数据源、数据目的地
    * 数据源可以是文件，可以是键盘
    * 数据目的地可以是文件、显示器及其他设备
* 流只是帮助数据进行传输，并对传输的数据进行处理，如过滤处理、转换处理
* 字节流-缓冲流
    * 输入流 InputStream - FileInputStream - BufferedInputStream
    * 输出流 OutputStream - FileOutputStream - BufferedOutputStream
* 字符流-缓冲流
    * 输入流 Reader - FileReader - BufferedReader
    * 输出流 Writer - FileWriter - BufferedWriter
* 转换流
    * InputStreamReader 字节流 转 字符流
    * OutputStreamWriter 字符流 转 字节流
* 对象流
    * ObjectInputStream
    * ObjectOutputStream
    * 序列化、反序列化
* RandomAccessFile随机存取文件
    
