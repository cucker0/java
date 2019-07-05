package com.java.exercise;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1() {
        DAO<User> dao = new DAO<>();
        User u1 = new User(10, 19, "三家寨");
        User u2 = new User(11, 18, "司丽子");
        User u3 = new User(12, 20, "马家驹");

        dao.save("sjz", u1);
        dao.save("slz", u2);
        dao.save("mjj", u3);

        User uu1 = dao.get("slz");
        System.out.println(uu1);

        dao.update("slz", new User(11, 22, "司丽子"));
        List<User> lis = dao.list();
        System.out.println(lis);

        dao.delete("mjj");
        System.out.println(dao.list());

    }
}
