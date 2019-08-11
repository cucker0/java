/*
对markdown文档添加折叠目录

* */

package com.java.exercise;

import org.junit.Test;

import java.io.*;

public class ReadmeTest {
    @Test
    public void test1() {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        try {
            String f1 = "E:\\mylab\\java_2019\\README\\java学习线路.md";
            String f2 = "E:\\mylab\\java_2019\\README\\java学习线路_ok.md";
            fw = new FileWriter(f2);
            fr = new FileReader(f1);
            br = new BufferedReader(fr);
            int count = 0;
            boolean isH1 = false;
            String line,
                    summary = "",
                    details_before = "",
                    details_after = "</details>\n";
            while ((line = br.readLine()) != null) {
                if (line.startsWith("# ")) { // # 开头的行
                    isH1 = true;
                    summary = line.split("# ")[1];
                    details_before = getDetailsBefore(summary);
                    ++count;
                    if (count == 1) {
                        fw.write(details_before);
                    }
                    else {
                        fw.write(details_after); // 上部最近的## 开头行的</details>标签
                        fw.write("\n");
                        fw.write(details_after); // 上部最近的# 开头行的</details>标签
                        fw.write("\n\n");
                        fw.write(details_before);
                    }
                    fw.write(line);
                    fw.write("\n");
                } else if (line.startsWith("## ")) { // ## 开头的行
                    summary = line.split("## ")[1];
                    details_before = getDetailsBefore(summary);
                    if (isH1) { // ## 开头行上部最近行为# 开头行
                        isH1 = false;
                        fw.write(details_before);
                    } else {
                        fw.write(details_after);
                        fw.write("\n");
                        fw.write(details_before);
                    }
                    fw.write(line);
                    fw.write("\n");
                } else { // 其他开头的行
                    fw.write(line);
                    fw.write("\n");
                }

            }
            // 最后一个# 的结尾
            fw.write(details_after);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public String getDetailsBefore(String summary) {
        String details_before = "<details>\n" +
                "<summary>" + summary + "</summary>\n" +
                "\n";
        return details_before;
    }
}
