package com.java.www;

import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path、Paths、Files
 *
 *
 */
public class PathsFilsPathTest {
    /**
     * IO写法
     */
    @Test
    public void test1() {
        File f = new File("./log.txt");

    }

    /**
     * NIO写法
     */
    @Test
    public void test2() {
        // 本地文件
        Path path = Paths.get("./log.txt");

        // URI
        try {
            Path path1 = Paths.get(new URI("https://www.baidu.com/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
