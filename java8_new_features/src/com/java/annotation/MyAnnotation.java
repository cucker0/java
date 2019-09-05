package com.java.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;


@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotations {
    MyAnnotation[] value();
}

/**
 * 可重复的注解
 */
@Repeatable(Annotations.class) // 修饰class可重复
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
//    String[] value();

    // 也可以定义带默认值的
    String[] value() default {"hehe"};
}

