package com.ratnikov.HW2.service;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DownloadFileServiceImpl implements DownloadFileService {
    public String path = "lesson17_Spring/src/main/resources/downloads/";

    @Override
    @SneakyThrows
    public void downloading(String url, String file) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileUtils.copyURLToFile(
                            new URL(url),
                            new File(path + file.substring(file.lastIndexOf("/"))),
                            10000,
                            10000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Downloading file: " + file.substring(file.lastIndexOf("/")) + " completed.");
            }
        }).start();
    }

    @PostConstruct
    public void init() {
        System.out.println("Init downloading");
    }
}
