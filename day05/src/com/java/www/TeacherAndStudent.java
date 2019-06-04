/*
题目：
编写教师类和学生类，并通过测试类创建对象进行测试
学生类：
    属性：
        姓名
        年龄
        参加的课程
        兴趣
    方法：
        显示学生的个人信息

教师类：
    属性：
        姓名
        专业
        教授的课程
        教龄
    方法：
        显示教师的个人信息


* */

package com.java.www;

public class TeacherAndStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("上官彤");
        s1.setAge(28);
        s1.course = new String[]{"语文", "英语", "武术"};
        s1.hobby = new String[]{"跳舞", "看电影"};
        System.out.println(s1.getInfo());

        Teacher t1 = new Teacher();
        t1.name = "梧桐语";
        t1.setTeaching_age(20);
        t1.setCourse_taught(new String[]{"平面设计", "钢琴入门"});
        t1.speciality = "流行艺术";
        t1.getInfo();
    }
}

class Student {
    String name;
    int age;
    String[] course;
    String[] hobby;

    public String getInfo() {
        String course_list = "\n## 课程\n", hobby_list = "\n## 爱好\n";
        for (int i = 0; i < course.length; ++i) {
            course_list += "\t" + course[i];
        }
        for (int i = 0; i < hobby.length; ++i) {
            hobby_list += "\t" + hobby[i];
        }
        String info ="\n# 学生\n## 基本信息\n" + "\tname: " + name + "    age: " + age + course_list + hobby_list;
        return info;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(int num) {
        age = num;
    }
}

class Teacher {
    String name;
    String speciality;
    String[] course_taught;
    int teaching_age;

    public void getInfo() {
        System.out.println("\n# 教师\n## 基本信息\n" + "\tname: " + name + "  speciality: " + speciality + "  teaching age: " + teaching_age);
        System.out.println("## 所授课程：");
        for (int i = 0; i < course_taught.length; ++i) {
            System.out.print("\t" + course_taught[i]);
        }
    }

    public void setName(String n) {
       name = n;
    }

    public void setTeaching_age(int num) {
        teaching_age = num;
    }

    public void setCourse_taught(String[] c) {
        course_taught = c;
    }
}