/*
* 团队调度系统
*
* 系统入口
* */

package com.java.view;

import com.java.service.Storage;

public class TeamDispatchSystem {
    /*
     * 程序入口
     * */
    public static void main(String[] args) {
        // 从文件加载数据
        Storage.read();

        // 进入主菜单
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
