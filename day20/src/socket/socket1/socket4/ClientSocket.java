package socket.socket1.socket4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("127.0.0.1",9999);
            System.out.println("客户端启动好");
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream =new DataOutputStream(outputStream);
            Scanner scanner =new Scanner(System.in);
            if(scanner.hasNext()){
                System.out.println("请输入多个字符：");
                String str = scanner.next();
                int type =1;
                byte[] data = str.getBytes();
                int len = data.length +5;
                dataOutputStream.writeByte(type);
                dataOutputStream.writeInt(len);
                dataOutputStream.write(data);
                dataOutputStream.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}