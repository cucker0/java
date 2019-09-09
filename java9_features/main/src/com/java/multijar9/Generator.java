package com.java.multijar9;

import java.util.Set;

public class Generator {
    // 构造器
    public Generator() {}

    // 方法
    public Set<String> createStrings() {
        Set<String> set = Set.of("java", "9");
        return set;
    }
}
