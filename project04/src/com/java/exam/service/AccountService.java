package com.java.exam.service;

import com.java.exam.domain.Account;
import com.java.exam.utils.GetInput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    /*
    * 记录帐号信息的列表
    * */
    private static List<Account> accountList = new ArrayList<>();

    /* 读取帐号的文件 */
    private static final String filePath = "./Account.txt";

    // 构造器
    public AccountService() {
        super();
    }

    // 方法
    /**
     * 添加一个帐号到accountList中
     * @param account
     *          指定要添加的用户对象
     * @return 添加操作的状态
     *          true: 添加成功，false:添加失败
     */
    private boolean addAccount(Account account) {
        return accountList.add(account);
    }

    /**
     * 通过用户ID查找用户
     * @param id
     *          用户ID
     * @return Account
     *          返回找到的帐号，没有找到则返回null
     */
    public Account getAccount(String id) {
        for (Account acc : accountList) {
            if (id.equals(acc.getId())) {
                return acc;
            }
        }
        return null;
    }

    /**
     * 从文件加载用户信息到accontList
     */
    public void loadAccountFromFile() {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = "";
            String id = null, name = null;
            int age = 0;
            while ((line = br.readLine()) != null) {
                String[] sArr;
                if (line.startsWith("姓名:")) {
                    sArr = line.split(":", 2);
                    if (sArr.length < 2) continue;
                    name = sArr[1].strip();
                } else if (line.startsWith("姓名：")) {
                    sArr = line.split("：", 2);
                    if (sArr.length < 2) continue;
                    name = sArr[1].strip();
                } else if (line.startsWith("身份证:")) {
                    sArr = line.split(":", 2);
                    if (sArr.length < 2) continue;
                    id = sArr[1].strip();
                } else if (line.startsWith("身份证：")) {
                    sArr = line.split("：", 2);
                    if (sArr.length < 2) continue;
                    id = sArr[1].strip();
                } else if (line.startsWith("年龄:") || line.startsWith("年龄：")) {

                    sArr = line.startsWith("年龄:") ? line.split(":", 2) : line.split("：", 2);
                    if (sArr.length < 2) continue;
                    age = GetInput.getNumber(sArr[1].strip());

                    if (name != null && id != null && age > 0) {
                        Account account = new Account(id, name, age);
                        addAccount(account);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭 BufferedReader流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
