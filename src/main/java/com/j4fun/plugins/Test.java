package com.j4fun.plugins;

import java.util.TreeMap;

public class Test {
    public static void myMethod(Object... params) {
        // Xử lý các tham số được truyền vào
        for (int i = 0; i < params.length; i++) {
            System.out.println("Tham số " + (i + 1) + ": " + params[i]);
        }
    }

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put("Một", 1);
        map.put("hai", 2);
        myMethod("1", 2, 4, "sáu", map,"tám");
    }
}
