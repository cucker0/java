/*
循环嵌套

运行：javac -encoding utf8 LoopNest.java && java LoopNest
* */

class LoopNest {
    public static void main(String[] args) {

        // # 打印下面的图形
        /*

*****
*****
*****
*****

        * */

        for (int i = 0; i <4; ++i ) { // 外层循环控制行数
            for (int j = 0; j < 5; ++j) { // 内层循环控制列数
                System.out.print('*');
            }
            System.out.println();
        }


        System.out.println();
        // # 打印下面的图片
        /*

*
**
***
****

        * */

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        // # 打印下面的图片
        /*

 *****
 ****
 ***
 **
 *

         * */

        for (int i = 0; i < 5; ++i) {
            for (int j = 5 - i; j > 0; --j) { // for (int j = 0; j > 5 - i; j++) {}
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        // # 打印下面的图片
        /*

 *
 **
 ***
 ****
 *****
 ****
 ***
 **
 *

         */
        for (int i = 0; i < 4; ++i) { // 上部分(上面4行)
            for (int j = 0; j <= i; ++j) {
                System.out.print('*');
            }
            System.out.println();
        }

        for (int i = 0; i < 5; ++i) { // 下部分(下面5行)
            for (int j = 0; j < 5 - i; ++j) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        // # 打印下面的图片
        /*

    *
   * *
  * * *
 * * * *
* * * * *
 * * * *
  * * *
   * *
    *

## 分解方法(把空格换成 '-' 是为了方便理解与察看)
----*
---* *
--* * *
-* * * *
* * * * *
上半部分
_* * * *
--* * *
---* *
----*
下半部分

## 上半部分关系
i(行)   j(-)    k(*)
0       4       1
1       3       2
2       2       3
3       1       2
4       0       5

j,i之间的关系
j = 4 - i

k,i之间的关系
k = i + 1

## 下半部分关系
i(行)   j(-)    k(*)
0       1       4
1       2       3
2       3       2
3       4       1

j,i之间的关系
j = i + 1

k,i之间的关系
k = 4 - i

## 最后把'*'替换成 ' '

        * */

        // 上半部分
        for (int i = 0; i < 5; ++i) { // 打印5行
            for (int j = 0; j < 4- i; ++j) {
//                System.out.print('-');
                System.out.print(' ');
            }
            for (int k = 0; k < i + 1; ++k) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // 下半部分
        for (int i = 0; i < 4; ++i) { // 打印4行
            for (int j = 0; j < i + 1; ++j) {
//                System.out.print('-');
                System.out.print(' ');
            }
            for (int k = 0; k < 4 - i; ++k) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}