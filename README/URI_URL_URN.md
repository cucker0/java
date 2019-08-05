URI、URL、URN联系与区别

# 概念
* URI
>Uniform Resource Identifiers 统一资源表示符
* URL
>Uniform Resource Locator 统一资源定位器，统一资源定位符
* URN
```text
Uniform Resource Name 统一资源名称，
P2P下载中使用的磁力链接是URN的一种实现，如:
ed2k://|file|cn_windows_10_enterprise_ltsc_2019_x64_dvd_9c09ff24.iso|4478906368|E7C526499308841A4A6D116C857DB669|/
```
* URI的两种形式
    * URL
    * URN

## URI、URL、URN联系    
对于一个URI资源标识来说，URN就好比他的名字，而URL就好比是资源的街道住址。  
换句话说，URN以名称形式标识了一个资源项目，而URL则提供了一种找到他的方法

# URI、URL格式
* URI格式
[]标识不是必须有的
```text
Generic Syntax 通用语法：
<scheme>://<authority><path>[?<query>][#<fragment>]

* scheme
    访问资源使用的协议，常用scheme: http、https、ftp、mailto、file、data、irc
* authority
* path
* query
* fragment

```
* URL格式
```text
<schecme>://[user:password@]host[:port]<path>[;<params>][?<query>][#<frag>]

```