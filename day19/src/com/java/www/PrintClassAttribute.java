package com.java.www;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * 遍历指定类的成员（属性变量、构造器、方法）
 * 用来简单了解下一个类有哪些变量、构造器、方法还是很有帮助的
 *
 * 使用示例：
 *      p.print("com.java.www.Person");
 *      p.print(new Person());
 *      p.print(String.class);
 *      p.print("java.lang.Integer");
 *
 * 得到的方法形参名称是无意义的arg0、arg1 ... ...
 * 遗憾的是，保留参数名这一选项由编译开关javac -parameters打开，默认是关闭的。
 *
 * idea中找到File->Settings->Build,Execution,Deployment->Compiler->Java Compiler 中的
 * Project bytecode version:选择最新的版本(>=8)
 * Additional command line parameters: 后面框中添加-parameters
 *
 * 注意：编译时打开这个参数也是对自己写的类有效，对于JDK内部类是不生效的
 */
public class PrintClassAttribute {
    private Class clazz;

    /* 存放clazz对应类的父类列表，最后一个为顶级根类 */
    private ArrayList<Class> superClasses = new ArrayList<>();

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
     * 获取类所在的包
     */
    public void showPackage() {
        if (clazz == null) return;
        System.out.printf("\n== %s 类所在的包 ==:\n", dotFilter(clazz.getName()));
        Package pack = clazz.getPackage();
        Class superclass = clazz.getSuperclass();
        System.out.println("包：" + pack.getName());

        int mod = clazz.getModifiers();
        String modifiers = Modifier.toString(mod);
        // 类的声明格式：修饰符 类名 extends AA implements BB, CC { }
        System.out.printf("%s %s%s%s\n", modifiers, clazz.getSimpleName(), extendsString(clazz), interfacesToString(clazz.getInterfaces()));
        System.out.println();

        // 打印父类层级结构
        for (int i = superClasses.size() - 1; i >= 0; --i ) {
            String cz = String.format("%s%s", getBlank((superClasses.size() -1 - i) * 4), superClasses.get(i).getName());
            System.out.println(cz);
        }
        String cz = String.format("%s%s", getBlank(superClasses.size() * 4), clazz.getName());
        System.out.println(cz);

    }


    /**
     * 获取指定的clazz extend继承的类，然后把它转成成字符串形式
     *      如：class Dog extends Animal {}，现在只把Dog类的父类Animal这部分转换成字符串 " extends Animal"
     * @param clazz
     *          指定的Class
     * @return
     */
    private String extendsString(Class clazz) {
        String str = "";
        Class superclazz = clazz.getSuperclass();
        if (superclazz == Object.class) {
            return str;
        }
        str = String.format(" extends %s", superclazz.getSimpleName());
        return str;
    }

    /**
     * 返回指定个数的空格字符串
     * @param num
     *          空格个数
     * @return 指定个数的空格字符串
     */
    private String getBlank(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 为clazz 找出所有父类的Class，并追加到superClasses列表中
     */
    private void getSuperClasses() {
        if (clazz == null) {
            return;
        }
        Class superclass = clazz.getSuperclass();
        for (; superclass != null;) {

            superClasses.add(superclass);
            if (superClasses == null) {
                return;
            }
            superclass = superclass.getSuperclass();
            if (superclass == Object.class) {
                superClasses.add(superclass);
                return;
            }
        }

    }


    /**
     * 获取属性字段
     */
    public void showFields() {
        if (clazz == null) return;
        System.out.println("\n== 声明的属性变量 ==:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(aFieldToString(f));
        }

        /*
        * 获取由父类继承来的属性，私有属性除外
        * */
        LinkedHashSet<Field> set = new LinkedHashSet<>(); // 用于存放从父类中继承来的属性

        for (Class c : superClasses) {
            if (c == Object.class) {
                break;
            }
            for (Field f : c.getDeclaredFields()) {
                int i = f.getModifiers();
                String modifiers = Modifier.toString(i);
                if (modifiers.startsWith("private")) { // 去掉private修饰的属性
                    continue;
                } else if (!(modifiers.startsWith("public") || modifiers.startsWith("protected"))) { // 此属性对应的类与clazz对应的类不在同一个包下，则此属性对应默认修饰的属性去掉
                    if (!c.getPackage().equals(clazz.getPackage())) {
                        continue;
                    }
                }
                set.add(f);
            }
        }

        System.out.println("\n== 继承于父类的属性变量 ==:");
        for (Field f : set) {
            System.out.println(aFieldToString(f));
        }

    }


    /**
     * 一个属性字段转成String格式，如：修饰符 类型 属性名
     * @param field
     *          一个属性对象
     * @return 一个属性字段转成String格式的字符串
     */
    private String aFieldToString(Field field) {
        // 获取属性修饰符
        int i = field.getModifiers();
        String modifier = Modifier.toString(i);

        // 获取属性的类型
        Class type = field.getType();

        // 获取属性名
        String fieldName = field.getName();
        String str = String.format("%s%s %s", modifier.length() == 0 ? "" : modifier + " ", type.getSimpleName(), fieldName);
        return str;
    }

    /**
     * 获取构造器
     */
    public void showConstructors() {
        if (clazz == null) return;
        System.out.println("\n== 构造器 ==:");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
            int i = constructor.getModifiers();
            String modifier = Modifier.toString(i);
            String name = constructor.getName();
            Parameter[] parameters =  constructor.getParameters();
            // 表格：修改符 构造器名(参数1, 参数2)
            System.out.printf("%s %s(%s)\n", modifier, dotFilter(name), parametersToString(parameters));
        }
    }

    /**
     * 参数数组转参数列表形式的字符串，表格如：String name, int age
     * @param parameters
     *          参数数组
     * @return 参数数组转参数列表形式的字符串
     */
    private String parametersToString(Parameter[] parameters) {
        String str = "";
        String oneParameter;
        for (int j = 0; j < parameters.length; ++j) {
            Parameter p = parameters[j];
            if (j == 0) {
                oneParameter= String.format("%s %s", p.getType().getSimpleName(), p.getName());
            } else {
                oneParameter= String.format(", %s %s", p.getType().getSimpleName(), p.getName());
            }
            str += oneParameter;
        }
        return str;
    }

    /**
     * 获取方法
     */
    public void showMethods() {
        if (clazz == null) return;
        System.out.println("\n== 声明的方法 ==:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(methodToString(m));
        }

        /*
        * 获取由父类继承来的方法，私有方法除外
        * */
        System.out.println("\n== 继承于父类的方法 ==:");
        LinkedHashSet<Method> set = new LinkedHashSet<>(); // 用于存放从父类中继承来的方法，私有方法除外
        for (Class c : superClasses) {
            if (c == Object.class) {
                break;
            }
            for (Method m : c.getDeclaredMethods()) {
                int i = m.getModifiers();
                String modifiers = Modifier.toString(i);
                if (modifiers.startsWith("private")) {
                    continue;
                } else if (!(modifiers.startsWith("public") || modifiers.startsWith("protected"))) { // 此属性对应的类与clazz对应的类不在同一个包下，则此属性对应默认修饰的方法去掉
                    if (!c.getPackage().equals(clazz.getPackage())) {
                        continue;
                    }
                }
                set.add(m);
            }
        }
        for (Method m2 : set) {
            System.out.println(methodToString(m2));
        }
    }


    /**
     * 一个方法转成字符串。一行一个方法。格式：
     *     返回类型 方法1名(参数1, 参数2) throws 异常类型列表
     *
     *
     * @param method
     *          方法对象
     * @return 一个方法转成字符串
     */
    private String methodToString(Method method) {
        int i = method.getModifiers();
        String modifier = Modifier.toString(i);
        String name = method.getName();
        Parameter[] parameters =  method.getParameters();

        // 抛出的异常类型列表，并拼接成字符串
        String throwsString = "";
        Class[] exceptionArr = method.getExceptionTypes();

        for (int k = 0; k < exceptionArr.length; ++k) {
            Class e = exceptionArr[k];
            if (k == 0) {
                throwsString += String.format(" throws %s", dotFilter(e.getName()));
            } else {
                throwsString += String.format(", %s", e.getName());
            }

        }
        // 格式：返回类型 方法名(参数1, 参数2) throws 异常类型列表
        String str = String.format("%s %s %s(%s)%s", modifier, method.getReturnType().getSimpleName(), dotFilter(name), parametersToString(parameters), throwsString);

        return str;
    }

    /**
     * 获取内部类
     */
    public void showInnerClass() {
        if (clazz == null) return;
        Class[] innerClazz = clazz.getDeclaredClasses();
        if (innerClazz.length > 0) {
            System.out.println("\n== 内部类 ==:");
            for (Class c : innerClazz) {
                String innerClass = "";
                int i = c.getModifiers();
                String modifier = Modifier.toString(i);
                String name = c.getSimpleName();
                Class[] interfaces = c.getInterfaces();

                // 格式：修饰符 类名 extends 父类 implements 接口列表
                System.out.printf("%s %s%s%s\n", modifier, name, extendsString(c), interfacesToString(interfaces));
            }
        }
    }

    /**
     * interface数组转成字符串，把类实现了的接口列表转成字符串形式
     * 如：class Dog extends Animal implements Paxing, Maoke {}，现在只把实现了的接口Paxing, Maoke 转成 " implements Paxing, Maoke"
     *
     * @param interfaces
     *          nterface数组
     * @return interface数组转成的字符串
     */
    private String interfacesToString(Class[] interfaces) {
        String str = "";
        for (int x = 0; x < interfaces.length; ++x) {
            Class inter = interfaces[x];
            if (x == 0) {
                str += " implements " + inter.getSimpleName();
            } else {
                str += String.format(", %s", inter.getSimpleName());
            }
        }
        return str;
    }

    /**
     * 打印前面指定类的属性、构造器、方法等信息
     */
    public void showClassStructor() {
        if (clazz == null) {
            return;
        }
        getSuperClasses();

        showPackage();
        showFields();
        showConstructors();
        showMethods();
        showInnerClass();
    }

    /**
     * 打印指定类名对应类的属性、构造器、方法等信息
     * @param fullClass
     *          完整类名
     * 使用方法：print("java.lang.Integer");
     */
    public void print(String fullClass) {
        getClazz(fullClass);
        showClassStructor();
    }

    /**
     * 打印指定类实例对应类的属性、构造器、方法等信息
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
     * 打印指定Class对应类的属性、构造器、方法等信息
     * @param clazz
     */
    public void print(Class clazz) {
        this.clazz = clazz;
        showClassStructor();
    }

    /**
     * 以.分割字符串，返回分割结果的最后一个
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
        p.print("com.java.www.Person");
//        p.print(new Person());
//        p.print(String.class);
//        p.print("java.lang.Integer");


/*
// 运行 p.print(new Person()) 打印结果
== Person 类所在的包 ==:
包：com.java.www
public Person extends Biology implements MyInterface, Comparator

java.lang.Object
    com.java.www.Biology
        com.java.www.Person

== 声明的属性变量 ==:
public String name
private int age

== 继承于父类的属性变量 ==:
double weith

== 构造器 ==:
protected Person(String name, int age)
private Person(String name)
public Person()

== 声明的方法 ==:
public boolean equals(Object o)
public String toString()
public int hashCode()
public String getName()
public int compare(Object o1, Object o2)
public static void info()
public void setName(String name) throws RuntimeException
public void walk()
public int getAge()
public void speak(String content)
private String see(int time, String how)
public void setAge(int age)

== 继承于父类的方法 ==:
public void sleaping()

== 内部类 ==:
 Wallet extends Pack implements Serializable
* */
    }
}
