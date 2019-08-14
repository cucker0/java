/*
对象深度复制

# 使用说明
* 使用该工具类的对象必须要实现Serializable接口，否则是没有办法实现克隆的

# 原理
```
在内存中通过字节流的拷贝。
把母对象写入到一个字节流中，再从字节流中将其读出来，这样就可以创建一个新的对象了，
并且该新对象与母对象之间并不存在引用共享的问题，真正实现对象的深拷贝
```


* */

package com.java.CustomerSystem2;

import java.io.*;

public class CloneUtils {
//    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T objClone = null;
        try {
            // 获取要深度复制对象的字节数组输出流，写入到内存
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            // 字节数组输出流读取对象，分配内存，写入原始对象，生成新对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object o = ois.readObject();
            ois.close();
            objClone = (T) o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objClone;
    }

}
