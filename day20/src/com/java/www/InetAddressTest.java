/*
InetAddress
    Inet4Address
    Inet6Address

## 构造器
// 跨包后调用不了此构造器
protected InetAddress() {
        holder = new InetAddressHolder();
}

## 方法
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


* */

package com.java.www;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    @Test
    public void test1() {
        try {
            InetAddress inetAddress1 = InetAddress.getByAddress(new byte[]{127, 0, 0, 1}); // /127.0.0.1
            System.out.println(inetAddress1);
            // InetAddress.getByName("域名") 会通过DNS服务器解析该域名
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com"); // www.baidu.com/14.215.177.38
            InetAddress inetAddress3 = InetAddress.getByName("223.5.5.5"); // /223.5.5.5
            System.out.println(inetAddress2);
            System.out.println(inetAddress2.getHostName()); // www.baidu.com
            System.out.println(inetAddress2.getHostAddress()); //14.215.177.38
            System.out.println();
            System.out.println(inetAddress3);
            System.out.println(inetAddress3.getHostName()); // 223.5.5.5
            System.out.println(inetAddress3.getHostAddress()); // 223.5.5.5
            System.out.println(inetAddress3.getCanonicalHostName());

            System.out.println();
            // 本机IP
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4); // 主机名/IP，如：tiantian/10.100.17.191
            System.out.println(inetAddress4.getHostName());
            System.out.println(inetAddress4.getHostAddress());
            System.out.println();

            InetAddress inetAdd1 = InetAddress.getByAddress("www.qq.com", new byte[]{113, 96, (byte)232, (byte)215});
            System.out.println(inetAdd1);
            System.out.println();

            InetAddress[] inetAddrArray = InetAddress.getAllByName("www.tmall.com"); // 获取到域名解析出来的多个IP
            for (InetAddress inetA : inetAddrArray) {
                System.out.println(inetA);
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


}
