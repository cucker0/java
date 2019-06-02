/*
用二维数组打印 杨辉三角

杨辉三角
使用二维数组打印一个 10 行杨辉三角.
1
1 1
1 2 1
1 3 3  1
1 4 6  4  1
1 5 10 10 5 1
 ....

【提示】
 1. 第一行有 1 个元素, 第 n 行有 n 个元素
 2. 每一行的第一个元素和最后一个元素都是 1
 3. 从第三行开始, 对于非第一个元素和最后一个元素的元素.
     yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
* */

package com.atguigu.exercise;

public class YangHuiTriangle {
    public static void main(String[] args) {
        // 声明二维数组变量
        int[][] triangle = new int[10][]; // 行数
        for (int i = 0; i < triangle.length; ++i) {
            triangle[i] = new int[i + 1]; // 每行的元素个数


        }

        for (int i = 0; i < triangle.length; ++i) {
            // 对每行第一个和最后一个元素赋值为1
            if (i == 0) {
                triangle[i][0] = 1;
            } else {
                triangle[i][0] = triangle[i][i] = 1; // triangle[i][i] 也可以用 triangle[i][triangle[i].length - 1]
                // 从第二个元素 至 倒数第二个元素进行赋值
                for (int j = 1; j < triangle[i].length - 1; ++j) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }

        }



        // 遍历杨辉三角数组
        for (int i = 0; i < triangle.length; ++i) {
            for (int j = 0; j < triangle[i].length; ++j) {
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
