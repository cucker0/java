package com.java.exercise;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    // 方法
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> lis = new ArrayList<>();
        for (String k : map.keySet()) {
            T t = map.get(k);
            lis.add(t);
        }
        return lis;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
