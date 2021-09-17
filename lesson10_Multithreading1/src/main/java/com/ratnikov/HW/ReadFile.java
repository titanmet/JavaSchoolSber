package com.ratnikov.HW;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class ReadFile {
    public static String rootDir = "lesson10_Multithreading1\\src\\main\\resources\\";
    public static String fileName = "data.txt";

    public static BigInteger getFactorial(BigInteger num) {
        BigInteger result = BigInteger.valueOf(1);
        for (long factor = 2; factor <= num.longValue(); factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    public static void readDataFileDisk() throws IOException {
        Scanner scanner = new Scanner(new File(rootDir + fileName));
        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            if (scanner.hasNextInt()){
                new Thread(()->{
                    System.out.println("Factorial " + nextInt + " = " + getFactorial(BigInteger.valueOf(nextInt)));
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("--------------------------------------------------------------------------");
                }).start();
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws IOException {
            readDataFileDisk();
    }
}
