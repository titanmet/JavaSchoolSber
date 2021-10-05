package com.ratnikov.lesson.Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new DownloadWindowsStrategy());
        context.download("file.txt");
        context = new Context(new DownloadLinuxStrategy());
        context.download("file.txt");
    }
}
