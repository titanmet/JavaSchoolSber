package com.ratnikov;

import java.util.HashMap;
import java.util.Map;

public class TestJit{
    public static Map<Integer, String> mapTest = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {
            mapTest.put(i, String.valueOf(i)+i);
        }
//        mapTest.entrySet().forEach(System.out::println);
    }
}
