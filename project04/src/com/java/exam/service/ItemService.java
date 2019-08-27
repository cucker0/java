package com.java.exam.service;

import com.java.exam.domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 封装与考试题目访问相关的业务方法
 *
 * */
public class ItemService {
    /* 题目列表，用于保存所有的题目 */
    private static ArrayList<Item> itemsList = new ArrayList<>();

    /* 文本形式的题目集 */
    private static final String filePath = "./Items.txt";

    // 构造器
    /**
     * build a ItemServer object
     */
    public ItemService() {
        super();
    }

    // 方法

    /**
     * 指定的Item添加到itemsList中
     * @param item
     *          the item which will add to itemsList
     * @return opration status
     */
    public boolean addItem(Item item) {
        if (item != null) {
            for (Item i : itemsList) {
                if (i.equals(item)) {
                    System.out.println("此题目已经添加");
                    return false;
                }
            }
            return itemsList.add(item);
        }
        System.out.println("item is invalid, can't a null object");
        return false;
    }

    /**
     * 获取itemsList中指定下标的Item
     * @param itemIndex
     *          item在itemsList 中的index
     * @return 指定index的Item，不存在则返回null
     */
    public Item getItem(int itemIndex) {
        if (itemIndex < itemsList.size() && itemIndex >= 0) {
            return itemsList.get(itemIndex);
        }
        return null;
    }

    public static ArrayList<Item> getItemsList() {
        return itemsList;
    }

    /**
     * 题目转换成用来展示的String
     * @param item
     *          Item对象
     * @return 题目转换成用来展示的String
     */
    public String showItem(Item item) {
        if (item == null) {
            return "";
        }
        String theStart = "N：下一题，Q：提交试卷。";
        String theEnd = "P：上一题，Q：提交试卷。";
        String theMiddle = "P：上一题，N：下一题，Q：提交试卷。";
        String str = "";
        str += item.getQuestion() + "\n";
        str += item.optionsToString();
        str += "\n\n";
        int num = itemsList.indexOf(item);
        if (num == 0) {
            str += theStart;
        } else if (num == itemsList.size() - 1) {
            str += theEnd;
        } else {
            str += theMiddle;
        }
        return str;
    }

    public String showItem(int itemIndex) {
        return showItem(getItem(itemIndex));
    }

    /**
     * 从文件加载题目到itemsList中
     */
    public void loadItemsFromFile() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String question = "";
            LinkedHashMap<String, String> options = new LinkedHashMap<>();
            HashSet<String> rightOptions = new HashSet<>();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                // 对每行进行解析
                String[] sArr;
                if (line.startsWith("题目:")) {
                    sArr = line.split(":", 2);
                    if (sArr.length < 2) continue;
                    question = sArr[1].strip();
                } else if (line.startsWith("题目：")) {
                    sArr = line.split("：", 2);
                    if (sArr.length < 2) continue;
                    question = sArr[1].strip();
                } else if (line.matches("\\w{1}\\..*$")) {
                    sArr = line.split("\\.", 2);
                    if (sArr.length < 2) continue;
                    options.put(sArr[0].strip(), sArr[1].strip());
                } else if (line.matches("^\\w{1}\\．.*$")) {
                    sArr = line.split("\\．", 2);
                    if (sArr.length < 2) continue;
                    options.put(sArr[0].strip(), sArr[1].strip());
                } else if (line.matches("^\\w{1}、.*$")) {
                    sArr = line.split("、", 2);
                    if (sArr.length < 2) continue;
                    options.put(sArr[0].strip(), sArr[1].strip());
                } else if (line.startsWith("答案:") || line.startsWith("答案：")) {
                    sArr = line.startsWith("答案:") ? line.split(":", 2) : line.split("：", 2);
                    if (sArr.length < 2) continue;
                    String anserOptions = sArr[1].strip().toUpperCase();
                    if (anserOptions.length() == 1) { //  单选
                        rightOptions.add(anserOptions);
                    } else { // 多选
                        String[] answersArr = anserOptions.split("");

                        for (String s : answersArr) {
                            if (s.matches("\\w")) {
                                rightOptions.add(s);
                            }
                        }
                    }

                    // 将解析出来的题目、选项、答案生成 Item对象添加到itemsList
                    if (!question.equals("") && options.size() != 0 && rightOptions.size() != 0) {
//                        System.out.printf("question: %s, options:%s, rightOptions:%s\n", question, options, rightOptions);
                        Item item = new Item(question, options, rightOptions);
//                        System.out.println("debug2 == " + item);
                        addItem(item);
                    }
                    // 添加Item后重置变量
                    question = "";
                    options = new LinkedHashMap<>();
                    rightOptions = new HashSet<>();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close BufferedReader stream
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
