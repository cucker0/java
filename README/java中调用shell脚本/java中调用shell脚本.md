java中调用shell脚本
==

# ProcessBuilder

```text
ProcessBuilder pb=new ProcessBuilder(cmd);
pb.start();
```

## ProcessBuilder示例
```java
import java.io.File;
import java.io.IOException;

public class JavaShellUtil1 {
    public static void main(String[] args) {
         ProcessBuilder builder=new ProcessBuilder("/bin/sh","-c","/home/songjy.sh a b >/home/songjy.log 2>&1");
         builder.directory(new File("/home/"));
         int runningStatus = 0;
         String s = null;
    
         try {
            Process pro=builder.start();
            System.out.println("the shell script running");
            try {
                runningStatus=pro.waitFor();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        if(runningStatus!=0){
            System.out.println("脚本执行失败");
        }else{
            System.out.println("脚本执行成功");
        }
    
        System.out.println("11111111111");
    }
}
```

## 但是这个两种方法都有个问题，执行诸如
* 
```text
:ps -ef | grep -v grep或者 /home/songjy.sh a b >/home/songjy.log 2>&1"
```

带有管道或重定向的命令就会出错。我们都知道使用以上两种方法执行命令时，如果带有参数就要把命令分割成数组或者List传入，不然会被当成一个整体执行（会出错，比如执行"ps -e"）。对于|,<,>号来说，这样做也不行。对于Linux系统，解决方法就是把整个命令都当成sh的参数传入，用sh来执行命令。
 
```text
ProcessBuilder builder=new ProcessBuilder("/bin/sh","-c","/home/songjy.sh a b >/home/songjy.log 2>&1");
``` 

* Windows下把sh换成cmd.exe就行了

这儿其实还做了另外的一个处理，就是将标准输入和标准出错打印重定向到日志里面，就不要用pid.getInputStream 和pid.getErrorStream 去将其读出来了（防止会一直阻塞，java一直等待shell的返回 

这个问题估计更加经常遇到。 原因是， shell脚本中有echo或者print输出， 导致缓冲区被用完了! 为了避免这种情况， 一定要把缓冲区读一下， 好处就是，可以对shell的具体运行状态进行log出来）


# Runtime
```text
Runtime.getRuntime().exec(cmd)
```

## 
```java
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
//http://kongcodecenter.iteye.com/blog/1231177
//参考http://siye1982.iteye.com/blog/592405
//参考http://blog.csdn.net/christophe2008/article/details/6046456
public class JavaShellUtil {
    // 基本路径
    private static final String basePath = "/home/";
 
    // 记录Shell执行状况的日志文件的位置(绝对路径)
    private static final String executeShellLogFile = basePath
            + "executeShell.log";
 
    // 发送文件到Kondor系统的Shell的文件名(绝对路径)
    private static final String sendKondorShellName = basePath
            + "songjy.sh";
 
    public int executeShell(String shellCommand) throws IOException {
        System.out.println("shellCommand:"+shellCommand);
        int success = 0;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
BufferedReader stdError=null;
        // 格式化日期时间，记录日志时使用
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS ");
 
        try {
            stringBuffer.append(dateFormat.format(new Date()))
                    .append("准备执行Shell命令 ").append(shellCommand)
                    .append(" \r\n");
            
            Process pid = null;
            String[] cmd = { "/bin/sh", "-c", shellCommand };
            // 执行Shell命令
            pid = Runtime.getRuntime().exec(cmd);
            if (pid != null) {
                stringBuffer.append("进程号：").append(pid.toString())
                        .append("\r\n");
                
                // bufferedReader用于读取Shell的输出内容
                bufferedReader = new BufferedReader(new InputStreamReader(pid.getInputStream()));
//读到标准出错的信息
stdError = new BufferedReader(new InputStreamReader(pid.getErrorStream()));
//这个是或得脚本执行的返回值
                int status=pid.waitFor();
                
                
//如果脚本执行的返回值不是0,则表示脚本执行失败，否则（值为0）脚本执行成功。
                if(status!=0)
                 {
                    stringBuffer.append("shell脚本执行失败！");
                 } else{
                    stringBuffer.append("shell脚本执行成功！");
                }
            } else {
                stringBuffer.append("没有pid\r\n");
            }
            stringBuffer.append(dateFormat.format(new Date())).append(
                    "Shell命令执行完毕\r\n执行结果为：\r\n");
            
            //将标准输入流上面的内容写到stringBuffer里面
            String line = null;
            // 读取Shell的输出内容，并添加到stringBuffer中
            while (bufferedReader != null
                    && (line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line).append("\r\n");
            }
            
            //将标准输入流上面的内容写到stringBuffer里面
String line1 = null;
while(stdError !=null &&(line1 = stdError.readLine()) != null){
stringBuffer.append(line1).append("\r\n");
}
            System.out.println("stringBuffer:"+stringBuffer);
        } catch (Exception ioe) {
            stringBuffer.append("执行Shell命令时发生异常：\r\n").append(ioe.getMessage())
                    .append("\r\n");
        } finally {
            if (bufferedReader != null) {
                OutputStreamWriter outputStreamWriter = null;
                try {
                    bufferedReader.close();
                    // 将Shell的执行情况输出到日志文件中
                    OutputStream outputStream = new FileOutputStream(executeShellLogFile);
                    outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    outputStreamWriter.write(stringBuffer.toString());
                    System.out.println("stringBuffer.toString():"+stringBuffer.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    outputStreamWriter.close();
                }
            }
            success = 1;
        }
        return success;
    }
 
    public static void main(String[] args) {
        try {
            new JavaShellUtil().executeShell(sendKondorShellName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
这个里面就是用pid.getInputStream 和pid.getErrorStream  去读缓冲区的
