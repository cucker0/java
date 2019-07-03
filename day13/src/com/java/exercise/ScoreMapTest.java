/*
题目
    请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。

* */

package com.java.exercise;

import java.util.*;

public class ScoreMapTest {
    public static void main(String[] args) {
        Scoretor sc1 = new Scoretor();
//        sc1.inputScore();
        sc1.genScore();
        sc1.showScore();

    }
}

class Scoretor {
    private Map tmap = Collections.synchronizedMap(new TreeMap()); // 同步控制，使用线程安全的

    // 构造器
    public Scoretor() {
        super();
    }

    // 方法
    public void recordScore(String name, int score) {
        tmap.put(name, score);
    }

    public void inputScore() {
        /*
        手动录入学生成绩
        * */

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生成绩（输入姓名、成绩），输入q退出：");
        String line = "";
        LinkedList aStudent = new LinkedList();
        while (!line.strip().equals("q")) { // 判断输入的字符是否为 q
            if (aStudent.size() % 2 == 0) {
                System.out.printf("第%d个学生姓名：", tmap.size() + 1);
                line = sc.nextLine();
                if (line.strip().isEmpty()) {
                    continue;
                }
                aStudent.add(line);
            } else {
                System.out.printf("第%d个学生成绩（满分150）：", tmap.size() + 1);
                line = sc.nextLine();
                int score;
                try {
                    score = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (score < 0 || score > 150) {
                    continue;
                }

                aStudent.add(score);
            }
            if (aStudent.size() == 2) {
                tmap.put(aStudent.get(0), aStudent.get(1));
                aStudent.clear();
            }
        }

    }

    public void genScore() {
        /*
        生成学生成绩
        * */
        tmap.put("Mahha", 92);
        tmap.put("Danny", 88);
        tmap.put("Fracker", 65);
        tmap.put("Nurry", 79);
        tmap.put("Erec", 99);
    }

    public void showScore() {
        if (tmap.size() > 0) {
            Set entryset = tmap.entrySet();
            Object[] arr = entryset.toArray();
            List lis = Arrays.asList(arr); // 也可以用 List lis = new ArrayList(entryset);

            Comparator comparator = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
                        Map.Entry e1 = (Map.Entry) o1;
                        Map.Entry e2 = (Map.Entry) o2;
                        Integer v1 = (Integer) e1.getValue();
                        Integer v2 = (Integer) e2.getValue();
                        int i = -v1.compareTo(v2);
                        return i;
                    }
                    return 0;
                }
            };

//            Collections.sort(lis, comparator); // 使用Collections.sort 排序
            List lis2 = MySort.sort(lis); // 使用自定义的List排序方法
            lis = lis2;
            System.out.println("=== 前三名学生 ===");
            System.out.println("姓名\t\t成绩");

            int count = lis.size() > 3 ? 3 : lis.size();
            for (int i = 0; i < count; ++i) {
                Map.Entry entry = (Map.Entry) lis.get(i);
                System.out.printf("%s\t\t%d\n", entry.getKey(), entry.getValue());
            }
        }
    }

    public Map getTmap() {
        return  tmap;
    }
}

class MySort {
    // List中元素为对象，通过对象中的指定属性进行排序
    public static List sort(List L) {
        if (L.size() <= 1) {
            return L;
        }

        for (int i = 0; i < L.size(); ++i) {
            int max_index = i;
            for (int j = i + 1; j < L.size(); ++j) {
                Map.Entry entry_max = (Map.Entry) L.get(max_index);
                Integer max = (Integer) entry_max.getValue();
                Map.Entry entry_compare = (Map.Entry) L.get(j);
                Integer compare = (Integer) entry_compare.getValue();
                if (max < compare) {
                    max_index = j;
                }
            }
            if (max_index != i) {
                Object temp = L.get(i);
                L.set(i, L.get(max_index));
                L.set(max_index, temp);
            }

        }

        return L;
    }

    public static List sort(List L, String T) {
        if (L.size() <= 1) {
            return L;
        }

        if (T == "des") {
            List L2 = sort(L);
            Object temp;
            for (int i = 0, j = L.size() - 1; i < j; ++i, --j ) {
               temp = L.get(i);
               L.set(i, L.get(j));
               L.set(j, temp);
            }
        }
        return L;
    }
}
