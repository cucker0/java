package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 可用于任何地方
 */
@Target(ElementType.TYPE_USE)
public @interface MyAnnotation3 {

}
