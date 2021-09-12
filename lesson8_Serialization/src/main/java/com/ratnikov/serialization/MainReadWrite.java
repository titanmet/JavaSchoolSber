package com.ratnikov.serialization;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MainReadWrite {
    public static String rootDir = "lesson8_Serialization\\src\\main\\resources\\";
    public static String fileName = "data";
    public static HashMap<List<Object>, Object> object;

    public static void writeDataFileDisk(HashMap<List<Object>, Object> object, String fileNamePrefix) {
        try (FileOutputStream fos = new FileOutputStream(rootDir + fileName + ".ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            System.out.println("Data file recorded to disk.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeZipFileDisk(HashMap<List<Object>, Object> object, String fileNamePrefix) {
        try (GZIPOutputStream gzis = new GZIPOutputStream(new FileOutputStream(rootDir + fileName));
             ObjectOutputStream oos = new ObjectOutputStream(gzis)) {
            oos.writeObject(object);
            System.out.println("Zip file recorded to disk.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<List<Object>, Object> readDataFile(String fileNamePrefix) {
        try (FileInputStream fis = new FileInputStream(rootDir + fileName + ".ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            object = (HashMap<List<Object>, Object>) ois.readObject();
            System.out.println(ois.toString());
            System.out.println("Data file read.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static HashMap<List<Object>, Object> readZipFile(String fileNamePrefix) {
        try (GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(rootDir + fileName));
             ObjectInputStream ois = new ObjectInputStream(gzis)) {
            object = (HashMap<List<Object>, Object>) ois.readObject();
            System.out.println("Zip file read.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
