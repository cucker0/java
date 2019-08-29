package com.java.www;


import java.lang.reflect.*;

/**
 * 遍历指定类的成员（属性变量、构造器、方法）
 * 用来简单了解下一个类有哪些变量、构造器、方法还是很有帮助的
 *
 * 使用示例：
 *      p.print("com.java.www.Person");
 *      p.print(new Person());
 *      p.print(String.class);
 *      p.print("java.lang.Integer");
 */
public class PrintClassAttribute {
    private Class clazz;

    // 构造器
    public PrintClassAttribute() {}

    /**
     * 通过类的完整名获取对应的Class
     * @param className
     *          类的完整名
     */

    // 方法
    private void getClazz(String className) {
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("未找到该类，类名必须是完整路径的");
//            e.printStackTrace();
        }
    }

    /**
     * 通过类实例获取对应的Class
     * @param o
     *          类的实例
     */
    private void getClazz(Object o) {
        clazz = o.getClass();
    }

    /**
     * 打印前面指定类的属性、构造器、方法等信息
     */
    public void showClassStructor() {
        if (clazz == null) {
            return;
        }

        /*
        * 获取类所在的包
        * */
        System.out.printf("\n== %s 类所在的包 ==:\n", dotFilter(clazz.getName()));
        Package pack = clazz.getPackage();
        System.out.println(pack);

        /*
        * 获取属性字段
        * */
        System.out.println("\n== 已声明属性变量 ==:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            // 获取属性修饰符
            int i = f.getModifiers();
            String modifier = Modifier.toString(i);

            // 获取属性的类型
            Class type = f.getType();
            String typeStr = dotFilter(type.toString());

            // 获取属性名
            String fieldName = f.getName();

            System.out.printf("%s %s %s\n", modifier, typeStr, fieldName);
        }

        /*
        * 获取构造器
        * */
        System.out.println("\n== 构造器 ==:");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
            int i = constructor.getModifiers();
            String modifier = Modifier.toString(i);
            String name = constructor.getName();
            Parameter[] parameters =  constructor.getParameters();
            String parametersToString = "";
            String oneParameter;
            if (parameters.length == 1) {
                oneParameter= String.format("%s %s", dotFilter(parameters[0].getType().toString()), parameters[0].getName());
                parametersToString += oneParameter;
            } else if (parameters.length > 1) {
                for (int j = 0; j < parameters.length; ++j) {
                    Parameter p = parameters[j];
                    if (j == 0) {
                        oneParameter= String.format("%s %s", dotFilter(p.getType().toString()), p.getName());
                    } else {
                        oneParameter= String.format(", %s %s", dotFilter(p.getType().toString()), p.getName());
                    }
                    parametersToString += oneParameter;
                }
            }

            System.out.printf("%s %s(%s)\n", modifier, dotFilter(name), parametersToString);
        }

        /*
        * 获取方法
        * */
        System.out.println("\n== 已声明方法 ==:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            int i = m.getModifiers();
            String modifier = Modifier.toString(i);
            String name = m.getName();
            Parameter[] parameters =  m.getParameters();
            String parametersToString = "";
            String oneParameter;
            if (parameters.length == 1) {
                oneParameter= String.format("%s %s", dotFilter(parameters[0].getType().toString()), parameters[0].getName());
                parametersToString += oneParameter;
            } else if (parameters.length > 1) {
                for (int j = 0; j < parameters.length; ++j) {
                    Parameter p = parameters[j];
                    if (j == 0) {
                        oneParameter= String.format("%s %s", dotFilter(p.getType().toString()), p.getName());
                    } else {
                        oneParameter= String.format(", %s %s", dotFilter(p.getType().toString()), p.getName());
                    }
                    parametersToString += oneParameter;
                }
            }

            // 抛出的异常类型列表，并拼接成字符串
            String throwsString = "";
            Class[] exceptionArr = m.getExceptionTypes();

            for (int k = 0; k < exceptionArr.length; ++k) {
                Class e = exceptionArr[k];
                if (k == 0) {
                    throwsString += String.format(" throws %s", dotFilter(e.getName()));
                } else {
                    throwsString += String.format(", %s", e.getName());
                }

            }
            System.out.printf("%s %s %s(%s)%s\n", modifier, dotFilter(m.getReturnType().toString()), dotFilter(name), parametersToString, throwsString);


        }

        /*
         * 获取内部类
         * */
        Class[] innerClazz = clazz.getDeclaredClasses();
        if (innerClazz.length > 0) {
            System.out.println("\n== 内部类 ==:");
            for (Class c : innerClazz) {
                String innerClass = "";
                int i2 = c.getModifiers();
                String modifier2 = Modifier.toString(i2);
                String name2 = c.getSimpleName();
                Class[] interfaces = c.getInterfaces();
                String interfacesString = "";
                for (int x = 0; x < interfaces.length; ++x) {
                    Class inter = interfaces[x];
                    if (x == 0) {
                        interfacesString += " implements " + inter.getSimpleName();
                    } else {
                        interfacesString += String.format(", %s", inter.getSimpleName());
                    }
                }
                System.out.printf("%s %s%s\n", modifier2, name2, interfacesString);
            }
        }
    }

    /**
     * 打指定类名对应类的属性、构造器、方法等信息
     * @param fullClass
     *          完整类名
     * 使用方法：print("java.lang.Integer");
     */
    public void print(String fullClass) {
        getClazz(fullClass);
        showClassStructor();
    }

    /**
     * 打指定类实例对应类的属性、构造器、方法等信息
     * @param o
     *          类的实例
     *
     * 使用方法：print(String.class)， print(new Person())
     */
    public void print(Object o) {
        getClazz(o);
        showClassStructor();
    }

    /**
     * 以.分割的字符串，返回分割结果的最后一个
     * @param str
     *         字符串
     * @return 分割结果的最后一个
     */
    private String dotFilter(String str) {
        if (str.contains(".")) {
            String[] sArr = str.split("\\.");
            return sArr[sArr.length -1];
        } else {
            return str;
        }
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        PrintClassAttribute p = new PrintClassAttribute();
//        p.print("com.java.www.Person");
//        p.print(new Person());
//        p.print(String.class);
        p.print("java.lang.Integer");

    }
}
