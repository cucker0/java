package com.java.exercise;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD})
public @interface MyTiger {
    String value();
}
