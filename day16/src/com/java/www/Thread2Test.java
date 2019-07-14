/*
Thread常用方法
* void start() 启动这个线程；调用该线程里的run()方法
* void run() 子线程要执行的代码放入run()方法中
* void stop() // Deprecated 停止当前线程，本质上是不安全的
* void stop(Throwable obj) // Deprecated
* static void sleep(long millis) 显式的让当前线程休眠millis毫秒
* static void sleep(long millis, int nanos) 让当前线程休眠millis毫秒加nanos纳秒
* void setDeamon(boolean on) 将此线程标记为守护进程线程或用户线程
* boolean isAlive() 测试此线程是否存活
* boolean isDaemon() 测试此线程是否为守护线程
* String getName() 返回线程名
* int getPriority() 返回线程的优先级
* void setName(String name) 设置此线程的名字
* void setPriority(int newPriority) 设置此线程的优先级，优先级范围[1-10]，值越大越优先，默认值5，优先级大的线程抢到CPU执行权概率要大，不是绝对的
* static void yield() 调用此方法的线程释放当前CPU的执行权
* void join() 等待这个线程执行到结束
    在A线程中调用B线程的join()方法，则当前线程到此线程方法时，A线程暂停执行，
    直到B线程执行完毕，A线程再接着B.join()之后的代码
* void join(long millis) 最多等millis毫秒来等待这个线程执行结束
* void 	join(long millis, int nanos) 最多等millis毫秒加nanos纳秒来等待这个线程执行结束
* Thread.State getState() 返回此线程的状态
* static Thread currentThread() // 返回当前正在执行的线程对象的引用(即当前线程对象)，调用当前的线程


* static int activeCount() 返回当前线程组及其子级中活动线程数的估计值
* void checkAccess()
* protected Object clone()
* int countStackFrames() // Deprecated
* void destroy()
* static void dumpStack()
* static int enumerate(Thread[] tarray)
* static Map<Thread,StackTraceElement[]> getAllStackTraces()
* ClassLoader getContextClassLoader()
* static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler()
* long getId()
* StackTraceElement[] getStackTrace()
* ThreadGroup getThreadGroup()
* Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
* static boolean holdsLock(Object obj)
* void interrupt()
* static boolean interrupted()
* boolean isInterrupted()
* void resume() // Deprecated
* void setContextClassLoader(ClassLoader cl)
* static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
* void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
* void suspend() // Deprecated
* String toString()


线程通信
* wait()
* notify()
* notifyAll()


* */

package com.java.www;

import org.junit.Test;

public class Thread2Test {
    public static void main(String[] args) {
        SubThread2 st1 = new SubThread2(100);
        st1.start();

        for (int i = 0; i < 100; ++i) {
            if (i == 22) {
                System.out.println("st1 isAlive: " + st1.isAlive());
                try { // 这里为什么要捕获异常，因为st1线程有可能结束了
                    st1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }

    @Test
    public void test1() {
        SubThread3 st1 = new SubThread3();
        SubThread3 st2 = new SubThread3();

        // set.Priority(int newPriority) 设置线程优先级
//        st1.setPriority(Thread.MAX_PRIORITY); // <==> st1.setPriority(10)
//        st2.setPriority(Thread.MIN_PRIORITY); // <==> str2.setPriority(1)
        st1.setPriority(3);
        st2.setPriority(2);
        st1.setName("优先级为10线程");
        st2.setName("优先级为1线程");
        System.out.println("st1 线程优先级：" + st1.getPriority());
        System.out.println("st2 线程优先级：" + st2.getPriority());

        st1.start();
        st2.start();

        // JUnit 测试Thread多线程时，默认执行到这就退出了，所以JUnit主线程要等待其他线程结束
        // Thread.currentThread().setDaemon(true);

        // 方法一：让主线程睡眠一定时间
//        try {
//            Thread.currentThread().sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 方法二：让主线程等待其他线程结束
        try {
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 获取线程的优先级
        System.out.println(Thread.currentThread().getPriority());

    }
}

class SubThread2 extends Thread {
    private int num;

    // 构造器
    public SubThread2(int num) {
        super();
        this.num = num;
    }

    // 方法
    @Override
    public void run() {
        for (int i = 0; i < num; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            // sleep(long millis)，这里的异常必须捕获，不能throws InterruptedException出去，因为父类Thread的run()未抛出异常，子类异常类型不能大于父类
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread3 extends Thread{
    // 方法
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}