/*
文件数据库

* */

package com.java.CustomerSystem2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static String filePath = "CustomersDatabase.db"; // 保存数据文件路径

    // 构造器
    public Storage() {
        super();
    }

    // 方法
    public static ArrayList read() {
        // 读取数据
        ArrayList list = null;
        ObjectInputStream objectInputStream = null;
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                System.out.println("数据库文件不存在");
                return list;
            }
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = objectInputStream.readObject();
            list = (ArrayList) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void save(List customerList) {
        // 保存数据
        ObjectOutputStream objectOutputStream = null;
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            if (customerList != null) {
                objectOutputStream.writeObject(customerList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
