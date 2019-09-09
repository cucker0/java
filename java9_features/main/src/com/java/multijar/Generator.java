package com.java.multijar;

import java.util.HashSet;
import java.util.Set;

public class Generator {
    // 构造器
    public Generator() {}

    // 方法
    public Set<String> createStrings() {
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("8");
        return set;
    }
}
