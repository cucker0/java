/*
URL 编程

功能：
    本地上传信息到服务器


#
URL url = new URL("http://127.0.0.1/");
URLConnection urlConnection = url.openConnection();
如果URL的scheme为 http或https，则可以把URLConnection转为HttpURLConnection
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

# HttpURLConnection类

## 属性
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

## 构造器
protected HttpURLConnection(URL u)
Constructor for the HttpURLConnection.

## 方法
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


* */

package com.java.www;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLTest2 {
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        int port = 80;
        try {
            serverSocket = new ServerSocket(port);
//            serverSocket.setReuseAddress(true);
            System.out.println("服务端已经启动，绑定端口：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            try {
                Socket socket = serverSocket.accept();
                // 新建socket线程，匿名Thread、Runnable对象
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader br = null;
                        BufferedWriter bw = null;

                        try {
                            // 接受客户端信息
                            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String data = "客户信息：" + socket.getRemoteSocketAddress() + "\n",
                                    s = "";
                            while ((s = br.readLine()) != null) {
                                data = data + s + "\n";
//                                if (s.equals("")) {
//                                    break;
//                                }
                                if (s.endsWith("<ENF>")) {
                                    break;
                                }
                            }
                            System.out.println(data.split("<ENF>")[0]);

                           /*
                           InputStream inputStream = socket.getInputStream();
                            byte[] b = new byte[1024 * 8];
                            int len;
                            while ((len = inputStream.read(b)) != -1) {
                                String str = new String(b, 0, len);
                                System.out.println(str);
                            }*/

                            // 响应客户端
                            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            String responseData = "HTTP/1.0 200 OK\r\n" +
                                    "Server: Java/12.0.1\r\n" +
                                    "Content-Type: text/html; charset=UTF-8\r\n" +
                                    "\r\n" +
                                    "<title>java web server</title>" +
                                    "<h1>Java Web Server</h1>" +
                                    "<h3>datetime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()) + "</h3>";

                            bw.write(responseData);
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                // 关闭bw、br、socket
                                if (bw != null) {
                                    bw.close();
                                }
                                if (br != null) {
                                    br.close();
                                }
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void client() {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            URL url = new URL("http://127.0.0.1/");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true); // 设置doOutput值为true，允许向OutputStream写入数据，默认是不允许的

            // upload
            urlConnection.setDoOutput(true);
            outputStream = urlConnection.getOutputStream();
            outputStream.write("hello server...".getBytes());
            outputStream.write("<ENF>\n".getBytes());
            outputStream.flush();
            System.out.println("向服务端发送数据完毕");

            // get
            inputStream = urlConnection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            System.out.println("开始接受数据");
            while ((len = inputStream.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
