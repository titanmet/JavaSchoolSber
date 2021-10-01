package com.ratnikov.lesson.metric;

import java.util.HashMap;
import java.util.Map;

public class Meter {
    private static Map<String, Long> timings = new HashMap<>();

    public static void execute(String name, Execution logic) {
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------ starting " + name + "-------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------");
        long start = System.nanoTime();
        logic.apply();
        long stop = System.nanoTime();
        long time = (stop - start) / 1_000_000;
        timings.put(name, time);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------ finished " + name + "-------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public static void printTimings() {
        timings.forEach(Meter::print);
    }

    private static void print(String name, long time) {
        System.out.println();
        System.out.println("Time for " + name + ", ms: " + time);
    }
}
