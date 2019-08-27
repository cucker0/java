package com.java.exam.domain;

import java.util.*;

/**
 * 考试题目类
 *
 */
public class Item {
    /* 题目描述 */
    private String question;

    /* 选项，结构: {"A":"option", "B":"option", "C":"option", "D":"option"} */
    private LinkedHashMap<String, String> options;

    /* 正确选项集 */
    private HashSet<String> rightOptions;

    // 构造器
    /**
     * build a Item structor
     */
    public Item() {
        super();
    }

    public Item(String question, LinkedHashMap<String, String> options, HashSet<String> rightOptions) {
        setQuestion(question);
        setOptions(options);
        setRightOptions(rightOptions);
    }

    // 方法
    /**
     * question getter
     * @return question
     */
    public String getQuestion() {
        return question;
    }


    /**
     * question setter
     * @param question
     *          问题描述内容
     */
    public void setQuestion(String question) {
        if (question.length() > 2) {
            this.question = question;
        } else {
            System.out.println("invalid qeustions");
        }
    }

    /**
     * options getter
     * @return options
     *          return the options.
     */
    public LinkedHashMap<String, String> getOptions() {
        return options;
    }

    /**
     * options setter
     * @param options
     *          选项集
     */
    public void setOptions(LinkedHashMap<String, String> options) {
        if (options != null) {
            this.options = options;
        } else {
            System.out.println("options选项集不能为空");
        }
    }


    /**
     * rightOptions getter
     * @return rightOptions
     *          this right options list.
     */
    public HashSet<String> getRightOptions() {
        return rightOptions;
    }

    /**
     * @param rightOptions
     *          set the right options list
     */
    public void setRightOptions(HashSet<String> rightOptions) {
        if (rightOptions != null) {
            this.rightOptions = rightOptions;
        } else {
            System.out.println("rightOptions can't be null object");
        }
    }


    /**
     * 所有选项一行一行显示成文本
     * @return options to String
     */
    public String optionsToString() {
        String str = "";
        if (options == null) {
            return str;
        }
        for (Map.Entry<String, String> option : options.entrySet()) {
            // 一个选项的显示, 如：A. xxx xxx
            str += option.getKey() + "、";
            str += option.getValue();
            str += "\n";
        }
        return str;
    }

    /**
     * 判断是否为单选题
     * @return true/false
     *          true:单选，false:多选
     */
    public boolean isSingleElection() {
        if (rightOptions.size() > 1) {
            return false;
        }
        return true;
    }


    /**
     * return the rightOptions string
     * @return rightOptions String
     */
    public String rightOptionsToString() {
        String str = "";
        if (rightOptions == null) {
            return str;
        }
        Iterator<String> iterator = rightOptions.iterator();
        while (iterator.hasNext()) {
            str += iterator.next();
        }
        return str;
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' + "\n" +
                ", options=" + optionsToString() +
                ", rightOptions=" + rightOptionsToString() + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return question != null ? question.equals(item.question) : item.question == null;

    }

    @Override
    public int hashCode() {
        return question != null ? question.hashCode() : 0;
    }
}
