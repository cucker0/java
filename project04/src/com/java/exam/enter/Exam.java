package com.java.exam.enter;

import com.java.exam.service.ItemService;
import com.java.exam.view.ExamView;

/**
 * 程序入口
 */
public class Exam {
    public static void main(String[] args) {
        // test
//        ItemService itemService = new ItemService();
//        itemService.loadItemsFromFile();
//        System.out.println(ItemService.getItemsList());


        // test2
//        String str = "a.xxxx";
//        System.out.println(str.matches("^\\w{1}\\..*$"));
//
//        String str2 = "";
//        System.out.println(str2.matches("\\w"));

        ExamView  examView = new ExamView();
        examView.enterMenu();

    }
}
