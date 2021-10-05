package com.ratnikov.lesson.Strategy;

public class DownloadLinuxStrategy implements Strategy{
    @Override
    public void download(String file) {
        System.out.println("Linux downloads: "+ file);
    }
}
