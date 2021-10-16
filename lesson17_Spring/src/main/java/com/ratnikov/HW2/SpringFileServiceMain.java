package com.ratnikov.HW2;

import com.ratnikov.HW2.service.DownloadFileService;
import com.ratnikov.HW2.service.ReadFileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class SpringFileServiceMain {
    public static final String FILE_DOWNLOADS = "lesson17_Spring/src/main/resources/downloads.txt";

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("xmlConfig.xml");
        final ReadFileService readFileService = context.getBean("fileReadService", ReadFileService.class);
        List<String> stringStreamFile = readFileService.readFiles(FILE_DOWNLOADS);
        final DownloadFileService downloadFileService = context.getBean("fileDownloadService", DownloadFileService.class);
        Map<String, String> map = combineListsIntoOrderedMap(stringStreamFile, stringStreamFile);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            downloadFileService.downloading(entry.getKey(),entry.getValue());
        }
        ((ConfigurableApplicationContext) context).close();
    }

    public static Map<String, String> combineListsIntoOrderedMap(List<String> keys, List<String> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException("Cannot combine lists with dissimilar sizes");
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
