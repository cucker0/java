/**
 * 程序的主控类，负责与用户交互，完成考试及成绩查询功能
 *
 * */

package com.java.exam.view;

import com.java.exam.domain.Account;
import com.java.exam.domain.Item;
import com.java.exam.service.AccountService;
import com.java.exam.service.ItemService;
import com.java.exam.utils.GetInput;

import java.io.*;
import java.util.*;

public class ExamView {
    /* 保存用户考试记录 */
    private static final String filePath = "./testRecord.db";
    private static ItemService itemService = new ItemService();
    private static AccountService accountService = new AccountService();
    private Account account; // 当前考试帐号

    /* 本次答题记录
    * 格式：{题索引: 选项, 题索引: 选项}
    * */
    private LinkedHashMap<Integer, String> answerRecord = new LinkedHashMap<>();

    /*
    * 帐号上次的考试记录
    * 格式：{Account对象:[得分，上次的答题记录], Account对象:[得分，上次的答题记录]}
    * */
    private static TreeMap<Account, ArrayList<Object>> testRecord = new TreeMap<>();

    // 构造器
    public ExamView() {
        loadWork();
        readTestRecordFromFile();
    }

    /**
     * 主菜单
     */
    // 方法
    public boolean login() {
        String menu = "-------欢迎使用在线考试系统-------\n\n" +
                "身份证号登录\n" +
                "(测试身份证号：513436200008277272)\n" +
                "Q退出\n" +
                "\n\n";
        System.out.println(menu);
        int i = 0;
        while (true) {
            if (i == 0) {
                System.out.print("身份证：");
            } else {
                System.out.print("\n重新登录\n身份证：");
            }
            String ramCmd = GetInput.getString();
            if (GetInput.isExit(ramCmd)) {
                break;
            }
            Account acc = accountService.getAccount(ramCmd);
            if (acc != null) { // 帐号存在，登录成功
                setAccount(acc);
                return true;
            } else {
                System.out.println("登录失败!\n");
            }
            ++i;
        }
        return false;
    }

    public void enterMenu() {
        if (!login()) {
            return;
        }
        String menu = String.format("-------欢迎使用在线考试系统-------\n" +
                "\t\t%s 欢迎你!\n\n" +
                "1 进入考试\n" +
                "2 查看成绩\n" +
                "3 系统退出\n" +
                "\n" +
                "选择操作项：", account.getName());

        while (true) {
            System.out.println(menu);
            String ramCmd = GetInput.getRaw();
            int num = GetInput.getNumber(ramCmd);
            switch (num) {
                case 1:
                    exam();
                    break;
                case 2:
                    viewResult();
                    break;
                case 3:
                    saveTestRecordTofile();
                    return;
                default:
                    break;
            }

        }

    }


    /**
     * 进入考试系统前的数据加载工作
     */
    private void loadWork() {
        // 加载题目数据
        itemService.loadItemsFromFile();
        // 加载帐号信息
        accountService.loadAccountFromFile();
    }

    /**
     * 考试作答菜单
     */
    public void exam() {
        String menu = "-----------欢迎进入考试-----------\n" +
                "满分100分，80分及格\n" +
                "共10题，每题10分\n" +
                "\n";
        System.out.println(menu);

        int i = 0;
        String lastPageAction = "";
        for (; ; ) {
            System.out.printf("\n\n第%s题[%s]、%s%s",
                    i + 1,
                    itemService.getItem(i).isSingleElection() ? "单选" : "多选",
                    itemService.showItem(i),
                    answerRecord.get(i) == null ? "选项：" : String.format("选项(已选 %s)：", answerRecord.get(i)));
            String answer = GetInput.getRaw();
            answer = answerFilter(answer);
            if (answer.equalsIgnoreCase("q")) { // 提交试卷
                if (answerRecord.size() < ItemService.getItemsList().size()) {
                    System.out.println("你还有些题没有作答完，");
                } else {
                    System.out.println("题目已经答完了，");
                }
                System.out.print("你确定提交试卷吗？\n" +
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
                lastPageAction = "p";
            } else if (answer.equalsIgnoreCase("n")) { // 下一题
                if (i < ItemService.getItemsList().size() -1) {
                    ++i;
                }
                lastPageAction = "n";
            } else if (isValidAnswer(itemService.getItem(i), answer)) { // 选项有效，记录答案并跳转下一题
                answerRecord.put(i, answer);
                if (i < ItemService.getItemsList().size() -1) {
                    ++i;
                }
                // 作答完最后道题
                if (i == ItemService.getItemsList().size() -1) {
                    if (answerRecord.size() < ItemService.getItemsList().size()) {
                        System.out.println("你还有些题没有作答完，");
                    } else {
                        System.out.println("题目已经答完了，");
                    }
                    System.out.print("提交试卷吗？\n" +
                            "Y: 是\n" +
                            "N: 否\n" +
                            "\n" +
                            "是否确认：");
                    if (GetInput.getIsYes()) {
                        submitPapers();
                        // 提交试卷后,按下任何键盘退出
                        break;
                    }
                }
            } else if (answer.equals("")) {
                // 已经作答的
                if (answerRecord.keySet().contains(i)) {
                    if (lastPageAction.equalsIgnoreCase("p")) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            System.out.println("输入无效");
        }
    }

    public String answerFilter(String answer) {
        if (answer.length() <= 1) {
            return answer.toUpperCase();
        }
        String str = "";
        String[] sArr = answer.split("");
        for (String s : sArr) {
            if (s.matches("\\w")) {
                str += s.toUpperCase();
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
                    HashSet<String > answerSet = new HashSet<>();
                    for (String s : sArr) {
                        answerSet.add(s);
                    }

/*                    boolean isCorrect = true;
                    for (String s : sArr) {
                        if (!item.getRightOptions().contains(s)) {
                            isCorrect = false;
                            break;
                        }
                    }
                    score += isCorrect ? 10 : 0;
                    */

                    score += answerSet.equals(item.getRightOptions()) ? 10 : 0;
                }
            }

        }
        String isPass = score >= 80 ? "恭喜成绩合格" : "成绩不合格，继续加油";
        System.out.printf("%s\n你的考试得分：%s 分.\n", isPass, score);

        // 保存考试成绩与答题记录
        /*
         * 帐号上次的考试记录
         * 格式：{Account对象:[得分，上次的答题记录], Account对象:[得分，上次的答题记录]}
         * testRecord
         * */
        ArrayList<Object> record = new ArrayList<>();
        record.add(score);
        record.add(answerRecord);
        testRecord.put(account, record);
    }


    /**
     * 查看成绩
     *
     */
    public void viewResult() {
        if (account == null || !testRecord.keySet().contains(account) || getScore(account) == -400) {
            System.out.println("你还未参加考试");
            return;
        }
        String menu = String.format("上次考试成绩：%s\n" +
                "\n" +
                "考试详情：\n", getScore(account));
        System.out.println(menu);
        System.out.println(getResult(account));
    }


    /**
     * 查询指定帐号上次的考试成绩
     * @param account
     * @return 上次的考试成绩
     *           返回-400表示上次没有考试的
     */
    private int getScore(Account account) {
        if (testRecord.keySet().contains(account) && testRecord.get(account).size() > 0) {
            return (int) testRecord.get(account).get(0);
        }
        return -400;
    }

    /**
     * 获取指定帐号上次作答记录与标准答案的对比
     * @return 上次作答记录与标准答案的对比拼接的String
     */
    public String getResult(Account account) {
        // 帐号必须已经登录，且已经参加过考试
        if (account == null || !testRecord.keySet().contains(account)) {
            return "";
        }
        String str = "题号\t\t\t\t\t你的答案\t标准答案\n";
        ArrayList<Object> record =  testRecord.get(account);
        int score = (int) record.get(0);
        LinkedHashMap<Integer, String> lastAnswerRecord = (LinkedHashMap) record.get(1);
        for (int i = 0; i < ItemService.getItemsList().size(); ++i) {
            Item item = ItemService.getItemsList().get(i);
            String aQuestioin = "";
            aQuestioin += String.format("第%-2s题[%s]\t\t\t%-4s\t\t%s\n", i + 1,
                    item.isSingleElection() ? "单选" : "多选",
                    lastAnswerRecord.get(i) == null ? " " : lastAnswerRecord.get(i),
                    item.rightOptionsToString());
            str += aQuestioin;
        }
        str += "\n";
        return str;
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
                str = "ABCDE";
                break;
            case 6:
                str = "ABCDEF";
                break;
            case 7:
                str = "ABCDEFG";
                break;
            case 8:
                str = "ABCDEFGH";
                break;
            default:
                str = "ABCD";
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

    private void setAccount(Account account) {
        if (account != null) {
            this.account = account;
        }
    }

    /**
     * 保存用户的考试记录
     */
    public void saveTestRecordTofile() {
        ObjectOutputStream oos = null;
        try {
            File file = new File(filePath);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(testRecord);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件读取用户的考试记录
     *
     */
    public void readTestRecordFromFile() {
        ObjectInputStream ois = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            Object obj = ois.readObject();
            TreeMap<Account, ArrayList<Object>> record = (TreeMap<Account, ArrayList<Object>>) obj;
            testRecord = record;
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
