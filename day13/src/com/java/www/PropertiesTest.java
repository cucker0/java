/*
Hashtable 子类: Properties

Properties处理属性文件


* */

package com.java.www;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
            String host = properties.getProperty("host");
            String dbname = properties.getProperty("dbname");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            System.out.println("host: " + host);
            System.out.println("dbname: " + dbname);
            System.out.println("user: " + user);
            System.out.println("password: " + password);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
