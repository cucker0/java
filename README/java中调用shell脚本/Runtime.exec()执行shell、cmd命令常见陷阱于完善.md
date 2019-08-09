Runtime.exec()执行shell、cmd命令常见陷阱于完善
==

# 前言
日常java开发中，有时需要通过java运行其它应用功程序，比如shell命令等。jdk的Runtime类提供了这样的方法。首先来看Runtime类的文档, 从文档中可以看出，每个java程序只会有一个Runtime实例，显然这是一个单例模式。

```java
/**
 * Every Java application has a single instance of class
 * <code>Runtime</code> that allows the application to interface with
 * the environment in which the application is running. The current
 * runtime can be obtained from the <code>getRuntime</code> method.
 * <p>
 * An application cannot create its own instance of this class.
 */
 public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    /**
     * Returns the runtime object associated with the current Java application.
     * Most of the methods of class <code>Runtime</code> are instance
     * methods and must be invoked with respect to the current runtime object.
     *
     * @return  the <code>Runtime</code> object associated with the current
     *          Java application.
     */
    public static Runtime getRuntime() {
        return currentRuntime;
    }

    /** Don't let anyone else instantiate this class */
    private Runtime() {}

    // ......
}
```

要运行JVM中外的程序，Runtime类提供了如下方法，详细使用方法可参见源码注释
```text
public Process exec(String command) throws IOException

public Process exec(String cmdarray[]) throws IOException

public Process exec(String command, String[] envp) throws IOException

public Process exec(String command, String[] envp, File dir) throws IOException

public Process exec(String[] cmdarray, String[] envp) throws IOException

public Process exec(String[] cmdarray, String[] envp, File dir) throws IOException
```

通过这种方式运行外部程序，有几个陷阱需要注意，本文尝试总结常见的几个陷阱，并给出相应的解决方法。同时封装一种比较完善的工具类，用来运行外部应用，并提供超时功能。


# Runtime.exec()常见的几种陷阱以及避免方法
## 陷阱1：IllegalThreadStateException
通过exec执行java命令为例子，最简单的方式如下。执行exec后，通过Process获取外部进程的返回值并输出。
```java
import java.io.IOException;

/**
 * Created by yangjinfeng02 on 2016/4/27.
 */
public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("java");
            int exitVal = process.exitValue();
            System.out.println("process exit value is " + exitVal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

很遗憾的是，我们发现输出结果如下，抛出了IllegalThreadStateException异常
```text
Exception in thread "main" java.lang.IllegalThreadStateException: process has not exited
at java.lang.ProcessImpl.exitValue(ProcessImpl.java:443)
at com.baidu.ubqa.agent.runner.Main.main(Main.java:18)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:497)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
```

为什么会抛出IllegalThreadStateException异常？
这是因为外部线程还没有结束，这个时候去获取退出码，exitValue()方法抛出了异常。看到这里读者可能会问，为什么这个方法不能阻塞到外部进程结束后再返回呢？确实如此，Process有一个waitFor()方法，就是这么做的，返回的也是退出码。因此，我们可以用waitFor()方法替换exitValue()方法。

## 陷阱2：Runtime.exec()可能hang住，甚至死锁
首先看下Process类的文档说明
```text
 * <p>By default, the created subprocess does not have its own terminal
 * or console.  All its standard I/O (i.e. stdin, stdout, stderr)
 * operations will be redirected to the parent process, where they can
 * be accessed via the streams obtained using the methods
 * {@link #getOutputStream()},
 * {@link #getInputStream()}, and
 * {@link #getErrorStream()}.
 * The parent process uses these streams to feed input to and get output
 * from the subprocess.  Because some native platforms only provide
 * limited buffer size for standard input and output streams, failure
 * to promptly write the input stream or read the output stream of
 * the subprocess may cause the subprocess to block, or even deadlock.

```

从这里可以看出，Runtime.exec()创建的子进程公用父进程的流，不同平台上，父进程的stream buffer可能被打满导致子进程阻塞，从而永远无法返回。
针对这种情况，我们只需要将子进程的stream重定向出来即可。

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yangjinfeng02 on 2016/4/27.
 */
public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("java");
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            System.out.println("OUTPUT");
            while ((line = stdoutReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("ERROR");
            while ((line = stderrReader.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = process.waitFor();
            System.out.println("process exit value is " + exitVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## 陷阱3：不同平台上，命令的兼容性
如果要在windows平台上运行dir命令，如果直接指定命令参数为dir，会提示命令找不到。而且不同版本windows系统上，运行改命令的方式也不一样。对这宗情况，需要根据系统版本进行适当区分。

```java
String osName = System.getProperty("os.name" );
String[] cmd = new String[3];
if(osName.equals("Windows NT")) {
    cmd[0] = "cmd.exe" ;
    cmd[1] = "/C" ;
    cmd[2] = args[0];
} else if(osName.equals("Windows 95")) {
    cmd[0] = "command.com" ;
    cmd[1] = "/C" ;
    cmd[2] = args[0];
}  
Runtime rt = Runtime.getRuntime();
Process proc = rt.exec(cmd);
```

## 陷阱4：错把Runtime.exec()的command参数当做命令行
本质上来讲，Runtime.exec()的command参数只是一个可运行的命令或者脚本，并不等效于Shell解器或者Cmd.exe,如果你想进行输入输出重定向，pipeline等操作，则必须通过程序来实现。不能直接在command参数中做。例如，下面的例子

```text
Runtime runtime = Runtime.getRuntime();
Process process = runtime.exec("java -version > a.txt");
```

这样并不会产出a.txt文件。要达到这种目的，需通过编程手段实现，如下
```java
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

class StreamGobbler extends Thread {
    InputStream is;
    String type;
    OutputStream os;

    StreamGobbler(InputStream is, String type) {
        this(is, type, null);
    }

    StreamGobbler(InputStream is, String type, OutputStream redirect) {
        this.is = is;
        this.type = type;
        this.os = redirect;
    }

    public void run() {
        try {
            PrintWriter pw = null;
            if (os != null)
                pw = new PrintWriter(os);

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (pw != null)
                    pw.println(line);
                System.out.println(type + ">" + line);
            }
            if (pw != null)
                pw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String args[]) {
        try {
            FileOutputStream fos = new FileOutputStream("logs/a.log");
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd.exe /C dir");

            // 重定向输出流和错误流
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", fos);

            errorGobbler.start();
            outputGobbler.start();
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);
            fos.flush();
            fos.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
```

# 一个比较完善的工具类
下面提供一种比较完善的实现，提供了超时功能。

## 封装返回结果
```java
/**
* ExecuteResult.java
*/
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExecuteResult {
    private int exitCode;
    private String executeOut;

    public ExecuteResult(int exitCode, String executeOut) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
    }
}
``` 

## 对外接口
```java
/**
* LocalCommandExecutor.java
*/
public interface LocalCommandExecutor {
    ExecuteResult executeCommand(String command, long timeout);
}
```

## StreamGobbler类，用来完成stream的管理
```java
/**
* StreamGobbler.java
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamGobbler extends Thread {
    private static Logger logger = LoggerFactory.getLogger(StreamGobbler.class);
    private InputStream inputStream;
    private String streamType;
    private StringBuilder buf;
    private volatile boolean isStopped = false;

    /**
     * @param inputStream the InputStream to be consumed
     * @param streamType  the stream type (should be OUTPUT or ERROR)
     */
    public StreamGobbler(final InputStream inputStream, final String streamType) {
        this.inputStream = inputStream;
        this.streamType = streamType;
        this.buf = new StringBuilder();
        this.isStopped = false;
    }

    /**
     * Consumes the output from the input stream and displays the lines consumed
     * if configured to do so.
     */
    @Override
    public void run() {
        try {
            // 默认编码为UTF-8，这里设置编码为GBK，因为WIN7的编码为GBK
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                this.buf.append(line + "\n");
            }
        } catch (IOException ex) {
            logger.trace("Failed to successfully consume and display the input stream of type " + streamType + ".", ex);
        } finally {
            this.isStopped = true;
            synchronized (this) {
                notify();
            }
        }
    }

    public String getContent() {
        if (!this.isStopped) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException ignore) {
                    ignore.printStackTrace();
                }
            }
        }
        return this.buf.toString();
    }
}
```

## 实现类
通过SynchronousQueue队列保证只有一个线程在获取外部进程的退出码，由线程池提供超时功能。

```java
/**
* LocalCommandExecutorImpl.java
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LocalCommandExecutorImpl implements LocalCommandExecutor {

    static final Logger logger = LoggerFactory.getLogger(LocalCommandExecutorImpl.class);

    static ExecutorService pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    public ExecuteResult executeCommand(String command, long timeout) {
        Process process = null;
        InputStream pIn = null;
        InputStream pErr = null;
        StreamGobbler outputGobbler = null;
        StreamGobbler errorGobbler = null;
        Future<Integer> executeFuture = null;
        try {
            logger.info(command.toString());
            process = Runtime.getRuntime().exec(command);
            final Process p = process;

            // close process's output stream.
            p.getOutputStream().close();

            pIn = process.getInputStream();
            outputGobbler = new StreamGobbler(pIn, "OUTPUT");
            outputGobbler.start();

            pErr = process.getErrorStream();
            errorGobbler = new StreamGobbler(pErr, "ERROR");
            errorGobbler.start();

            // create a Callable for the command's Process which can be called by an Executor
            Callable<Integer> call = new Callable<Integer>() {
                public Integer call() throws Exception {
                    p.waitFor();
                    return p.exitValue();
                }
            };

            // submit the command's call and get the result from a
            executeFuture = pool.submit(call);
            int exitCode = executeFuture.get(timeout, TimeUnit.MILLISECONDS);
            return new ExecuteResult(exitCode, outputGobbler.getContent());

        } catch (IOException ex) {
            String errorMessage = "The command [" + command + "] execute failed.";
            logger.error(errorMessage, ex);
            return new ExecuteResult(-1, null);
        } catch (TimeoutException ex) {
            String errorMessage = "The command [" + command + "] timed out.";
            logger.error(errorMessage, ex);
            return new ExecuteResult(-1, null);
        } catch (ExecutionException ex) {
            String errorMessage = "The command [" + command + "] did not complete due to an execution error.";
            logger.error(errorMessage, ex);
            return new ExecuteResult(-1, null);
        } catch (InterruptedException ex) {
            String errorMessage = "The command [" + command + "] did not complete due to an interrupted error.";
            logger.error(errorMessage, ex);
            return new ExecuteResult(-1, null);
        } finally {
            if (executeFuture != null) {
                try {
                    executeFuture.cancel(true);
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
            if (pIn != null) {
                this.closeQuietly(pIn);
                if (outputGobbler != null && !outputGobbler.isInterrupted()) {
                    outputGobbler.interrupt();
                }
            }
            if (pErr != null) {
                this.closeQuietly(pErr);
                if (errorGobbler != null && !errorGobbler.isInterrupted()) {
                    errorGobbler.interrupt();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
    }

    private void closeQuietly(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException e) {
            logger.error("exception", e);
        }
    }
}
```