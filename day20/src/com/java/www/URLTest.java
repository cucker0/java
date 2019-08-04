/*
URL编程

URL的方法 openStream()：能从网络上读取数据
openConnection() 通过URLConnection对象获取的输入流和输出流，可用于与服务器端的 CGI(Common Gateway Interface公网网关接口)交互

功能：
    从网络上下载一个文件

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
