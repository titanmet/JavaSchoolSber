package com.ratnikov.HW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteFile {
    public static String rootDir = "lesson10_Multithreading1\\src\\main\\resources\\";
    public static String fileName = "data.txt";

    public static void writeDataFileDisk() {
        int[] array = new int[10];
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i)
            array[i] = random.nextInt(50);

        try (final FileWriter writer = new FileWriter(rootDir + fileName, false)) {
            for (int i = 0; i < array.length; ++i) {
                final String s = Integer.toString(array[i]);
                writer.write(s);
                writer.write(System.lineSeparator());
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeDataFileDisk();
    }
}
