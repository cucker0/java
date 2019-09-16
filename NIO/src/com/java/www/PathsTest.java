package com.java.www;

import org.junit.Test;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths类
 * 提供创建Path对象的静态方法
 *
 *
 * 只有一个私有的构造器，private Paths() { }
 * 只有两个静态方法：
 * public static Path get(String first, String... more)
 * 根据给定的一个或多个字符串创建Path对象，最终是调用了Path.of(first, more)
 *
 * public static Path get(URI uri)
 * 解析根据给定的uri并创建Path对象，最终是调用了Path.of(uri)。只能解析file文件系统资源，无法解析URL资源
 */
public class PathsTest {
    @Test
    public void test1() {
        // public static Path get(String first, String... more)
        Path path = Paths.get("./conf/jdbc.conf");
        System.out.println(path);
        System.out.println();

        URI uri = URI.create("file:///www/google/com/");
//        Path path1 = Paths.get(URI.create("https://www.biadu.com")); // 不能解析URL资源
        Path path1 = Paths.get(uri);
        System.out.println(uri);
    }

}
