/*
模拟DAO，database access object

* */

package com.java.www;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO<T> {
    private List<T> list = new ArrayList<>();

    // 构造器
    public DAO() {
        super();
    }

    // 方法，CRUD

    public void add(T t) {
        list.add(t);
    }

    public T get(int index) {
        return list.get(index);
    }

    public List<T> getList() {
        return list;
    }

    public void update(int index, T t) {
        list.set(index, t);
    }

    public void delete(int index) {
        list.remove(index);
    }
}

