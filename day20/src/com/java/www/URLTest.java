/*
URL编程

URL的方法 openStream()：能从网络上读取数据
openConnection() 通过URLConnection对象获取的输入流和输出流，可用于与服务器端的 CGI(Common Gateway Interface公网网关接口)交互

功能：
    从网络上下载一个文件


Uniform Resource Identifiers(URI) : Generic * Syntax" :
    <scheme>://<authority><path>?<query>#<fragment>

# URL类
## 构造器
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

## 方法
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


# URLConnection类
## 属性
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

## 构造器
protected URLConnection(URL url)
Constructs a URL connection to the specified URL.


## 方法
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

long getDate()
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

* */

package com.java.www;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    @Test
    public void test1() {
        String url = "https://img.alicdn.com/imgextra/i3/3982196496/O1CN015PeaP11xrDOOCXYNp_!!3982196496.jpg_q100.jpg_.webp?v=100";
        URL u = null;
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String protocol = u.getProtocol();
        String host = u.getHost();
        int port = u.getPort(); // -1
        String path = u.getPath();
        String file = u.getFile();
        String ref = u.getRef();
        String query = u.getQuery();

        System.out.println("protocol: " + protocol);
        System.out.println("host: " + host);
        System.out.println("port: " + port);
        System.out.println("path: " + path);
        System.out.println("file: " + file);
        System.out.println("ref: " + ref);
        System.out.println("query: " + query);
        /*
        打印结果：
        protocol: https
        host: img.alicdn.com
        port: -1
        path: /imgextra/i3/3982196496/O1CN015PeaP11xrDOOCXYNp_!!3982196496.jpg_q100.jpg_.webp
        file: /imgextra/i3/3982196496/O1CN015PeaP11xrDOOCXYNp_!!3982196496.jpg_q100.jpg_.webp?v=100
        ref: null
        query: v=100

        * */

    }

    @Test
    public void downFile() {
        String url = "https://img.alicdn.com/imgextra/i3/3982196496/O1CN015PeaP11xrDOOCXYNp_!!3982196496.jpg_q100.jpg_.webp?v=100";

        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();


            // inputStream = u.openStream(); // 获取输入流，此方法也是可以的
            inputStream = urlConnection.getInputStream(); // 获取输入流
            // OutputStream outputStream = urlConnection.getOutputStream(); // 获取输出流

            fos = new FileOutputStream("huodong.jpg");
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("文件下载完毕");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
