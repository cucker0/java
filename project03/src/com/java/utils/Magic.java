/**
* 魔法工具
*
* */

package com.java.utils;

public class Magic {
    /**
    * 由Class获取相应的职位名称
    * */
    public static String clazzToPost(Class clazz) {
        String post = "";
        switch (clazz.getSimpleName()) {
            case "GeneralStaff":
                post = "普通员工";
                break;
            case "Programmer":
                post = "程序员";
                break;
            case "Designer":
                post = "设计师";
                break;
            case "Architect":
                post = "架构师";
                break;
            default:
                clazz.getSimpleName();
                break;
        }
        return post;
    }

}
