package com.ratnikov.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainSerializationRead {
    public static void main(String[] args) {
        String rootDir = "C:\\JavaSchoolSber\\lesson8_Serialization\\src\\main\\resources\\";
        String fileName = "data1.ser";
        try (
                FileInputStream fos = new FileInputStream(rootDir + fileName);
                ObjectInputStream ois = new ObjectInputStream(fos)) {
            ServiceImpl ser = (ServiceImpl) ois.readObject();
            System.out.println(ser.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
