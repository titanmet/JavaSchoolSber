package com.ratnikov.serialization;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileNamePrefix = "ser";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите команду: 1 - save data file, 2 - save zip file, 3 - load data file, 4 - load zip file ");
        System.out.println("Закончить работу: exit");
        String methodName = scanner.nextLine();
        while (!methodName.equals("exit")) {
            try {
                int methodNumber = Integer.parseInt(methodName);
                switch (methodNumber) {
                    case 1:
                        fileNamePrefix = fileNamePrefix + ".ser";
                        MainReadWrite.writeDataFileDisk(MainReadWrite.object, fileNamePrefix);
                        break;
                    case 2:
                        fileNamePrefix = fileNamePrefix + ".zip";
                        MainReadWrite.writeZipFileDisk(MainReadWrite.object, fileNamePrefix);
                        break;
                    case 3:
                        fileNamePrefix = fileNamePrefix + ".ser";
                        MainReadWrite.readDataFile(fileNamePrefix);
                        break;
                    case 4:
                        fileNamePrefix = fileNamePrefix + ".zip";
                        MainReadWrite.readZipFile(fileNamePrefix);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильная команда !!!");
            }
            methodName = scanner.nextLine();
        }
    }
}
