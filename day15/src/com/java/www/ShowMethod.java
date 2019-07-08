package com.java.www;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethod {
    private static String usage = "" +
            "usage:\n" +
            "ShowMethods qualified.class.name\n"+
            "To show all methods in class or:\n"+
            "ShowMethods qualified.class.name word\n"+
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w + \\.");

    public static void main(String[] args) {
        /*
        打印传入类的方法，
        需要传入完整的类名，如
        ShowMethod.main(new String[]{"java.io.File"});

        * */
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }

        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();

            if (args.length == 1) {
                // methods
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                    System.out.println(method);
                }
                System.out.println();

                // constructors
                for (Constructor constructor : constructors) {
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                    System.out.println(constructor);
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        System.out.println(method);
                        ++lines;
                    }
                }
                for (Constructor constructor : constructors) {
                    if (constructor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                        System.out.println(constructor);
                        ++lines;
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }


    }
}
