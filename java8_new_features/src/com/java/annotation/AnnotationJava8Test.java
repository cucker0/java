package com.java.annotation;


public class AnnotationJava8Test {

    public static void main(String[] args) {
        // 重复的注解
        AnnotationTest anno = new AnnotationTest();
        anno.show("haha");
        System.out.println();

        // 注解类型
        TypeDefine td1 = new TypeDefine();
        td1.test(new Thread());
        System.out.println();

        //
        TypeDefine2 td2 = new TypeDefine2("墨子");
        try {
            td2.speak("说什么呢...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

// 重复的注解
@MyAnnotation("Hello")
@MyAnnotation("World")
class AnnotationTest {
    // 数据类型的注解
    public void show(@MyAnnotation("abc") String string) {
        System.out.println("show 方法...");
    }
}

// 注解类型
class TypeDefine<@MyAnnotation2() U> {
    // 字段属性
    private U u;

    // 方法
    public <@MyAnnotation2() T> void test(T t) {
        System.out.println("test method..." + u);
        System.out.println(t);
    }
}

// 注解放任何地方
@MyAnnotation3
class TypeDefine2<U> {
    @MyAnnotation3 private String name;

    // 构造器
    public @MyAnnotation3 TypeDefine2() {
        super();
    }

    @MyAnnotation3 public TypeDefine2(String name) {
        this.name = name;
    }

    // 方法
    public static void getDesc() {
        TypeDefine2<@MyAnnotation3 String> t = null;
        int a = (@MyAnnotation3 int) 2L;
        int b = 10;
    }

    public static <@MyAnnotation3 T> void run(T t) {
        System.out.println(t);
    }

    public void speak(@MyAnnotation3 String str) throws @MyAnnotation3 Exception{
        System.out.printf("%s: %s", name, str);
    }
}