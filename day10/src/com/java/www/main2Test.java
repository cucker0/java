package com.java.www;

public class main2Test {
    public static void main(String[] args) {
        Main.main(new String[100]);
    }

}

class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            args[i] = "value_" + i;
            System.out.println(args[i]);
        }
    }
}
