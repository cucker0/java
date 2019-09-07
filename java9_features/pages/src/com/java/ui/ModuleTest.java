package com.java.ui;

//import com.java.service.Course;
import com.java.www.Person;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * module模块测试
 *
 * 本模块中的包名不能与导入的包名不能相同
 *
 *
 *
 */
public class ModuleTest {
    private static final Logger LOGGER = Logger.getLogger("api");

    public static void main(String[] args) {
        Person p = new Person("小曼", 24);
        System.out.println(p);

//        Course course = new Course(); // 源模块中没有导出的包里的类不能被使用


        LOGGER.info("获取Person name");
    }

    @Test
    public void test() {

    }

}
