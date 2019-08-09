Java常用工具类
==


# StrictMath类
它提供了和Math几乎一模一样的方法。

这两个类的区别在于，由于浮点数计算存在误差，不同的平台（例如x86和ARM）计算的结果可能不一致（指误差不同），

因此，StrictMath保证所有平台计算结果都是完全相同的，

而Math会尽量针对平台优化计算速度，所以，绝大多数情况下，使用Math就足够了


# Random类
Random用来创建伪随机数。  
所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的。  
Math.random()实际上内部调用了Random类，所以它也是伪随机数，只是我们无法指定种子。

## 示例
要生成一个随机数，可以使用nextInt()、nextLong()、nextFloat()、nextDouble()：
 ```text
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(100));
        }
        // 51, 80, 41, 28, 55...
    }
}

```

# SecureRandom类
真随机数，创建不可预测的安全的随机数  
实际上真正的真随机数只能通过量子力学原理来获取。

SecureRandom无法指定种子，它使用RNG（random number generator）算法。  
JDK的SecureRandom实际上有多种不同的底层实现，  
有的使用安全随机种子加上伪随机数算法来产生安全的随机数，  
有的使用真正的随机数生成器

SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。  
这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。  

在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。  
因此，时刻牢记必须使用SecureRandom来产生安全的随机数

## 示例
```text
SecureRandom sr = new SecureRandom();
System.out.println(sr.nextInt(100));
```

实际使用的时候，可以优先获取高强度的安全随机数生成器，  
如果没有提供，再使用普通等级的安全随机数生成器
```text
import java.util.Arrays;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}

```