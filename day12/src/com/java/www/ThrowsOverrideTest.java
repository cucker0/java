/*
重写方法情况下，

* 子类重写父类的方法，其抛出的异常类型只能是被重写方法抛出异常类的子类或异常类型一样。

* */

package com.java.www;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsOverrideTest {
    public static void main(String[] args) {
        AA a1 = new AA();
        BB b1 = new BB();

        AA a2 = new BB();
        try {
            a2.method();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class AA {
    public void method() throws FileNotFoundException {

    }
}

class BB extends AA {
//    public void method() throws IOException { // 这里的错误类型比父类的大，编译时报错
//
//    }

    public void method() throws FileNotFoundException {

    }
}


