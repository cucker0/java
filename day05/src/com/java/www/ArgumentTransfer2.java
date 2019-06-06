/*
java 值传递
* */

package com.java.www;

public class ArgumentTransfer2 {
    public static void main(String[] args) {
        ArgumentTransfer2 t = new ArgumentTransfer2();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }

}

class Value {
    int i = 15;
}
