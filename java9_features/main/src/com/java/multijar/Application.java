package com.java.multijar;

public class Application {
    public static void multiJar() {
        Generator generator = new Generator();
        System.out.println("Generated strings: " + generator.createStrings());
    }
}
