package com.java.www;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path接口
 *
 *
 */
public class PathTest {
    @Test
    public void test1() {
        // String toString() ： 返回调用 Path 对象的字符串表示形式
        Path path = Paths.get("./log", "server.log");
        System.out.println("path: " + path.toString()); // .\log\server.log

        // boolean startsWith(String path) : 判断是否以 path 路径开始
        Path p2 = Paths.get("./log");
        boolean bb = path.startsWith(p2);
        System.out.println("path.startsWith(p2): " + bb);

        // boolean endsWith(String path) : 判断是否以 path 路径结束
        System.out.println("path.endsWith(\".log\"): " + path.endsWith(".log")); // false
        System.out.println("path.endsWith(\"server.log\"): " + path.endsWith("server.log")); // true

        // boolean isAbsolute() : 判断是否是绝对路径
        System.out.println("path.isAbsolute(): " + path.isAbsolute()); // false

        // Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
        Path p33 = path.getParent();
        System.out.println("path.getParent(): " + p33); // .\log

        // Path getRoot() ：返回调用 Path 对象的根路径
        System.out.println("path.getRoot(): " + path.getRoot()); // null

        // Path getFileName() : 返回与调用 Path 对象关联的文件名
        System.out.println("path.getFileName(): " + path.getFileName()); // server.log

        // int getNameCount() : 返回Path 根目录后面元素的数量(即path的层数)
        int i = path.getNameCount();
        System.out.println("path.getNameCount(): " + i); // 3

        // Path getName(int idx) : 返回指定索引位置 idx 的路径名称，从0开始
        System.out.println("path.getName(0): " + path.getName(0));
        System.out.println("path.getName(1): " + path.getName(1));
        System.out.println("path.getName(2): " + path.getName(2));
//        System.out.println(path.getName(3)); // IllegalArgumentException异常

        // Path toAbsolutePath() : 返回此path对象的绝对路径Path对象
        Path path1 = path.toAbsolutePath();
        System.out.println("path.toAbsolutePath(): " + path1);

        // Path resolve(Path p) : 返回此对象后面追加Path p合成后的新Path对象
        Path p57 = Paths.get("bin");
        Path p58 = Paths.get("main.exe");
        Path pp = p57.resolve(p58);
        Path pp2 = p58.resolve(p57);
        System.out.println("p57: " + p57);
        System.out.println("p58: " + p58);
        System.out.println("p57.resolve(p58): " + pp); //
        System.out.println("p58.resolve(p57): " + pp2); //

        // File toFile(): 将Path转化为File类的对象
        File file = path.toFile();
        System.out.println("path.toFile(): " + file); // .\log\server.log
    }
}
