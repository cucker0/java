/*
Thread常用方法
* void start() 启动这个线程；调用该线程里的run()方法
* static int activeCount() 返回当前线程组及其子级中活动线程数的估计值
* void checkAccess()
* protected Object clone()
* int countStackFrames() // Deprecated
* static Thread currentThread() // 返回当前正在执行的线程对象的引用(即当前线程对象)
* void destroy()
* static void dumpStack()
* static int enumerate(Thread[] tarray)
* static Map<Thread,StackTraceElement[]> getAllStackTraces()
* ClassLoader getContextClassLoader()
* static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler()
* long getId()
* String getName()
* int getPriority()
* StackTraceElement[] getStackTrace()
* Thread.State getState()
* ThreadGroup getThreadGroup()
* Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
* static boolean holdsLock(Object obj)
* void interrupt()
* static boolean interrupted()
* boolean isActive()
* boolean isDaemon()
* boolean isInterrupted()
* void join() 等待这个线程执行到结束
* void join(long millis) 最多等x毫秒来等待这个线程执行结束
* void 	join(long millis, int nanos)


* */

package com.java.www;

public class Thread2Test {
}
