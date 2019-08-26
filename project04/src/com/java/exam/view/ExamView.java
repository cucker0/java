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
import java.util.Map;

public class ExamView {
    private ItemService itemService = new ItemService();

    /* 答题记录
    * 格式：{题索引: 选项, 题索引: 选项}
    * */
    private LinkedHashMap<Integer, String> answerRecord = new LinkedHashMap<>();


    // 构造器
    public ExamView() {}

    /**
     * 主菜单
     */
    // 方法
    public void enterMenu() {
        itemService.loadItemsFromFile();

        String menu = "-------欢迎使用在线考试系统-------\n\n" +
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
                    exam();
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
            System.out.printf("第%s题 %s%s\n",
                    i + 1,
                    itemService.showItem(i),
                    answerRecord.get(i) == null ? "选项：" : String.format("选项(已选 %s)：", answerRecord.get(i)));
            String answer = GetInput.getString();
            answer = answerFilter(answer);
            if (answer.equalsIgnoreCase("q")) { // 提交试卷
                System.out.println("! 你确定提交试卷吗？\n" +
                        "Y: 是\n" +
                        "N: 否\n" +
                        "\n" +
                        "是否确认：");
                if (GetInput.getIsYes()) {
                    submitPapers();
                    // 提交试卷后,按下任何键盘退出
                    break;
                }
            } else if (answer.equalsIgnoreCase("p")) { // 上一题
                if (i > 0) {
                    --i;
                }
            } else if (answer.equalsIgnoreCase("n")) { // 下一题
                if (i < ItemService.getItemsList().size() -1) {
                    ++i;
                }
            } else if (isValidAnswer(itemService.getItem(i), answer)) { // 选项有效，记录答案并跳转下一题
                answerRecord.put(i, answer);
                if (i < ItemService.getItemsList().size() -1) {
                    ++i;
                }
            }
        }
    }

    public String answerFilter(String answer) {
        if (answer.length() <= 1) {
            return answer;
        }
        String str = "";
        String[] sArr = answer.split("");
        for (String s : sArr) {
            if (s.matches("\\w")) {
                str = str.join(s);
            }
        }
        return str;

    }

    /**
     * 提交试卷
     * 完成一项功能
     * 1. 计算得分
     * 2. 显示成绩
     */
    public void submitPapers() {
        int score = 0;
        for (Map.Entry<Integer, String> entry : answerRecord.entrySet()) {
            Item item = itemService.getItem(entry.getKey());
            if (item.getRightOptions().size() == 1) { // 单选题
                if (entry.getValue().length() == item.getRightOptions().size()) {
                    score += item.getRightOptions().contains(entry.getValue()) ? 10 : 0;
                }
            } else if (item.getRightOptions().size() > 1) { // 多选题
                if (entry.getValue().length() == item.getRightOptions().size()) {
                    String[] sArr = entry.getValue().split("");
                    boolean isCorrect = true;
                    for (String s : sArr) {
                        if (!item.getRightOptions().contains(s)) {
                            isCorrect = false;
                            break;
                        }
                    }
                    score += isCorrect ? 10 : 0;
                }
            }
        }
    }

    /**
     * 判断答案是否有效，即是所选选项是否为题目中的选项。注意不是是否正确
     * @param item
     *          Item对象
     * @param answer
     *          答案字符串
     *          题目类型, true:单选, false:多选
     * @return 判断答案是否有效的结果。true:有效，false:无效
     */
    public boolean isValidAnswer(Item item, String answer) {
        answer = answer.strip();
        if (item == null || answer.equals("")) {
            return false;
        }
        String str;
        switch (item.getOptions().size()) {
            case 5:
                str = "abcde";
                break;
            case 6:
                str = "abcdef";
                break;
            case 7:
                str = "abcdefg";
                break;
            case 8:
                str = "abcdefgh";
                break;
            default:
                str = "abcd";
                break;
        }
        if (item.getRightOptions().size() == 1 && answer.length() == 1) { // 单选
            if (str.contains(answer)) {
                return true;
            }

        } else if (item.getRightOptions().size() > 1 && answer.length() > 1) { // 多选
            String[] sArr = answer.split("");
            boolean isValid = true;
            for (String s : sArr) {
                if (!str.contains(s)) {
                    isValid = false;
                }
            }
            return isValid;
        }
        return false;
    }



}
