package com.java.www;

import org.junit.Test;

import java.util.Calendar;

import static java.util.Calendar.*;

public class SwitchTest {
    /**
     * 目前使用的方式，break不能少，有break与没有break执行逻辑不一样
     */
    @Test
    public void test1() {
        int day = Calendar.MONDAY;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
    }

    /**
     *  switch建议形式, java 12中还未实现
     *
     */
    @Test
    public void test2() {
        int day = 3;

        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }
    }

    @Test
    public void test3() {
        int numLetters;
        int day = 6;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new IllegalStateException("Wat: " + day);
        }
    }

    /**
     * 建议方式
     *
     */
    @Test
    public void test4() {
        int day = 6;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
    }
}
