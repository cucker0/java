package com.java.www;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeTest {
    private static Pipe mypipe;

    {
        try {
            mypipe = Pipe.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipeTest() {}

    @Test
    public void test1() {
        Pipe.SinkChannel sinkChannel = null;
        Pipe.SourceChannel sourceChannel = null;
        try {
            Pipe pipe = Pipe.open();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            sinkChannel = pipe.sink();
            byteBuffer.put("学习亦难，亦快乐！".getBytes());
            byteBuffer.flip();
            sinkChannel.write(byteBuffer);

            sourceChannel = pipe.source();
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            int len = sourceChannel.read(byteBuffer1);
            byteBuffer1.flip();
            System.out.println(new String(byteBuffer1.array()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sourceChannel != null) {
                try {
                    sourceChannel.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sinkChannel != null) {
                try {
                    sinkChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 利用多线程，一个线程往管道中写入数据，一个线程从管理中读取数据。操作的管理为同一个管道
     * 运行main()方法进行测试
     */
    @Test
    public void test2() {
        Runnable send = new Runnable() {
            @Override
            public void run() {
                System.out.println("send");
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    Pipe.SinkChannel sinkChannel = mypipe.sink();
                    byteBuffer.put("学习亦难，亦快乐！".getBytes());
                    byteBuffer.flip();
                    sinkChannel.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable receive = () -> {
            System.out.println("receive");
            try {
                Pipe.SourceChannel sourceChannel = mypipe.source();
                ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
                int len = sourceChannel.read(byteBuffer1);
                byteBuffer1.flip();
                System.out.println(new String(byteBuffer1.array(), 0, len));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Thread th1 = new Thread(send);
        Thread th2 = new Thread(receive);
        th1.start();
        th2.start();

    }

    public static void main(String[] args) {
        PipeTest pipeTest = new PipeTest();
        pipeTest.test2();
    }
}


