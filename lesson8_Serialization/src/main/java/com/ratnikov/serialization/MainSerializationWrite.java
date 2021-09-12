package com.ratnikov.serialization;

import java.io.*;
import java.util.Date;

import static java.lang.System.*;

public class MainSerializationWrite {
    public static void main(String[] args) {
        final long serialVersionID = 1L;
        String rootDir = "C:\\JavaSchoolSber\\lesson8_Serialization\\src\\main\\resources\\";
        String fileName = "data1.ser";

        ServiceImpl service = new ServiceImpl();
        service.setWork("work1");
        service.setI(10.0);
        service.setDate(new Date());
        service.doHardWork();
        double n1 = 756;
        double n2 = 986;
        service.calc(n1, n2);

        try (FileOutputStream fos = new FileOutputStream(rootDir + fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(service);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
