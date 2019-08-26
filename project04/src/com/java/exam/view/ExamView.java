/**
 * 程序的主控类，负责与用户交互，完成考试及成绩查询功能
 *
 * */

package com.java.exam.view;

import com.java.exam.domain.Item;
import com.java.exam.service.ItemService;
import com.java.exam.utils.GetInput;

import java.util.LinkedHashMap;
import java.util.List;

public class ExamView {
    private ItemService itemService = new ItemService();

    /* 答题记录
    * 格式：{题号: 选项, 题号: 选项}
    * */
    private LinkedHashMap<Integer, String> anserRecord = new LinkedHashMap<>();


    // 构造器
    public ExamView() {}

    /**
     * 主菜单
     */
    // 方法
    public void enterMenu() {
        String menu = "-------欢迎使用在线考试系统-------" +
                "1 进入考试\n" +
                "2 查看成绩\n" +
                "3 系统退出\n" +
                "\n" +
                "选择操作项：";

        while (true) {
            System.out.println(menu);
            String ramCmd = GetInput.getRaw();
            int num = GetInput.getNumber(ramCmd);
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    break;
            }

        }

    }


    /**
     * 考试菜单
     */
    public void exam() {
        String menu = "-----------欢迎进入考试-----------\n" +
                "满分100分，80分及格\n" +
                "共10题，每题10分\n" +
                "\n";
        System.out.println(menu);

        int i = 0;
        for (; ; ) {
            List<Item> itemsList = itemService.getItemsList();
            System.out.println(itemService.showItem(i));;
            String answer = GetInput.getString();

        }
    }


    /**
     * 判断答案是否有效。注意不是是否正确
     * @param item
     *          Item对象
     * @param answer
     *          答案字符串
     * @param type
     *          题目类型, true:单选, false:多选
     * @return 判断答案是否有效的结果。true:有效，false:无效
     */
    public boolean isValidAnswer(Item item, String answer, boolean type) {
        if (true) {
            if (item == null || answer.length() != 1) {
                return false;
            }
        } else {
            if (item == null) {
                return false;
            }
        }
        String str;
        switch (item.getOptions().size()) {
            case 5:
                str = "abcde";
                break;
            case 6:
                str = "abcdef";
            case 7:
                str = "abcdefg";
            case 8:
                str = "abcdefgh";
            default:
                str = "abcd";
                break;
        }

        return false;
    }


    /**
     * 判断单选题的答案是否有效
     * @param item
     *          Item对象
     * @param answer
     *          答案字符串
     * @return 判断答案是否有效的结果。true:有效，false:无效
     */
    public boolean isValidAnswer(Item item, String answer) {
        return isValidAnswer(item, answer, true);
    }

}
