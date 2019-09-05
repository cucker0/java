package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


/**
 * 可以用于注解类型
 */
@Target(ElementType.TYPE_PARAMETER)
public @interface MyAnnotation2 {

}
