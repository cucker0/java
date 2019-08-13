/*
Inet4Address 其中一个构造器


* */

public final class Inet4Address extends InetAddress {

    Inet4Address(String hostName, byte addr[]) {
        holder().hostName = hostName;
        holder().family = IPv4;
        if (addr != null) {
            if (addr.length == INADDRSZ) {
                // 10.100.1.12， 第1节.第2节.第3节.第4节，第节占一个字节，一字节占二进制8个位

                // 第4节 取二进制的低8位值
                int address = addr[3] & 0xFF;

                /*
                addr[2] << 8
                    第3节，换成二进制向右移8位，设int x =addr[2] << 8
                ((addr[2] << 8) & 0xFF00) 相当于 x & 0xFF00
                    取x的低16到9位值，设int y = x & 0xFF00
                address |= y 相当于把第4个节的二进制数与第3个节的二进制数拼接起来

                * */
                address |= ((addr[2] << 8) & 0xFF00);
                address |= ((addr[1] << 16) & 0xFF0000);
                address |= ((addr[0] << 24) & 0xFF000000);
                holder().address = address;
            }
        }
        holder().originalHostName = hostName;
    }

}