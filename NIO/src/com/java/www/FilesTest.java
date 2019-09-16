package com.java.www;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Parameter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

/**
 * Files类
 *
 *
 */
public class FilesTest {
    /**
     * Files常用方法
     *
     */
    @Test
    public void test1() {
        // Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
        Path p1 = Path.of("./ph.png");
        Path p2 = Path.of("./ph2.png");
        try {
            if (!Files.exists(p2)) {
                Path p3 = Files.copy(p1, p2);
                System.out.println(p3 == p2); // true
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();


        // Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
        try {
            Path directory = Files.createDirectory(Paths.get("./conf"));
            System.out.println(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        // public static Path createDirectories(Path dir, FileAttribute<?>... attrs) ：创建多层目录。类似于linux中的md -p命令
        Path p47 = Path.of("./im/qq");
        try {
            Files.createDirectories(p47);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件，目录要求已经存在
        Path p3 = Path.of("./server.log");
        try {
            Files.createFile(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // void delete(Path path) : 删除一个文件/目录，如果不存在，执行报NoSuchFileException异常
        try {
//            Files.delete(Path.of("bin"));
            Files.delete(Path.of("conf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除
        Path p64 = Path.of("./file1");
        Path p65 = Path.of("./dir2");
        try {
//            Files.createFile(p64);
//            Files.createDirectory(p65);
            Files.deleteIfExists(p64);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置，也可以用来重命名。功能类似 linux 的move命令
        Path p75 = Path.of("./dir22");
        try {
            Files.move(p65, p75);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // long size(Path path) : 返回 path 指定文件的大小
        try {
            long size = Files.size(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Files用于判断的常用方法
     *
     */
    @Test
    public void test2() {
        // boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
        Path p1 = Path.of("./ph.png");
        boolean b = Files.exists(p1);
        System.out.println("Files.exists(p1): " + b);

        // boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
        System.out.println("Files.isDirectory(p1): " + Files.isDirectory(p1));

        // boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是普通文件
        System.out.println("Files.isRegularFile(p1): " + Files.isRegularFile(p1));

        // boolean isHidden(Path path) : 判断是否是隐藏文件
        try {
            System.out.println("Files.isHidden(p1): " + Files.isHidden(p1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // boolean isReadable(Path path) : 判断文件是否可读
        System.out.println("Files.isReadable(p1): " + Files.isReadable(p1));

        // boolean isWritable(Path path) : 判断文件是否可写
        System.out.println("Files.isWritable(p1): " + Files.isWritable(p1));

        // boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
        System.out.println("Files.notExists(p1): " + Files.notExists(p1));
    }

    /**
     * 内容操作
     *
     */
    @Test
    public void test3() {
        // SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
        Path p1 = Path.of("server.log");
        try {
            SeekableByteChannel seekableByteChannel = Files.newByteChannel(p1, StandardOpenOption.WRITE, StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            int read = seekableByteChannel.read(byteBuffer);
            System.out.println(read);
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(1024);
            byteBuffer2.put("996".getBytes());
            seekableByteChannel.write(byteBuffer2);
            System.out.println(seekableByteChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DirectoryStream<Path> newDirectoryStream(Path path) : 打开 path 指定的目录
        Path path = Path.of("./im/qq");
        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            paths.forEach(System.out::println);
            System.out.println(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
        try {
            InputStream inputStream = Files.newInputStream(p1);
//            InputStream inputStream2 = Files.newInputStream(p1, StandardOpenOption.APPEND);
            System.out.println("newInputStream: ");
            byte[] b =  new byte[20];
            int i;
            while ((i = inputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, i));
            }
            System.out.println("---");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
        try {
            OutputStream outputStream = Files.newOutputStream(p1, StandardOpenOption.APPEND);
            outputStream.write("222222222".getBytes()); // 把字节数组写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
