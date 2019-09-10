day04
==

# 数组
```text
* 数组是多个相同类型数据的组合，实现对这些数据的统一管理
* 数组中的元素可以是任何数据类型，包括基本数据类型和引用数据类型
* 数组属引用类型，数组型数据是对象（object），数组中的每个元素相当于该对象的成员变量

```

## 数组声明与初始化
* 静态初始化
```java
int[] ii;
ii = new int[]{12, 2, 4, 5};
int[] jj = {33, 12, 10}; // 这种省略形式也是可以，其他方式时，new 类型 不能省

short[] ss = new short[]{3, 999, 7};

byte[] bb = byte[]{127, 1, 5}; // 推荐使用这种格式
byte bb[] = byte[]{127, 1, 5}; // 也可以是这种格式，不推荐



```

* 动态初始化
```java
String[] strs = new String[4];
strs[0] = "AA";
strs[2] = "CC";

int[] ii = new int[3];

```

## 数组元素的默认值
* byte, short, int, long 数组元素默认值：0
* float, double数组元素默认值：0.0
* char 数组元素默认值：空白(即不输出任何东西) '\0'
* boolean数组元素默认值：false
* 引用类型数组元素默认值：null

## java数据的内存基本结构
基本结构
![内存基本结构](./images/内存基本结构.png)

数组在内存的结构
![数组内存结构](./images/数组在内存中的结构.png)


# 多维数组
对于多维构成的事物可以当做多维数组

```java
        // 二维数组
        // # 声明二维数组(可以先声明二维数组变量，后初始化； 也可以声明并初始二维数组)
        int[][] score2;
        String[][] names; // 也可以写成 String[] names[];
                            // 或 String names[][];
                            // 但不建议这两种方式

        String[][] names2;

        // #.静态初始化
        score2 = new int[][]{{3, 5, 7}, {2, 9}, {33, 11}};
        // 同时声明和静态初始化
        int[][] nums = new int[][]{{11, 22}, {1}, {44, 3,}};
        int[][] num3 = {{3, 5, 7}, {2}, {33, 11}}; // 省略格式。

        // # 动态初始化
        names = new String[6][5]; // 动态初始化一
        names2 = new String[6][]; // 动态初始化二，这表示第一层的长度
        String[][] names3 = new String[8][3];
        names[0][0] = "s00";
        names[3][1] = "狗子";

//        names2[0] = new String[3];
//        names2[1] = new String[5];
//        names2[3] = new String[2];


        String[][] obj = names2;
        // 每一层的数组都有length属性
        for (int i = 0; i < obj.length; ++i) {
            if (obj[i] != null) { // 避免报错：Exception in thread "main" java.lang.NullPointerException
                for (int j = 0; j < obj[i].length; ++j) {
                    System.out.println(obj[i][j]);
                }
            }
            System.out.println();
        }
```

## 数组的不同书写格式
```text
// 声明数组变量（一维数组、二维数组），建议把数组的维度都写类型这

// 一维数组
int[] x; // 建议使用这种
int x[];

// 二维数组
int[][] y; // 建议使用这种
int[] y[];
int y[][];

```

* 声明数组是就需要确定长度（显式或隐式）
* 多维数组所有的元素类型必须为制定的类型，且只能有一种数据类型

## 混合数据类型数组
```java
        Object[][]  aa = new Object[][]{{1, "china", 5}, {"aa", "bb", "bb"}, {2.3, 3,14}};

        System.out.print("{ ");
        for (int i = 0; i < aa.length; ++i) {
            System.out.print("{ ");
            for (int j = 0; j < aa[i].length; ++j) {
                System.out.print(aa[i][j] + ", ");
            }
            System.out.print(" }");
        }
        System.out.print(" }");

```

# Arrays数组操作类
常用方法
* public static boolean equals(int[] a, int[] a2)
>比较两个数组是否相等

* public static String toString(int[] a)
>数组转成字符串

* public static void fill(int[] a, int val)
>数组中所有的元素填充为指定的值val

* public static void sort(int[] a)
>数组排序

* public static int binarySearch(int[] a, int key)
>二分查找指定的值的索引位置。要求数组已经排序好。返回值为负数时，表示没有找到
